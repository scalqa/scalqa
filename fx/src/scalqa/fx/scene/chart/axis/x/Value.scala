package scalqa; package fx; package scene; package chart; package axis; package x; import language.implicitConversions

abstract class Value[A](val map: TwoWayFunction[A, Double]) extends Chart.Axis[A]:
  type VALUE = Number
  override protected type REAL <: javafx.scene.chart.ValueAxis[Number]

  lazy  val valueMap : TwoWayFunction[A, Number] = TwoWayFunction(map(_), n => map.undo(n.doubleValue))
  /**/  val ordering : Ordering[A]               = Double.ordering.on(map(_))

  /**/      def lowerBoundPro                  : Pro.OM[A]       = Fx.JavaFx.To.pro_OM(real.lowerBoundProperty).mutableMapView(using map.reverse)
  /**/      def lowerBound                     : A               = map.undo(real.getLowerBound)
  /**/      def lowerBound_=(v: A)             : Unit            = real.setLowerBound(map(v))
  /**/      def upperBoundPro                  : Pro.OM[A]       = Fx.JavaFx.To.pro_OM(real.upperBoundProperty).mutableMapView(using map.reverse)
  /**/      def upperBound                     : A               = map.undo(real.getUpperBound)
  /**/      def upperBound_=(v: A)             : Unit            = real.setUpperBound(map(v))
  /**/      def minorTickCountPro              : Int.Pro.OM      = Fx.JavaFx.To.pro_OM(real.minorTickCountProperty)
  /**/      def minorTickCount                 : Int             = real.getMinorTickCount
  /**/      def minorTickCount_=(v: Int)       : Unit            = real.setMinorTickCount(v)
  /**/      def minorTickLengthPro             : Double.Pro.OM   = Fx.JavaFx.To.pro_OM(real.minorTickLengthProperty)
  /**/      def minorTickLength                : Double          = real.getMinorTickLength
  /**/      def minorTickLength_=(v: Double)   : Unit            = real.setMinorTickLength(v)
  /**/      def minorTickVisiblePro            : Boolean.Pro.OM  = Fx.JavaFx.To.pro_OM(real.minorTickVisibleProperty)
  /**/      def minorTickVisible               : Boolean         = real.isMinorTickVisible
  /**/      def minorTickVisible_=(v: Boolean) : Unit            = real.setMinorTickVisible(v)
  /**/      def scalePro                       : Double.Pro.O    = Fx.JavaFx.To.pro_O(real.scaleProperty)
  /**/      def scale                          : Double          = real.getScale
  protected def scale_=(v: Double)             : Unit            = real.setScaleX(v)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
