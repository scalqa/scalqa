package scalqa; package Index; package Z; package As

private[scalqa] class Tail[A](protected val real: Index[A], protected val from: Int) extends Index[A] {

  def apply(i: Int) = real(i + from)

  def size = real.size - from max 0

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/