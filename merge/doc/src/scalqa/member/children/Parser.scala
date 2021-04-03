package scalqa; package member; package children; import language.implicitConversions

class Parser(owner: Member):
  extension(x: String)    private def _propertyName          : String      = if(x.endsWith("_=")) x.dropLast(2) + "_*" else x + "_*"
  extension(x: String)    private def _isAliasName           : Boolean     = x.charAt(0).isUpperCase && (x.length==1 || x.charAt(1).isLowerCase)
  extension(x: ~[Member]) private def _takeIfIn(s: ~[Member]): ~[Member]   = x.takeAllBy(_.name, s.map(_.name))
  extension(x: ~[Member]) private def _dropIfIn(s: ~[Member]): ~[Member]   = x.dropAllBy(_.name, s.map(_.name))
  extension(x: Member)    private def _isLocal               : Boolean     = x.inheritedFrom.filterNot(_.dri.memberId.startsWith(owner.id + "._")).isEmpty
  extension(x: Member)    private def _child_?               : Opt[Member] = x.signature.?.drop(v => v.isEmpty || !v.head.isInstanceOf[Link]).map(_.head.asInstanceOf[Link].dri.moduleId)
                                                                             .takeOnly(owner.id.moduleId + "." + x.name.nameToId).map_?(Doc.module_?).map(_.main)
  // -----------------------------   ----------------------------------------------------------------------------------------------------------------------
  given memberOrdering:  Ordering[Member]  with
    extension(inline x: Member) inline def typ = if(x.kind.isType) 0 else 1
    def compare(x:Member,y:Member) = { var i=stringOrdering.compare(x.name,y.name); if(i!=0) i else x.typ - y.typ }


  var all,members,aliases,types,defs,extended,exports,localDefs,inheritedDefs,makers: ><[Member] = \/
  var extensions: ><[(ExtensionTarget,List[Member])] = \/

  this.all = owner.members.~.dropOnlyBy(_.name,"THIS_TYPE"/*,"NumericOps","OrderingOps"*/).drop(m => Doc.isHiddenName(owner,m.name))
  owner.name match
  case "API"    => members = owner.members.~.take(_.name=="scalqa")
  case "scalqa" =>
    members = all.~.takeOnlyBy(_.name,"Def","Gen","J","Fx","Val")
    aliases  = { members.~.drop(_.name=="J").flatMap(_.members).drop(v => v.name == "~" && v.kind.isDefLike) ++ all.~.find_?(_.name == "~~")
              ++ Doc.member_?(Member.Id("scalqa.gen.request$")).get.members }.sort
  case _ =>
    if(owner.dri.isOpaque)
      this.defs     = all.~.take(_.kind.isExtension)
        //          .groupBy(m => { val id = Id(m.kind.asInstanceOf[Kind.Extension].on.signature);  id})
        //          .toSeq.map((_,v) => (v.head.kind.asInstanceOf[Kind.Extension].on,v.map(Mem(_)).sorted))
    else
      this.members  = { all.~.take(_.kind.isClassLike).drop(_.id.isOpaqueBase) ++ all.~.takeOnlyBy(_.kind.name, "def","val","type").map_?(_._child_?) }.sort

      this.makers   = all.~.take(m => /*m.kind.isDef &&*/ Doc.isMakerMethod(owner.name,m.name) && owner.name!="Def").sort

      this.defs     = all.~.takeOnlyBy(_.kind.name, "def","val","var").drop(_.name == "this")._dropIfIn(members)._dropIfIn(makers)

      this.aliases  = all.~.take(m => m.kind.name=="type" && m.name!="type")._dropIfIn(members)._dropIfIn(makers)

      this.aliases  = aliases  ++ defs.~._takeIfIn(aliases) ++ defs.~._dropIfIn(aliases).take(_.name._isAliasName)
      this.defs     = defs.~._dropIfIn(aliases).drop(_.name.startsWith("xx"))

      this.defs     = defs.~.drop(v => defs.~.exists(_.name == v.name._propertyName))
      this.defs.~.partition(_.origin.^.convert(o => o.isDefined || o.isOverride)).^(s => {defs = s.read.sort; extended = s.read.sort})

      this.types    = aliases.~.take(Doc.isTypeLikeAlias)
      this.types    = {types.~ ++ aliases.~.drop(_.kind.isTypeLike)._takeIfIn(types)}.sort

      this.aliases  = aliases.~._dropIfIn(types).dropOnlyBy(_.name,"~","<>","><","\\/").sort

      this.exports = all.~.take(_.kind.isExported).sort

      if(defs.size > 20 && defs.~.take(_._isLocal).count <= 5 ) defs.~.partition(_._isLocal).^(s => {localDefs = s.read; inheritedDefs = s.read})

      extensions = all.~
                 .take(_.kind.isExtension)
                 .groupBy(m => Id(m.kind.cast[Kind.Extension].on.signature))
                 .map(_.toList)
                 .map[(ExtensionTarget,List[Member])](v => (v.head.kind.cast[Kind.Extension].on,v)).><

      //if(aliases.nonEmpty) aliases.~.map(_.name).tp