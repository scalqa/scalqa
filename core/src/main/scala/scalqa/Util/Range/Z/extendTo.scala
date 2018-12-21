package scalqa; package Util; package Range; package Z

private[Range] object extendTo {

  def apply[A](x: Range[A], a: A): Range[A] =
    if (a.isVoid) x
    else if (x.isVoid) Base.make(x, a, false, a, false)
    else if (!Base.startContains(x, a)) Base.make(x, a, false, x.end, x.endExclusive)
    else if (!Base.endContains(x, a)) Base.make(x, x.start, x.startExclusive, a, false)
    else x

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
