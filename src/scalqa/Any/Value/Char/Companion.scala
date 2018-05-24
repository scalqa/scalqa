package scalqa; package Any; package Value; package Char

import scala.{ Char => CHAR }

abstract class Companion[THIS <: Char] protected (voidPrimitive: CHAR = Void, voidDflt: CHAR = 0) extends Value.Companion[THIS, CHAR](voidPrimitive, voidDflt) {

  protected def tag[A <: CHAR]: Tag[A] = Tag.Char

  private[scalqa] def undo(v: THIS): CHAR = v._real

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
 *   Companion object type required to be implemented for each new [[Any.Value.Char]] type
 *
 */
