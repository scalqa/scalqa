package scalqa; package String; package Z; package Table

private[Table] class Row(val table: Table, val index: Int) extends Index.W.The[Cell] {

  override def apply(i: Int): Cell = { (size <> i).all.map(cf).apply(add); super.apply(i) }

  def fill(vals: ~[Any]) = vals.applyIdx((i, v) => { apply(i).value = v })

  override def toString = all.format(" ") + '\n'

  private[Table] def cf(i: Int) = new Cell(this, i)

}

// *******************************************************************
private[Table] class Cell(val row: Row, val index: Int, protected var _value: Any = String.Empty) {

  def value = _value.toString

  def value_=(v: Any) = { _value = if (v == null) "null" else v; column.width = column.width.max(value.length) }

  def column: row.table.header.Column = row.table.header(index).cast

  override def toString = value.padEndTo(column.width, " ")
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/