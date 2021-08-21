package scalqa; package lang; package anyref; package g; package customized; package companion; import language.implicitConversions

class Pro[A]:
  def apply[A](source: => A): Val.Pro[A] = Val.Pro(source)

  // *****************************************************************************************
  type Observable = Val.Pro.O[A]
  object Observable:
    def apply(v: => A, dependencies: ~[Observable] = \/)                         : O                            = Val.Pro.O(v, dependencies)
    def apply(v: => A, dependencies: Observable*)                                : O                            = Val.Pro.O(v, dependencies.~)
    def constant(v: A)                                                           : O                            = Val.Pro.O.constant(v)
    def named(name: String, v: => A, dependencies: ~[Observable] = \/)           : O & Able.Name                = Val.Pro.O.named[A](name, v, dependencies)
    def refreshable(v: => A, dependencies: ~[Observable] = \/)                   : O & Able.Refresh             = Val.Pro.O.refreshable[A](v, dependencies)
    def namedRefreshable(name: String, v: => A, dependencies: ~[Observable] = \/): O & Able.Name & Able.Refresh = Val.Pro.O.namedRefreshable[A](name, v, dependencies)

  // *****************************************************************************************
  type Mutable = Val.Pro.M[A]
  object Mutable:
    def apply(v: A)               : M             = Val.Pro.M.apply(v)
    def named(name: String, v: A) : M & Able.Name = Val.Pro.M.named(name, v)

  // *****************************************************************************************
  type ObservableMutable = Val.Pro.OM[A]
  object ObservableMutable:
    def apply(v: A)               : OM             = Val.Pro.OM(v)
    def named(name: String, v: A) : OM & Able.Name = Val.Pro.OM.named(name,v)

  // Aliases
  type M  = Mutable;           transparent inline def M  = Mutable
  type O  = Observable;        transparent inline def O  = Observable
  type OM = ObservableMutable; transparent inline def OM = ObservableMutable

private[scalqa] object Pro extends Pro[AnyRef]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
