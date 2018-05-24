package scalqa; package Any; package Value; package Float

import scala.{ Float => FLOAT }

abstract class Companion[THIS <: Float] protected (voidPrimitive: FLOAT = Void, voidDflt: FLOAT = 0) extends Value.Companion[THIS, FLOAT](voidPrimitive, voidDflt) {

  protected def tag[A <: FLOAT]: Tag[A] = Tag.Float

  private[scalqa] def undo(v: THIS): FLOAT = v._real

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
 *   Companion object type required to be implemented for each new [[Any.Value.Float]] type
 *
 */
