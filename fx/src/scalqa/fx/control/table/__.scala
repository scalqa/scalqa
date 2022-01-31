package scalqa; package fx; package control; import table.*; import language.implicitConversions

abstract class Table[ROW] extends Control with _properties[ROW] with _Column[ROW] with _customRow[ROW]:
  self =>
  protected     type REAL = javafx.scene.control.TableView[ROW]
  protected[fx] type VIEW
  protected      def onCreateRowCell(f: => RowCell[ROW, VIEW]): Unit       = real.rowFactoryProperty.set(prime => f.real.cast[javafx.scene.control.TableRow[ROW]])
  private[fx]    val columnData : Idx.M[Table.Column[ROW,_,_]] & Able.Seal = Idx.M.sealable()
  private[fx]    val rowData    : z.RowData[ROW]                           = new z.RowData[ROW](this)
  // ----------------------------------------------------------------------------------------------------------------------------------------
  def columns                         : Idx[Table.Column[ROW,_,_]] = columnData
  def rows                            : Idx.OM[ROW]                = rowData
  lazy val selection                  : Fx.Selection[ROW]          = Fx.Selection[ROW](rows, real.getSelectionModel)
  def sortOrder                       : Pack[Column[_]]            = real.getSortOrder.~~.map(_.getUserData.cast[Column[_]]).pack
  def sortOrder_=(a:Stream[Column[_]]): Unit                       = real.getSortOrder.setAll(a.map(_.real).toJavaList)
  def scrollTo(i: Int)                : Unit                       = real.scrollTo(i)

  ({
    _createRealOverride(new REAL().self(r => { r.setEditable(true); r.setItems(Fx.JavaFx.list(rowData))}))
    _onRealCreated(real => {
      columnData.seal.stream.foreach(c => { real.getColumns.add(c.real); c.sortable = c.ordering.nonVoid && sortMode.nonVoid})
      onCreateRowCell(new RowCell[ROW, VIEW](this))
      z.SortEventHandler(this)
    })
  })

  private[fx] def mkViewOpt[VIEW](v: ROW)       : Opt[VIEW] = viewOptFun(v).cast[Opt[VIEW]]; private var viewOptFun: ROW => Opt[VIEW] = v => if(v == null) VOID else v.cast[VIEW]
  protected   def useView (f: ROW => VIEW)       : Unit      = useViewOpt(f(_))
  protected   def useViewOpt(f: ROW => Opt[VIEW]): Unit      = viewOptFun = f

object Table:
  private[fx] type Column[ROW,V,A] = table.Column[ROW,V,A]
  private[fx] type RowCell[A,B]    = table.RowCell[A,B]
  /**/        type Cell[ROW,V,A]   = table.Cell[ROW,V,A];     transparent inline def Cell     = table.Cell
  /**/        type SortMode        = table.SortMode;          transparent inline def SortMode = table.SortMode

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**

@class Table -> ###

   Table is designed to visualize rows of rowData, broken out into columns

   ```
    object MyApp extends Fx.Application:

      object View extends Fx.Table[Int]:

        new Column[Int]   ("Int",    100, i => i)
        new Column[String]("String", 200, "str_" + _)
        new Column[Int]   ("% 10",   100, _ % 10)

        items ++= 1 <> 1000
   ```
*/
