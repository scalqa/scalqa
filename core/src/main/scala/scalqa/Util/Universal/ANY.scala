package scalqa; package Util; package Universal

object ANY {

  implicit def zzFilter[@specialized(DATA) A](v: ANY.type): Stream.Filter[A] = _ => true

  implicit def zzFilterFunction[A](v: ANY.type): A => Boolean = Filter

  private object Filter extends (Any => Boolean) { def apply(v: Any) = true }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object ANY ->
 *
 *   See [[Universal]] for usage
 *
 *   Note. [[ANY]] is implicitly converted to a filter function, which always returns `true`
 *
 *   {{{
 *       (1 <> 10).all.drop(ANY) // The Stream is empty
 *   }}}
 *
 *  @def zzFilter[ -> true
 *
 *    Always returns `true`
 *
 *  @def zzFilterFunction[ -> true
 *
 *    Always returns `true`
 *
 */
