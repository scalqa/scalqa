package scalqa; package Util

package object Opt {
  private[scalqa] def This = this

  val Void: Opt[Nothing] = new Opt[Nothing](VoidValue)

  val VoidAlt: Opt[Nothing] = new Opt[Nothing](VoidValue.Alt)

  def apply[T](value: T): Opt[T] = if (value == null) Void else new Opt[T](value)

  def make[T](value: T): Opt[T] = if (value == null) Void else new Opt[T](value)

  def makeNullAble[T](v: T): Opt[T] = new Opt[T](v)

  def fromOption[T](v: scala.Option[T]): Opt[T] = if (v == null || v.isEmpty) Void else apply(v.get)

  def fromOptional[T](v: java.util.Optional[T]): Opt[T] = if (v != null && v.isPresent) apply(v.get) else Void

  // ***************************************************************
  class Int private[Opt] (private[Opt] val real: scala.Int) extends AnyVal with Z.IntDef

  object Int extends Z.IntDef.Setup

  // ***************************************************************
  private[scalqa] class VoidValue

  private[scalqa] object VoidValue extends VoidValue {

    object Alt extends VoidValue

  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object Opt ->
 *
 *     [[Opt]] can also be created with shortcuts:
 *
 *     {{{
 *         val o1 : Opt[Int] = 12    // By implicit convertion
 *
 *         val o2 = 12.Opt           // With built-in constructor attached to every object
 *     }}}
 *
 * @class Int -> `Int Value Option`
 *
 *   [[Opt.Int]] is functionally equivalent to [[scalqa.Opt Opt[Int]]]
 *
 *   The method sets are identical, so please refer to [[Opt]] for details
 *
 *   [[Opt.Int]] is specialized for Int primitive and provides performance boost where it is critical
 *
 *   Generally [[Opt]] is very fast, except for primitives, which are auto-boxed
 *
 * @def apply -> 'get' overload
 *
 *     Same as 'get' for shorter expression where applicable
 *
 *
 * @def make[T](value -> By value
 *
 *     Creates [[Opt]] based on given `value`
 *
 *     Note, 'null' will translate to Opt.Void
 *
 *     {{{
 *         val oi : Opt[Int]    = Opt.make(10)
 *
 *         val os : Opt[String] = Opt.make("foo")
 *     }}}
 *
 * @def makeNullAble -> By value
 *
 *     Creates [[Opt]] based on given `value`
 *
 *     'null' will create [[Opt]] with value 'null'
 *
 *     'null' options should NEVER happen, unless there is no choice
 *
 *     In Scalqa 'null' options only happen in cases of Arrays with default values:
 *
 *     {{{
 *         new Array[String](6).all.lp  // Prints: ~(null, null, null, null, null, null)
 *     }}}
 *
 * @def fromOption[ -> By Scala Option
 *
 *     Creates [[Opt]] based on `scala.Option`
 *
 *     {{{
 *         val o : Opt[String] = Opt.fromOption(scala.Option("foo"))
 *     }}}
 *
 * @def fromOptional -> By Java Optional
 *
 *     Creates [[Opt]] based on `java.util.Optional`
 *
 *     {{{
 *         val o : Opt[String] = Opt.getByOptional(java.util.Optional.of("foo"))
 *     }}}
 *
 * @val Void: -> Void constant
 *
 *     Opt void instance, which can be assigned to any Opt type
 *
 *     {{{
 *         val io  : Opt[Int]    = Opt.Void
 *
 *         val io2 : Opt[Int]    = \/       // Same with shortcut
 *
 *         val so  : Opt[String] = Opt.Void
 *
 *         val so2 : Opt[String] = \/       // Same with shortcut
 *     }}}
 *
 * @val VoidAlt: -> Void alternative constant
 *
 *     VoidAlt is functionally equivalent to Void, but is not equal to Void
 *
 *     It is for special cases, when there is need to distinguish between different voids
 *     {{{
 *         // Opt access, which needs to be initialized
 *
 *         private var _opt : Opt[Int] = Opt.VoidAlt
 *
 *         def getOpt: Opt[Int] = if(_opt != Opt.VoidAlt) _opt else App.Fail("Not initialized")
 *
 *         def initOpt(o :Opt[Int]): Unit = if(_opt == Opt.VoidAlt) _opt = o else App.Fail("Already initialized")
 *     }}}
 */
