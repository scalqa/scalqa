package scalqa; package fx; package control; package label; import language.implicitConversions

abstract class Like extends Control:
  protected type REAL <: javafx.scene.control.Labeled

  @tn("text_Pro")      def text_*               : String.Pro.OM  = Fx.JavaFx.To.pro_OM(real.textProperty)
  /**/                 def text                 : String         = real.getText
  /**/                 def text_=(v: String)    : Unit           = real.setText(v)

  @tn("alignment_Pro") def alignment_*          : Pro.OM[Pos]    = Fx.JavaFx.To.pro_OM(real.alignmentProperty).mutableMap_^[Pos]
  /**/                 def alignment            : Pos            = real.getAlignment
  /**/                 def alignment_=(v: Pos)  : Unit           = real.setAlignment(v)

  @tn("font_Pro")      def font_*               : Pro.OM[Fx.Font]= Fx.JavaFx.To.pro_OM(real.fontProperty).mutableMap_^[Fx.Font]
  /**/                 def font                 : Fx.Font        = Fx.Font(real.getFont)
  /**/                 def font_=(v: Fx.Font)   : Unit           = real.setFont(v.real)

  @tn("textFill_Pro")  def textFill_*           : Pro.OM[Paint]  = Fx.JavaFx.To.pro_OM(real.textFillProperty).mutableMap_^[Paint]
  /**/                 def textFill             : Paint          = Paint(real.getTextFill)
  /**/                 def textFill_=(v: Paint) : Unit           = real.setTextFill(v.real)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**

@def text_* -> Display text

     The text to display in the label

     The text may be null.


@def alignment_* -> Alignment

     Specifies how the text and graphic within the Labeled should be aligned when there is empty space within the [[Label.Like]]


@def font_* -> Font

     The default font to use for text

     If the [[Label.Like]] text is rich text then this font may or may not be used depending on the font information embedded in the rich text,
     but in any case where a default font is required, this font will be used


@def textFill_* -> [[Paint]] used

     The [[Paint]] used to fill the text

*/
