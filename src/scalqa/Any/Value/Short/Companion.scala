package scalqa; package Any; package Value; package Short

import scala.{ Short => SHORT }

abstract class Companion[THIS <: Short] protected (voidPrimitive: SHORT = Void, voidDflt: SHORT = 0) extends Value.Companion[THIS, SHORT](voidPrimitive, voidDflt) {

  protected def tag[A <: SHORT]: Tag[A] = Tag.Short

  private[scalqa] override def undo(v: THIS): SHORT = v._real

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
 *   Companion object type required to be implemented for each new [[Any.Value.Short]] type
 *
 */
