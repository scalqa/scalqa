package scalqa; package Sorting; package Z; package The

private[Sorting] class Prioritized[A](s: Sorting[A], priority: A => Int) extends Sorting[A] {

  def position(x: A, y: A) = {
    val xr = priority(x)
    val yr = priority(y)
    if (xr > yr) Sorting.Position.AsIs
    else if (xr < yr) Sorting.Position.Inverse
    else s(x, y)
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/