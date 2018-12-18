package scalqa; package Custom; package Ordering; package Z

private[Ordering] class PrioritizedView[A](o: math.Ordering[A], priority: A => Int) extends Ordering[A] {

  def compare(x: A, y: A) = {
    val xr = priority(x)
    val yr = priority(y)
    if (xr > yr) -1
    else if (xr < yr) 1
    else o.compare(x, y)
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
