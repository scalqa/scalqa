package scalqa; package Index; package Selection; package Z

private[scalqa] trait LibraryBase[A] extends Any {

  protected def This: Selection[A]

  def asPro(dflt: A): Pro[A] = new Pro[A] { def apply = This.positions.opt(0).map(This(_)) or dflt }

  def isMultiple = This.positions.size > 1

}

private[scalqa] object LibraryBase {

  trait O[A] extends Any with LibraryBase[A] {

    protected def This: Selection.O[A]

    def onChange(f: => Any): Concurrent.Control = This.onChange(_ => f)

    override def asPro(dflt: A): Pro.O[A] = new Pro.O[A] { def apply = This.positions.opt(0).map(This(_)) or dflt; def onChange(f: () => Any) = This.onChange(_ => f()) }

  }

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
