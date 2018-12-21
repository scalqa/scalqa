package scalqa; package Fx; package Chart; package XY; package A; package Basic

trait _Item[X, Y] extends XY._Item[X, Y] { self: XY[X, Y] =>

  class Item private extends super.Item {
    def this(xPar: X, yPar: Y) = { this(); x = xPar; y = yPar }
    def this(p: (X, Y)) = { this(p._1, p._2) }

    lazy val node: Fx.A.Node = null

    def isVisible = true

    protected[Basic] var layoutJob: () => Any = \/

  }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
