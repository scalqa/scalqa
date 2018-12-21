package scalqa; package Fx; package Chart; package Axis; package A; package Numeric

trait _Setup[A] {

  protected[Numeric] object Setup {

    def unit = _unit; def unit_=(d: Double) { _unit = d }; var _unit = 0D

    var forceZeroInRange = false

    var currentFormatter = "0"

    var getTickLabelFun: A => String = a => a.toString

    var getAllTicksFun: Span[A] => ~[A] = r => Z.GetAllTicks(r.map(map)).map(map.undo)

    var getAllMinorTicksFun: (Span[A], Int) => ~[A] = (r, minorTickCount) => Z.GetAllMinorTicks(r.map(map), minorTickCount).map(map.undo)

    var getRangeFun: (Range[A], Double, Double) => Span[A] = (r, scale, labelSize) => Z.GetRange(This, r.map(map), scale, labelSize).map(map.undo _)

    def measureTickMarkLabelSize(labelText: String, rotation: Double) = real.measureTickMarkLabelSizeX(labelText, rotation)

    def side: Side = real.getSide

  }

  // ----------------------------------------------
  private[Numeric] def This = this.asInstanceOf[Numeric[A]]
  private[Numeric] def real: Z.ValueAxis[A]
  private[Numeric] def map: BiMap[A, Double]

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
