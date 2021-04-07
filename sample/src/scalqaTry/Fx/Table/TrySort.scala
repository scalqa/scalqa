package scalqaTry.Fx.Table;  import scalqa.{*, given};  import language.implicitConversions

import Fx.*

object TrySort extends Application(800, 401, "TryTableSort"):

  val intStream : Int.~       = 1 <> 1000
  val ITEMS     : Idx.OM[Int] = Idx.OM()

  ITEMS ++= intStream.read_~(6).reverseEvery(3)
  ITEMS.onChange(_.~.print) // print out events

  object SortableTable extends Table[Int]:
    new Column[Int]   ("Sortable Ints ",   120, i => i)
    new Column[String]("Sortable Strings", 120, i => (1000 - i).toString)
    items    = ITEMS
    sortMode = Table.SortMode.Direct
    sortMode_*.onValueChange(v => "Sorting Changed to: " + v tp())

  object ControlTable extends Table[Int]:
    new Column[Int]("True Ints", 150, v => v)
    items    = ITEMS
    sortMode = \/

  object View extends Pane.Border:
    center = Pane.Flow(SortableTable, ControlTable)
    top    = Pane.Flow(
      ComboBox(Table.SortMode.~ , SortableTable.sortMode).^(_.value_*.onValueChange(v => SortableTable.sortMode = v)),
      Button("Delete first two",        ITEMS.modify(_.remove_<>(0 <> 1))).^(b => ITEMS.onChange(_ => b.disable = ITEMS.size < 2)),
      Button("Append next 5",           ITEMS ++= intStream.read_~(5)),
      Button("Replace All with next 5", ITEMS.replaceAll(intStream.read_~(5))),
      Button("Clear All",               ITEMS.clear),
      Button("Sort",                    ITEMS.sort),
      Button("Sort Reversed",           ITEMS.sortReversed))


