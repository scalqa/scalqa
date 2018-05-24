package scalqa; package Index; package Z; package As

private[Index] class Mapped[A, B](protected val real: Index[A], map: A => B) extends Index[B] {

  def apply(i: Int) = map(real(i))

  def size = real.size

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/