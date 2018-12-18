package scalqa; package Util; package Universal

object NONE {

  implicit def zzFilter[@specialized(DATA) A](v: NONE.type): (A => Boolean) = _ => false

  implicit def zzAnyFilter[@specialized(DATA) A](v: ANY.type): Stream.Filter[A] = _ => false

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
 *     See [[Universal]] for usage
 *
 *     Note. [[NONE]] is implicitly converted to a filter function, which always returns `false`
 *
 *     {{{
 *       (1 <> 10).all.let(NONE) // The Stream is empty
 *     }}}
 *
 *
 */
