package scalqa; package lang; package double; package g; package companion; import language.implicitConversions

class Idx[A<:Raw] extends z_Pack[A,G.Idx[A]]:
  type Mutable = G.Idx.Mutable[A];                    val Mutable = new Idx.Mutable[A]
  type M       = G.Idx.Mutable[A]; transparent inline def M       = Mutable

object Idx:

  class Mutable[A<:Raw]:
    inline def apply(inline initSize: Int = J.initSize): G.Idx.Mutable[A] = new G.Buffer[A](initSize)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
