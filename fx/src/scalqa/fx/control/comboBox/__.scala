package scalqa; package fx; package control; import language.implicitConversions

import javafx.scene.control.ListCell

class ComboBox[A](using val docDef: Any.Def.Doc[A]) extends comboBox.Base[A]:
  protected type REAL = javafx.scene.control.ComboBox[A];  protected override def _createReal = new REAL

  @fast lazy  val items                     : Idx.M[A]        = Idx.M.wrap(real.getItems)
  @fast lazy  val selection                 : Fx.Selection[A] = Fx.Selection(items, real.getSelectionModel)
  /**/        def visibleRowCountPro        : Int.Pro.OM      = Fx.JavaFx.To.pro_OM(real.visibleRowCountProperty);
  /**/        def visibleRowCount           : Int             = real.getVisibleRowCount;
  /**/        def visibleRowCount_=(v: Int) : Unit            = real.setVisibleRowCount(v)

  def useFormat(f: A => String) =
    class Cell extends ListCell[A] { override def updateItem(a: A, empty: Boolean) = { super.updateItem(a, empty); setText{if (empty) null else f(a) }}}
    real.setCellFactory(l => new Cell)
    real.setButtonCell(new Cell)

  useFormat(_.tag(using docDef))

object ComboBox:
  def apply[A]()                               (using t: Any.Def.Doc[A]): ComboBox[A] = new ComboBox[A]
  def apply[A](v: Stream[A])                   (using t: Any.Def.Doc[A]): ComboBox[A] = apply[A]().self(_.items ++= v)
  def apply[A](v: Stream[A], selected: Opt[A]) (using t: Any.Def.Doc[A]): ComboBox[A] = apply[A](v).self(v => selected.forval(v.selection.select(_)))

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Base[A] = comboBox.Base[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/

