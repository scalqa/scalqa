package scalqa; package Any; package Value; package Int

import scala.{ Int => INT }

abstract class Companion[THIS <: Int] protected (voidPrimitive: INT = Void, voidDflt: INT = 0) extends Value.Companion[THIS, INT](voidPrimitive, voidDflt) {

  protected def tag[A <: INT]: Tag[A] = Tag.Int

  private[scalqa] override def undo(v: THIS): INT = v._real

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
 *   Companion object type required to be implemented for each new [[Any.Value.Int]] type
 *
 */
