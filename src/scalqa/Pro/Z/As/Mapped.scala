package scalqa; package Pro; package Z; package As

private[Pro] class Mapped[A, B](protected val real: Pro[A], f: A => B) extends Pro[B] {

  def apply = f(real())

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/