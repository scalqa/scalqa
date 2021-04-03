package dotty.tools.scaladoc
package tasty.comments

import scala.quoted._

trait MemberLookup {

  def memberLookupResult(using Quotes)(
    symbol: quotes.reflect.Symbol,
    label: String,
    inheritingParent: Option[quotes.reflect.Symbol] = None
  ): (quotes.reflect.Symbol, String, Option[quotes.reflect.Symbol]) =
    (symbol, label, inheritingParent)

  def lookup(using Quotes, DocContext)(
    query: Query,
    owner: quotes.reflect.Symbol,
  ): Option[(quotes.reflect.Symbol, String, Option[quotes.reflect.Symbol])] = lookupOpt(query, Some(owner))

  def lookupOpt(using Quotes, DocContext)(
    query: Query,
    ownerOpt: Option[quotes.reflect.Symbol],
  ): Option[(quotes.reflect.Symbol, String, Option[quotes.reflect.Symbol])] =
    try
      import quotes.reflect._

      def nearestClass(sym: Symbol): Symbol =
        if sym.isClassDef then sym else nearestClass(sym.owner)

      def nearestPackage(sym: Symbol): Symbol =
        if sym.flags.is(Flags.Package) then sym else nearestPackage(sym.owner)

      def nearestMembered(sym: Symbol): Symbol =
        if sym.isClassDef || sym.flags.is(Flags.Package) then sym else nearestMembered(sym.owner)

      val res: Option[(Symbol, String, Option[Symbol])] = {
        def toplevelLookup(querystrings: List[String]) =
          downwardLookup(querystrings, defn.PredefModule.moduleClass)
          .orElse(downwardLookup(querystrings, defn.ScalaPackage))
          .orElse(downwardLookup(querystrings, defn.RootPackage))
          .orElse(downwardLookup(querystrings, defn.EmptyPackageClass))

        ownerOpt match {
          case Some(owner) =>
            val nearest = nearestMembered(owner)
            val nearestCls = nearestClass(owner)
            val nearestPkg = nearestPackage(owner)
            def relativeLookup(querystrings: List[String], owner: Symbol): Option[(Symbol, Option[Symbol])] = {
              val isMeaningful =
                owner.exists
                // those are just an optimisation, they can be dropped if problems show up
                && owner.ne(defn.ScalaPackage)
                && owner.ne(defn.RootClass)
                && owner.ne(defn.EmptyPackageClass)

              if !isMeaningful then None else {
                downwardLookup(querystrings, owner) match {
                  case None => relativeLookup(querystrings, owner.owner)
                  case some => some
                }
              }
            }

            query match {
              case Query.StrictMemberId(id) =>
                downwardLookup(List(id), nearest).map(memberLookupResult(_, id, _))
              case Query.QualifiedId(Query.Qual.This, _, rest) =>
                downwardLookup(rest.asList, nearestCls).map(memberLookupResult(_, rest.join, _))
              case Query.QualifiedId(Query.Qual.Package, _, rest) =>
                downwardLookup(rest.asList, nearestPkg).map(memberLookupResult(_, rest.join, _))
              case query =>
                val ql = query.asList
                toplevelLookup(ql)
                .orElse(relativeLookup(ql, nearest))
                .map(memberLookupResult(_, query.join, _))
            }

          case None =>
            toplevelLookup(query.asList).map(memberLookupResult(_, query.join, _))
        }
      }

      // println(s"looked up `$query` in ${owner.show}[${owner.flags.show}] as ${res.map(_.show)}")

      res
    catch
      case e: Exception =>
        // TODO (https://github.com/lampepfl/scala3doc/issues/238): proper reporting
        val msg = s"Unable to find a link for ${query} ${ownerOpt.fold("")(o => "in " + o.name)}"
        report.warn(msg, e)
        None

  private def hackMembersOf(using Quotes)(rsym: quotes.reflect.Symbol) = {
    import quotes.reflect._
    import dotty.tools.dotc
    given dotc.core.Contexts.Context = quotes.asInstanceOf[scala.quoted.runtime.impl.QuotesImpl].ctx
    val sym = rsym.asInstanceOf[dotc.core.Symbols.Symbol]
    val members =
      sym.info.allMembers.iterator.map(_.symbol).filter(
        s => hackIsNotAbsent(s.asInstanceOf[Symbol])
      )
    // println(s"members of ${sym.show} : ${members.map(_.show).mkString(", ")}")
    members.asInstanceOf[Iterator[Symbol]]
  }

  private def hackIsNotAbsent(using Quotes)(rsym: quotes.reflect.Symbol) = {
    import dotty.tools.dotc
    given dotc.core.Contexts.Context = quotes.asInstanceOf[scala.quoted.runtime.impl.QuotesImpl].ctx
    val sym = rsym.asInstanceOf[dotc.core.Symbols.Symbol]
    // note: Predef has .info = NoType for some reason
    sym.isCompleted && sym.info.exists
  }

