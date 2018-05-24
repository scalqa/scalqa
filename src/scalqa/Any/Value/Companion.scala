package scalqa; package Any; package Value

import scala.language.implicitConversions

abstract class Companion[THIS, VAL] private[Value] (private[scalqa] val voidVal: VAL, private[scalqa] val voidDefault: VAL) {

  protected def get(v: VAL): THIS

  protected def void: THIS = get(voidVal)

  val map: BiMap[VAL, THIS] = new BiMap[VAL, THIS] {

    def apply(v: VAL): THIS = get(v)

    def undo(v: THIS): VAL = Companion.this.undo(v)

  }

  protected def tag[A <: VAL]: Tag[A]

  implicit def zzGet(v: \/.type): THIS = void

  private[scalqa] def undo(v: THIS): VAL
}

object Companion {

  private[scalqa] implicit class zzLibrary[THIS, VAL](val This: Companion[THIS, VAL]) extends AnyVal {

    @inline def tag[A <: VAL]: Tag[A] = This.tag

  }
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
 *   Companion object type required to be implemented for each new [[Any.Value]] type
 *
 * @def get -> By base value
 *
 *    Creates a new instance by base value
 *
 *   @val map -> Base mapping
 *
 *     [[BiMap]] between base and ''this'' types
 *
 */
