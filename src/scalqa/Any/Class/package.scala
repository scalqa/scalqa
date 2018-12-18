package scalqa; package Any

package object Class {
  type Ilk = Ilk._Class

  def make[A](v: java.lang.Class[A]) = new Class(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object Class ->
 *
 *   Class can be created with a universal built-in constructor on any object
 *
 *   {{{
 *       12.Class.lp  // Prints: java.lang.Integer
 *   }}}
 */
