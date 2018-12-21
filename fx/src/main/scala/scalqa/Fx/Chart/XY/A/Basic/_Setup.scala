package scalqa; package Fx; package Chart; package XY; package A; package Basic

trait _Setup[X, Y] extends _Series[X, Y] { self: XY[X, Y] =>

  protected[A] object Setup {

    var updateLegendJobs: Refs[() => Any] = \/

    var calcXRangeOptFun: () => Opt[Range[X]] = () => allItems.map(_.x).range(axisX.ordering).I.Opt

    var calcYRangeOptFun: () => Opt[Range[Y]] = () => allItems.map(_.y).range(axisY.ordering).I.Opt

  }

  private[A] def allItems: ~[Item]
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
