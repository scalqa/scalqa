package scalqa; package Any; package Value; package Double

import scala.{ Double => DBL }

abstract class Companion[THIS <: Double] protected (voidPrimitive: DBL = Void, voidDflt: DBL = 0) extends Value.Companion[THIS, DBL](voidPrimitive, voidDflt) {

  protected def tag[A <: DBL]: Tag[A] = Tag.Double

  private[scalqa] def undo(v: THIS): DBL = v._real

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Companion ->
 *
 *   Companion object type required to be implemented for each new [[Any.Value.Double]] type
 *
 */
