package scalqa; package Custom; package Ordering; package Z

private[scalqa] class Wrap[A](val real: math.Ordering[A]) extends Ordering[A] {

  def compare(x: A, y: A) = real.compare(x, y)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
