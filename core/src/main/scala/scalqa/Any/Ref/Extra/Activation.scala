package scalqa; package Any; package Ref; package Extra

trait Activation extends Event.Like {

  protected def _isActive: Boolean = {
    var in = false
    val b = _topEntry.all(Activation.Status).findOpt(e => {
      in = true;
      val b = e.value.asInstanceOf[() => Boolean]()
      if (!b) e.cancel
      b
    })
    if (!b && in) _fireEvent[Boolean => Any](Activation.Events, _(false))
    b
  }

  protected def _activate(activeRule: () => Boolean) = if (activeRule()) _isActive.I(b => { _addEntry(Activation.Status, activeRule); if (!b) _fireEvent[Boolean => Any](Activation.Events, _(true)) })

  protected def _onActivateDeactivate(f: Boolean => Any) = _addOrRemoveEvent(Activation.Events, f)

  protected def _onActivateRun(f: => Any) = _onActivateDeactivate(b => if (b) f)

  protected def _onDeactivateRun(f: => Any) = _onActivateDeactivate(b => if (!b) f)

}

private object Activation { object Status; object Events }
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
