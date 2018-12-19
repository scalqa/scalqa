package scalqa; package Idx.I

import Custom.Array.{ Z => AZ }

class Refs[A] private[I] (protected val base: Array[A]) extends AnyVal with Idx.I[A] {
  protected type TYPE = Refs[A]
  @inline protected def make = new Refs[A](_)

  @inline def apply(i: Int) = base(i)
  @inline def size: Int = base.length
  @inline def length: Int = base.length

  override def all: ~[A] =
    if (Array.emptyObjectArray.getClass.isInstance(base)) Custom.Array.Z.stream[A](base.asInstanceOf[Array[A]])
    else Ilk.fromArray(base).mkStream(base.asInstanceOf[Array[A]])

}

object Refs {

  def *[A](vs: A*): Refs[A] = vs match {
    case a: scala.collection.mutable.WrappedArray[A] => new Refs[A](a.array)
    case _ => vs.all.to[Refs]
  }

  def repeatValue[A](value: A, size: Int)(implicit i: Ilk[A]): Refs[A] = new Refs({
    val a = i.mkArray[A](size);
    if (a.length > 0 && a(0) != value) { var i = 0; while (i < size) { a(i) = value; i += 1 } }
    a
  })

  private[scalqa] def copy[A](a: Array[_ >: A]): Refs[A] = new Refs(a.copyFull.asInstanceOf[Array[A]])

  private[scalqa] def single[A](v: A)(implicit i: Ilk[A]): Refs[A] = new Refs({ val a = i.mkArray[A](1); a(0) = v; a })

  private[scalqa] def fromFlow[A](v: Stream.Flow[A]): Refs[A] = new Refs[A]({
    val b = Idx.Array.Buffer.makeSized[A](v.sizeOpt or App.initSize)(v.ilkDefault)
    v.copyTo(b.loader)
    b.arrayBase
  })

  def void[A](implicit i: Ilk[A]) = new Refs[A](i.mkArray(0))

  implicit def zzMake[A](v: \/)(implicit i: Ilk[A]) = void[A]

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Refs ->
 *
 *     [[Refs]] is an immutable Array wrap of appropriate type
 *
 * @object Refs ->
 *
 *   [[Refs]] can also be created from a [[Stream]]:
 *   {{{
 *       (1 ~+ 2 + 3).to[Refs]
 *   }}}
 *
 * @def *[A] -> Vararg constructor
 *
 *    Creates [[Refs]] with specified values
 *
 *
 */
