package scalqa; package Any; package Value; package Long

import scala.{ Long => LONG }

abstract class Companion[THIS <: Long] protected (voidPrimitive: LONG = Void, voidDflt: LONG = 0) extends Value.Companion[THIS, LONG](voidPrimitive, voidDflt) {

  protected def tag[A <: LONG]: Tag[A] = Tag.Long

  private[scalqa] override def undo(v: THIS): LONG = v._real

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
 *   Companion object type required to be implemented for each new [[Any.Value.Long]] type
 *
 */
