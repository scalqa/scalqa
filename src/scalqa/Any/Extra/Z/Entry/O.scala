package scalqa; package Any; package Extra; package Z; package Entry

private[Extra] class O(child: Entry, scope: AnyRef, value: Any) extends Entry(child, scope, value) {

  def init {
    this.onCancelRun(fire(O.Action.Remove))
    fire(O.Action.Add)
  }

  private def fire(a: O.Action): Unit = all(O.Scope).map(_.value.cast[O.Listener]).let(l => l.targetScope == scope && l.action == a).apply(_.on(this))

}

private[Extra] object O {

  object Scope

  sealed class Action
  object Action {
    object Add extends Action
    object Remove extends Action
  }

  class Listener(val targetScope: Any, val action: Action, val on: Entry => Any)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
