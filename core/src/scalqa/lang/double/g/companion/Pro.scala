package scalqa; package lang; package double; package g; package companion; import language.implicitConversions

class Pro[A<:Raw]:
  type Mutable           = G.Pro.Mutable[A];                               val Mutable           = new Pro.Mutable[A]
  type Observable        = G.Pro.Observable[A];                            val Observable        = new Pro.Observable[A]
  type ObservableMutable = G.Pro.ObservableMutable[A];                     val ObservableMutable = new Pro.ObservableMutable[A]
  type M                 = G.Pro.Mutable[A];            transparent inline def M                 = Mutable
  type O                 = G.Pro.Observable[A];         transparent inline def O                 = Observable
  type OM                = G.Pro.ObservableMutable[A];  transparent inline def OM                = ObservableMutable

object Pro:

  class Mutable[A<:Raw]:
    def apply(v: A) : G.Pro.Mutable[A] = new G.Pro.Mutable.X.Basic(v)

  class Observable[A<:Raw]

  class ObservableMutable[A<:Raw]:
    def apply(v: A): G.Pro.ObservableMutable[A] = new G.Pro.ObservableMutable.X.Basic(v)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
