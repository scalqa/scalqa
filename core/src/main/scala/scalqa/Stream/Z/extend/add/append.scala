package scalqa; package Stream; package Z; package extend; package add

private[Stream] object append {

  def apply[@specialized(DATA) A](s: Stream[A], value: A): Stream[A] = new Stream[A] with A.Extended.All[A] {

    protected var hot = true

    def prime = real.prime || hot

    def pump =
      if (real.prime) real.pump
      else if (hot) { hot = false; value }
      else Stream.failEmpty

    def foreach(c: Consumer[A]) = {
      real.foreach(c)
      if (hot) { hot = false; c.accept(value) }
    }

    override def sizeOpt = real.sizeOpt.map(_ + (if (hot) 1 else 0))

    def real = s
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
