package scalqa

package object Double {
  type Like = Like._Trait

  val Min = scala.Double.MinValue

  val Max = scala.Double.MaxValue

  protected[scalqa] val Class = classOf[java.lang.Double]
  protected[scalqa] val ClassPrimitive = java.lang.Double.TYPE

  private[scalqa] def orderMultiplier(i: Int): Double = OrderMultiplier(i)

}

private object OrderMultiplier {
  lazy val longMultipliers = Array.get[Long](11).I(a => (0 <>> 11).all.foldAs[Long](1L, (v, i) => { a(i) = v; v * 10L }))
  lazy val doubleMultipliers = Array.get[Double](10).I(a => (0 <>> 10).all.foldAs[Double](1D, (v, i) => { val r = v / 10D; a(i) = r; r }))

  def apply(i: Int): Double = { /* Assert.isBetween[Int.The](i, -10, 10);*/ if (i >= 0) longMultipliers(i) else doubleMultipliers(i.abs - 1) }
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object Double ->  Package for base '''scala.Double''' type
 *
 * @val Min -> Minimum value.
 *
 *    Constant 2<sup>-1022</sup>
 *
 *  {{{  2.2250738585072014E-308 }}}
 *
 * @val Max -> Maximum value.
 *
 *   Constant (2-2<sup>-52</sup>)&middot;2<sup>1023</sup>
 *
 *   {{{  1.7976931348623157e+308 }}}
 */
