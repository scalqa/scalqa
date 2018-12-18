package scalqa; package Idx; package Z; package A

private[scalqa] class JavaList[A](protected val real: Idx[A]) extends Custom.List[A] {

  def get(i: Int): A = real(i)

  def size = real.size

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
