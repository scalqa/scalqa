package scalqa; package lang; package any; package ref; package custom;  package containers; package companion; import language.implicitConversions

class Lookup[A]:
  def apply[B](v: ~[(A, B)]) : Val.Lookup[A,B] = Val.Lookup(v)
  def apply[B](v: (A, B)*)   : Val.Lookup[A,B] = Val.Lookup(v.~)

  type Stable[B] = Val.Lookup.Stable[A,B]
  object Stable:
    /**/           inline def apply[B](inline v: ~[(A, B)]) : Stable[B] = Val.Lookup.Stable(v)
    /**/           inline def apply[B](inline v: (A, B)*)   : Stable[B] = Val.Lookup.Stable(v)
    @tn("getVoid") inline def void[B]                       : Stable[B] = Val.Lookup.Stable.void

object Lookup extends Lookup[AnyRef]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@def void  -> Get void instance

*/