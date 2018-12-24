package scalqa; package Fx; package Table; package Cell; package A

abstract class ComboBox[ENTRY, VIEW, VAL](c: Column[ENTRY, VIEW, VAL]) extends Cell[ENTRY, VIEW, VAL](c) {

  protected override def _createGui: REAL = new REAL {

    protected override def updateItem(slot: ITEM, empty: Boolean): Unit = { super.updateItem(slot, empty); refresh }

    converterProperty.set(Custom.StringConverter(BiMap.oneWay[ITEM, String](_.textOpt or \/)))

  }

  protected type REAL = javafx.scene.control.cell.ComboBoxTableCell[ENTRY, ITEM]

  lazy val items: Idx.M[VAL] = Idx.M.wrap(real.getItems).asBiMappedView(_.valueOpt.value, v => new Z.Item[ENTRY, VIEW, VAL](column.I.asInstanceOfTarget, v).asInstanceOf[ITEM])

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
