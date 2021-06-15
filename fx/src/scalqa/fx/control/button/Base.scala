package scalqa; package fx; package control; package button

import javafx.event.ActionEvent

abstract class Base extends Label.Like:
  protected type REAL <: javafx.scene.control.ButtonBase
  /**/             def arm                               : Unit           = real.arm
  /**/             def disarm                            : Unit           = real.disarm
  @tn("armed_Pro") def armed_*                           : Boolean.Pro.O  = Fx.JavaFx.To.pro_O(real.armedProperty)
  /**/             def armed                             : Unit           = real.isArmed
  /**/             def onAction[U](l: Action.Event => U) : Event.Control  = _onFxEvent[ActionEvent, Action.Event, U](real.onActionProperty, Action.Event(_), l)
  /**/             def onActionRun[U](run: => U)         : Event.Control  = onAction(e => run)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**

@def arm -> Arm

      Arms the button


@def disarm -> Disarms

      Disarms the button


@def armed_* -> Armed

       Indicates that the button has been "armed" such that a mouse release will cause the button's action to be invoked

       This is subtly different from pressed

       Pressed indicates that the mouse has been pressed on a Node and has not yet been released

       arm however also takes into account whether the mouse is actually over the button and pressed


@def onAction ->  On action

      The button's action, which is invoked whenever the button is fired

      This may be due to the user clicking on the button with the mouse, or by a touch event, or by a key press, or if the developer programmatically invokes the fire() method


@def onActionRun ->  Run on action

      Overload of [[onAction]]


*/
