package scalqa; package Sorting; package Z; package The

private[Sorting] class Tuple3[A, B, C](oa: Sorting[A], ob: Sorting[B], oc: Sorting[C]) extends Sorting[(A, B, C)] {

  def position(x: (A, B, C), y: (A, B, C)) = oa(x._1, y._1) ifEither ob(x._2, y._2) ifEither oc(x._3, y._3)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/