package scalqa; package fx; package control; package table; package cell; package x; import language.implicitConversions

class CheckBox[ROW,V,A](c: Column[ROW,V,A]) extends Cell[ROW,V,A](c):

  protected override def _createReal: REAL = new REAL {
    override def updateItem(slot: ITEM, empty: Boolean): Unit =
      super.updateItem(slot, empty)
      afterItemUpdated
      text = null

    selectedStateCallbackProperty.set(v => {
      val pr: Pro.O[Opt[A]] = c.mkProOpt(table.rows(v))
      Fx.JavaFx.booleanPropertry(
        new Val.Pro.O.X.Base[Boolean] with Boolean.Pro.OM  {
          override def apply(): Boolean = pr().map(twoWay).or(false)
          def update(b: Boolean) = { val r = table.rows(v); column.editCommitFun.cast[(ROW,Boolean)=> Unit].apply(r, b) }
        })
    })
  }

  protected type REAL = javafx.scene.control.cell.CheckBoxTableCell[ROW, ITEM]

  var twoWay: TwoWayFunction[A, Boolean] = \/

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
