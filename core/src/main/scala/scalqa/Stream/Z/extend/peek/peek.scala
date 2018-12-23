package scalqa; package Stream; package Z; package extend; package peek

private[Stream] object peek {

  @inline final def apply[@specialized(DATA) A](s: Stream[A], f: Consumer[A]): Stream[A] = new Stream[A] with A.Extended.All[A] {

    @inline final def real = s

    @inline final def prime = real.prime

    @inline final def pump = { val v = real.pump; f.accept(v); v }

    @inline final def foreach(c: Consumer[A]) = s.foreach(new Consumer[A] { def accept(v: A) = { f.accept(v); c.accept(v) } })

  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
