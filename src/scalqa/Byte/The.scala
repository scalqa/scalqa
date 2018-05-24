package scalqa; package Byte

class The private (protected[Byte] val real: Byte) extends AnyVal with Like {
  protected type THIS = The

  protected def companion = The

}

object The extends Like.Companion[The] {

  def get(v: Byte) = new The(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class The -> '''The Byte'''
 *
 *   "The Byte" is the default [[Numeric]] implementation of [[Byte]] primitive
 *
 * @object The ->
 *
 *   The easiest way to build [[Byte.The]] is with built-in constructor
 *
 *   {{{
 *       val value : Byte.The = 10.toByte.The
 *
 *       val void  : Byte.The = \/
 *   }}}
 *
 * *
 */
