package scalqa; package Stream; package Z; package consume; package evaluate

private[Stream] object unequalOpt {

  def apply[A](p1: Stream[A], p2: Stream[A], s: (A, A) => Boolean): Opt[String] = {
    var i = 0
    do {
      if (p1.prime != p2.prime) return if (p1.prime) "First has more elements" else "First has less elements"
      val v1 = p1.pump
      val v2 = p2.pump
      if (!s(v1, v2)) return "Fail at index " + i + ": " + v1 + " != " + v2
      i += 1
    } while (p1.prime || p2.prime)
    \/
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
