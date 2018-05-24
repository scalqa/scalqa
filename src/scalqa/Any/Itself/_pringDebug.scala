package scalqa; package Any; package Itself

trait _printDebug[A] extends Any with __[A] {

  def lp: Unit = Print.ln(line)

  def lp(tag: String): Unit = Print.ln(tag + line)

  def tp: Unit = Print.ln(text)

  def tp(tag: String): Unit = Print.ln(text.indent(tag))

  private def line = This.I.infoOpt.map(_.infoLine(This.Class.toString)) or This.I.toString
  private def text = This.I.infoOpt.map(_.infoText(This.Class.toString)) or This.I.toString.Text
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
 *   These are "self print to console" operations
 *
 *   These methods are primarily for debugging, that is why names are short and cryptic
 *
 *   Note: There are similar operations in [[Any._library._printDebug]] library with slightly different semantics
 *   {{{
 *      // Compare
 *
 *      App.Memory.I.lp // Prints: scalqa.App.Memory{max=15.2gB,total=1.0gB,free=986.2mB,used=42.9mB}
 *
 *      App.Memory lp   // Prints: Memory{max=15.2gB,total=1.0gB,free=986.2mB,used=42.9mB}
 *   }}}
 *
 * @def lp: -> Line print
 *
 *     Prints class name and [[Able.Info]].info properties to console
 *
 *     If [[Able.Info]] is not implemented, ''toString'' is used
 *     {{{ App.Memory.I.lp // Prints: scalqa.App.Memory{max=15.2gB,total=1.0gB,free=986.2mB,used=42.9mB} }}}
 *
 * @def lp( -> Line print tagged
 *
 *     Prints same as parameterless ''lp'' prefixed with ''tag''
 *
 * @def tp: -> Text print
 *
 *    Prints class name and [[Able.Info]].info properties formatted as text to console
 *
 *    If [[Able.Info]] is not implemented, ''toString'' is used
 *    {{{
 *       App.Memory.I.tp
 *
 *       // Output
 *       scalqa.App.Memory{max=15.2gB,
 *                         total=1.0gB,
 *                         free=986.2mB,
 *                         used=42.9mB}
 *    }}}
 *
 * @def tp( -> Text print tagged
 *
 *     Prints same as parameterless ''tp'' indented with ''tag''
 *
 */
