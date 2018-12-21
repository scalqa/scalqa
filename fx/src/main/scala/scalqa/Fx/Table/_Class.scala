package scalqa; package Fx; package Table

abstract class _Class[ENTRY] protected extends A.Control with _base[ENTRY] with _Column[ENTRY] with _RowUi[ENTRY] {
  private[Table]type VIEW

  {
    setupDefaultColumns
    _onCreateGuiRun(
      new REAL().I(real => {
        real.setEditable(true);
        this.data.init(real)
      }))
    _onAfterCreateGuiRun {
      columns.seal.all.map(_.real).foreach(real.getColumns.add(_))
      onCreateRowCell(new Row.Cell[ENTRY, VIEW](this))
      placeholder = new Fx.Pane { real.setStyle("-real-background-color: black;") };
      columns.all(c => c.sortable = !c.ordering.isVoid && !sortMode.isVoid)
    }
  }

  private[Table] def This = this

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _Class ->
 *
 *   [[Fx.Table]] is designed to visualize rows of data, broken out into columns
 *
 *   {{{
 *     object MyApp extends Fx.Application {
 *
 *       scene = new Fx.Table[Int] {
 *
 *         new Column[Int]   ("Int",    100, i => i)
 *         new Column[String]("String", 200, "str_" + _)
 *         new Column[Int]   ("% 10",   100, _ % 10)
 *
 *         items +~= 1 <> 1000
 *       }
 *     }
 *   }}}
 */
