package scalqa; package lang; package long; package custom;  package containers; package companion; import language.implicitConversions

class Idx[A<:RAW] extends Pack.zBased[A,G.Idx[A]]:
  type M = G.Idx.Mutable[A]; inline def M = Mutable

  type Mutable = G.Idx.Mutable[A]
  object Mutable:
    inline def apply(inline initSize: Int = J.initSize): Mutable = new G.Buffer[A](initSize)

object Idx extends Idx[SELF]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
