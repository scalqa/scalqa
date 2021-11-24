package scalqa; package fx; package control; import language.implicitConversions

import Text.Font

class Text(s: Opt[String]= \/) extends Shape:
  protected def _createReal: REAL = s.map(new REAL(_)) or new REAL
  protected type REAL = javafx.scene.text.Text

  def textPro           : Pro.OM[String] = Fx.JavaFx.To.pro_OM(real.textProperty)
  def text              : String         = real.getText
  def text_=(v: String) : Unit           = real.setText(v)
  def fontPro           : Pro.OM[Font]   = Fx.JavaFx.To.pro_OM(real.fontProperty).mutableMapView[Font]

object Text:
  def apply() = new Text()
  def apply(v: String) = new Text(v)

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type InputControl = text.InputControl;       transparent inline def InputControl = text.InputControl
  type Field        = text.Field;              transparent inline def Field        = text.Field
  type Area         = text.Area;               transparent inline def Area         = text.Area
  type Font         = text.Font.TYPE.DEF;      transparent inline def Font         = text.Font

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
