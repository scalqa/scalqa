package scalqa; package Any; package _library

trait _printDebug[A] extends Any with __[A] {

  def lp: Unit = Print.ln(This.I.infoLine)

  def lp(tag: String): Unit = Print.ln(tag + This.I.infoLine)

  def tp: Unit = Print.ln(This.I.infoText)

  def tp(tag: String): Unit = Print.ln(This.I.infoText.indent(tag))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _printDebug -> '''Debug Printing'''
 *
 *   These are "self printing to console" operations attached to ''every'' single object in Scalqa
 *
 *   These methods are primarily for debugging, that is why names are short and cryptic
 *
 *   Note: There are similar operations in [[Any.Itself._printDebug]] library with slightly different semantics
 *   {{{
 *      // Compare
 *
 *      App.Memory lp   // Prints: Memory{max=15.2gB,total=1.0gB,free=986.2mB,used=42.9mB}
 *
 *      App.Memory.I.lp // Prints: scalqa.App.Memory{max=15.2gB,total=1.0gB,free=986.2mB,used=42.9mB}
 *   }}}
 *
 * @def lp: -> Line print
 *
 *     Prints [[Able.Info]].infoLine to console
 *
 *     If [[Able.Info]] is not implemented, ''toString'' is used
 *
 *     {{{ App.Memory lp   // Prints: Memory{max=15.2gB,total=1.0gB,free=986.2mB,used=42.9mB} }}}
 *
 * @def lp( -> Line print tagged
 *
 *     Prints same as parameterless ''lp'' prefixed with ''tag''
 *
 * @def tp: -> Text print
 *
 *    Prints [[Able.Info]].infoText to console
 *
 *    If [[Able.Info]] is not implemented, ''toString'' is used
 *    {{{
 *       App.Memory.I tp
 *
 *       // Output
 *       Memory{max=15.2gB,
 *              total=1.0gB,
 *              free=986.2mB,
 *              used=42.9mB}
 *    }}}
 *
 * @def tp( -> Text print tagged
 *
 *     Prints same as parameterless ''tp'' indented with ''tag''
 */
