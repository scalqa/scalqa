package scalqa; package Pipe; package Z; package evaluate

private[Pipe] object equalAllOpt {

  def apply[A](a1: Pipe[A], a2: Pipe[A], p: (A, A) => Boolean): Opt.Ok = {
    val it1 = a1.iterator
    val it2 = a2.iterator
    var o1 = it1.nextOpt; var o2 = it2.nextOpt;
    var i = 0
    while (o1) {
      if (!o2) return "First has more elements"
      if (!p(o1.value, o2.value)) return "Fail at index " + i + ": " + o1.value + " != " + o2.value
      o1 = it1.nextOpt; o2 = it2.nextOpt;
      i += 1
    }
    if (o2) "First has less elements" else Opt.Ok
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/