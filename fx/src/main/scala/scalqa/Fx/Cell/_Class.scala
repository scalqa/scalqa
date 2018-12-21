package scalqa; package Fx; package Cell

abstract class _Class protected extends Label.Like {
  protected override def _createGui: REAL = new javafx.scene.control.Cell[ITEM].asInstanceOf[REAL]

  protected type ITEM
  protected type REAL <: javafx.scene.control.Cell[ITEM]
  // --------------------------------------------------------------------------------------------------
  protected var updateJob: Refs[() => Any] = \/

  def onObservableChange(f: () => Any): Unit = updateJob += f

  protected def refresh {

    stylePro() = \/;

    updateJob.all(_())
  }

  // --------------------------------------------------------------------------------------------------
  def itemOpt: Opt[ITEM] = if (real.isEmpty) \/ else real.getItem

  def emptyPro: Pro.O[Boolean] = Custom.ProO(real.emptyProperty); def empty = real.isEmpty

  def editingPro: Pro.O[Boolean] = Custom.ProO(real.editingProperty); def editing = real.isEditing

  def editablePro: Pro.OM[Boolean] = Custom.ProWO(real.editableProperty); def editable = real.isEditable; def editable_=(b: Boolean) = real.setEditable(b)

  // --------------------------------------------------------------------------------------------------

  def styleClass: Style.Class = _styleClass; protected var _styleClass: Style.Class = \/

  def styleClass_=(sc: Style.Class): Unit = if (_styleClass != sc) {
    val list = styleClasses
    val c = _styleClass
    if (list.lastOpt.contains(c)) list.removeAt(list.size - 1) else list.remove(c)
    _styleClass = sc
    sc.I.Opt(list.add)
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
