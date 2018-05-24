package scalqa; package Any; package Extra

trait Event0 extends Event.Like {

  protected def _onEvent0(scope: AnyRef, f: () => Any): Concurrent.Control = _addOrRemoveEvent(scope, f)

  protected def _fireEvent0(scope: AnyRef) = _fireEvent[() => Any](scope, _())

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait Event0 ->
 *
 *   @example
 *   {{{
 *     class Eventfull extends Any.Extra.Event0 {
 *
 *       def onEvent(on: () => Any) = _onEvent0(Eventfull.Scope, on)
 *
 *       protected def fireEvent: Unit = _fireEvent0(Eventfull.Scope)
 *
 *     }
 *
 *     object Eventfull {
 *       private object Scope
 *     }
 *   }}}
 */
