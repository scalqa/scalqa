package scalqa; package children; package z; import language.implicitConversions

class GeneralData(m: Member) extends Data(m):

  this.members  = { all.~.take(_.kind.isClassLike).drop(_.dri.isTypeDef) ++ all.~.takeValuesBy(_.kind.name, ("def","val","type")).map_?(_._member_?) }.sort.><

  this.makers   = all.~.take(m => !owner.kind.isObject && m.kind.isExtension && Docs.isMakerMethod(owner.name,m.name)).sort.><

  val DefValVar = all.~.takeValuesBy(_.kind.name, ("def","val","var"))
                  .drop(_.kind.isExtension && (m.kind.isObject || m.name.in("Base","Data","Ordered","Calculable","Numerical","Sequential")))
                  .drop(_.name == "this")._dropIfIn(members ++ makers).><

  this.aliases  = all.~.take(m => m.kind.name=="type" && m.name!="type")._dropIfIn(members)._dropIfIn(makers).><

  this.aliases  = aliases ++ DefValVar.~._takeIfIn(aliases) ++ DefValVar.~._dropIfIn(aliases).take(_.name._isAliasName)

  this.types    = aliases.~.take(Docs.isTypeLikeAlias).><
  this.types    = {types.~ ++ aliases.~.drop(_.kind.isTypeLike)._takeIfIn(types)}.sort.><

  this.aliases  = aliases.~._dropIfIn(types).><


  this.extended = DefValVar.~.take(_.origin.isExtension).><

  this.defs     = DefValVar.~._dropIfIn(aliases ++ extended).drop(_.name.startsWith("given")).drop(_.name.startsWith("implicit")).drop(v => DefValVar.~.exists(_.name == v.name._propertyName)).><

  this.exports  = all.~.take(_.kind.isExported).sort.><

  aliases.~.partition(_.name in GeneralData.ContainerNames).^(s => { this.containers=s.read.><; this.aliases = s.read.>< })

  extensions = all.~
             .take(_.kind.isExtension)
             .groupBy(m => Id(m.kind.cast[Kind.Extension].on.signature))
             .map(_.toList)
             .map[(ExtensionTarget,List[Member])](v => (v.head.kind.cast[Kind.Extension].on,v)).><

  // ---------------------------------------------------------------------------------------------------------------------------------------------------
  extension(x: String)    private def _propertyName          : String      = if(x.endsWith("_=")) x.dropLast(2) + "_*" else x + "_*"
  extension(x: String)    private def _isAliasName           : Boolean     = x.charAt(0).isUpper && (x.length==1 || x.charAt(1).isLower)
  extension(x: ~[Member]) private def _takeIfIn(s: ~[Member]): ~[Member]   = x.takeValuesBy(_.name.nameToId, s.map(_.name.nameToId))
  extension(x: ~[Member]) private def _dropIfIn(s: ~[Member]): ~[Member]   = x.dropValuesBy(_.name.nameToId, s.map(_.name.nameToId))
  extension(x: Member)    private def _isLocal               : Boolean     = x.inheritedFrom.filterNot(_.dri.id.startsWith(owner.id + "._")).isEmpty
  extension(x: Member)    private def _member_?              : Opt[Member] = x.signature.~.takeFirst(1).read_?.takeType[Link].map(_.dri.id.moduleId)
                                                                              .takeOnly(Id(owner.id.moduleId.real + "." + x.name.nameToId))
                                                                              .map_?(Registry.module_?).map(_.main)

  if(m.name in ("Val","G","Request")) this.aliases  = aliases.~.dropValuesBy(_.name,("~","<>","><","\\/")).><

object GeneralData:
  val ContainerNames = ><("~","<>","><","Buffer","Collection","Idx","Lookup","Opt","Pro","Promise","Result","Set","Fun")