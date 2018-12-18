package scalqa; package Idx.I

import Custom.Array.{ Z => AZ }

class Booleans private[I] (protected val base: Array[Boolean]) extends AnyVal with Idx.I[Boolean] {
  protected type TYPE = Booleans
  @inline protected def make = new Booleans(_)

  @inline def apply(i: Int) = base(i)
  @inline def size: Int = base.length
  @inline def length: Int = base.length
  @inline override def all: ~[Boolean] = Custom.Array.Z.stream(base)

  @inline override def copy(r: Idx.Range) = new Booleans(AZ.copy.range(base, r))
  @inline override def copyDrop(r: Idx.Range) = new Booleans(AZ.copy.dropRange(base, r))

  @inline override def +(v: Boolean) = new Booleans(AZ.plus(base, v))
  @inline override def +~(v: ~[Boolean]) = new Booleans(AZ.plus.stream(base, v))
  @inline override def +@(i: Int, v: Boolean) = new Booleans(AZ.plus.at(base, i, v))
  @inline override def +~@(i: Int, v: ~[Boolean]) = new Booleans(AZ.plus.pipeAt(base, i, v))

  @inline override def -(v: Boolean) = new Booleans(AZ.minus(base, v))
  @inline override def -~(v: ~[Boolean]) = new Booleans(AZ.minus.stream(base, v))

  @inline override def toArray(implicit t: ClassTag[Boolean]) = base.copyFull
}

object Booleans extends Z.Primitive.Setup[Boolean, Booleans](new Booleans(_), Array.emptyBooleanArray)

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Booleans -> `Immutable Boolean Array Wrap`
 *
 * @object Booleans ->
 *
 *   [[Booleans]] is often created from a [[Stream]]:
 *
 *   {{{
 *       (true ~+ false + true + false).toPrimitive[Booleans]
 *   }}}
 */
