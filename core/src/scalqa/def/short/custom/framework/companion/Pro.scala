package scalqa; package `def`; package short; package custom; package framework; package companion; import language.implicitConversions

class Pro[A<:RAW]:
  type OM = ObservableMutable; @fast lazy val OM = ObservableMutable
  type M  = Mutable;           @fast lazy val M  = Mutable
  type O  = Observable;        @fast lazy val O  = Observable

  type   Mutable = G.Pro.Mutable[A];
  object Mutable:
    def apply(v: A) : Mutable = new G.Pro.Mutable.X.Basic(v)
    object X:
      type Basic = G.Pro.Mutable.X.Basic[A]

  type   Observable = G.Pro.Observable[A];
  object Observable:
    object X:
      type Abstract = G.Pro.Observable.X.Abstract[A]

  type   ObservableMutable = G.Pro.ObservableMutable[A];
  object ObservableMutable:
    def apply(v: A): ObservableMutable = new G.Pro.ObservableMutable.X.Basic(v)
    object X:
      type Abstract    = G.Pro.ObservableMutable.X.Abstract[A]
      type Basic = G.Pro.ObservableMutable.X.Basic[A]

object Pro extends Pro[SELF]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object X -> ###  \n\n Object [[X]] defines standard parent type extensions
@object X -> ###  \n\n Object [[X]] defines standard parent type extensions
@object X -> ###  \n\n Object [[X]] defines standard parent type extensions
*/