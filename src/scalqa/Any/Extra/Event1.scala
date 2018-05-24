package scalqa; package Any; package Extra

trait Event1 extends Event.Like {

  protected def _onEvent1[P1](scope: AnyRef, f: P1 => Any): Concurrent.Control = _addOrRemoveEvent(scope, f)

  protected def _fireEvent1[P1](scope: AnyRef, p1: P1) = _fireEvent[P1 => Any](scope, _(p1))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait Event1 ->
 *
 *   @example
 *   {{{
 *     class Eventfull extends Any.Extra.Event1 {
 *
 *       def onEvent(on: Int => Any) = _onEvent1(Eventfull.Scope, on)
 *
 *       protected def fireEvent(v: Int): Unit = _fireEvent1(Eventfull.Scope, v)
 *
 *     }
 *
 *     object Eventfull {
 *       private object Scope
 *     }
 *   }}}
 */
