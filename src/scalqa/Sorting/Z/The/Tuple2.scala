package scalqa; package Sorting; package Z; package The

private[Sorting] class Tuple2[A, B](oa: Sorting[A], ob: Sorting[B]) extends Sorting[(A, B)] {

  def position(x: (A, B), y: (A, B)) = oa(x._1, y._1) ifEither ob(x._2, y._2)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/