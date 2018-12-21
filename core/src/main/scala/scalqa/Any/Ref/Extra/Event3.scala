package scalqa; package Any; package Ref; package Extra

trait Event3 extends Event.Like {

  protected def _onEvent3[P1, P2, P3](scope: AnyRef, f: (P1, P2, P3) => Any): EventControl = _addOrRemoveEvent(scope, f)

  protected def _fireEvent3[P1, P2, P3](scope: AnyRef, p1: P1, p2: P2, p3: P3) = _fireEvent[(P1, P2, P3) => Any](scope, _(p1, p2, p3))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait Event3 ->
 *
 *   {{{
 *     class Eventfull extends Any.Ref.Extra.Event3 {
 *
 *       def onEvent(on: (Int,Long,String) => Any) = _onEvent3(Eventfull.Scope, on)
 *
 *       protected def fireEvent(v: Int, l: Long, s: String): Unit = _fireEvent3(Eventfull.Scope, v, l, s)
 *
 *     }
 *
 *     object Eventfull {
 *       private object Scope
 *     }
 *   }}}
 */
