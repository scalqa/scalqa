package scalqa; package lang; package anyref; package g; package companion; import language.implicitConversions

class Idx[A]:
  def apply(v: A)                        : Val.Idx[A] = Val.Idx(v)
  def apply(v1: A, v2: A)                : Val.Idx[A] = Val.Idx(v1, v2)
  def apply(v1: A, v2: A, v3: A, vs: A*) : Val.Idx[A] = Val.Idx(v1, v2, v3, vs *)

  type Mutable = Val.Idx.M[A];                     val Mutable = new Idx.Mutable[A]
  type M       = Val.Idx.M[A];  transparent inline def M       = Mutable

object Idx:

  class Mutable[A]:
    def apply(initSize: Int = J.initSize) : Val.Idx.M[A]  = Val.Idx.M(initSize)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
