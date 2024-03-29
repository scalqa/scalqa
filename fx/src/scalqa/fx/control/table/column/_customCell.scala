package scalqa; package fx; package control; package table; package column; import language.implicitConversions

transparent trait _customCell[ROW,V,A]:
  self: Column[ROW,V,A] =>
  private[table] var emptyCellSetup   : control.Cell.Setup[control.Cell]=VOID
  private[table] var customCellSetups : Pack[Cell.Setup[ROW, V, A]]     =VOID

  class CustomCell[T]private (override val rowFilter: ROW => Boolean, empty: Boolean, val voidDef: Any.Def.Void[T], val docDef: Any.Def.Doc[T]) extends Cell.Setup[ROW, V, T]:
    def this(rowFilter: ROW => Boolean)(using voidDef: Any.Def.Void[T], docDef: Any.Def.Doc[T]) = this(rowFilter,false,voidDef,docDef)
    def this(v: EMPTY) = this(null, true, self.voidDef.cast[Any.Def.Void[T]], self.docDef.cast[Any.Def.Doc[T]])
    private[table] def column   = self

    if(empty) emptyCellSetup    = this.cast[control.Cell.Setup[control.Cell]]
    else      customCellSetups += this.cast[Cell.Setup[ROW, V, A]]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class CustomCell -> ### Custom cell

    By default all cells are formatted with column definitions. Custom sell defines special format for certain raws

@def this ->  For filtered rows

      Creates custom cell for rows defined by given filter

      There can be many custom cells. For each non empty row, cells are tested in the order created, and the first positive is applied.
      If non is applied, formatting is defaulted to column

@def this -> Empty rows

      Creates custom cell for empty rows

      There can be only one empty row formatter

 */
