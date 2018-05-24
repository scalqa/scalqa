package scalqa; package Float; package _library

trait _constructor extends Any with __ {

  def Rich = new scala.runtime.RichFloat(This)

  def The: Float.The = Float.The.get(This)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def The -> "The Float" constructor
 *
 *     Built-in constructor to create [[Float.The]] instances
 *
 *     {{{ 0F.The.Class.lp  // Prints: scalqa.Float.The}}}
 *
 * @def Rich -> Scala library
 *
 *   Provides access to Scala RichFloat library.
 *
 *   This library is available by default in Scala, but is disabled in Scalqa
 *
 *   {{{
 *      100f.Rich.toDegrees.lp  // Prints: 5729.578
 *   }}}
 *
 */
