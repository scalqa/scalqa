package scalqa; package fx; package control; package label; import language.implicitConversions

abstract class Like extends Control:
  protected type REAL <: javafx.scene.control.Labeled

  def textPro              : Pro.OM[String] = Fx.JavaFx.To.pro_OM(real.textProperty)
  def text                 : String         = real.getText
  def text_=(v: String)    : Unit           = real.setText(v)

  def alignmentPro         : Pro.OM[Pos]    = Fx.JavaFx.To.pro_OM(real.alignmentProperty).mutableMapView[Pos]
  def alignment            : Pos            = real.getAlignment
  def alignment_=(v: Pos)  : Unit           = real.setAlignment(v)

  def fontPro              : Pro.OM[Fx.Font]= Fx.JavaFx.To.pro_OM(real.fontProperty).mutableMapView[Fx.Font]
  def font                 : Fx.Font        = Fx.Font(real.getFont)
  def font_=(v: Fx.Font)   : Unit           = real.setFont(v.real)

  def textFillPro          : Pro.OM[Paint]  = Fx.JavaFx.To.pro_OM(real.textFillProperty).mutableMapView[Paint]
  def textFill             : Paint          = Paint(real.getTextFill)
  def textFill_=(v: Paint) : Unit           = real.setTextFill(v.real)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**

@def textPro -> Display text

     The text to display in the label

     The text may be null.


@def alignmentPro -> Alignment

     Specifies how the text and graphic within the Labeled should be aligned when there is empty space within the [[Label.Like]]


@def fontPro -> Font

     The default font to use for text

     If the [[Label.Like]] text is rich text then this font may or may not be used depending on the font information embedded in the rich text,
     but in any case where a default font is required, this font will be used


@def textFillPro -> [[Paint]] used

     The [[Paint]] used to fill the text

*/
