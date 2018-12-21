package scalqa; package Fx; package Table

trait _RowUi[ENTRY] { self: Table[ENTRY] =>

  private[Table] val uiSetup = new Fx.Cell.Ui.Setup[Row.Cell[ENTRY, VIEW]]

  // ****************************************************************************************************
  class RowUi(filter: Row.Cell[ENTRY, VIEW] => Boolean) extends Row.Ui[ENTRY, VIEW](filter) {
    uiSetup.add(this)
  }

  // ****************************************************************************************************
  class NonEmptyRowUi extends RowUi(!_.empty) {}

  // ****************************************************************************************************
  class EmptyRowUi extends RowUi(_.empty) {}

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
