package scalqa; package fx; package control; import table.*; import language.implicitConversions

abstract class Table[ROW] extends Control with _properties[ROW] with _Column[ROW] with _customRow[ROW]:
  self =>
  protected     type REAL = javafx.scene.control.TableView[ROW]
  protected[fx] type VIEW
  protected      def onCreateRowCell(f: => RowCell[ROW, VIEW]): Unit       = real.rowFactoryProperty.set(prime => f.real.cast[javafx.scene.control.TableRow[ROW]])
  private[fx]    val columnData : Idx.M[Table.Column[ROW,_,_]] & Able.Seal = Idx.M.sealable()
  private[fx]    val rowData    : z.RowData[ROW]                           = new z.RowData[ROW](this)
  // ----------------------------------------------------------------------------------------------------------------------------------------
  def columns                      : Idx[Table.Column[ROW,_,_]] = columnData
  def rows                         : Idx.OM[ROW]                = rowData
  lazy val selection               : Fx.Selection[ROW]          = Fx.Selection[ROW](rows, real.getSelectionModel)
  def sortOrder                    : ><[Column[_]]              = real.getSortOrder.~.map(_.getUserData.cast[Column[_]]).><
  def sortOrder_=(a: ~[Column[_]]) : Unit                       = real.getSortOrder.setAll(a.map(_.real).toJavaList)
  def scrollTo(i: Int)             : Unit                       = real.scrollTo(i)

  ({
    _createRealOverride(new REAL().^(r => { r.setEditable(true); r.setItems(Ui.JavaFx.list(rowData))}))
    _onRealCreated(real => {
      columnData.seal.~.foreach(c => { real.getColumns.add(c.real); c.sortable = c.ordering.nonVoid && sortMode.nonVoid})
      onCreateRowCell(new RowCell[ROW, VIEW](this))
      z.SortEventHandler(this)
    })
  })

  // Lazy vals have problem in _properties trait, and have to be defined here
  @tn("ordering_Pro")      lazy  val ordering_*    : Pro.OM[Ordering[ROW]] = Pro.OM.X.Basic[Ordering[ROW]](\/)
  @tn("sortingBase_Pro")   lazy  val sortingBase_* : Pro.OM[Ordering[ROW]] = Pro.OM.X.Basic[Ordering[ROW]](\/)

  /**/               private[fx] def mkViewOpt[VIEW](v: ROW)     : Opt[VIEW] = viewOptFun(v).cast[Opt[VIEW]]; private var viewOptFun: ROW => Opt[VIEW] = v => if(v == null) \/ else v.cast[VIEW]
  @tn("view_Setup")    protected def view_: (f: ROW => VIEW)     : Unit      = view_:?(f(_))
  @tn("view_SetupOpt") protected def view_:?(f: ROW => Opt[VIEW]): Unit      = viewOptFun = f

object Table:
  private[fx] type Column[ROW,V,A] = table.Column[ROW,V,A]
  private[fx] type RowCell[A,B]    = table.RowCell[A,B]
  /**/        type Cell[ROW,V,A]   = table.Cell[ROW,V,A];     inline def Cell     = table.Cell
  /**/        type SortMode        = table.SortMode;          inline def SortMode = table.SortMode

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**

@class Table -> ###

[[fx.Table]] is designed to visualize rows of rowData, broken out into columns

   ```
       object MyApp extends fx.Application {

         scene = new fx.Table[Int] {

           new Column[Int]   ("Int",    100, i => i)
           new Column[String]("String", 200, "str_" + _)
           new Column[Int]   ("% 10",   100, _ % 10)

           items ++= 1 <> 1000
         }
       }
   ```

*/
