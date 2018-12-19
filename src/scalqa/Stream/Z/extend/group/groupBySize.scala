package scalqa; package Stream; package Z; package extend; package group

private[Stream] object groupBySize {

  @inline def apply[@specialized(DATA) A](s: Stream[A], size: Int): Stream[~[A]] = new Stream.A.Base[~[A]] with A.Extended[~[A]] {
    protected val real = s

    @inline def prime = real.prime

    @inline def pump = real.take(size)

    @inline override def ilkOpt = Ilk.Refs

    if (size <= 0) App.Fail.argument("size" + '=' + size)
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
