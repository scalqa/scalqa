package scalqa; package String; package Z; package Table

private[scalqa] class _Class(val name: String = "") {
  val header = new Header(this)
  val rows = new Index.W.The[Row]

  def newRow: Row = new Row(this, rows.size) { rows.add(this) }

  def =+(v: Any) = newRow.fill(v.I.~)

  def +~=(vals: ~[Any]) = newRow.fill(vals)

  override def toString: String = if (rows.isEmpty) "empty" else String.Builder.get().I(b => {
    val sep = header.all.map(c => String.Empty.padEndTo(c.column.width, "-")).format(" ") + '\n'
    b =+ sep =+ header =+ sep =+~ rows.all =+ sep
  })

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/