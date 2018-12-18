package scalqa; package Idx; package Z; package A

private[scalqa] class Tail[A](protected val real: Idx[A], protected val from: Int) extends Idx[A] {

  def apply(i: Int) = real(i + from)

  def size = real.size - from max 0

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/