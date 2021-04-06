package scalqa; package fx; package control; package table; package cell; package x; import language.implicitConversions

abstract class ComboBox[ROW,V,A](c: Column[ROW,V,A]) extends Cell[ROW,V,A](c):

  protected type REAL = javafx.scene.control.cell.ComboBoxTableCell[ROW, ITEM]

  protected override def _createReal: REAL = new REAL {
    converterProperty.set(Ui.JavaFx.stringConverter(TwoWayFun.oneWay[ITEM, String](_.text_? or "")))
    override def updateItem(slot: ITEM, empty: Boolean): Unit =
      super.updateItem(slot, empty)
      afterItemUpdated
  }

  @fast lazy val items:  Idx.M[A] =  Idx.M.javaList_^(real.getItems).twoWay_^(_.value, v => item.make(v))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