  private def localLookup(using Quotes)(
    sel: MemberLookup.Selector,
    owner: quotes.reflect.Symbol
  ): Iterator[quotes.reflect.Symbol] = {
    import quotes.reflect._

    def findMatch(syms: Iterator[Symbol]): Iterator[Symbol] = {
      def matches(s: Symbol): Boolean =
        s.name == sel.ident && sel.kind.match {
          case MemberLookup.SelectorKind.ForceTerm => s.isTerm
          case MemberLookup.SelectorKind.ForceType => s.isType
          case MemberLookup.SelectorKind.NoForce => true
        }

      def hackResolveModule(s: Symbol): Symbol =
        if s.flags.is(Flags.Module) then s.moduleClass else s

      // val syms0 = syms.toList
      // val matched0 = syms0.filter(matches)
      // if matched0.isEmpty then
      //   println(s"Failed to look up ${sel.ident} in $owner; all members: {{{")
      //   syms0.foreach { s => println(s"\t$s") }
      //   println("}}}")
      // val matched = matched0.iterator

      // def showMatched() = matched0.foreach { s =>
      //   println(s"\t $s")
      // }
      // println(s"localLookup in class ${owner} for `${sel.ident}`{kind=${sel.kind}}:{{{")
      // showMatched()
      // println("}}}")

      val matched = syms.filter(matches)
      matched.map(hackResolveModule)
    }

    if owner.isPackageDef then
      findMatch(hackMembersOf(owner).flatMap {
        s =>
          (if s.name.endsWith("package$") then hackMembersOf(s) else Iterator.empty) ++ Iterator(s)
      })
    else
      owner.tree match {
        case tree: TypeDef =>
          val tpe =
            tree.rhs match {
              case tb : TypeBoundsTree => tb.hi.tpe
              case tpt: TypeTree => tpt.tpe
            }

          tpe.classSymbol match {
            case Some(s) => findMatch(hackMembersOf(s))
            case None => Iterator.empty
          }
        case _ =>
          findMatch(hackMembersOf(owner))
      }
  }

  private def downwardLookup(using Quotes)(
    query: List[String], owner: quotes.reflect.Symbol
  ): Option[(quotes.reflect.Symbol, Option[quotes.reflect.Symbol])] = {
    import quotes.reflect._
    query match {
      case Nil => None
      case q :: Nil =>
        val sel = MemberLookup.Selector.fromString(q)
        val res = sel.kind match {
          case MemberLookup.SelectorKind.NoForce =>
            val lookedUp = localLookup(sel, owner).toSeq
            // note: those flag lookups are necessary b/c for objects we return their classes
            lookedUp.find(s => s.isType && !s.flags.is(Flags.Module)).orElse(
              lookedUp.find(s => s.isTerm || s.flags.is(Flags.Module))
            )
          case _ =>
            localLookup(sel, owner).nextOption
        }
        res match {
          case None => None
          case Some(sym) =>
            val externalOwner: Option[quotes.reflect.Symbol] =
              if owner eq sym.owner then None
              else if owner.flags.is(Flags.Module) then Some(owner.moduleClass)
              else if owner.isClassDef then Some(owner)
              else None
            Some(sym -> externalOwner)
        }
      case q :: qs =>
        val sel = MemberLookup.Selector.fromString(q)
        val lookedUp = localLookup(sel, owner).toSeq

        if lookedUp.isEmpty then None else {
          // tm/tp - term/type symbols which we looked up and which allow further lookup
          // pk - package symbol
          // Note: packages collide with both term and type definitions
          // Note: classes and types collide
          var pk: Option[Symbol] = None
          var tp: Option[Symbol] = None
          var tm: Option[Symbol] = None
          lookedUp.foreach { s =>
            if s.isPackageDef then pk = Some(s)
            else if s.flags.is(Flags.Module) then tm = Some(s)
            else if s.isClassDef || s.isTypeDef then tp = Some(s)
          }
          pk.flatMap(downwardLookup(qs, _))
          .orElse(tp.flatMap(downwardLookup(qs, _)))
          .orElse(tm.flatMap(downwardLookup(qs, _)))
        }
    }
  }
}

object MemberLookup extends MemberLookup {
  enum SelectorKind {
    case ForceTerm
    case ForceType
    case NoForce
  }

  case class Selector(ident: String, kind: SelectorKind)
  object Selector {
    def fromString(str: String) = {
      // Scaladoc overloading support allows terminal * (and they're meaningless)
      val cleanStr = str.stripSuffix("*")

      if cleanStr endsWith "$" then
        Selector(cleanStr.init, SelectorKind.ForceTerm)
      else if cleanStr endsWith "!" then
        Selector(cleanStr.init, SelectorKind.ForceType)
      else
        Selector(cleanStr, SelectorKind.NoForce)
    }
  }
}
