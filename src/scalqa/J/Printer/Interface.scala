package scalqa; package J; package Printer

trait Interface {

  def apply(list: Any*): this.type = separated(String.Empty, list: _*)

  def ln(): this.type = print(String.Eol)

  def ln(first: Any, list: Any*): this.type = separated(String.Empty, (first +: list :+ String.Eol): _*)

  def ls(list: Any*): this.type = separated(String.Space, (list :+ String.Eol): _*)

  def separated(separator: String, list: Any*): this.type = print(list.all.format(separator))

  protected def print(s: String): this.type

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def apply -> Print.
 *
 *   Prints the ''list'' of passed elements.
 *
 *    @example
 *   {{{
 *       Print("1",'2',3)
 *       Print("1",'2',3)
 *
 *       // Output
 *      123123
 *   }}}
 *
 * @def ln() -> Print line break
 *
 *
 * @def ln(first -> Print line
 *
 *   Prints the ''first'' and the ''list'' of passed elements.
 *
 *   Line break added at the end.
 *
 *    @example
 *   {{{
 *       Print.ln("1",'2',3)
 *       Print.ln("1",'2',3)
 *
 *       // Output
 *      123
 *      123
 *   }}}
 *
 * @def ls -> Print line spaced
 *
 *   Prints the ''list'' of passed elements separated with one space character.
 *
 *   Line break added at the end.
 *
 *    @example
 *   {{{
 *       Print.ls("1",'2',3)
 *       Print.ls("1",'2',3)
 *
 *       // Output
 *      1 2 3
 *      1 2 3
 *   }}}
 *
 * @def separated -> Print separated.
 *
 *   Prints the ''list'' of passed elements separated with ''separator''.
 *
 *    @example
 *   {{{
 *       Print.separated("|","1",'2',3)
 *
 *       // Output
 *      1|2|3
 *   }}}
 */
