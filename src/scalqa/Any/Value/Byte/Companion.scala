package scalqa; package Any; package Value; package Byte

import scala.{ Byte => BYTE }

abstract class Companion[VAL <: Byte](voidPrimitive: BYTE = -127, voidDflt: BYTE = -127) extends Value.Companion[VAL, BYTE](voidPrimitive, voidDflt) {

  protected def tag[A <: BYTE]: Tag[A] = Tag.Byte

  private[scalqa] override def undo(v: VAL): BYTE = v._real

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
 *   Companion object type required to be implemented for each new [[Any.Value.Byte]] type
 *
 */
