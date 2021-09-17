package scalqa; package fx; package control; package table; import language.implicitConversions

abstract class Cell[ROW,V,A](val column: Column[ROW,V,_]) extends control.Cell.Indexed:
  protected type ITEM = Cell.Item[ROW,V,A]
  protected type REAL <: javafx.scene.control.TableCell[ROW, Cell.Item[ROW, V, A]]

  /**/            def table   : Table[ROW]  = column.table
  /**/            def row     : ROW         = row_?.get
  /**/            def view    : V           = view_?.get
  /**/            def value   : A           = value_?.get

  @tn("rowOpt")   def row_?   : Opt[ROW]    = item_?.map(_.row)
  @tn("viewOpt")  def view_?  : Opt[V]      = row_?.map_?(i => column.table.mkViewOpt[V](i))
  @tn("valueOpt") def value_? : Opt[A]      = item_?.map_?(_.value_?)
  @tn("textOpt")  def text_?  : Opt[String] = item_?.map_?(_.text_?)

  protected override def afterItemUpdated: Unit =
    super.afterItemUpdated
    psedoClasses.clear
    item_?.process(i => {
        i.setup(this);
        i.text_?.forval(text = _)
      },{
        column.emptyCellSetup(this)
      })
    editable = row_?.map(e => column.editEnabledFun(e)).or(false)
    tooltip  = item_?.map_?(_.setup.funTooltipOpt.map(_(value_?))) or \/ : Tooltip

object Cell:
  transparent inline def X = cell.X
  type Setup[ROW,V,A] = cell.Setup[ROW,V,A]
  type Item [ROW,V,A] = cell.Item[ROW,V,A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
