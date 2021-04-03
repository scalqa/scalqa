package scalqa; package `val`; package idx; package z; import language.implicitConversions

class Product_View(x: Idx[Any]) extends Product:
  override def productPrefix              : String  = "Idx"
  /**/     def productArity               : Int     = x.size
  override def productElementName(i: Int) : String  = "_"+(i+1)
  /**/     def productElement(i: Int)     : Any     = x(i)
  /**/     def canEqual(that: Any)        : Boolean = false

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
