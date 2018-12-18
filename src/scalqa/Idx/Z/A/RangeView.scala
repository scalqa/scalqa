package scalqa; package Idx; package Z; package A

private[scalqa] class RangeView[A](protected val real: Idx[A], protected val range: Idx.Range) extends Idx[A] {

  def apply(i: Int) = real(i + range.start)

  def size = range.size

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
