package scalqa; package fx; package scene; package chart; package axis; package x; import custom.*; import language.implicitConversions

import javafx.geometry.Dimension2D

class Custom[A](m: ReversibleFunction[A, Double]) extends Value[A](m):
  def this(name: String, m: ReversibleFunction[A, Double]) = { this(m); name.^.?.forval(label = _) }

  override protected type REAL = z.Real[A]; protected override def _createReal = new REAL(this)

  lazy  val setup: Setup = new Setup

  class Setup:
    var unit                                                     : Double      = 0D
    var forceZeroInRange                                         : Boolean     = false
    var formatPattern                                            : String      = "0"
    def label(v: A)                                              : String      = v.toString
    def tick_~(r: Range[A])                                      : ~[A]        = z.calcTick.stream(r.transform(map)).map(map.undo)
    def minorTick_~(r: Range[A], minorTickCount: Int)            : ~[A]        = z.calcTick.minorStream(r.transform(map), minorTickCount).map(map.undo)
    def scope(r: <>[A], totalSize: Double, labelSize: Double)    : Range[A]    = z.calcScope(Custom.this, r.convert(map), totalSize, labelSize).transform(map.undo _)
    def labelSize(labelText: String, rotation: Double)           : Dimension2D = real._measureTickMarkLabelSize(labelText, rotation)
    def side                                                     : Side        = real.getSide


object Custom:
  type Range[A] = custom.Range[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
