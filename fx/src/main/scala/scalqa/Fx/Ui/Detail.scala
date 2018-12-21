package scalqa; package Fx; package Ui

abstract class Detail[A <: AnyRef](private var value: A) extends Module with Pro.OM[A] with Pro.O.A.Base[A] {
  def this() = this(null.asInstanceOf[A])

  def apply = value

  def update(v: A): Unit = if (value != v) { value = v; fireChange }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
