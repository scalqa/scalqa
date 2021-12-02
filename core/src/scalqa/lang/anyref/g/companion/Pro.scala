package scalqa; package lang; package anyref; package g; package companion; import language.implicitConversions

class Pro[A]:
  def apply[A](source: => A): Val.Pro[A] = Val.Pro(source)

  type Mutable           = Val.Pro.Mutable[A];                              val Mutable           = new Pro.Mutable[A]
  type Observable        = Val.Pro.Observable[A];                           val Observable        = new Pro.Observable[A]
  type ObservableMutable = Val.Pro.ObservableMutable[A];                    val ObservableMutable = new Pro.ObservableMutable[A]
  type M                 = Val.Pro.Mutable[A];           transparent inline def M                 = Mutable
  type O                 = Val.Pro.Observable[A];        transparent inline def O                 = Observable
  type OM                = Val.Pro.ObservableMutable[A]; transparent inline def OM                = ObservableMutable

object Pro:

  class Mutable[A]:
    def apply(v: A)               : Val.Pro.Mutable[A]             = Val.Pro.M.apply(v)
    def named(name: String, v: A) : Val.Pro.Mutable[A] & Able.Name = Val.Pro.M.named(name, v)

  class Observable[A]:
    def apply(v: => A, dependencies: Val.Stream[Gen.Observable] =VOID)                    : Val.Pro.O[A]                            = Val.Pro.O(v, dependencies)
    def apply(v: => A, dependencies: Gen.Observable*)                                     : Val.Pro.O[A]                            = Val.Pro.O(v, dependencies.stream)
    def constant(v: A)                                                                    : Val.Pro.O[A]                            = Val.Pro.O.constant(v)
    def named(name: String, v: => A, dependencies: Val.Stream[Gen.Observable] =VOID)      : Val.Pro.O[A] & Able.Name                = Val.Pro.O.named[A](name, v, dependencies)
    def refreshable(v: => A, dependencies: Val.Stream[Gen.Observable] =VOID)              : Val.Pro.O[A] & Able.Refresh             = Val.Pro.O.refreshable[A](v, dependencies)
    def namedRefreshable(name:String, v: =>A, dependencies:Val.Stream[Gen.Observable]=VOID): Val.Pro.O[A] & Able.Name & Able.Refresh = Val.Pro.O.namedRefreshable[A](name, v, dependencies)

  class ObservableMutable[A]:
    def apply(v: A)               : Val.Pro.ObservableMutable[A]             = Val.Pro.OM(v)
    def named(name: String, v: A) : Val.Pro.ObservableMutable[A] & Able.Name = Val.Pro.OM.named(name,v)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
