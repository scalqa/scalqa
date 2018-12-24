package scalqa; package Idx.I

import Custom.Array.{ Z => AZ }

class Booleans private[I] (protected val base: Array[Boolean]) extends AnyVal with Idx.I[Boolean] {
  protected type TYPE = Booleans
  def make = new Booleans(_)

  def apply(i: Int) = base(i)
  def size: Int = base.length
  override def all: ~[Boolean] = Custom.Array.Z.stream(base)

  override def copy(r: Idx.Range) = new Booleans(AZ.copy.range(base, r))
  override def copyDrop(r: Idx.Range) = new Booleans(AZ.copy.dropRange(base, r))

  override def +(v: Boolean) = new Booleans(AZ.plus(base, v))
  override def +~(v: ~[Boolean]) = new Booleans(AZ.plus.stream(base, v))
  override def +@(i: Int, v: Boolean) = new Booleans(AZ.plus.at(base, i, v))
  override def +~@(i: Int, v: ~[Boolean]) = new Booleans(AZ.plus.pipeAt(base, i, v))

  override def -(v: Boolean) = new Booleans(AZ.minus(base, v))
  override def -~(v: ~[Boolean]) = new Booleans(AZ.minus.stream(base, v))

  override def toArray(implicit t: ClassTag[Boolean]) = base.copyFull
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
 * There is [[Booleans]] alias at Scalqa root, so this class can be universally used without prefix
 *
 * @object Booleans ->
 *
 *   [[Booleans]] is often created from a [[Stream]]:
 *
 *   {{{
 *       (true ~+ false + true + false).toRaw[Booleans]
 *   }}}
 */
