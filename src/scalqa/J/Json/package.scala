package scalqa; package J

package object Json {
  type Object = Object._Trait
  type Array = Array._Trait

  def format(l: Data): String = App.Pro.JsonFormat().format(l)

  def parseOpt(s: String): Opt.orError[Data] = App.Pro.JsonFormat().parseOpt(s)

  def parseObjectOpt(s: String): Opt.orError[Object] = parseOpt(s).validateAs(classOf[Object])

  def parseArrayOpt(s: String): Opt.orError[Array] = parseOpt(s).validateAs(classOf[Array])

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
