package scalqa; package Pro; package O; package Z; package As

private[Pro] class Mapped[A, B](protected override val real: O[A], as: A => B) extends Pro.Z.As.Mapped[A, B](real, as) with O[B] {

  def onChange(f: () => Any) = real.onChange(f)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/