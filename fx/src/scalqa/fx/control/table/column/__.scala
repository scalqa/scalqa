package scalqa; package fx; package control; package table; import column.*; import language.implicitConversions

abstract class Column[ROW,V,A] private[control](val voidDef: Any.Def.Void[A], val docDef: Any.Def.Doc[A]) extends cell.Setup[ROW,V,A] with _value[ROW,V,A] with _edit[ROW,V,A] with _properties[ROW,V,A] with _customCell[ROW,V,A]:
  protected type REAL = javafx.scene.control.TableColumn[ROW, Cell.Item[ROW, V, A]]
  val real = new REAL {
    setSortable(false)
    setUserData(Column.this)
    onEditCommitProperty.set(e => editCommitFun(e.getRowValue(), e.getNewValue.valueOpt.get))
    cellValueFactoryProperty.set(v => {
      class ItemFactory extends base.javaFx.z.value.Abstract[cell.Item[ROW, V, A]]:
        /**/     val row  : ROW                   = v.getValue
        /**/     val valuePro                     = setup.mkProOpt(row)
        /**/     def setup: Cell.Setup[ROW,V,A]   = customCellSetups.stream.findOpt(_.rowFilter(row)) or Column.this
        /**/     def getValue                     = cell.Item[ROW,V,A](row, setup, valuePro())
        override def afterFirstListenerAdded      = valuePro.onObservableChange(Event.Id.make0(this, () => fireInvalidated))
        override def afterLastListenerRemoved     = valuePro.onObservableChange(Event.Id.cancel0(this))
      new ItemFactory
    })
  }

  /**/           def table                        : Table[ROW]
  /**/           def useCell(f: => Cell[ROW,V,A]) : Unit               = real.cellFactoryProperty.set(p => f.real)
  /**/           def reposition(index: Int)       : Unit               = table.columnData.self(v => { v.remove(this); v.addAt(index max 0 min table.columns.size, this)})
  /**/           def refreshColumn                : Unit               = { val c = column.real; if (c.isVisible) { c.setVisible(false); c.setVisible(true) } }
  /**/           def refreshRow(c: Cell[ROW,V,A]) : Unit               = refreshAt(c.index)
  /**/           def refreshAt(i: Int)            : Unit               = column.table.rows.refreshAt(i)
  /**/           def refreshRange(r: Int.Range)   : Unit               = column.table.rows.refreshRange(r)
  override       def doc                          : Doc                = super.doc +@= (0, "label", label) +@= (1, "width", width)
  private[table] def column                       : Column[ROW,V,A]    = this
  private[table] def rowOrdering                  : Ordering[ROW]      = { val o = ordering.optView(1).on[ROW](e => mkProOpt(e)()); if (real.getSortType == javafx.scene.control.TableColumn.SortType.DESCENDING) o.reverse else o }

  // ??? This will move to _properties when dotty issue 13358 is fixed
  @fast lazy val orderingPro: Pro.OM[Ordering[A]] = Pro.OM(\/)
  @fast lazy val sortablePro: Boolean.Pro.OM      = Fx.JavaFx.To.pro_OM(real.sortableProperty)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
