package scalqa; package Byte; package _library

trait _use extends Any with __ {

  def allUp: ~[Byte] = new Z.all.Up(This)

  def allDown: ~[Byte] = new Z.all.Down(This)

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
 *   Creates a pipe of elements from ''this'' to [[Byte.Max]]
 *   {{{ 0.toByte.allUp.count() lp // Prints: 128 }}}
 *
 * @def allDown -> Down pipe
 *
 *   Creates a pipe of elements from ''this'' to [[Byte.Min]]
 *   {{{ 0.toByte.allDown.count() lp // Prints: 129 }}}
 *
 */
