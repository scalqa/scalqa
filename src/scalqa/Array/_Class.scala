package scalqa; package Array

class _Class[A] private[scalqa] (val raw: Array.Raw[_ >: A]) extends AnyVal with _basic[A] with _data[A] with _copy[A] with _plusMinus[A] with Like[A, _Class[A]] {

  protected override def _get(a: Array[A]) = a

}

object _Class extends Able.Void.Companion.Typed[Array](Void) with Z.Implicits {

  import scala.language.implicitConversions

  implicit def zzRaw[A](raw: Array.Raw[_ >: A]) = new Array[A](raw)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *  @class _Class ->
 *
 *    [[Array]] in Scalqa is a wrapper around ''scala.Array'', which are aliased with name [[Array.Raw]]
 *
 *    Wrapping solves general Java problem of creating a generic array with only modest performance hit. In Java, as well as in Scala, it is impossible to create a general array structure,
 *    the final class information must be present
 *
 *    In Scalqa the [[Array.Raw]][AnyRef] is the base generic storage for arrays like Array[String], Array[Numeric], etc.
 *    [[Array.Raw]] of a primitive is the base storage for an [[Array]] of corresponding primitive
 *
 *    The good news is that base generic storage can be determined even by runtime value examples. This makes [[Array]] a structure of choice to use with [[Pipe]]s
 *
 *    There is even a generic void [[Array]][Any] - something unthinkable in Java:
 *    {{{
 *       var ia: Array[Int]    = \/
 *       var sa: Array[String] = \/
 *
 *       // Void array is same
 *       (ia == sa) lp              // Prints: true
 *
 *       ia +~= 1 <> 5              // Plus Ints only
 *       sa = sa + "A" + "B" + "C"  // Plus Strings only
 *
 *       ia.all lp                  // Prints: ~(1, 2, 3, 4, 5)
 *
 *       sa.all lp                  // Prints: ~(A, B, C)
 *    }}}
 */
