package scalqa; package fx; package control; package comboBox

import javafx.scene.control.ComboBoxBase
import javafx.event.ActionEvent;

abstract class Base[A] extends Control:
  protected type REAL <: ComboBoxBase[A]

  def valuePro                          : Pro.OM[A]     = Fx.JavaFx.To.pro_OM(real.valueProperty)
  def value                             : A             = real.getValue
  def value_=(v: A)                     : Unit          = real.setValue(v)

  def onAction[U](l: Action.Event => U) : Event.Control = _onFxEvent[ActionEvent, Action.Event, U](real.onActionProperty, Action.Event(_), l)
  def onActionRun[U](l: => U)           : Event.Control = onAction(e => l)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
