package scalqa; package lang; package string; package z; import language.implicitConversions

private[scalqa] class Table(val name: String = \/):
  /**/     def newRow        : Row         = new Row(Rows.size).^( Rows += _ )
  /**/     def +=(v: ~[Any]) : Unit        = newRow.fill(v)
  /**/     def separator     : String      = Header.cells.~.map(c => "".padEndTo(c.column.width, "-")).makeString(" ")

  object Header extends Row(-1):
    protected override def mkCell = cells += new Column(cells.size)
    class Column(index: Int, var width: Int = 1) extends Cell(index, "?")
    override def toString: String = separator + '\n' + super.toString + '\n' + separator

  object Rows extends AnyRef.Buffer[Row]

  class Row(val index: Int):
    /**/      val cells                             = Buffer[Cell]()
    /**/      def apply(i: Int): Cell               = { while(i >= cells.size) mkCell; cells(i) }
    /**/      def update(i: Int, v: Any)            = { while(i >= cells.size) mkCell; cells(i).value = v }
    /**/      def fill(vals: ~[Any], from: Int = 0) = { var i = from; vals.foreach(v => { apply(i).value = v; i += 1 }) }
    protected def mkCell                            = cells += new Cell(cells.size)
    override  def toString                          = cells.~.makeString(" ")

    class Cell(val index: Int, _val: String = ""):
      private  var _value: String        = _val
      /**/     def value                 = _value
      /**/     def value_=(v: Any)       = { _value = if (v == null) "null" else v.toString; column.width = column.width.max(value.length) }
      /**/     def column: Header.Column = Header(index).cast[Header.Column]
      override def toString              = value.padEndTo(column.width)

  // ------------------------------------------------------------------------------------------------
  override def toString: String = if (Rows.isEmpty) "empty" else String.Builder().^(b => {
    b += Header += '\n'
    Rows.~.foreach(r => b += r += '\n' )
    b += separator
  }).tag

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
