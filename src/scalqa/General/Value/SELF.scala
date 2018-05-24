package scalqa; package General; package Value

object SELF extends Value {

  val Map: Any => Any = map; private object map extends (Any => Any) { def apply(v: Any) = v }

  import scala.language.implicitConversions

  implicit def zzMap[A](v: SELF.type): (A => A) = Map.cast
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object SELF ->
 *
 *     See [[General.Value]] for usage
 *
 *     Note. [[SELF]] can implicitly be converted to Any => Any function, which always returns passed value
 *
 *     {{{
 *       (1 <> 3).sort all.let(NONE) // The Pipe is empty
 *     }}}
 *
 */
