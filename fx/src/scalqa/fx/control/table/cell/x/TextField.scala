package scalqa; package fx; package control; package table; package cell; package x; import language.implicitConversions

class TextField[ROW,V,A](c: Column[ROW,V,A], parser: String => Result[A]) extends Cell[ROW,V,A](c):
  protected type REAL = javafx.scene.control.cell.TextFieldTableCell[ROW, ITEM]

  @tn("error_pro") val error_* : String.Pro.OM = String.Pro.OM("")

  protected override def _createReal: REAL = new REAL {
    given FxConverter: TwoWayFun[ITEM, String] = new TwoWayFun[ITEM, String](){
        def apply(v: ITEM)  = v.text_? or ""
        def undo(v: String) =
           val o =  parser(v)
           o.problem_?.forval(v => error_*() = v.message)
           item.make(o.value_?)
    }

    converterProperty.set(Util.JavaFx.stringConverter(FxConverter))

    override def updateItem(slot: ITEM, empty: Boolean): Unit =
      super.updateItem(slot, empty)
      afterItemUpdated
  }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
