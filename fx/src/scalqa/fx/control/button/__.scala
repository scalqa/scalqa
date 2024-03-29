package scalqa; package fx; package control; import language.implicitConversions

class Button extends button.Base:
  protected type REAL = javafx.scene.control.Button
  protected override def _createReal = new REAL

object Button:
  def apply(s: String)                  : Button = new Button().self(b => s.??.forval(b.text= _))
  def apply(s: String, action: => Unit) : Button = apply(s).self(_.onActionRun(action))

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Base = button.Base
  type Type = button.Type.TYPE.DEF;  transparent inline def Type = button.Type

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
