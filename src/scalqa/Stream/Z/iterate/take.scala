package scalqa; package Stream; package Z; package iterate

private[Stream] object take {

  def apply[@specialized(DATA) A](s: Stream[A], cnt: Int): Stream[A] = if (cnt <= 0 || !s.prime) \/ else {
    var i = 0
    val a = s.ilkOpt.map(_.mkArray[A](cnt)) or {
      val v = s.pump
      val a = v.I.ilk.mkArray[A](cnt)
      a(0) = v
      i += 1
      a
    }
    while (i < cnt && s.prime) { a(i) = s.pump; i += 1 }
    Custom.Array.Z.stream(a, i)
  }
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
