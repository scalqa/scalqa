package scalqa

package object Int {
  type Range = Range._Class
  type Like = Like._Trait

  val Min = scala.Int.MinValue

  val Max = scala.Int.MaxValue

  def getParse(ba: Array[Byte], r: Int.Range): Int = Long.getParse(ba, r).toInt

  protected[scalqa] val Class = classOf[java.lang.Integer]

  protected[scalqa] val ClassPrimitive = java.lang.Integer.TYPE
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object Int ->  Package for base '''scala.Int''' type
 *
 * @val Min -> Minimum value.
 *
 *    Constant -2<sup>31</sup>
 *
 *  {{{  -2,147,483,648  }}}
 *
 * @val Max -> Maximum value.
 *
 *   Constant 2<sup>31</sup>-1
 *
 *   {{{  2,147,483,647 }}}
 *
 */
