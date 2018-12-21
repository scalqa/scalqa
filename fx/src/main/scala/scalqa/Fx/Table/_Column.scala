package scalqa; package Fx; package Table

trait _Column[ENTRY] { self: Table[ENTRY] =>

  class Column[A]()(implicit o: Ordering[A]) extends Table.Column[ENTRY, VIEW, A] {

    def this(label: String, widthOpt: Opt[Int], on: ENTRY => A)(implicit c: Ordering[A]) = {
      this()(c)
      label.I.Opt(this.label= _)
      if (on != null) onGet(on)
      widthOpt(prefWidth = _)
    }

    def this(label: String, on: ENTRY => A)(implicit c: Ordering[A]) = this(label, Opt.Void, on)(c)

    def this(label: String, widthOpt: Opt[Int])(implicit c: Ordering[A]) = this(label, widthOpt, null)(c)

    def this(label: String)(implicit c: Ordering[A]) = this(label, Opt.Void)(c)

    def this(on: ENTRY => A)(implicit c: Ordering[A]) = this("", Opt.Void, on)(c)

    def this(label: String, cc: Column.Config[A])(implicit c: Ordering[A]) = { this(label, Opt.Void)(c); cc.I.Opt(_(this)) }

    def this(cc: Column.Config[A])(implicit c: Ordering[A]) = this("", cc)(c)

    def table = _Column.this.This

    val real = new javafx.scene.control.TableColumn[ENTRY, Cell.Z.Item[ENTRY, VIEW, A]] {
      setSortable(false)
      setUserData(Column.this)
      onEditCommitProperty.set(e => _onEditCommit(e.getRowValue(), e.getNewValue.valueOpt.value))
      cellValueFactoryProperty.set(v => {
        val entry = v.getValue
        val ui = uiSetup.all.letType[Cell.Ui[ENTRY, VIEW, A]].findOpt(_.entryFilter(entry)) or App.Fail("Could not find ui for: " + entry)
        new Cell.Z.Item[ENTRY, VIEW, A](entry, ui)
      })
    }
    {
      if (table.columns.isSealed) App.Fail("Table already used, all the columns must be defined before entries or properties")
      table.columns += this
      setupCell(new Cell.A.Label[ENTRY, VIEW, A](this.I.asInstanceOfTarget))
      ordering = o
    }
  }
}

object _Column {

  implicit def zzVoidOrdering[A]: Ordering[A] = \/
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
