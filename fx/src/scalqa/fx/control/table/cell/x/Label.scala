package scalqa; package fx; package control; package table; package cell; package x

class Label[ROW,V,A](c: Column[ROW,V,A]) extends Cell[ROW,V,A](c):

  protected override def _createReal: REAL = new javafx.scene.control.TableCell[ROW, ITEM] {
    override def updateItem(slot: ITEM, empty: Boolean): Unit =
      super.updateItem(slot, empty);
      try afterItemUpdated
      catch
        case e: RuntimeException => throw e
  }.cast[REAL]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
