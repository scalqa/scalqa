package scalqa; package Fx; package Label

abstract class Like protected extends A.Control {
  protected type REAL <: javafx.scene.control.Labeled

  def textPro: Pro.OM[String] = Custom.ProWO(real.textProperty); def text = real.getText; def text_=(v: String) = real.setText(v)

  def alignmentPro = Custom.ProWO(real.alignmentProperty).asBiMappedView(Pos); def alignment: Pos = real.getAlignment; def alignment_=(v: Pos) = real.setAlignment(v)

  def fontPro = Custom.ProWO(real.fontProperty).asBiMappedView(Font.Map); def font = Font.make(real.getFont); def font_=(v: Font) = real.setFont(v.real)

  def textFillPro = Custom.ProWO(real.textFillProperty).asBiMappedView(Paint.Map); def textFill = Paint.make(real.getTextFill); def textFill_=(v: Paint) = real.setTextFill(v.real)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def textPro -> Display text
 *
 *   The text to display in the label
 *
 *   The text may be null.
 *
 * @def alignmentPro -> Alignment
 *
 *   Specifies how the text and graphic within the Labeled should be aligned when there is empty space within the [[Label.Like]]
 *
 * @def fontPro -> Font
 *
 *   The default font to use for text
 *
 *   If the [[Label.Like]] text is rich text then this font may or may not be used depending on the font information embedded in the rich text,
 *   but in any case where a default font is required, this font will be used
 *
 * @def textFillPro -> [[Paint]] used
 *
 *   The [[Paint]] used to fill the text
 */
