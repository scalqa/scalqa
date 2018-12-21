package scalqa; package Any; package Able

trait ToText extends Any {

  def toText: String

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *
 * @trait ToText -> `Text Able`
 *
 * @def toText -> Custom multi-line description
 *
 *   This description can easily printed out with globally available `tp` (text print) method
 *
 *   {{{
 *       object Foo extends Any.Able.ToText{
 *
 *           def toText = "111\n2222\n333".Text
 *       }
 *
 *      Foo.tp
 *
 *      // Output
 *      111
 *      2222
 *      333
 *   }}}
 */
