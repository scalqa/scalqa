package scalqa; package Any; package _library

trait _use[A] extends Any with __[A] {

  @inline def Class = new Any.Class[A](This.getClass.asInstanceOf[java.lang.Class[A]])

  @inline def cast[T]: T = This.asInstanceOf[T]

  @inline def I: Itself[A] = new Itself(This)

  @inline def Itself = I

  def isVoid: Boolean = Any.isVoid(This)
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def isVoid -> Void check
 *
 *    This is a universal way to check an instance for voidness
 *
 *     See [[Any.isVoid]] for details
 *
 *     {{{
 *        (null: String).isVoid lp  // Prints: true
 *
 *        "".isVoid lp              // Prints: true
 *
 *        (\/ : Percent).isVoid lp  // Prints: true
 *     }}}
 *
 * @def cast -> Type casting
 *
 *    ''cast'' is a shortcut for Scala's ''asInstanceOf''
 *
 *    {{{
 *       val a : Any = "abc"
 *
 *       val s: String = a.cast   // Context typed cast
 *
 *       a.cast[String].length lp // Prints: 3
 *    }}}
 *
 * @def Class -> Any.Class constractor
 *
 *     Built-in constructor for [[Any.Class]]
 *
 *     {{{
 *       "abc".Class lp  // Prints: java.lang.String
 *     }}}
 *
 * @def Itself -> Same as [[_use.I " I "]]
 *
 *     'Itself' is full version of [[_use.I " I "]] and is kept just in case [[_use.I " I "]] is disabled or for illustration purposes
 *
 * @def I: -> Any.Itself constractor
 *
 *     Built-in constructor for [[Any.Itself]]
 *
 *     [[Any.Itself]] becomes another library attached to every single object in Scalqa, but it has to be accessed over ".I" notation
 *
 *     {{{
 *       val txt = "abc".Text.I(_ lp) // Prints: "abc"
 *
 *       txt.I.id lp                  // Prints: scalqa.String.Text@1
 *
 *       txt.I.hashIndex lp           // Prints: 1
 *     }}}
 */
