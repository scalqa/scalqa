package scalqa; package fx; package control; import language.implicitConversions

import javafx.scene.control.ListCell

class ComboBox[A](using val docTag: Info.Tag.Doc[A]) extends comboBox.Base[A]:
  protected type REAL = javafx.scene.control.ComboBox[A];  protected override def _createReal = new REAL

  /**/                 lazy  val items                     : Idx.M[A]     =  Idx.M.javaList_^(real.getItems)
  /**/                 lazy  val selection                 : Selection[A] = Selection(items, real.getSelectionModel)
  @tn("visibleRowCount_Pro") def visibleRowCount_*         : Int.Pro.OM   = Fx.JavaFx.As.pro_OM(real.visibleRowCountProperty);
  /**/                       def visibleRowCount           : Int          = real.getVisibleRowCount;
  /**/                       def visibleRowCount_=(v: Int) : Unit         = real.setVisibleRowCount(v)

  def format_:(f: A => String) =
    class Cell extends ListCell[A] { override def updateItem(a: A, empty: Boolean) = { super.updateItem(a, empty); setText{if (empty) null else f(a) }}}
    real.setCellFactory(l => new Cell)
    real.setButtonCell(new Cell)

  format_:(_.tag(using docTag))

object ComboBox:
  def apply[A]()                          (using t: Info.Tag.Doc[A]) : ComboBox[A] = new ComboBox[A]
  def apply[A](v: ~[A])                   (using t: Info.Tag.Doc[A]) : ComboBox[A] = apply[A]().^(_.items ++= v)
  def apply[A](v: ~[A], selected: Opt[A]) (using t: Info.Tag.Doc[A]) : ComboBox[A] = apply[A](v).^(v => selected.forval(v.selection.select(_)))

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Base[A] = comboBox.Base[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/

