package scalqa; package Any; package Itself

import Opt.Void

class _Class[A] private[scalqa] (protected val real: A) extends AnyVal  {

  def id: String = Class.label + '@' + hashIndex

  def hashIndex: Int = Z.hashIndex(real)

  override def toString: String = Z.toString(real)

  // ------------------------------------------------------------------------------------------------------------
  def let(f: A=>Boolean): Opt[A] = if (f(real)) real else Void

  def letType[B](implicit t: ClassTag[B]): Opt[B] = if (t.unapply(real).isEmpty) Void else real.asInstanceOf[B]

  def drop(f: A=>Boolean): Opt[A] = if (f(real)) Void else real

  def Opt: Opt[A] = if (Any.isVoid(real)) Void else real

  def toArray(implicit ct: ClassTag[A]): Array[A] = { val a = ct.newArray(1); a(0) = real; a }

  def to[THIS[_]](implicit to: To.Converter[THIS], i: Ilk.Tag[A]): THIS[A] = to.make(real, i)

  def ~ : ~[A] = Stream.Z.A.One(real)

  def repeat(times: Int): ~[A] = new Stream.A.Indexed[A] { val _size = times max 0; def _apply(i: Int) = real }

  def unfold(f: Stream.Mapping[~[A], A]): Stream[A] = ~.unfold(f)

  def ilk: Ilk = Ilk.fromClass(real.getClass)

  def Class = new Class[A](real.getClass.asInstanceOf[java.lang.Class[A]])

  // ------------------------------------------------------------------------------------------------------------
  def apply(f: A => Any): A = { f(real); real }

  def as[B](f: A => B)(implicit t: ClassTag[B]): B = if (t.unapply(real).isEmpty) f(real) else real.asInstanceOf[B]

