package scalqa; package Fx; package Chart; package Axis

trait _pro {

  def animatedPro: Pro.OM[Boolean] = Custom.ProWO(real.animatedProperty); def animated = real.getAnimated; def animated_=(b: Boolean) = real.setAnimated(b)

  def labelPro: Pro.OM[String] = Custom.ProWO(real.labelProperty); def label = real.getLabel; def label_=(v: String) = real.setLabel(v)

  def ticksGapPro: Pro.OM[Double] = Custom.ProWO(real.tickLabelGapProperty); def ticksGap = real.getTickLabelGap; def ticksGap_=(v: Double) = real.setTickLabelGap(v)

  def ticksRotationPro: Pro.OM[Double] = Custom.ProWO(real.tickLabelRotationProperty); def ticksRotation = real.getTickLabelRotation; def ticksRotation_=(v: Double) = real.setTickLabelRotation(v)

  def ticksVisiblePro: Pro.OM[Boolean] = Custom.ProWO(real.tickLabelsVisibleProperty); def ticksVisible = real.isTickLabelsVisible; def ticksVisible_=(b: Boolean) = real.setTickLabelsVisible(b)

  def ticksMarkVisiblePro: Pro.OM[Boolean] = Custom.ProWO(real.tickMarkVisibleProperty); def ticksMarkVisible = real.isTickMarkVisible; def ticksMarkVisible_=(b: Boolean) = real.setTickMarkVisible(b)

  def ticksFillPro = Custom.ProWO(real.tickLabelFillProperty).asBiMappedView(Paint.Map); def ticksFill = Paint.make(real.getTickLabelFill); def ticksFill_=(v: Paint) = real.setTickLabelFill(v.real)

  def ticksFontPro = Custom.ProWO(real.tickLabelFontProperty).asBiMappedView(Font.Map); def ticksFont = Font.make(real.getTickLabelFont); def ticksFont_=(v: Font) = real.setTickLabelFont(v.real)

  // ----------------------------------------------
  private[Axis] def real: javafx.scene.chart.Axis[_]

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
