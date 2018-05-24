package scalqa; package Able; package Copy; package Range

trait _Trait[TARGET] extends Any {

  def copyFull: TARGET = _copy(size.Range)

  def copy(r: Int.Range): TARGET = _copy(r)

  def copyDrop(r: Int.Range): TARGET = _copyDrop(r)

  def copyFirst(number: Int): TARGET = _copy(number.Range)

  def copyLast(number: Int): TARGET = _copy(size - number <>> size)

  def copyFrom(position: Int): TARGET = _copy(position <>> size)

  def copyShort(cnt: Int): TARGET = _copy((size - cnt).Range)

  protected def size: Int
  protected def _copy(r: Int.Range): TARGET
  protected def _copyDrop(r: Int.Range): TARGET

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait -> '''Generic Copy Range'''
 *
 * @def copyFull -> Copy everything
 *
 *     Copies entire content
 *
 * @def copy( -> Copy range
 *
 *     Copies elements within the range specified
 *     {{{
 *       // Generic String example
 *       "abcdefghi".copy(3 <> 5).lp  // Prints: def
 *     }}}
 *
 * @def copyDrop -> Copy without range
 *
 *     Copies elements outside the range specified
 *     {{{
 *       // Generic String example
 *       "abcdefghi".copyDrop(3 <> 5).lp  // Prints: abcghi
 *     }}}
 *
 * @def copyFirst -> Copy start
 *
 *    Copies specified number of first elements
 *     {{{
 *       // Generic String example
 *       "abcdefghi".copyFirst(3).lp  // Prints: abc
 *     }}}
 *
 *
 * @def copyLast -> Copy end
 *
 *    Copies specified number of elements at the end
 *    {{{
 *       // Generic String example
 *       "abcdefghi".copyLast(3).lp  // Prints: ghi
 *    }}}
 *
 * @def copyFrom -> Copy end
 *
 *     Copies elements from specified position to the end
 *    {{{
 *       // Generic String example
 *       "abcdefghi".copyFrom(5).lp  // Prints: fghi
 *    }}}
 *
 * @def copyShort -> Copy without end
 *
 *    Copies from the beginning, missing specified number of elements at the end
 *    {{{
 *       // Generic String example
 *       "abcdefghi".copyShort(3).lp  // Prints: abcdef
 *    }}}
 */
