package scalqa; package Fx; package ComboBox

import javafx.scene.control.ComboBoxBase
import javafx.event.ActionEvent;

abstract class Like[A] protected extends A.Control {
  protected type REAL <: ComboBoxBase[A]

  def valuePro: Pro.OM[A] = Custom.ProWO(real.valueProperty); def value = real.getValue; def value_=(v: A) = real.setValue(v)

  def onAction(f: Action.Event => Any) = _onFxEvent[ActionEvent, Action.Event](real.onActionProperty, e => new Action.Event(e), f)

  def onActionRun(f: => Any): EventControl = onAction(e => f)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
