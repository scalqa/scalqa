package scalqa; package Any; package _library

trait _range[A] extends Any {
  protected def This: A

  def <>(that: A)(implicit s: Sorting[A], t: Tag[A] = \/): Range[A] = Range.getGeneral(This, false, that, false)

  def <>>(that: A)(implicit s: Sorting[A], t: Tag[A] = \/): Range[A] = Range.getGeneral(This, false, that, true)

  def <<>(that: A)(implicit s: Sorting[A], t: Tag[A] = \/): Range[A] = Range.getGeneral(This, true, that, false)

  def <<>>(that: A)(implicit s: Sorting[A], t: Tag[A] = \/): Range[A] = Range.getGeneral(This, true, that, true)

  def <>+(intSize: Int)(implicit step: Int.Step[A], s: Sorting[A], t: Tag[A] = \/): Range[A] = Range.getGeneral(This, false, step(intSize, This), false)

  def <>>+(intSize: Int)(implicit step: Int.Step[A], s: Sorting[A], t: Tag[A] = \/): Range[A] = Range.getGeneral(This, false, step(intSize, This), true)

  def <>!(implicit s: Sorting[A], t: Tag[A] = \/): Range[A] = Range.getOne(This, false)

  def <>>!(implicit s: Sorting[A], t: Tag[A] = \/): Range[A] = Range.getOne(This, true)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _range -> '''Range Built-in Constructors'''
 *
 *     These are ranging operations attached to ''every'' single object in Scalqa
 *
 * @def <>( ->  Simple Range
 *
 *     Creates range from ''this'' to ''that'' all inclusive
 *     {{{
 *         'A' <> 'Z'  // Creates: Range[Char]
 *
 *         10L <> 20   // Creates: Range[Long]
 *     }}}
 * @def <>>( -> Exclusive end range
 *
 *     Creates range from ''this'' to ''that'' with exclusive end
 *     {{{
 *         'A' <>> 'Z'  // Creates: Range[Char]
 *
 *         10L <>> 20   // Creates: Range[Long]
 *     }}}
 * @def <<>( -> Exclusive start range
 *
 *     Creates range from ''this'' to ''that'' with exclusive start
 *     {{{
 *         'A' <<> 'Z'  // Creates: Range[Char]
 *
 *         10L <<> 20   // Creates: Range[Long]
 *     }}}
 * @def <<>>( ->  All Exclusive range
 *
 *     Creates range from ''this'' to ''that'' with exclusive start and end.
 *
 *     {{{
 *         'A' <<>> 'Z'  // Creates: Range[Char]
 *
 *         10L <<>> 20   // Creates: Range[Long]
 *     }}}
 * @def <>! -> Single value range
 *
 *     Creates a single value range with ''this''
 *     {{{
 *         'A' <>!  // Creates: Range[Char] = 'A' <> 'A'
 *
 *         10L <>!  // Creates: Range[Long] = 10 <> 10
 *     }}}
 * @def <>>! -> Exclusive single value range
 *
 *     Creates a single value range with ''this'' exclusive
 *
 *     Note. The range will not be capable to contain anything
 *     {{{
 *         'A' <>>!  // Creates: Range[Char] = 'A' <>> 'A'
 *
 *         10L <>>!  // Creates: Range[Long] = 10 <>> 10
 *     }}}
 * @def <>+ -> Value plus size range
 *
 *     Creates range from ''this'' to "''this'' plus ''intSize''"
 *
 *     [[Int.Step]] must be implicitly available to add ''intSize''
 *     {{{
 *         'A' <>+ 5  // Creates: Range[Char] = A <> F
 *
 *         10L <>+ 5  // Creates: Range[Long] = 10 <> 15
 *     }}}
 *
 * @def <>>+ -> Exclusive end value plus size range
 *
 *     Creates range from ''this'' to "''this'' plus ''intSize''" with end exclusive
 *
 *     [[Int.Step]] must be implicitly available to add ''intSize''
 *     {{{
 *         'A' <>>+ 5  // Creates: Range[Char] = A <>> F
 *
 *         10L <>>+ 5  // Creates: Range[Long] = 10 <>> 15
 *     }}}
 */
