package scalqa; package fx; package scene; package chart; package axis; package as; import language.implicitConversions

abstract class Value[A](val map: TwoWayFun[A, Double]) extends Chart.Axis[A]:
  type VALUE = Number
  override protected type REAL <: javafx.scene.chart.ValueAxis[Number]

  lazy  val valueMap : TwoWayFun[A, Number] = TwoWayFun(map(_), n => map.undo(n.doubleValue))
  /**/  val ordering : Ordering[A]          = Double.ordering.on(map(_))

  @tn("lowerBound_Pro")       def lowerBound_*                   : Pro.OM[A]       = Fx.JavaFx.As.pro_OM(real.lowerBoundProperty).twoWay_^(using map.reverse)
  /**/                        def lowerBound                     : A               = map.undo(real.getLowerBound)
  /**/                        def lowerBound_=(v: A)             : Unit            = real.setLowerBound(map(v))
  @tn("upperBound_Pro")       def upperBound_*                   : Pro.OM[A]       = Fx.JavaFx.As.pro_OM(real.upperBoundProperty).twoWay_^(using map.reverse)
  /**/                        def upperBound                     : A               = map.undo(real.getUpperBound)
  /**/                        def upperBound_=(v: A)             : Unit            = real.setUpperBound(map(v))
  @tn("minorTickCount_Pro")   def minorTickCount_*               : Int.Pro.OM      = Fx.JavaFx.As.pro_OM(real.minorTickCountProperty)
  /**/                        def minorTickCount                 : Int             = real.getMinorTickCount
  /**/                        def minorTickCount_=(v: Int)       : Unit            = real.setMinorTickCount(v)
  @tn("minorTickLength_Pro")  def minorTickLength_*              : Double.Pro.OM   = Fx.JavaFx.As.pro_OM(real.minorTickLengthProperty)
  /**/                        def minorTickLength                : Double          = real.getMinorTickLength
  /**/                        def minorTickLength_=(v: Double)   : Unit            = real.setMinorTickLength(v)
  @tn("minorTickVisible_Pro") def minorTickVisible_*             : Boolean.Pro.OM  = Fx.JavaFx.As.pro_OM(real.minorTickVisibleProperty)
  /**/                        def minorTickVisible               : Boolean         = real.isMinorTickVisible
  /**/                        def minorTickVisible_=(v: Boolean) : Unit            = real.setMinorTickVisible(v)
  @tn("scale_Pro")            def scale_*                        : Double.Pro.O    = Fx.JavaFx.As.pro_O(real.scaleProperty)
  /**/                        def scale                          : Double          = real.getScale
  /**/              protected def scale_=(v: Double)             : Unit            = real.setScaleX(v)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
