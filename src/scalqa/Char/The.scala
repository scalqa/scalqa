package scalqa; package Char

class The private (protected[Char] val real: Char) extends AnyVal with Like {
  protected type THIS = The

  protected def companion = The

}

object The extends Like.Companion[The] {

  def get(v: Char) = new The(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class The -> '''The Char'''
 *
 *   "The Char" is the default [[Numeric]] implementation of [[Char]] primitive
 *
 *
 */
