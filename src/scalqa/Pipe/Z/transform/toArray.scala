package scalqa; package Pipe; package Z; package transform

private[Pipe] object toArray extends To[Array](false, classOf[Array[Any]]) {

  override def opt[A](f: Flow[A], t: Tag[A]): Opt[Array[A]] = f.sizeOpt.I.to(so => {
    f match {
      case l if so.letOnly(0)      => \/ : Array[A]
      case l if t.isVoid.not && so => Array.get[A](so.value)(t).loadFlowAt(0, l, so.value)
      case p: Pipe[_]              => p.cast[Pipe[A]].yieldSizeAndTag.to((p, sz, tg) => apply(p, tg))
      case l                       => apply(f.to(To.CollVal, t).all, t)
    }
  })

  def raw[A](f: Pipe[A], ct: scala.reflect.ClassTag[A]): Array.Raw[A] = f.sizeOpt.map(ct.newArray(_)).apply(a => Array.getByRaw(a).loadFlowAt(0, f, a.length)) or raw(f.yieldSize.to((a, _) => a), ct)

  // ****************************************************************************************
  object Refs extends To[Refs](false, classOf[Refs[Any]]) {
    override def opt[A](f: Flow[A], t: Tag[A]): Opt[Refs[A]] = toArray.opt(f, t).map(_.Refs)
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
