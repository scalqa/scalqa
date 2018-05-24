package scalqa; package Double

class The private (protected[Double] val real: Double) extends AnyVal with Like {
  protected override type THIS = The

  protected def companion = The

}

object The extends Like.Companion[The] {

  def get(v: Double) = new The(v)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class The -> '''The Double'''
 *
 *   "The Double" is the default [[Numeric]] implementation of [[Double]] primitive
 *
 *
 */