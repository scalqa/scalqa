package scalqa; package General; package Value

object EVERY extends Value {

  val Filter: Any => Boolean = filter; private object filter extends (Any => Boolean) { def apply(a: Any) = true }

  import scala.language.implicitConversions

  implicit def zzFilter(v: EVERY.type): (Any => Boolean) = Filter
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object EVERY ->
 *
 *   See [[General.Value]] for usage
 *
 *   Note. [[EVERY]] is implicitly converted to a filter function, which always returns ''true''
 *
 *   {{{
 *       (1 <> 10).all.drop(EVERY) // The Pipe is empty
 *   }}}
 *
 *  @val Filter -> Any => true
 *
 *    Always returns ''true''
 *
 */
