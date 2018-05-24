package scalqa; package Any

package object Value {
  type Byte = Byte._Trait
  type Char = Char._Trait
  type Double = Double._Trait
  type Float = Float._Trait
  type Int = Int._Trait
  type Long = Long._Trait
  type Ref[VAL <: AnyRef] = Ref._Trait[VAL]
  type Short = Short._Trait

  protected[scalqa] val Class = classOf[Value]

  private[scalqa] def companion(v: Any): Companion[Any, Any] = v.cast[Value].kin.cast
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object Value ->
 *
 *  [[Any.Value]] is the root for all value types:
 *
 *    - [[Byte]]
 *    - [[Char]]
 *    - [[Double]]
 *    - [[Float]]
 *    - [[Int]]
 *    - [[Long]]
 *    - [[Ref]]
 *    - [[Short]]
 *
 */
