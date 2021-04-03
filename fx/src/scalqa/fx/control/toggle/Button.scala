package scalqa; package fx; package control; package toggle; import language.implicitConversions

class Button extends control.Button.Base with Toggle:
  protected override def _createReal = new REAL; protected type REAL = javafx.scene.control.ToggleButton

object Button:
  def apply(s: String)                  : Button = { val b = new Button(); s.^.?.forval(b.text= _); b }
  def apply(s: String, action: => Unit) : Button = apply(s).^(_.onActionRun(action))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
