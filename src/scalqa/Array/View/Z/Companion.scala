package scalqa; package Array; package View; package Z

private[Array] abstract class Companion[A, SELF <: Like[A, SELF]](private[Array] val create: Array.Raw[A] => SELF, voidVal: Array.Raw[A]) extends Able.Void.Companion[SELF](create(voidVal)) {

  def get(vs: A*): SELF = if (vs.isEmpty) Void else create(vs.all.to(Pipe.To.Array, vs(0).Class.tag).raw.cast)

  def getRepeatValue(value: A, size: Int): SELF = create(value.Class.tag.newArray[A](size).I(a => if (a.size > 0 && a(0) != value) a.fill(value)).raw.cast)

  // -----------------------------------------------------------------
  import scala.language.implicitConversions

  implicit def zzGet(a: Array.Raw[A]): SELF = create(a)
  implicit def zzGet(a: Like[A, _]): SELF = a.value.cast[Array.Raw[A]]
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *
 * @def get( -> By elements
 *
 *     Creates new instance with elements provided
 *
 *     {{{
 *       // Ints generic example
 *       val v = Ints.get(3, 5, 7, 8)
 *
 *       v.all.lp // Prints: ~(3, 5, 7, 8)
 *     }}}
 *
 * @def getRepeatValue( -> By repeating value
 *
 *     Creates new instance with single ''value'' repeated to the given size
 *
 *     {{{
 *       // Ints generic example
 *       val v = Ints.getRepeatValue(99, 10)
 *
 *       v.all.lp // ~(99, 99, 99, 99, 99, 99, 99, 99, 99, 99)
 *     }}}
 */
