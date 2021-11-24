package scalqa; package fx; package control; package table; import language.implicitConversions

transparent trait _customRow[ROW]:
  self: Table[ROW] =>

  private var emptyRowSetup  : Fx.Cell.Setup[Fx.Cell] = \/
  private var customRowSetups: Pack[CustomRow]        = \/

  private[table] def rowSetup(v: RowCell[ROW, VIEW], empty: Boolean ): control.Cell.Setup[control.Cell] =
    if(empty) emptyRowSetup
    else customRowSetups.stream.findOpt(_.filter(v)).cast[Opt[control.Cell.Setup[control.Cell]]] or \/

  // *****************************************************************************************************************************************************
  class CustomRow private(private[table] val filter: RowCell[ROW, VIEW] => Boolean, empty: Boolean) extends control.Cell.Setup[RowCell[ROW, VIEW]]:
    {
      if(empty) emptyRowSetup    = this.cast[control.Cell.Setup[control.Cell]]
      else      customRowSetups += this
    }
    def this(filter: RowCell[ROW, VIEW] => Boolean) = this(filter,false)
    def this(v: EMPTY) = this(null,true)

    private var triggers: Pack[ROW => Observable] = \/
    def refreshOn(f: ROW => Observable): Unit = triggers += f
    override def apply(r: RowCell[ROW, VIEW]): Unit =
      super.apply(r)
      r.rowOpt.forval(e => {
        if (triggers.size > 0) triggers.stream.map(_(e)).foreach(_.onObservableChange(() => r.table.rows.refreshAt(r.index)).cancelIf(() => !r.rowOpt.contains(e)))
      })

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
