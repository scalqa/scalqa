package scalqa; package fx; package control; package table; import language.implicitConversions

import Any.Def

transparent trait _Column[ROW]:
  self: Table[ROW] =>

  class Column[A] private (t: Def.Void[A], d: Def.Doc[A]) extends table.Column[ROW, VIEW, A](t,d):
    def this()(using oo: Opt[Ordering[A]])(using t:Def.Void[A], d:Def.Doc[A]) = {
      this(t,d)
      if (self.columnData.isSealed) J.illegalState("Table already used, all the columns must be defined before rows or properties")
      self.columnData += this
      useCell(cell.x.Label[ROW, VIEW, A](this))
      oo.forval(v => ordering = v)
    }
    def this(label: String, widthOpt:Int.Opt, f:ROW=>A) (using o: Opt[Ordering[A]])(using t:Def.Void[A],d:Def.Doc[A]) = {
      this()(using o)(using t,d)
      label.??.forval(this.label= _)
      if (f != null) useValue(f)
      widthOpt.forval(prefWidth = _)
    }
    def this(label: String, f: ROW => A)(using o: Opt[Ordering[A]])(using t:Def.Void[A],d:Def.Doc[A]) = this(label,VOID, f)(using o)(using t,d)
    def this(label: String, width : Int)(using o: Opt[Ordering[A]])(using t:Def.Void[A],d:Def.Doc[A]) = this(label, width, null)(using o)(using t,d)
    def this(label: String)             (using o: Opt[Ordering[A]])(using t:Def.Void[A],d:Def.Doc[A]) = this(label,VOID, null)(using o)(using t,d)
    def this(f: ROW => A)               (using o: Opt[Ordering[A]])(using t:Def.Void[A],d:Def.Doc[A]) = this("",VOID, f)(using o)(using t,d)

    def table = self


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
