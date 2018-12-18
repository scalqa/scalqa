package scalqa; package Any; package Able

trait CopyRange[TYPE] extends Any {

  def size: Int

  def copyFull: TYPE = copy(size.Range)

  def copy(r: Idx.Range): TYPE

  def copyDrop(r: Idx.Range): TYPE

  def copyFirst(number: Int): TYPE = copy(number.Range)

  def copyLast(number: Int): TYPE = copy(size - number <>> size)

  def copyFrom(position: Int): TYPE = copy(position <>> size)

  def copyShort(cnt: Int): TYPE = copy((size - cnt).Range)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait CopyRange -> `Generic Range Copy `
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
 *
 * @def size -> Container size
 *
 *    Notion of a `range` is only valid in presence of `size`
 */
