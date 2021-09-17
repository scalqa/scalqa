package scalqa; package lang; package anyref; package g; package companion; import language.implicitConversions

class Collection[A]:
  def apply(v: A)                        : Val.Collection[A] = Val.Collection(v)
  def apply(v1: A, v2: A)                : Val.Collection[A] = Val.Collection(v1, v2)
  def apply(v1: A, v2: A, v3: A, vs: A*) : Val.Collection[A] = Val.Collection(v1, v2, v3, vs *)

  type Mutable = Val.Collection.Mutable[A];                    val Mutable = new Collection.Mutable[A]
  type M       = Val.Collection.Mutable[A]; transparent inline def M       = Mutable

object Collection:

  class Mutable[A]:
    def apply(initSize: Int = J.initSize): Val.Collection.Mutable[A] = new AnyRef.Buffer(initSize)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@def void  -> Get void instance

*/