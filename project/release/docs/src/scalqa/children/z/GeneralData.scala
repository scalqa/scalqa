package scalqa; package children; package z; import language.implicitConversions

class GeneralData(m: Member) extends Data(m):

  this.members  = { all.stream.take(_.kind.isClassLike).drop(_.dri.isTypeDef) ++ all.stream.takeValuesBy(_.kind.name, ("def","val","type")).mapOpt(_._memberOpt) }.sort.pack

  this.makers   = all.stream.take(m => !owner.kind.isObject && m.kind.isExtension && Docs.isMakerMethod(owner.name,m.name)).sort.pack

  val DefValVar = all.stream.takeValuesBy(_.kind.name, ("def","val","var"))
                  .drop(_.kind.isExtension && (m.kind.isObject || m.name.in("Base","Data","Ordered","Calculable","Numerical","Sequential")))
                  .drop(_.name == "this")._dropIfIn(members ++ makers).pack

  this.aliases  = all.stream.take(m => m.kind.name=="type" && m.name!="type")._dropIfIn(members)._dropIfIn(makers).pack

  this.aliases  = aliases ++ DefValVar.stream._takeIfIn(aliases) ++ DefValVar.stream._dropIfIn(aliases).take(_.name._isAliasName)

  this.types    = aliases.stream.take(Docs.isTypeLikeAlias).pack
  this.types    = {types.stream ++ aliases.stream.drop(_.kind.isTypeLike)._takeIfIn(types)}.sort.pack

  this.aliases  = aliases.stream._dropIfIn(types).pack


  this.extended = DefValVar.stream.take(_.origin.isExtension).pack

  this.defs     = DefValVar.stream._dropIfIn(aliases ++ extended).drop(_.name.startsWith("given")).drop(_.name.startsWith("implicit")).drop(v => DefValVar.stream.exists(_.name == v.name._propertyName)).pack

  this.exports  = all.stream.take(_.kind.isExported).sort.pack

  this.implicits= all.stream.take(m => m.kind.isImplicit && m.name.startsWith("implicit")).pack
  this.givens   = all.stream.take(m => m.kind.isGiven && m.name.startsWith("given")).pack

  aliases.stream.partition(_.name in GeneralData.ContainerNames).self(s => { this.containers=s.read.pack; this.aliases = s.read.pack })

  extensions = all.stream
             .take(_.kind.isExtension)
             .groupBy(m => Id(m.kind.cast[Kind.Extension].on.signature))
             .map(_.toList)
             .map[(ExtensionTarget,List[Member])](v => (v.head.kind.cast[Kind.Extension].on,v)).pack

  // ---------------------------------------------------------------------------------------------------------------------------------------------------
  extension(x: String)         private def _propertyName              : String        = if(x.endsWith("_=")) x.dropLast(2) + "Pro" else x + "Pro"
  extension(x: String)         private def _isAliasName               : Boolean       = x.charAt(0).isUpper && (x.length==1 || x.charAt(1).isLower)
  extension(x: Stream[Member]) private def _takeIfIn(s:Stream[Member]): Stream[Member]= x.takeValuesBy(_.name.lower, s.map(_.name.lower))
  extension(x: Stream[Member]) private def _dropIfIn(s:Stream[Member]): Stream[Member]= x.dropValuesBy(_.name.lower, s.map(_.name.lower))
  extension(x: Member)         private def _isLocal                   : Boolean       = x.inheritedFrom.filterNot(_.dri.id.startsWith(owner.id + "._")).isEmpty
  extension(x: Member)         private def _memberOpt                 : Opt[Member]   = x.signature.~~.takeFirst(1).readOpt.takeType[Link].map(_.dri.id.moduleId)
                                                                                         .takeOnly(Id(owner.id.moduleId.real + "." + x.name.lower))
                                                                                         .mapOpt(Registry.moduleOpt).map(_.main)
object GeneralData:
  val ContainerNames = Pack("Stream","Range","Pack","Buffer","Collection","Idx","Lookup","Opt","Pro","Promise","Result","Set","Fun","Array")