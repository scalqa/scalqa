package scalqa; package fx; package scene; package chart; package axis; package x; import language.implicitConversions

class Numbers[A](m: ReversibleFunction[A, Double]) extends Value[A](m):
  def this(name: String, m: ReversibleFunction[A, Double]) = { this(m); name.^.?.forval(label = _) }

  protected override type REAL = javafx.scene.chart.NumberAxis
  protected override def _createReal = new REAL

  @tn("forceZeroInRange_Pro") def forceZeroInRange_*             : Boolean.Pro.OM  = Fx.JavaFx.To.pro_OM(real.forceZeroInRangeProperty)
  /**/                        def forceZeroInRange               : Boolean         = real.isForceZeroInRange
  /**/                        def forceZeroInRange_=(v: Boolean) : Unit            = real.setForceZeroInRange(v)

  @tn("tickUnit_Pro")         def tickUnit_*                     : Double.Pro.OM   = Fx.JavaFx.To.pro_OM(real.tickUnitProperty)
  /**/                        def tickUnit                       : Double          = real.getTickUnit
  /**/                        def tickUnit_=(v: Double)          : Unit            = real.setTickUnit(v)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
