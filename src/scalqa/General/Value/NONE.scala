package scalqa; package General; package Value

object NONE extends Value {

  val Filter: Any => Boolean = filter; private object filter extends (Any => Boolean) { def apply(a: Any) = false }

  import scala.language.implicitConversions

  implicit def zzFilter(v: NONE.type): (Any => Boolean) = Filter

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object NONE ->
 *
 *     See [[General.Value]] for usage
 *
 *     Note. [[NONE]] is implicitly converted to a filter function, which always returns ''false''
 *
 *     {{{
 *       (1 <> 10).all.let(NONE) // The Pipe is empty
 *     }}}
 *
 *  @val Filter -> Any => false
 *
 *    Always returns ''false''
 *
 */
