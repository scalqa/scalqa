package scalqa; package Pipe; package Z; package reduce

private[Pipe] object fold {

  def opt[A](src: Flow[A], op: (A, A) ⇒ A): Opt[A] = {
    var o: Opt[A] = \/
    src(v => o = if (o) o.map(op(_, v)) else v)
    o
  }

  def as[A, B](src: Pipe[A], start: B, op: (B, A) ⇒ B): B = {
    var b = start
    src(a => b = op(b, a))
    b
  }

  def asOpt[A, B](src: Flow[A], start: B, op: (B, A) ⇒ B): Opt[B] = {
    var v = start
    var b = false
    src.apply(a => { b = true; v = op(v, a) })
    if (b) v else \/
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
