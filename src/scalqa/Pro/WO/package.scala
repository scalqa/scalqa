package scalqa; package Pro

package object WO {
  type The[A <: AnyRef] = The._Class[A]

  def get[A](v: A): WO[A] with Any.O.Source = The._Class(v)

  def getNamed[A](name: String, v: A)(implicit ct: Tag[A]): WO[A] with Able.Name with Any.O.Source = The.Named(name, v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
