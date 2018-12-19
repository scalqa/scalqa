package scalqa; package Util

import OneOfTwo._

class OneOfTwo[+A, +B] private (private val real: Any) extends AnyVal with Any.Able.ToString {

  def isOne = !isTwo: @inline
  def one: A = real.asInstanceOf[A]
  def oneOpt: Opt[A] = if (isTwo: @inline) Opt.Void else real.asInstanceOf[A]
  def mapOne[C](f: A => C): OneOfTwo[C, B] = oneOpt.map(v => OneOfTwo.one[C, B](f(v))) or asInstanceOf[OneOfTwo[C, B]]

  // ----------------------------------------------------------------------------------------
  def isTwo = real.isInstanceOf[Two[B]]
  def two: Opt[B] = real.asInstanceOf[Two[B]].value
  def twoOpt: Opt[B] = real match { case v: Two[B] => v.value; case v => Opt.Void }
  def mapTwo[C](f: B => C): OneOfTwo[A, C] = twoOpt.map(v => OneOfTwo.two[A, C](f(v))) or asInstanceOf[OneOfTwo[A, C]]

  // ----------------------------------------------------------------------------------------
  def any: Any = real match { case v: Two[B] => v.value; case v => v }

  def apply(one: A => Any, two: B => Any): Unit = real match { case v: Two[B] => two(v.value); case v => one(v.asInstanceOf[A]) }
  def convert[C](f1: A => C, f2: B => C): C = real match { case v: Two[B] => f2(v.value); case v => f1(v.asInstanceOf[A]) }

  override def toString = if (isOne) "One(" + real + ")" else "Two(" + twoOpt.value + ")"
}

object OneOfTwo {

  @inline def one[A, B](v: A) = new OneOfTwo[A, B](v)
  @inline def two[A, B](v: B) = new OneOfTwo[A, B](new Two(v))

  implicit def zzMakeOne[A, B](v: A) = one[A, B](v)
  implicit def zzMakeTwo[A, B](v: B) = two[A, B](v)

  // ***************************************************
  private class Two[A](val value: A)
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *
 * @class OneOfTwo ->
 *
 *   Represents value of one of two possible types (a disjoint union)
 *
 *   [[OneOfTwo]] is NOT biased. Two and One values are logically equal
 *
 *   Implementation wise Two takes a little bit more resources, so putting more frequent types one is justified
 *
 *   {{{
 *       var o: OneOfTwo[String, Int] = "foo"
 *
 *       o.lp        // Prints: One(foo)
 *
 *       o = 777
 *
 *       o.lp        // Prints: Two(777)
 *
 *       o = "bar"
 *
 *       o.lp        // Prints: One(bar)
 *   }}}
 *
 * @def mapOne -> Map one
 *
 *   Maps one value or returns [[OneOfTwo]] as is, if it is two
 *
 * @def mapTwo -> Map one
 *
 *   Maps two value or returns [[OneOfTwo]] as is, if it is one
 *
 * @def oneOpt -> One value
 *
 *   Optionally returns one value
 *
 * @def twoOpt -> Two value
 *
 *   Optionally returns two value
 *
 * @def isOne -> One test
 *
 *     Returns true if this [[OneOfTwo]] holds one value
 *
 * @def isTwo -> Two test
 *
 *     Returns true if this [[OneOfTwo]] holds two value
 *
 * @def any -> Any value
 *
 *     Returns [[OneOfTwo]] value, whatever it is: one or two
 *
 * @def apply -> Process [[OneOfTwo]], either: one or two
 *
 *     Takes two functions, one to process one value, another - two value
 *
 * @def convert -> Convert [[OneOfTwo]]
 *
 *     Takes two functions, one to convert one value, another - two value
 */
