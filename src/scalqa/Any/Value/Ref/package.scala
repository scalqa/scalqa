package scalqa; package Any; package Value

package object Ref {
  type Companion[REF <: Ref[VAL], VAL <: AnyRef] = Companion._Class[REF, VAL]

  protected[scalqa] val Class = classOf[Ref[_]]

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
