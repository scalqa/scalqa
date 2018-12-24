package scalqa; package Custom; package Boolean

class _library private[scalqa] (private val real: Boolean) extends AnyVal {

  def toOpt[A](value: => A): Opt[A] = if (real) value else Opt.Void

  def ! : Boolean = !real

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def toOpt -> Value if `true`
 *
 *   Returns optional value if `This` is `true` and Opt.Void if `false`
 *
 *   {{{
 *       def isImmutable  : Boolean = true
 *       def isWritable   : Boolean = true
 *       def isWeired     : Boolean = false
 *
 *       def allAsStrings = ~[String] +~ isImmutable.toOpt("immutable") +~ isWritable.toOpt("writable") +~ isWeired.toOpt("weired")
 *
 *       allAsStrings lp // Prints: ~(mutable, writable)
 *   }}}
 *
 * @def ! -> Trailing 'not'
 *
 *     {{{
 *         if(fun1.fun2.fun3.
 *              fun4.fun5.fun6.
 *              fun7.fun8.fun9.
 *              fun10.isEmpty.!) ()
 *
 *        // If there is too much fun, the leading ! would be hard to detect
 *
 *     }}}
 */
