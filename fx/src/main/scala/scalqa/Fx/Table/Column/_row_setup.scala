package scalqa; package Fx; package Table; package Column

trait _row_setup[ENTRY, VIEW, VAL] { self: Column[ENTRY, VIEW, VAL] =>

  // ****************************************************************************************************************************
  class RowUi[T](aplicableEntries: ENTRY => Boolean) extends Cell.Ui[ENTRY, VIEW, T] {
    def this(specific: ENTRY) = this(_ == specific)
    private[Table] def column = self.I.asInstanceOfTarget
    private[Table] def entryFilter = aplicableEntries
    uiSetup.add(this.I.asInstanceOfTarget)
  }

  // ****************************************************************************************************************************
  class EmptyRowUi extends Fx.Cell.Ui[Table.Cell[ENTRY, VIEW, VAL]] {
    private[Table] def owner = self
    protected final def cellFilter = _.empty
    uiSetup.add(this.I.asInstanceOfTarget)
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *  @trait _row -> The column itself implements [[Ui]] which formats every cell (except empty) by default
 *
 *    If a RowUi created, it will overtake formatting for entries defined by the filter
 *
 *  @class RowUi -> Selected rows UI
 *
 *    If 'new' created, it will overtake formatting entries defined by the filter
 *
 *  @class EmptyRowUi -> Empty rows UI
 *
 *    If 'new' created, it will format empty cells (without the entries)
 *
 */
