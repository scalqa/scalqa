package scalqa; package Any; package Ref; package Extra

trait Event2 extends Event.Like {

  protected def _onEvent2[P1, P2](scope: AnyRef, f: (P1, P2) => Any): EventControl = _addOrRemoveEvent(scope, f)

  protected def _fireEvent2[P1, P2](scope: AnyRef, p1: P1, p2: P2) = _fireEvent[(P1, P2) => Any](scope, _(p1, p2))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait Event2 ->
 *
 *   {{{
 *     class Eventfull extends Any.Ref.Extra.Event2 {
 *
 *       def onEvent(on: (Int,Long) => Any) = _onEvent2(Eventfull.Scope, on)
 *
 *       protected def fireEvent(v: Int, l: Long): Unit = _fireEvent2(Eventfull.Scope, v, l)
 *
 *     }
 *
 *     object Eventfull {
 *       private object Scope
 *     }
 *   }}}
 */
