package scalqa; package General.Tool

object Print extends J.Printer.Interface {

  protected def print(s: String): this.type = { System.out.print(s); this }

  def stackTrace: Unit = new Exception { setStackTrace(getStackTrace.drop(1)) }.printStackTrace

  def stackTraceAndExit: Nothing = { stackTrace; App.exit; Fail.state() }

  val Error: J.Printer.Interface = error

  // -------------------------------------------------------------
  import scala.language.implicitConversions

  implicit def zzFunction1(v: Print.type): (Any => Any) = a => apply(a)

  // *******************************************************
  private object error extends J.Printer.Interface { protected def print(s: String): this.type = { System.err.print(s); this } }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object Print -> '''Console Printer'''
 *
 *     Globally available console printer
 *
 *     Prints to ''java.lang.System.out''
 *
 *     {{{
 *         def name  : String = "degree"
 *         def value : Int    = 60
 *
 *         Print.ln("name=", name," value=", value)
 *
 *         // Output
 *         name=degree value=60
 *     }}}
 *
 * @val Error -> Error printer
 *
 *     Prints to ''java.lang.System.err''
 *
 *     {{{
 *         def name  : String = "degree"
 *         def value : Int    = 60
 *
 *         Print.Error.ln("name=", name," value=", value)
 *
 *         // Error Output
 *         name=degree value=60
 *     }}}
 *
 * @def stackTrace: -> Prints current stack trace.
 *
 * @def stackTraceAndExit: -> Prints current stack trace and values [[App.exit]].
 *
 */
