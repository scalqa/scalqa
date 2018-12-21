package scalqa; package Fx; package Chart; package XY; package A; package Basic

trait _Series[X, Y] extends _Item[X, Y] with XY._Series[X, Y] { self: XY[X, Y] =>

  class Series(name: String, l: Idx.O[ITEM]) extends super.Series(name, l) {
    def this() = this(\/, \/)

    lazy val node: Fx.A.Node = null

    protected[Basic] var layoutJob: () => Any = \/

  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
