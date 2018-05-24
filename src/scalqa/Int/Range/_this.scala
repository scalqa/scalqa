package scalqa; package Int; package Range

trait _this extends Any with scalqa.Range.__[Int] {
  protected override type THIS = Range

  protected def value: Long

  def size: Int = value << 32 >>> 32 toInt

  def toIndex: Index[Int] = new Z.all(This)

  def toArray: Array[Int] = Z.array(This)

  // -------------------------------------------------------------------------------------------
  def >>(shiftSize: Int): Range = (start + shiftSize) <>>+ size
  def <<(shiftSize: Int): Range = (start - shiftSize) <>>+ size

  def +(sizeIncrease: Int): Range = start <>> this.end + sizeIncrease
  def -(sizeDecrease: Int): Range = start <>> this.end - sizeDecrease

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _this -> [[Int.Range]] methods, not inherited from [[scalqa.Range Range]]
 *
 * @def toIndex -> Index collection
 *
 *     Returns all indexes belonging to the range as [[Index  Index[Int]]] collection
 *     {{{
 *       (3 <>> 9).toIndex.all lp // Prints: ~(3, 4, 5, 6, 7, 8)
 *     }}}
 *
 * @def size -> Size
 *
 *     Returns range size, which is equal to ''end'' - ''start''
 *     {{{
 *       (2 <>> 5).size lp  // Prints: 3
 *     }}}
 *
 * @def + -> Extend
 *
 *    Creates a new [[Range]] with increased size by ''sizeIncrease''
 *    {{{
 *      (0 <> 1) + 2 lp // Print: 0 <>> 4
 *
 *      (5 <> 7) + 5 lp // Print: 5 <>> 13
 *   }}}
 *
 * @def - -> Shrink
 *
 *    Creates a new [[Range]] with decreased size by ''sizeDecrease''
 *    {{{
 *       (0 <> 9) - 5 lp // Print: 0 <>> 5
 *
 *       (0 <> 1) - 1 lp // Print: 0 <>> 1
 *   }}}
 *
 * @def >> -> Right shift
 *
 *    Creates a new [[Range]], where elements of ''this'' are shifter to the right by ''shiftSize''
 *    {{{
 *       (0 <> 1) >> 2 lp // Print: 2 <>> 4
 *
 *       (5 <> 7) >> 5 lp // Print: 10 <>> 13
 *    }}}
 *
 * @def << -> Left shift
 *
 *    Creates a new [[Range]], where elements of ''this'' are shifter to the left by ''shiftSize''
 *    {{{
 *       (0 <> 1) << 2 lp // Print: -2 <>> 0
 *
 *       (5 <> 7) << 5 lp // Print: 0 <>> 3
 *    }}}
 *
 * @def toArray -> Array of indexes
 *
 *    Returns all indexes belonging to the range as [[Array  Array[Int]]]
 *    {{{
 *      (5 <> 10).toArray.all lp // Prints: ~(5, 6, 7, 8, 9, 10)
 *    }}}
 */
