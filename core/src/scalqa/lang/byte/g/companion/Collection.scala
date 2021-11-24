package scalqa; package lang; package byte; package g; package companion; import language.implicitConversions

class Collection[A<:Raw] extends z_Pack[A,G.Collection[A]]:
  type Mutable = G.Collection.Mutable[A];                     val Mutable = new Collection.Mutable[A]
  type M       = G.Collection.Mutable[A];  transparent inline def M       = Mutable

object Collection:

  class Mutable[A<:Raw]:
    def apply(initSize: Int = J.initSize): G.Collection.Mutable[A] = new G.Buffer(initSize)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
