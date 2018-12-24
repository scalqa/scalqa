package scalqa; package Stream; package Z; package extend; package filter

private[Stream] object dropVoid {

  def apply[@specialized(DATA) A](s: Stream[A]): Stream[A] = new Stream[A] with A.Extended.Filter[A] {
    protected var has = false
    protected var v: A = _

    def prime = has || { while (!has && real.prime) { v = real.pump; has = !Any.isVoid(v) }; has }

    def pump = { has = false; v }

    def foreach(c: Consumer[A]) = {
      if (has) c.accept(pump)
      s.foreach(new Consumer[A] { def accept(v: A) = if (!Any.isVoid(v)) c.accept(v) })
    }

    override def real = s
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
