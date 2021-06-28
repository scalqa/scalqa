package scalqa; package fx; package control; import language.implicitConversions

class Label extends Label.Like:
  protected type REAL = javafx.scene.control.Label
  protected override def _createReal = new REAL

object Label:
  def apply()              : Label = new Label
  def apply[A](txt: String): Label = apply().^(_.text = txt)

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~
  type Like = label.Like

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
