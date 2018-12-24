package scalqa; package Fx; package Table; package Cell; package A

class Label[ENTRY, VIEW, VAL](c: Column[ENTRY, VIEW, VAL]) extends Cell[ENTRY, VIEW, VAL](c) {

  protected override def _createGui: REAL = new javafx.scene.control.TableCell[ENTRY, ITEM] {
    protected override def updateItem(slot: ITEM, empty: Boolean): Unit = {
      super.updateItem(slot, empty);
      try {
        refresh
      } catch {
        case e: RuntimeException => {
          //        scalqa.err.println("Cell Error --->>>", text(), "   ", _Cell.this);
          throw e;
        }
      }
    }
  }.asInstanceOf[REAL]
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
