package scalqa; package Any

class _library[A] private[scalqa] (protected val real: A) extends AnyVal {

  def ~+(that: A): ~[A] = Stream.Z.A.Two(real, that)

  def ~+~(that: ~[A]): ~[A] = if (that == null) real.I.~ else that.insertAt(0, real)

  def +-(that: Any): String = real.I.toString + " " + that

  def \/(default: => A): A = if (Any.isVoid(real)) default else real

  @inline final def Opt: Opt[A] = if (real == null) scalqa.Opt.Void else real

  @inline final def isVoid: Boolean = Any.isVoid(real)

  @inline final def I: Itself[A] = new Itself(real)

  def lp: Unit = println(real.I.toString)
  def tp: Unit = real match { case v: Able.ToText => println(v.toText); case _ => lp }

  def <>(that: A)(implicit o: Ordering[A], i: scalqa.Ilk[A]): Range[A] = Range.general(real, false, that, false)
  def <>>(that: A)(implicit o: Ordering[A], i: scalqa.Ilk[A]): Range[A] = Range.general(real, false, that, true)
  def <<>(that: A)(implicit o: Ordering[A], i: scalqa.Ilk[A]): Range[A] = Range.general(real, true, that, false)
  def <<>>(that: A)(implicit o: Ordering[A], i: scalqa.Ilk[A]): Range[A] = Range.general(real, true, that, true)
  def <>+(intSize: Int)(implicit n: Numeric[A], i: scalqa.Ilk[A]): Range[A] = Range.general(real, false, n.plus(real, n.fromInt(intSize)), false)
  def <>>+(intSize: Int)(implicit n: Numeric[A], i: scalqa.Ilk[A]): Range[A] = Range.general(real, false, n.plus(real, n.fromInt(intSize)), true)
  def <>!(implicit o: Ordering[A], i: scalqa.Ilk[A]): Range[A] = Range.one(real, false)
  def <>>!(implicit o: Ordering[A], i: scalqa.Ilk[A]): Range[A] = Range.one(real, true)
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _library -> `Any Library`
 *
 *     Defines operations universally attached to every single object in Scalqa
 *
 * @def +- -> Plus spaced to String
 *
 *     Creates a String concatenation of this, single space, and that
 *
 *     This is useful for debugging, consider:
 *     {{{
 *       '1' +- 2 +- "34" lp // Prints: 1 2 34
 *
 *       // vs.
 *
 *       '1' + 2 + "34" lp   // Prints: 5134
 *     }}}
 *
 * @def isVoid -> Void check
 *
 *    This is a universal way to check an instance for voidness
 *
 *     See [[Any.isVoid]] for details
 *
 *     {{{
 *        (null: String).isVoid lp  // Prints: true
 *
 *        "".isVoid lp              // Prints: true
 *
 *        (\/ : Percent).isVoid lp  // Prints: true
 *     }}}
 *
 * @def I: -> Any.Itself constractor
 *
 *     Built-in constructor for [[Any.Itself]]
 *
 *     [[Any.Itself]] becomes another library attached to every single object in Scalqa, but it has to be accessed over ".I" notation
 *
 *     {{{
 *       val txt = "abc".Text.I(_ lp) // Prints: "abc"
 *
 *       txt.I.id lp                  // Prints: scalqa.String@1
 *
 *       txt.I.hashIndex lp           // Prints: 1
 *     }}}
 *
 * @def lp -> Line print
 *
 *     Prints this object to console with next line marker appended
 *
 *     {{{
 *        val i = 12
 *
 *        " Value i = " + i lp;
 *
 *        // same as
 *
 *        println(" Value i = " + i)
 *     }}}
 *
 * @def tp -> Text print
 *
 *     Prints `this` object to console with next line marker appended
 *
 *     If `this` implements [[Any.Able.ToText]] then `toText` value used, otherwise `toString`
 *
 *     {{{
 *       // Compare to lp
 *
 *       (1 <> 3).all lp  // Prints ~(1, 2, 3)
 *
 *       (1 <> 3).all tp  //  Prints -
 *                        //         ?
 *                        //         -
 *                        //         1
 *                        //         2
 *                        //         3
 *                        //         -
 *     }}}
 *
 * @def ~+( -> Stream plus
 *
 *   Creates a [[Stream]] out of this and appends that
 *
 *   Essentially: creates a Stream of two elements
 *
 *   {{{
 *        1 ~+ 2 lp                 // Prints: ~(1, 2)
 *
 *       'A' ~+ 'Z' lp              // Prints: ~(A, Z)
 *
 *       "aaa" ~+ "bbb" + "ccc" lp  // Prints: ~(aaa, bbb, ccc)
 *   }}}
 *
 * @def ~+~( -> Stream plus stream
 *
 *   Creates a [[Stream]] out of this and appends that stream
 *
 *   Essentially: Prepends this to that stream
 *
 *   {{{
 *       1 ~+~ (2 <> 5) lp                 // Prints: ~(1, 2, 3, 4, 5)
 *
 *       "aa" ~+~ ("bb" ~+ "cc" +"dd") lp  // Prints: ~(aa, bb, cc, dd)
 *   }}}
 *
 * @def Opt -> Opt Constructor
 *
 *     Creates an [[Opt]] with current value
 *
 *     'null' will create Opt.Void
 *
 * @def \/ -> Non void default
 *
 *     If `this` isVoid, `default` is returned
 *
 *     Otherwise `this` is returned
 *
 *    {{{
 *         val p : Percent = \/
 *         val s : String  = null
 *
 *         p \/ 12    lp  // Prints: 12.0%
 *
 *         s \/ "abc" lp  // Prints: abc
 *    }}}
 *
 * @def <>( ->  Simple Range
 *
 *     Creates range from `this` to `that` all inclusive
 *     {{{
 *         'A' <> 'Z'  // Creates: Range[Char]
 *
 *         10L <> 20   // Creates: Range[Long]
 *     }}}
 * @def <>>( -> Exclusive end range
 *
 *     Creates range from `this` to `that` with exclusive end
 *     {{{
 *         'A' <>> 'Z'  // Creates: Range[Char]
 *
 *         10L <>> 20   // Creates: Range[Long]
 *     }}}
 * @def <<>( -> Exclusive start range
 *
 *     Creates range from `this` to `that` with exclusive start
 *     {{{
 *         'A' <<> 'Z'  // Creates: Range[Char]
 *
 *         10L <<> 20   // Creates: Range[Long]
 *     }}}
 * @def <<>>( ->  All Exclusive range
 *
 *     Creates range from `this` to `that` with exclusive start and end.
 *
 *     {{{
 *         'A' <<>> 'Z'  // Creates: Range[Char]
 *
 *         10L <<>> 20   // Creates: Range[Long]
 *     }}}
 * @def <>! -> Single value range
 *
 *     Creates a single value range with `this`
 *     {{{
 *         'A' <>!  // Creates: Range[Char] = 'A' <> 'A'
 *
 *         10L <>!  // Creates: Range[Long] = 10 <> 10
 *     }}}
 * @def <>>! -> Single exclusive value range
 *
 *     Creates a single value range with `this` exclusive
 *
 *     Note. The range will not be capable to contain anything
 *     {{{
 *         'A' <>>!  // Creates: Range[Char] = 'A' <>> 'A'
 *
 *         10L <>>!  // Creates: Range[Long] = 10 <>> 10
 *     }}}
 * @def <>+ -> Value plus size range
 *
 *     Creates range from `this` to "`this` plus `intSize`"
 *
 *     math.Numeric must be implicitly available to add `intSize`
 *     {{{
 *         'A' <>+ 5  // Creates: Range[Char] = A <> F
 *
 *         10L <>+ 5  // Creates: Range[Long] = 10 <> 15
 *     }}}
 *
 * @def <>>+ -> Value plus size exclusive end range
 *
 *     Creates range from `this` to "`this` plus `intSize`" with end exclusive
 *
 *     math.Numeric must be implicitly available to add `intSize`
 *     {{{
 *         'A' <>>+ 5  // Creates: Range[Char] = A <>> F
 *
 *         10L <>>+ 5  // Creates: Range[Long] = 10 <>> 15
 *     }}}
 */
