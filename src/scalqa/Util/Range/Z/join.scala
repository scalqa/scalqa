package scalqa; package Util; package Range; package Z

private[Range] object join {

  def apply[A](x: Range[A], y: Range[A]): Range[A] =
    if (y.isVoid) x
    else if (x.isVoid) x.adapt(y)
    else if (Base.startContains(x, y.start, y.startExclusive))
      if (Base.endContains(x, y.end, y.endExclusive)) x
      else Base.make(x, x.start, x.startExclusive, y.end, y.endExclusive)
    else if (Range.endContains(y, x.end, x.endExclusive)) x.adapt(y)
    else Base.make(x, y.start, y.startExclusive, x.end, x.endExclusive)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
