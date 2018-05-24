package scalqa

package object Long {
  type Like = Like._Trait

  val Min = scala.Long.MinValue

  val Max = scala.Long.MaxValue

  val One: Long = 1L
  val OneThousand = One * 1000L
  val OneMillion = OneThousand * 1000L
  val OneBillion = OneMillion * 1000L
  val OneTrillion = OneBillion * 1000L

  def getParse(ba: Array[Byte], r: Int.Range): Long = {
    var l = 0L; var i = r.start; var c = ba(i).toChar
    val end = r.end
    while (i < end && c >= '0' && c <= '9') { l = l * 10 + (c - '0'); i += 1; c = ba(i).toChar }
    return l
  }

  @inline def get10Power(i: Int): Long = tenPowers(i); private lazy val tenPowers = Array.get[Long](19).I(a => 19.all.foldAs[Long](1L, (v, i) => { a(i) = v; v * 10L }))

  private[scalqa] val Class = classOf[java.lang.Long]
  private[scalqa] val ClassPrimitive = java.lang.Long.TYPE
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object Long ->  Package for base '''scala.Long''' type
 *
 * @def get10Power -> 10 in power of ''i''
 *
 *     Returns pre-built constants
 *
 *     @param i is from 0 to 18
 *     {{{
 *         Long.get10Power(0) lp  // Prints: 1
 *
 *         Long.get10Power(5) lp  // Prints: 100000
 *
 *         Long.get10Power(18) lp // Prints: 1000000000000000000
 *     }}}
 *
 * @val One: -> 1 value
 *
 *     Readable number presentation
 *
 * @val OneThousand -> 1,000 value
 *
 *     Readable number presentation
 *
 * @val OneMillion -> 1,000,000 value
 *
 *     Readable number presentation
 *
 * @val OneBillion -> 1,000,000,000 value
 *
 *     Readable number presentation
 *
 * @val OneTrillion -> 1,000,000,000,000 value
 *
 *     Readable number presentation
 *
 * @val Min -> Minimum value
 *
 *    Constant -2<sup>63</sup>
 *
 *  {{{  -9,223,372,036,854,775,808  }}}
 *
 * @val Max -> Maximum value
 *
 *   Constant 2<sup>63</sup>-1
 *
 *   {{{  9,223,372,036,854,775,807 }}}
 *
 */
