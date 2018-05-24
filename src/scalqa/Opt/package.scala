package scalqa

package object Opt {
  type orError[+A] = orError._Class[A]

  val Void: Opt[Nothing] = new Opt[Nothing](Z.Empty.Void)

  val VoidAlt: Opt[Nothing] = new Opt[Nothing](Z.Empty.VoidAlt)

  def get[T](value: T): Opt[T] = if (value == null) Void else new Opt[T](value)

  def getNullAble[T](v: T): Opt[T] = new Opt[T](v)

  def getByOption[T](v: scala.Option[T]): Opt[T] = if (v == null || v.isEmpty) Void else get(v.get)

  def getByOptional[T](v: java.util.Optional[T]): Opt[T] = if (v != null && v.isPresent) get(v.get) else Void

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
 *     [[Opt]] can also be created:
 *
 *     {{{
 *         val o1 : Opt[Int] = 12    // By implicit convertion
 *
 *         val o2 = 12.Opt           // By built-in constructor attached to every object
 *     }}}
 *
 * @def get[T](value -> By value
 *
 *     Creates [[Opt]] based on given ''value''
 *
 *     Note, 'null' will translate to Opt.Void
 *
 *     {{{
 *         val oi : Opt[Int]    = Opt.get(10)
 *
 *         val os : Opt[String] = Opt.get("Abc")
 *     }}}
 *
 * @def getNullAble -> By value
 *
 *     Creates [[Opt]] based on given ''value''
 *
 *     'null' will create [[Opt]] with value 'null'
 *
 *     'null' options should NEVER happen, unless there is no choice
 *
 *     In Scalqa 'null' options only happen in cases of Arrays with default values:
 *
 *     {{{
 *         Array.get[String](6).all.lp  // Prints: ~(null, null, null, null, null, null)
 *     }}}
 *
 * @def getByOption[ -> By Scala Option
 *
 *     Creates [[Opt]] based on ''scala.Option''
 *
 *     {{{
 *         val o : Opt[String] = Opt.getByOption(scala.Option("Abc"))
 *     }}}
 *
 * @def getByOptional -> By Java Optional
 *
 *     Creates [[Opt]] based on ''java.util.Optional''
 *
 *     {{{
 *         val o : Opt[String] = Opt.getByOptional(java.util.Optional.of("Abc"))
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
 *         def opt: Opt[Int] = if(_opt != Opt.VoidAlt) _opt else Fail("Not initialized")
 *
 *         def initOpt(o :Opt[Int]): Unit = if(_opt == Opt.VoidAlt) _opt = o else Fail("Already initialized")
 *     }}}
 */
