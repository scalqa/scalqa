package scalqa; package Pro; package Z; package A

private[Pro] abstract class Base[A] extends Pro[A] with Any.Able.ToInfo {

  def toInfo = new Pro.Info(this) +~= this.I.letType[Any.Able.Name].map(n => ("name", n.name)) += ("value", apply)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
