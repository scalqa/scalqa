package scalqa; package children; package z; import language.implicitConversions

class OpaqueData(m: Member) extends Data(m):

  //"Opaque: " + m.dri.tag +"       " + m.dri.id  tp()

//  if(owner.dri.anchor!="opaque")
  this.defs = all.stream.take(_.kind.isExtension).pack
         //          .groupBy(m => { val id = Id(m.kind.asInstanceOf[Kind.Extension].on.signature);  id})
         //          .toSeq.map((_,v) => (v.head.kind.asInstanceOf[Kind.Extension].on,v.map(Mem(_)).sorted))


