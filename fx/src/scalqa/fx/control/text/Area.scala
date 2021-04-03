package scalqa; package fx; package control; package text; import language.implicitConversions

class Area protected (text: String.Opt = \/) extends Text.InputControl(text):
  protected type REAL = javafx.scene.control.TextArea
  protected override def _createReal = new REAL

object Area:
  def apply()          : Area = new Area()
  def apply(v: String) : Area = new Area(v)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
