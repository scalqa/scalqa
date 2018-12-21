package scalqa; package Fx

package object Style {

  def make(v: String): Style = new Style(v)

  def Map = _Class.Map

  lazy val DefaultPro = new Pro.A.Setup[Refs[java.net.URL]](\/); def Default = DefaultPro()

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
