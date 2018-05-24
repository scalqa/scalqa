package scalqa; package Any; package Value

trait _Trait extends Any with Able.Void {
  protected type THIS
  protected type VALUE
  protected type SORTABLE = THIS

  protected def real: VALUE

  protected def companion: Companion[THIS, VALUE]

  protected def value: VALUE = if (real != companion.voidVal) real else companion.voidDefault

  protected override def isVoid: Boolean = real == companion.voidVal

  override def toString = if (isVoid) "void" else value.toString

  private[scalqa] def _real: VALUE
  private[scalqa] def kin: Companion[THIS, VALUE]
}

object _Trait {

  import scala.language.implicitConversions

  implicit def zzLibrary(v: Value) = new _library[v.THIS, v.VALUE](v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def value -> Base value
 *
 *     Returns the base underlying value
 *
 * @def toString -> String description
 *
 *     If this is void, returns "void"
 *
 *     Otherwise returns value.toStirng
 *
 * @trait _Trait -> '''Value Value'''
 *
 *   [[Any.Value]] is the root for value data types.
 *
 *   Like any AnyVal, [[Any.Value]] creates a virtual class around certain value, which can be a primitive.
 *
 *   The trouble with general AnyVals is that, when they are stored in generic collections, they do become boxed (wrapped in real object), eliminating many advantages of value types.
 *
 *   [[Any.Value]] provides enough information for willing collections to store it as values.
 *
 *   Many collections in Scalqa are aware of [[Any.Value]] and treat it accordingly.
 *
 *    @example{{{
 *       val list:  List[Int.The]      = (1 <> 1000000).map(_.The).all.to[List]
 *       // list holds 1,000,000 boxed instances of Int.The
 *
 *       val index: Index.Val[Int.The] = (1 <> 1000000).map(_.The).all.to[Index.Val]
 *       // index holds single Array[Int] sized 1,000,000
 *   }}}
 */
