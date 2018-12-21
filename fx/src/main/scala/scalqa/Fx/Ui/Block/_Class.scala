package scalqa; package Fx; package Ui; package Block

abstract class _Class[ENTRY] protected extends Module with Idx[ENTRY] {

  protected def table: Fx.Table[ENTRY]

  protected lazy val view: A.Parent = new Fx.Pane.Border {
    center = table;
    _removePropertyOpt(_Class.Status).apply(bottom = _)
  }

  protected def onCreateStatusBar(sb: => A.Node.Like) = _setPropertyOpt(_Class.Status, sb)

  protected def entries: Idx.OM[ENTRY] = table.entries.asInstanceOf[Idx.OM[ENTRY]]

  // -----------------------------------------------------------------------------------------------------------------

  def items: Idx[ENTRY] = table.items

  def selection = table.selection

  def size = entries.size

  def apply(i: Int) = entries(i)

}

private object _Class {
  object Status
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
