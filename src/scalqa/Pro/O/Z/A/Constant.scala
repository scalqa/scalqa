package scalqa; package Pro; package O; package Z; package A

private[Pro] class Constant[A](val apply: A) extends O[A] {

  def onChange(f: () => Any) = \/

  override def equals(that: Any) = that.I.letType[Constant[A]].let(_.apply == apply)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
