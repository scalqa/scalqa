package scalqa; package Util; package Range; package Z

private[Range] object overlapOpt {

  def apply[A](x: Range[A], y: Range[A]): Opt[Range[A]] =
    if (x.isVoid || y.isVoid)
      \/
    else if (Base.startContains(x, y.start, y.startExclusive))
      if (!Base.endContains(x, y.start, y.startExclusive)) \/
      else if (Base.endContains(x, y.end, y.endExclusive)) x.adapt(y)
      else Base.make(x, y.start, y.startExclusive, x.end, x.endExclusive)
    else {
      if (!Range.endContains(y, x.start, x.startExclusive)) \/
      else if (Range.endContains(y, x.end, x.endExclusive)) x
      else Base.make(x, x.start, x.startExclusive, y.end, y.endExclusive)
    }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
