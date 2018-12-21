package scalqa; package Fx; package Custom

import javafx.beans.value.ChangeListener
import javafx.beans.InvalidationListener

trait ObservableBase[A] extends javafx.beans.value.ObservableValue[A] {
  private var _listeners: Refs[AnyRef] = \/

  def addListener(l: InvalidationListener): Unit = _add(l)
  def removeListener(l: InvalidationListener): Unit = _remove(l)

  def addListener(l: ChangeListener[_ >: A]): Unit = _add(l)
  def removeListener(l: ChangeListener[_ >: A]): Unit = _remove(l)

  protected def fireInvalidate { _listeners.all.letType[InvalidationListener].foreach(_.invalidated(this)) }
  protected def refresh(v: A, old: A) { _listeners.all.letType[ChangeListener[A]].foreach(_.changed(this, old, v)) }

  protected def listenerCount = _listeners.size

  protected def whenStartListening: Unit = ()
  protected def whenStopListening: Unit = ()

  // -----------------------------------------------------------------------------------------------------
  private def _add(l: AnyRef): Unit = { _listeners += l; if (_listeners.size == 1) whenStartListening }
  private def _remove(l: AnyRef): Unit = if (!_listeners.isEmpty) {
    val sz = _listeners.size - 1;
    _listeners -= l;
    if (sz != _listeners.size) App.Fail("to remove listener: " + l)
    if (_listeners.isEmpty) whenStopListening
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
