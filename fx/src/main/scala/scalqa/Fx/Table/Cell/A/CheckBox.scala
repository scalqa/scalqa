package scalqa; package Fx; package Table; package Cell; package A

class CheckBox[ENTRY, VIEW, VAL](c: Column[ENTRY, VIEW, VAL]) extends Cell[ENTRY, VIEW, VAL](c) {

  protected override def _createGui: REAL = new REAL {

    protected override def updateItem(slot: ITEM, empty: Boolean) { super.updateItem(slot, empty); refresh; text = null }

    selectedStateCallbackProperty.set(v => {
      val pr: Pro.O[Opt[VAL]] = c.createOptPro(table.entries(v))
      Custom.BooleanProperty(
        new Pro.OM.A.Base[Boolean] {
          override def apply: Boolean = pr().map(biMap).or(false)
          def update(b: Boolean) = { val r = table.entries(v); column._onEditCommit(r.I.asInstanceOfTarget, biMap.undo(b).I.asInstanceOfTarget) }
        })
    })
  }

  protected type REAL = javafx.scene.control.cell.CheckBoxTableCell[ENTRY, ITEM]

  var biMap: BiMap[VAL, Boolean] = \/
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
