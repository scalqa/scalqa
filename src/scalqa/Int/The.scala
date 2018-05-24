package scalqa; package Int

class The private (protected[Int] val real: Int) extends AnyVal with Like {
  protected override type THIS = The

  protected def companion = The

}

object The extends Like.Companion[The] {

  def get(v: Int) = new The(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class The -> '''The Int'''
 *
 *   "The Int" is the default [[Numeric]] implementation of [[Int]] primitive
 *
 *
 */
