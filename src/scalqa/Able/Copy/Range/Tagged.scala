package scalqa; package Able; package Copy; package Range

trait Tagged[A, TARGET] extends Any {

  def copyFull(implicit t: Tag[A] = \/): TARGET = _copy(size.Range, t)

  def copy(r: Int.Range)(implicit t: Tag[A] = \/): TARGET = _copy(r, t)

  def copyDrop(r: Int.Range)(implicit t: Tag[A] = \/): TARGET = _copyDrop(r, t)

  def copyFirst(number: Int)(implicit t: Tag[A] = \/): TARGET = _copy(number.Range, t)

  def copyLast(number: Int)(implicit t: Tag[A] = \/): TARGET = _copy(size - number <>> size, t)

  def copyFrom(position: Int)(implicit t: Tag[A] = \/): TARGET = _copy(position <>> size, t)

  def copyShort(cnt: Int)(implicit t: Tag[A] = \/): TARGET = _copy((size - cnt).Range, t)

  protected def _copy(r: Int.Range, t: Tag[A]): TARGET
  protected def _copyDrop(r: Int.Range, t: Tag[A]): TARGET
  protected def size: Int

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait Tagged -> '''Generic Copy Range Tagged'''
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
