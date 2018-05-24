package scalqa; package Index; package Z; package As

private[scalqa] class Ranged[A](protected val real: Index[A], protected val range: Int.Range) extends Index[A] {

  def apply(i: Int) = real(i + range.start)

  def size = range.size

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/