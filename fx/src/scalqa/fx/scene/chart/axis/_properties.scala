package scalqa; package fx; package scene; package chart; package axis; import language.implicitConversions

import Fx.Font

transparent trait _properties:
  self: Chart.Axis[_] =>

  @tn("animated_Pro")         def animated_*                      : Boolean.Pro.OM  = Fx.JavaFx.To.pro_OM(real.animatedProperty)
  /**/                        def animated                        : Boolean         = real.getAnimated
  /**/                        def animated_=(b: Boolean)          : Unit            = real.setAnimated(b)
  @tn("label_Pro")            def label_*                         : Pro.OM[String]  = Fx.JavaFx.To.pro_OM(real.labelProperty)
  /**/                        def label                           : String          = real.getLabel
  /**/                        def label_=(v: String)              : Unit            = real.setLabel(v)
  @tn("ticksGap_Pro")         def ticksGap_*                      : Double.Pro.OM   = Fx.JavaFx.To.pro_OM(real.tickLabelGapProperty)
  /**/                        def ticksGap                        : Double          = real.getTickLabelGap
  /**/                        def ticksGap_=(v: Double)           : Unit            = real.setTickLabelGap(v)
  @tn("ticksRotation_Pro")    def ticksRotation_*                 : Double.Pro.OM   = Fx.JavaFx.To.pro_OM(real.tickLabelRotationProperty)
  /**/                        def ticksRotation                   : Double          = real.getTickLabelRotation
  /**/                        def ticksRotation_=(v: Double)      : Unit            = real.setTickLabelRotation(v)
  @tn("ticksVisible_Pro")     def ticksVisible_*                  : Boolean.Pro.OM  = Fx.JavaFx.To.pro_OM(real.tickLabelsVisibleProperty)
  /**/                        def ticksVisible                    : Boolean         = real.isTickLabelsVisible
  /**/                        def ticksVisible_=(b: Boolean)      : Unit            = real.setTickLabelsVisible(b)
  @tn("ticksMarkVisible_Pro") def ticksMarkVisible_*              : Boolean.Pro.OM  = Fx.JavaFx.To.pro_OM(real.tickMarkVisibleProperty)
  /**/                        def ticksMarkVisible                : Boolean         = real.isTickMarkVisible
  /**/                        def ticksMarkVisible_=(b: Boolean)  : Unit            = real.setTickMarkVisible(b)
  @tn("ticksFill_Pro")        def ticksFill_*                     : Pro.OM[Paint]   = Fx.JavaFx.To.pro_OM(real.tickLabelFillProperty).mutableMap_^[Paint]
  /**/                        def ticksFill                       : Paint           = Paint(real.getTickLabelFill)
  /**/                        def ticksFill_=(v: Paint)           : Unit            = real.setTickLabelFill(v.real)
  @tn("ticksFont_Pro")        def ticksFont_*                     : Pro.OM[Font]    = Fx.JavaFx.To.pro_OM(real.tickLabelFontProperty).mutableMap_^[Font]
  /**/                        def ticksFont                       : Font            = Font(real.getTickLabelFont)
  /**/                        def ticksFont_=(v: Font)            : Unit            = real.setTickLabelFont(v.real)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
