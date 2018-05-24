package scalqa; package Any; package _library

trait _opt[A] extends Any with __[A] {

  @inline def Opt: Opt[A] = if (This.isVoid) \/ else This

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _opt -> '''Option creation'''
 *
 * @def Opt -> Non void value option
 *
 *     Built-in constructor to create [[Opt]] with non void value
 *
 *     If value tests [[Any.isVoid]] positive, Opt.Void is returned
 *
 *     Note. 'null' is always void.
 *
 *     {{{
 *         var s: String  = null
 *         var p: Percent = \/
 *
 *         s.Opt lp    // Prints: Opt.Void
 *         p.Opt lp    // Prints: Opt.Void
 *
 *         s = "abc"
 *         p = 12
 *
 *         s.Opt lp    // Prints: Opt(abc)
 *         p.Opt lp    // Prints: Opt(12.0%)
 *     }}}
 */
