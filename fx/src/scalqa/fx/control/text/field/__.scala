package scalqa; package fx; package control; package text; import language.implicitConversions

class Field(columnsO: Opt[Int] = \/, value: String.Opt = \/) extends Text.InputControl(value):
  protected type REAL = javafx.scene.control.TextField
  protected override def _createReal = new REAL().^(f => columnsO.forval(f.setPrefColumnCount))

  /**/                   def onAction[U](l: () => U) : Event.Control = _onFxEvent[javafx.event.ActionEvent,U](real.onActionProperty(), Event.Id.map1(l,(ae: javafx.event.ActionEvent) => l()))
  /**/                   def onActionRun[U](l: => U) : Event.Control = onAction(() => l)
  @tn("columnCount_Pro") def columnCount_*           : Int.Pro.OM    = Fx.JavaFx.To.pro_OM(real.prefColumnCountProperty)
  /**/                   def columnCount             : Int           = real.getPrefColumnCount
  /**/                   def columnCount_=(b: Int)   : Unit          = real.setPrefColumnCount(b)

object Field:
  def apply(value: String)                                  : Text.Field = new Text.Field(\/, value)
  def apply(columns: Opt[Int] = \/, value: String.Opt = \/) : Text.Field = new Text.Field(columns, value)

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Number   = field.Number;    transparent inline def Number   = field.Number
  type Password = field.Password;  transparent inline def Password = field.Password

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
