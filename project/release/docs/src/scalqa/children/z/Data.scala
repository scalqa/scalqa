package scalqa; package children; package z; import language.implicitConversions

class Data(val owner: Member):

  val all: ><[Member] = owner.members.~.drop(m => Docs.isHiddenName(owner,m.name)).><

  var members,
      aliases,
      containers,
      types,
      defs,
      extended,
      exports,
      implicits,
      givens,
      makers    : ><[Member] = \/

  var extensions: ><[(ExtensionTarget,List[Member])] = \/

  // -------------------------------------------------------------------------------------------------------
  given ordering: Ordering[Member] with
    extension(inline x: Member) inline def typ = if(x.kind.isType) 0 else 1
    def compare(x:Member,y:Member) = { var i=stringOrdering.compare(x.name,y.name); if(i!=0) i else x.typ - y.typ }
