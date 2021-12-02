package scalqa; package fx; package control; package text; package field; import language.implicitConversions

class Password protected (columns: Opt[Int]=VOID) extends Text.Field(columns):
  protected override def _createReal = new javafx.scene.control.PasswordField

object Password:

  def apply(columns: Opt[Int]=VOID) : Password = new Password(columns)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
