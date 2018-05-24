package scalqa; package Index; package Z; package As

private[scalqa] class Reversed[A](protected val real: Index[A]) extends Index[A] {

  def apply(i: Int) = real(size - i - 1)

  def size = real.size

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/