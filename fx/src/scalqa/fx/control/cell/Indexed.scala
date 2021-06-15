package scalqa; package fx; package control; package cell

abstract class Indexed extends Cell:
  protected type ITEM
  protected type REAL <: javafx.scene.control.IndexedCell[ITEM]
  protected override def _createReal: REAL       = new javafx.scene.control.IndexedCell[ITEM].cast[REAL]

  @tn("index_Pro") def index_*   : Int.Pro.O  = Fx.JavaFx.To.pro_O(real.indexProperty)
  /**/             def index     : Int        = real.getIndex

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
