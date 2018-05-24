package scalqa; package Any; package Extra

trait Event4 extends Event.Like {

  protected def _onEvent4[P1, P2, P3, P4](scope: AnyRef, f: (P1, P2, P3, P4) => Any): Concurrent.Control = _addOrRemoveEvent(scope, f)

  protected def _fireEvent4[P1, P2, P3, P4](scope: AnyRef, p1: P1, p2: P2, p3: P3, p4: P4) = _fireEvent[(P1, P2, P3, P4) => Any](scope, _(p1, p2, p3, p4))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait Event4 ->
 *
 *   @example
 *   {{{
 *     class Eventfull extends Any.Extra.Event4 {
 *
 *       def onEvent(on: (Int,Long,String,String) => Any) = _onEvent4(Eventfull.Scope, on)
 *
 *       protected def fireEvent(v: Int, l: Long, s1: String, s2: String): Unit = _fireEvent4(Eventfull.Scope, v, l, s1, s2)
 *
 *     }
 *
 *     object Eventfull {
 *       private object Scope
 *     }
 *   }}}
 */
