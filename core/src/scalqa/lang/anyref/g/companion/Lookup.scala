package scalqa; package lang; package anyref; package g; package companion; import language.implicitConversions

class Lookup[A]:
  def apply[B](v: ~[(A, B)]) : Val.Lookup[A,B] = Val.Lookup(v)
  def apply[B](v: (A, B)*)   : Val.Lookup[A,B] = Val.Lookup(v.~)

  type Stable[B]  = Val.Lookup.Stable[A,B];                      val Stable  = new Lookup.Stable[A]
  type Mutable[B] = Val.Lookup.Mutable[A,B];                     val Mutable = new Lookup.Mutable[A]
  type M[B]       = Val.Lookup.Mutable[A,B];  transparent inline def M       = Mutable

object Lookup:

  class Stable[A]:
    /**/           inline def apply[B](inline v: ~[(A, B)]) : Val.Lookup.Stable[A,B]  = Val.Lookup.Stable(v)
    /**/           inline def apply[B](inline v: (A, B)*)   : Val.Lookup.Stable[A,B]  = Val.Lookup.Stable(v)
    @tn("getVoid") inline def void[B]                       : Val.Lookup.Stable[A,B]  = Val.Lookup.Stable.void


  class Mutable[A]:
    /**/           inline def apply[B]()                    : Val.Lookup.Mutable[A,B] = Val.Lookup.Mutable()
    /**/           inline def apply[B](inline v: ~[(A, B)]) : Val.Lookup.Mutable[A,B] = Val.Lookup.Mutable(v)
    /**/           inline def concurrent[B]()               : Val.Lookup.Mutable[A,B] = Val.Lookup.Mutable.concurrent()



/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@def void  -> Get void instance

*/