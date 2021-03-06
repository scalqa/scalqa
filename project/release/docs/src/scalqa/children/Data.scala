package scalqa; package children; import language.implicitConversions

class Data(val owner: Member):

  val all: ><[Member] = owner.members.~.dropOnlyBy(_.name,"THIS_TYPE"/*,"NumericOps","OrderingOps"*/).drop(m => Docs.isHiddenName(owner,m.name))

  var members,
      aliases,
      types,
      defs,
      extended,
      exports,
      makers    : ><[Member] = \/

  var extensions: ><[(ExtensionTarget,List[Member])] = \/

  // -------------------------------------------------------------------------------------------------------
  given ordering: Ordering[Member] with
    extension(inline x: Member) inline def typ = if(x.kind.isType) 0 else 1
    def compare(x:Member,y:Member) = { var i=stringOrdering.compare(x.name,y.name); if(i!=0) i else x.typ - y.typ }
