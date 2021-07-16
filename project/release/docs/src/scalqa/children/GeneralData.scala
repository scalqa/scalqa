package scalqa; package children; import language.implicitConversions

class GeneralData(m: Member) extends Data(m):

  this.members  = { all.~.take(_.kind.isClassLike).drop(_.dri.isOpaqueDef) ++ all.~.takeOnlyBy(_.kind.name, "def","val","type").map_?(_._child_?) }.sort

  this.makers   = all.~.take(m => !owner.kind.isObject && m.kind.isExtension && Docs.isMakerMethod(owner.name,m.name)).sort

  val DefValVar = all.~.takeOnlyBy(_.kind.name, "def","val","var").drop(_.kind.isExtension && !m.name.startsWith("_")).drop(_.name == "this")._dropIfIn(members ++ makers).><

  this.aliases  = all.~.take(m => m.kind.name=="type" && m.name!="type")._dropIfIn(members)._dropIfIn(makers)
  this.aliases  = aliases ++ DefValVar.~._takeIfIn(aliases) ++ DefValVar.~._dropIfIn(aliases).take(_.name._isAliasName)

  this.types    = aliases.~.take(Docs.isTypeLikeAlias)
  this.types    = {types.~ ++ aliases.~.drop(_.kind.isTypeLike)._takeIfIn(types)}.sort

  this.aliases  = aliases.~._dropIfIn(types)

  this.extended = DefValVar.~.take(_.origin.isExtension)

  this.defs     = DefValVar.~._dropIfIn(aliases ++ extended).drop(_.name.startsWith("given")).drop(_.name.startsWith("implicit")).drop(v => DefValVar.~.exists(_.name == v.name._propertyName))

  this.exports  = all.~.take(_.kind.isExported).sort

  extensions = all.~
             .take(_.kind.isExtension)
             .groupBy(m => Id(m.kind.cast[Kind.Extension].on.signature))
             .map(_.toList)
             .map[(ExtensionTarget,List[Member])](v => (v.head.kind.cast[Kind.Extension].on,v)).><

  // ---------------------------------------------------------------------------------------------------------------------------------------------------
  extension(x: String)    private def _propertyName          : String      = if(x.endsWith("_=")) x.dropLast(2) + "_*" else x + "_*"
  extension(x: String)    private def _isAliasName           : Boolean     = x.charAt(0).isUpper && (x.length==1 || x.charAt(1).isLower)
  extension(x: ~[Member]) private def _takeIfIn(s: ~[Member]): ~[Member]   = x.takeAllBy(_.name, s.map(_.name))
  extension(x: ~[Member]) private def _dropIfIn(s: ~[Member]): ~[Member]   = x.dropAllBy(_.name, s.map(_.name))
  extension(x: Member)    private def _isLocal               : Boolean     = x.inheritedFrom.filterNot(_.dri.id.startsWith(owner.id + "._")).isEmpty
  extension(x: Member)    private def _child_?               : Opt[Member] = x.signature.?.drop(v => v.isEmpty || !v.head.isInstanceOf[Link]).map(_.head.asInstanceOf[Link].dri.id.mid.lower)
                                                                              .takeOnly(owner.id.mid.lower + "." + x.name.nameToId.lower)
                                                                              .map_?(Registry.module_?).map(_.main)

  if(m.name in ("Val","G","Request")) this.aliases  = aliases.~.dropOnlyBy(_.name,"~","<>","><","\\/")
