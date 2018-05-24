package scalqa; package Float

class The private (protected[Float] val real: Float) extends AnyVal with Like {
  protected type THIS = The

  protected def companion = The

}

object The extends Like.Companion[The] {

  def get(v: Float) = new The(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class The -> '''The Float'''
 *
 *   "The Float" is the default [[Numeric]] implementation of [[Float]] primitive
 *
 *
 */
