package scalqa; package fx; package control; package table; import language.implicitConversions

import Def.{ Doc, Void }

transparent trait _Column[ROW]:
  self: Table[ROW] =>

  class Column[A] private (t: Void[A], d: Doc[A]) extends table.Column[ROW, VIEW, A](t,d):
    def this()(using oo: Opt[Ordering[A]])(using t:Void[A], d:Doc[A]) = {
      this(t,d)
      if (self.columnData.isSealed) J.illegalState("Table already used, all the columns must be defined before rows or properties")
      self.columnData += this
      createCell_:(cell.x.Label[ROW, VIEW, A](this))
      oo.forval(ordering = _ )
    }
    def this(label: String, widthOpt:Int.Opt,f:ROW=>A)(using o: Opt[Ordering[A]])(using t:Void[A],d:Doc[A]) = {this()(using o)(using t,d); label.^.?.forval(this.label= _); if (f != null) value_:(f); widthOpt.forval(prefWidth = _) }
    def this(label: String, f: ROW => A)              (using o: Opt[Ordering[A]])(using t:Void[A],d:Doc[A]) = this(label, \/, f)(using o)(using t,d)
    def this(label: String, width : Int)              (using o: Opt[Ordering[A]])(using t:Void[A],d:Doc[A]) = this(label, width, null)(using o)(using t,d)
    def this(label: String)                           (using o: Opt[Ordering[A]])(using t:Void[A],d:Doc[A]) = this(label, \/, null)(using o)(using t,d)
    def this(f: ROW => A)                             (using o: Opt[Ordering[A]])(using t:Void[A],d:Doc[A]) = this("", \/, f)(using o)(using t,d)


    def table = self


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
