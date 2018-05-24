package scalqa; package Array; package View

class Refs[A] private[scalqa] (protected val raw: Array.Raw[_ >: A]) extends AnyVal with Like[A, Refs[A]] {

  protected def _get(a: Array[A]) = new Refs[A](a.raw)

}

object Refs {
  private val Void = new Refs(VoidRaw.cast)

  def get[A](vs: A*)(implicit t: Tag[A] = \/): Refs[A] = vs match {
    case a: scala.collection.mutable.WrappedArray[A] => new Refs[A](a.array)
    case _ => vs.all.to(Pipe.To.Refs, t)
  }

  def get[A](a: Array[A]): Refs[A] = new Refs[A](a.raw)

  // ---------------------------------------------------------------
  import scala.language.implicitConversions

  implicit def zzGet[A](a: Array[A]) = get(a)

  implicit def zzGet[A](v: \/.type): Refs[A] = Void.cast

  implicit def zzRaw[A](a: Array.Raw[_ >: A]) = new Refs[A](a)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Refs -> '''Array View of Object References'''
 *
 *     [[Refs]] is an unmodifiable view of an Array of [[Any]]
 *
 *     Note, if primitives or [[Any.Value]]s are stored in [[Refs]],
 *     they will always be 'auto boxed' as 'AnyRef' and taking memory like regular objects
 *     Though this will not make any difference from usage prospective
 *
 *     [[Refs]] can be treated as an immutable object, as long as the reference to the base array is lost
 *     {{{
 *
 *         val view1: Refs[String]  = ("A" ~ "B" ~ "C").to[Refs]   // view1 is perfectly immutable
 *
 *         val array: Array[String] = Array.get("D", "E", "F")
 *
 *         val view2: Refs[String]  = array.Refs                   // view2 is mutable through array
 *
 *         val view3: Refs[String]  = view1 +~ view2               // view3 is perfectly immutable again
 *     }}}
 *
 *     Note: All 'copy' methods return modifiable Array to work with, but it can be converted back to [[Refs]] in a snap:
 *     {{{
 *         val view4 = view3.copy(1 <> 3).Refs            // Explicitly
 *
 *         val view5 : Refs[String] = view3.copy(1 <> 3)  // Implicitly
 *     }}}
 * @object Refs ->
 *
 *   There are two general ways to create Refs:
 *
 *     1. Any [[Pipe]] can be converted to [[Refs]]
 *        {{{
 *            val v: Refs[Int] = (1 <> 5).all.to[Refs]
 *        }}}
 *
 *     2. [[Array]] has a built-in constructor
 *        {{{
 *            val array: Array[Boolean] = Array.get(true, true, false, false)
 *
 *            val v: Refs[Boolean] = array.Refs
 *        }}}
 */
