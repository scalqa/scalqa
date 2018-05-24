package object scalqa extends General._include with Array._include with Time._include with Any.Tuple._include {

  type App = App._Class
  type Coll[+A] = Coll._Trait[A]
  type Index[+A] = Index._Trait[A]
  type Concurrent[+A] = Concurrent._Trait[A]

  type Lookup[A, +B] = Lookup._Trait[A, B]
  type Numeric = Numeric._Trait
  type Range[A] = Range._Trait[A]
  type Sorting[-A] = Sorting._Trait[A]
  type Opt[+A] = Opt._Class[A]
  type Pipe[A] = Pipe._Class[A]
  type Pro[+A] = Pro._Trait[A]

  type BiMap[A, B] = Any.BiMap[A, B]; val BiMap = Any.BiMap.This
  type Percent = Numeric.Percent; val Percent = Numeric.Percent
  type Tag[A] = Any.Class.Tag[A]; val Tag = Any.Class.Tag.This
  type Void = Any.As.Void
  type ~[+A] = Pipe.Interface[A]; def ~ = Pipe.Interface.This

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object scalqa -> Notable top level groups include:
 *
 *     - Monads: [[Pipe]] and [[Opt]]
 *     - Collections: [[Coll]], [[Index]] and [[Lookup]]
 *     - [[Able]] contains generic traits
 *
 * @type BiMap -> Alias
 *
 *   Universally available alias to type and object [[Any.BiMap]]
 *
 * @type Percent -> Alias
 *
 *   Universally available alias to type and object [[Numeric.Percent]]
 *
 * @type Tag -> Alias
 *
 *   Universally available alias to type and object [[Any.Class.Tag]]
 *
 * @type Void -> Alias
 *
 *   Universally available alias to type and object [[Any.As.Void]]
 *
 */
