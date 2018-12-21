package scalqa; package Fx; package Cell

abstract class Indexed extends Cell {
  protected override def _createGui: REAL = new javafx.scene.control.IndexedCell[ITEM].asInstanceOf[REAL]

  protected type ITEM
  protected type REAL <: javafx.scene.control.IndexedCell[ITEM]
  // --------------------------------------------------------------------------------------

  def indexPro: Pro.O[Int] = Fx.Custom.ProO(real.indexProperty); def index = real.getIndex
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
