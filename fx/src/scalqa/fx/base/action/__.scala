package scalqa; package fx; package base; import action.*; import language.implicitConversions

import javafx.scene.control.MenuItem;
import javafx.event.ActionEvent;

class Action(label: String = \/) extends Abstract.Delegate.Gui:
  protected type REAL <: MenuItem
  protected          def _createReal                      : REAL              = new MenuItem(label.^.? or null) { setUserData(Action.this) }.cast[REAL]
  /**/               def onAction[U](l: Event => U)       : Gen.Event.Control = _onFxEvent[ActionEvent,U](real.onActionProperty, Gen.Event.Id.map1(l,(e: ActionEvent) => l(Event(e))))
  /**/               def onActionRun[U](run: => U)        : Gen.Event.Control = onAction(e => run)
  /**/               def toMenuItem                       : Menu.Item         = this match { case v: Menu.Item => v; case _ => Menu.Item(this) }

  /**/               def visible                          : Boolean           = real.isVisible
  /**/               def visible_=(b: Boolean)            : Unit              = real.setVisible(b)
  @tn("visible_Pro") def visible_*                        : Boolean.Pro.OM    = Fx.JavaFx.To.pro_OM(real.visibleProperty)

  /**/               def text                             : String            = real.getText
  /**/               def text_=(v: String)                : Unit              = real.setText(v)
  @tn("text_Pro")    def text_*                           : String.Pro.OM     = Fx.JavaFx.To.pro_OM(real.textProperty)

  /**/               def enable                           : Boolean           = !real.isDisable
  /**/               def enable_=(b: Boolean)             : Unit              = real.setDisable(!b)
  @tn("enable_Pro")  def enable_*                         : Pro.OM[Boolean]   = Fx.JavaFx.To.pro_OM(real.disableProperty).mutableMap_^(using zBooleanReverse)

  @tn("scene_Opt")   def scene_?                          : Opt[Scene]        = \/


object Action:
  def apply(mi: MenuItem)                                 : Action            = mi.getUserData.cast[Action]
  def apply(n: Fx.Node)                                   : Action            = n match { case v: Action => v; case v => new Menu.Item.Custom(v) }
  def apply(s: SEPARATOR)                                 : Action            = new z.Separator
  def apply(n: Fx.Node.Like)                              : Action            = new z.Basic(n)
  def apply(n1: Fx.Node.Like, n2: Fx.Node.Like)           : Action            = Action(Pane(n1, n2))
  def apply[U](label: String, enabled: Boolean, l: ()=>U) : Action            = { val a = new Action(label); a.enable = enabled; a.onAction(Gen.Event.Id.map1(l,_ => l())); a }
  def apply[U](label: String, l: () => U)                 : Action            = Action(label, true, l)
  def apply(label: String)                                : Action            = new Action(label)

  implicit inline def implicitFrom(v: Fx.Node)            : Action            = apply(v)
  implicit inline def implicitFrom(v: SEPARATOR)          : Action            = apply(v)

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Event    = action.Event;     transparent inline def Event = action.Event
  type Provider = action.Provider

private object zBooleanReverse extends ReversibleFunction[Boolean,Boolean]:
  def apply(v: Boolean) = !v
  def undo (v: Boolean) = !v

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
