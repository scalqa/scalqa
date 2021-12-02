package scalqa; package fx; package control; package table; import language.implicitConversions

abstract class Cell[ROW,V,A](val column: Column[ROW,V,_]) extends control.Cell.Indexed:
  protected type ITEM = Cell.Item[ROW,V,A]
  protected type REAL <: javafx.scene.control.TableCell[ROW, Cell.Item[ROW, V, A]]

  def table   : Table[ROW]  = column.table
  def row     : ROW         = rowOpt.get
  def view    : V           = viewOpt.get
  def value   : A           = valueOpt.get

  def rowOpt  : Opt[ROW]    = itemOpt.map(_.row)
  def viewOpt : Opt[V]      = rowOpt.mapOpt(i => column.table.mkViewOpt[V](i))
  def valueOpt: Opt[A]      = itemOpt.mapOpt(_.valueOpt)
  def textOpt : Opt[String] = itemOpt.mapOpt(_.textOpt)

  protected override def afterItemUpdated: Unit =
    super.afterItemUpdated
    psedoClasses.clear
    itemOpt.process(i => {
        i.setup(this);
        i.textOpt.forval(text = _)
      },{
        column.emptyCellSetup(this)
      })
    editable = rowOpt.map(e => column.editEnabledFun(e)).or(false)
    tooltip  = itemOpt.mapOpt(_.setup.funTooltipOpt.map(_(valueOpt))) or VOID : Tooltip

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
