package scalqa; package General.Tool

object VariableArguments {

  def apply[A](v: A*): Pipe[A] = ~.get(v: _*)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object VariableArguments ->  '''Variable Arguments Tool'''
 *
 *     Globally available tool under alias [[VariableArguments *]]
 *
 * @def apply -> Arguments pipe
 *
 *   Returns [[Pipe]] of passed arguments
 *
 *   {{{
 *       val ip: ~[Int]    = *(1, 4, 7, 9)
 *
 *       val sp: ~[String] = *("1", "4", "7", "9")
 *
 *       val ap: ~[Any]    = *(1, "4", 7, "9")
 *   }}}
 */