  def asInstanceOfTarget[T]: T = real.asInstanceOf[T]

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _Class ->
 *
 *     [[Any.Itself]] is a library available for `every` single object in Scalqa
 *
 *     [[Any.Itself]] has to be accessed of <any>.I notation
 *
 *     Because, of <any>.I access [[Any.Itself]] has luxury of providing diverse functionality on every object with no naming conflicts with application methods
 *
 *     {{{
 *       val txt = "abc".I(_ lp)     // Prints: "abc"
 *
 *       txt.I.id lp                 // Prints: scalqa.String@1
 *
 *       txt.I.hashIndex lp          // Prints: 1
 *     }}}
 *
 * @def Opt -> Non void Opt Constructor
 *
 *     Creates an [[Opt]] with current value
 *
 *     'null' or void values will create Opt.Void
 *
 *     Voidness is tested with [[Any.isVoid]]
 *
 *     {{{
 *         var s: String  = null
 *         var p: Percent = \/
 *
 *         s.I.Opt lp    // Prints: Opt.Void
 *         p.I.Opt lp    // Prints: Opt.Void
 *
 *         s = "abc"
 *         p = 12
 *
 *         s.I.Opt lp    // Prints: Opt(abc)
 *         p.I.Opt lp    // Prints: Opt(12.0%)
 *     }}}
 *
 * @def toArray -> Create single element array
 *
 * @def ~ : -> Create single element [[Stream]]
 *
 * @def Class -> Class constructor
 *
 *     Built-in constructor for [[Class]]
 *
 *     {{{
 *       "abc".I.Class.name lp  // Prints: java.lang.String
 *     }}}
 *
 *
 * @def as[ -> Adapt
 *
 *    Adapts `this` to the target type
 *
 *    If `this` implements target type, simple `asInstanceOf` is returned
 *
 *    Otherwise conversion function is used and the result is returned
 *
 *    {{{
 *       val x:  Idx[Int]   = Idx.*(1, 2, 3)
 *       val xw: Idx.M[Int] = x.I.as[Idx.M[Int]](x => Idx.M.makeSized[Int](x.size).I(_ +~= x))
 *
 *       // check
 *       xw.isInstanceOf[Idx.M[Int]].lp  // Prints: true
 *       xw.all.lp                       // Prints: ~(1, 2, 3)
 *    }}}
 *
 * @def asInstanceOfTarget -> Target cast
 *
 *     This is same as regular [[asInstanceOf]] except it can derive target type from the context
 *
 *     It can be useful when type is hard to come by
 *
 *     {{{
 *       type FOO >: Int
 *
 *       val v : FOO = 1.asInstanceOfTarget
 *     }}}
 *
 * @def apply -> Process
 *
 *    Runs specified function for `this`
 *
 *    Returns `this`
 *    {{{
 *      // Defining array and data in one line
 *      val array = new Array[Int](3).I(a => {a(1)=1; a(2)=2})
 *    }}} *
 * @def unfold -> Lazy infinite stream
 *
 *    Lazily unfolds next value with a function taking all prior values
 *
 *    {{{
 *      1.I.unfold(_.last * 2).letNext(10).lp // Prints ~(1, 2, 4, 8, 16, 32, 64, 128, 256, 512)
 *    }}}
 *
 * @def repeat( -> Repeat as Stream
 *
 *    Returns [[Stream]] with value repeated specified number of times
 *
 *    {{{
 *       'a'.I repeat 5 lp // Prints ~(a, a, a, a, a)
 *    }}}
 *
 * @def let( -> Filtered value option
 *
 *     If `this` passes filter function, `this` is returned as [[Opt]]
 *
 *     Otherwise empty Opt.Void is returned
 *     {{{
 *         5.I.let(_ < 10).lp // Prints: Opt(5)
 *         5.I.let(_ > 10).lp // Prints: Opt.Void
 *     }}}
 *
 * @def drop( -> Filtered out value option
 *
 *     If `this` does not pass filter function, `this` is returned as [[Opt]]
 *
 *     Otherwise empty Opt.Void is returned
 *     {{{
 *         5.I.drop(_ < 10).lp // Prints: Opt.Void
 *         5.I.drop(_ > 10).lp // Prints: Opt(5)
 *     }}}
 *
 * @def letType -> Typed option
 *
 *     If `this` is an instance of provided type, `this` is returned as [[Opt]] value of new type
 *
 *     Otherwise empty Opt.Void is returned.
 *     {{{
 *        val a : Any = "abc"
 *        a.I.letAs[String].lp  // Prints: Opt(abc)
 *        a.I.letAs[Double].lp  // Prints: Opt.Void
 *     }}}
 *
  * @def toString -> String description
 *
 *     Only differences with basic `toString`:
 *
 *       - will not fail for `null` and print "null"
 *       - for void objects will print "void"
 *       - for scala singleton objects will omit hashCode (which does not make sense)
 *
 *     {{{
 *         "abc".I.toString.lp           // Prints: abc
 *         (null: String).I.toString.lp  // Prints: null
 *         "".I.toString.lp              // Prints: void
 *     }}}
 *
 * @def id -> Instance identifier
 *
 *   Returns: Class.label + "@" + hashIndex
 *    {{{ "abc".I.id.lp  // Prints: java.lang.String@1 }}}
 *
 * @def hashIndex -> Easy to read hash
 *
 *   Object hash is a long, hard to read number
 *
 *   This method creates a static Lookup, where the long hash is stored with its sequential index. The index is used instead of real hash
 *
 *   This mechanism is great for light debugging, and should not be use in production, because the Lookup table can grow to a point when it is a hurdle
 *
 *   {{{
 *     val myString = "string"
 *
 *     "other1".I.hashIndex.lp // Prints: 1
 *     myString.I.hashIndex.lp // Prints: 2
 *     "other2".I.hashIndex.lp // Prints: 3
 *     myString.I.hashIndex.lp // Prints: 2
 *     "other3".I.hashIndex.lp // Prints: 4
 *     myString.I.hashIndex.lp // Prints: 2
 *  }}}
 *
 */
