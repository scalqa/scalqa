package scalqa; package Short; package _library

trait _use extends Any with __ {

  def allUp: ~[Short] = new Z.all.Up(This)

  def allDown: ~[Short] = new Z.all.Down(This)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def allUp -> Up pipe
 *
 *   Creates a pipe of elements from ''this'' to [[Short.Max]]
 *   {{{ (0: Short).allUp.count().lp // Prints: 32768 }}}
 *
 * @def allDown -> Down pipe
 *
 *   Creates a pipe of elements from ''this'' to [[Short.Min]]
 *   {{{ (0: Short).allDown.count().lp // Prints: 32769 }}}
 */
