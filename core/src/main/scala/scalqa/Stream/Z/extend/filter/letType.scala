package scalqa; package Stream; package Z; package extend; package filter

private[Stream] object letType {

  def apply[@specialized(DATA) A, B](s: Stream[A], t: ClassTag[B]): Stream[B] = new Stream[B] with A.Extended[B] {

    protected var has = false
    protected var v: A = _

    protected def check(v: A) = t.unapply(v).isDefined

    def prime = has || { while (!has && real.prime) { v = real.pump; has = check(v) }; has }

    def pump = { has = false; v.asInstanceOf[B] }

    def foreach(c: Consumer[B]) = {
      if (has) c.accept(pump)
      class Each extends Consumer[A] { def accept(v: A) = if (check(v)) c.accept(v.asInstanceOf[B]) }
      s.foreach(new Each)
    }

    override def ilkOpt = Ilk.fromClass(t.runtimeClass)

    override def real = s
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
