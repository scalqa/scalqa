package scalqa; package fx; package control; import language.implicitConversions

import Text.Font

class Text(s: String.Opt = \/) extends Shape:
  protected def _createReal: REAL = s.map(new REAL(_)) or new REAL
  protected type REAL = javafx.scene.text.Text

  @tn("text_Pro") def text_*            : String.Pro.OM  = Fx.JavaFx.To.pro_OM(real.textProperty)
  /**/            def text              : String         = real.getText
  /**/            def text_=(v: String) : Unit           = real.setText(v)
  @tn("font_Pro") def font_*            : Pro.OM[Font]   = Fx.JavaFx.To.pro_OM(real.fontProperty).mutableMap_^[Font]

object Text:
  def apply() = new Text()
  def apply(v: String) = new Text(v)

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type InputControl = text.InputControl;       /*transparent inline def*/ val InputControl = text.InputControl
  type Field        = text.Field;              /*transparent inline def*/ val Field        = text.Field
  type Area         = text.Area;               /*transparent inline def*/ val Area         = text.Area
  type Font         = text.Font.opaque.`type`; /*transparent inline def*/ val Font         = text.Font

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
