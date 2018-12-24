package scalqa; package Fx; package Table; package Column

trait _edit_setup[ENTRY, VIEW, VAL] { self: Column[ENTRY, VIEW, VAL] =>
  private[Table] var _onEditEnabled: ENTRY ⇒ Boolean = ANY
  private[Table] var _onEditCommit: (ENTRY, VAL) => Any = \/

  def setupEdit(e: => Editor, commit: (ENTRY, VAL) => Any, enabled: ENTRY => Boolean = ANY): Unit = { setupCell(e); _onEditEnabled = enabled; _onEditCommit = commit }

  // *****************************************************************************************************************************
  trait Editor extends Table.Cell[ENTRY, VIEW, VAL]

  // *****************************************************************************************************************************
  class CheckBox extends Cell.A.CheckBox[ENTRY, VIEW, VAL](this.I.asInstanceOfTarget) with Editor

  // *****************************************************************************************************************************
  class ComboBox extends Cell.A.ComboBox[ENTRY, VIEW, VAL](this.I.asInstanceOfTarget) with Editor {
    def this(initItems: ~[VAL]) = { this(); items +~= initItems }
  }

  // *****************************************************************************************************************************
  class TextField(parser: String => Opt[VAL]) extends Cell.A.TextField[ENTRY, VIEW, VAL](this.I.asInstanceOfTarget, parser) with Editor
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait Editor -> Cell Editor
 *
 * @class CheckBox -> CheckBox Editor
 *
 * @class ComboBox -> ComboBox Editor
 *
 * @class TextField -> TextField Editor
 *
 *
 *
 */
