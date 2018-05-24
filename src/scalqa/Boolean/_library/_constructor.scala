package scalqa; package Boolean; package _library

trait _constructor extends Any with __ {

  def Rich = new scala.runtime.RichBoolean(This)

  def The = Boolean.The.get(This)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def The -> "The Boolean" constructor
 *
 *     Built-in constructor to create [[Boolean.The]] instances
 *
 *     {{{ true.The.Class.lp  // Prints: scalqa.Boolean.The}}}
 */
