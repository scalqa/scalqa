package scalqa; package Stream; package Z; package extend; package group

private[Stream] object group {

  @inline def apply[@specialized(DATA) A](s: Stream[A], groupper: (A, A) => Boolean, peeker: (A, Boolean) => Any): Stream[~[A]] = new Stream.A.Base[~[A]] with A.Extended[~[A]] {
    protected val real = s.preview

    protected var value: A = _

    @inline def prime = real.prime

    def pump = {
      var isFirst = true
      real.takeWhile(v => {
        var r = true
        if (!isFirst) r = groupper(value, v)
        if (r) peeker(v, isFirst)
        isFirst = false
        value = v
        r
      })
    }

    @inline override def ilkOpt = Ilk.Refs
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
