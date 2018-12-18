package scalqa; package Stream; package Z; package consume; package evaluate

private[Stream] object find {

  def indexOpt[@specialized(DATA) A](s: Stream[A], f: Filter[A]): Opt.Int = {
    var i = 0
    while (s.prime) {
      if (f.allow(s.pump)) return i
      i += 1
    }
    \/
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
