package scalqa

package object Able {
  type Add[A] = Add._Trait[A]
  type Minus[A] = Minus._Trait[A]
  type Plus[A] = Plus._Trait[A]
  type Remove[A] = Remove._Trait[A]
  type Info = Info._Trait
  type Seal = Seal._Trait
  type Void = Void._Trait

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object Able -> Package [[Able]] defines a set of highly generic interfaces
 */
