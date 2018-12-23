package Features.Data_Modeling

/**
 *
 * Let's define a numeric data type 'Dollars' stored as a Float
 *
 * =Definition=
 *
 * {{{
 *     class Dollars(val real: Float) extends AnyVal with Any.Datum.Float.Number[Dollars] {
 *
 *       protected def setup = Dollars
 *
 *       override def toString = "\$" + real
 *
 *     }
 *
 *     object Dollars extends Any.Datum.Float.Number.Setup[Dollars] {
 *
 *        def make(v: Float): Dollars = new Dollars(v)
 *
 *     }
 *
 *     implicit class zzDollarsConstructor(val v: Double) extends AnyVal {
 *
 *       def Dollars = new Dollars(v.toFloat)
 *
 *     }
 * }}}
 *
 * For the trouble taken, we get following benefits:
 *
 * =New data type=
 *
 * {{{
 *     val d: Dollars = 5.Dollars   // Nice in-line constructor
 *
 *     val v: Dollars = 5.0F        // Fails to compile, Float is not Dollars
 * }}}
 *
 * =Ordered=
 *
 * {{{
 *     def stream: ~[Dollars] = 2.Dollars ~+ 12.99.Dollars + 5.Dollars
 *
 *     stream.sort.lp      // Prints: ~(\$2.0, \$5.0, \$12.99)
 *
 *     stream.max.lp       // Prints: \$12.99
 *
 *     stream.min.lp       // Prints: \$2.0
 * }}}
 *
 * =Numeric=
 *
 * {{{
 *     def stream : ~[Dollars] = ~.*(2.Dollars, 12.99.Dollars, 5.Dollars)
 *
 *     stream.average.lp   // Prints: \$6.6633334
 *
 *     stream.sum.lp       // Prints: \$19.99
 * }}}
 *
 * =Regular Math=
 *
 * Math is similar to the Float. Primitive conversions are allowed
 * {{{
 *     14.99.Dollars + 1.Dollars lp // Prints \$15.99
 *
 *     20.Dollars - 10.99F lp       // Prints \$9.01
 *
 *     20.Dollars * 10.Dollars lp   // Prints \$200.0
 *
 *     20.Dollars / 4 lp            // Prints \$5.0
 * }}}
 *
 * =Ranging operations=
 * {{{
 *     val rng:  Range[Dollars] = 1.Dollars <> 5.Dollars
 *
 *     val rng2: Range[Dollars] = 3.5.Dollars <> 100.Dollars
 *
 *     rng contains 5.Dollars lp   // Prints true
 *
 *     rng contains rng2 lp        // Prints false
 *
 *     rng overlapOpt rng2 lp      // Prints Opt(\$3.5 <> \$5.0)
 *
 *     rng.all.lp                  // Prints ~(\$1.0, \$2.0, \$3.0, \$4.0, \$5.0)
 *
 *     rng.allStep(2.Dollars).lp   // Prints ~(\$1.0, \$3.0, \$5.0)
 * }}}
 *
 * =Un-boxed collections=
 *
 * Note: AnyVal when put into a general collection is always boxed and takes resources as an Object
 *
 * [[scalqa.Vals Vals]] is an immutable collection to store [[scalqa.Any.Datum any data]] as primitives
 *
 * {{{
 *     var immutable: Vals[Dollars] = (1.Dollars <> 10.Dollars).allStep(3).toVals
 *
 *     val buffer:    Idx.M[Dollars]  = Idx.M.getNewVals()  // Mutable unboxed collection
 *
 *     immutable = immutable + 4.Dollars
 *
 *     immutable.all.lp                    // Prints ~(\$1.0, \$2.0, \$3.0, \$4.0)
 *
 *     buffer +~= immutable += 5.Dollars
 *
 *     buffer.all.lp                       // Prints ~(\$1.0, \$2.0, \$3.0, \$4.0, \$5.0)
 *  }}}
 */
class Dollars_Example { val sort_1 = () }
