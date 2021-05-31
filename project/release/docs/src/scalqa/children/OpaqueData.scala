package scalqa; package children; import language.implicitConversions

class OpaqueData(m: Member) extends Data(m):

  //"Opaque: " + m.dri.tag +"       " + m.dri.id  tp()

//  if(owner.dri.anchor!="opaque")
  this.defs = all.~.take(_.kind.isExtension)
         //          .groupBy(m => { val id = Id(m.kind.asInstanceOf[Kind.Extension].on.signature);  id})
         //          .toSeq.map((_,v) => (v.head.kind.asInstanceOf[Kind.Extension].on,v.map(Mem(_)).sorted))


