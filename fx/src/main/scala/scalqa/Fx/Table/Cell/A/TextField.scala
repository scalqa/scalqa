package scalqa; package Fx; package Table; package Cell; package A

class TextField[ENTRY, VIEW, VAL](c: Column[ENTRY, VIEW, VAL], parser: String => Opt[VAL]) extends Cell[ENTRY, VIEW, VAL](c) {
  protected type REAL = javafx.scene.control.cell.TextFieldTableCell[ENTRY, ITEM]

  protected override def _createGui: REAL = new REAL {
    protected override def updateItem(slot: ITEM, empty: Boolean) {
      super.updateItem(slot, empty); refresh
    }

    converterProperty.set(Custom.StringConverter(BiMap[ITEM, String](v => v.textOpt or \/, txt => itemOpt.apply(_.valueOpt = parser(txt)).value)))
  }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
