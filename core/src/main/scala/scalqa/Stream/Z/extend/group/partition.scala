package scalqa; package Stream; package Z; package extend; package group

private[Stream] object partition {

  @inline final def apply[A](src: Stream[A], groups: Array[Filter[A]]): Stream[~[A]] = new Stream[~[A]] with A.Extended[~[A]] {

    def real = src

    lazy val calculation = {
      val a = new Array[Idx.Array.Buffer[A]](groups.size + 1)
      val i = src.ilkDefault
      val sz = src.sizeOpt.map(_ / groups.length * 2) or App.initSize
      a.length.all(a(_) = Idx.Array.Buffer.makeSized(sz)(i))
      src.foreach(v => {
        var i = 0
        while (i < groups.size) if (!groups(i).allow(v)) i += 1 else { a(i) add v; i = a.size }
        if (i < a.size) {
          a(i) add v
        }
      })
      a.all.drop(_.size == 0).map(_.all)
    }

    def prime = calculation.prime

    def pump = calculation.pump

    def foreach(f: Consumer[~[A]]) = calculation.foreach(f)
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
