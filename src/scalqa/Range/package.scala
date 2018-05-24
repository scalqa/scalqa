package scalqa

package object Range {

  def get[A](start: A, end: A, endEx: Boolean = false)(implicit s: Sorting[A], t: Tag[A] = \/): Range[A] = getGeneral(start, false, end, endEx)

  def getOne[A](a: A, ex: Boolean)(implicit s: Sorting[A], t: Tag[A] = \/): Range[A] = {
    if (t.isPrimitive && s.isInstanceOf[Sorting.The.Z.Default[_]]) getGeneral(a, false, a, ex)
    else if (ex) new Z.The.One.Exclusive(a, s)
    else new Z.The.One(a, s)
  }

  def getGeneral[A](start: A, startEx: Boolean, end: A, endEx: Boolean)(implicit s: Sorting[A], t: Tag[A] = \/): Range[A] = {
    if (!t.isPrimitive || !s.isInstanceOf[Sorting.The.Z.Default[_]]) {
      new Z.The.Any[A](start, startEx, end, endEx, s)
    } else if (t.isValue) {
      import Z.The.{ Value => V }
      t match {
        case Tag.IntValue    => new V.Ints(start.cast, startEx, end.cast, endEx).cast
        case Tag.DoubleValue => new V.Doubles(start.cast, startEx, end.cast, endEx).cast
        case Tag.LongValue   => new V.Longs(start.cast, startEx, end.cast, endEx).cast
        case Tag.CharValue   => new V.Chars(start.cast, startEx, end.cast, endEx).cast
        case Tag.ByteValue   => new V.Bytes(start.cast, startEx, end.cast, endEx).cast
        case Tag.FloatValue  => new V.Floats(start.cast, startEx, end.cast, endEx).cast
        case Tag.ShortValue  => new V.Shorts(start.cast, startEx, end.cast, endEx).cast
        case _               => Fail.state("Not value: " + t)
      }
    } else {
      import Z.The.{ Primitive => P }
      t match {
        case Tag.Int    => new P.Ints(start.cast, startEx, end.cast, endEx).cast
        case Tag.Double => new P.Doubles(start.cast, startEx, end.cast, endEx).cast
        case Tag.Long   => new P.Longs(start.cast, startEx, end.cast, endEx).cast
        case Tag.Char   => new P.Chars(start.cast, startEx, end.cast, endEx).cast
        case Tag.Byte   => new P.Bytes(start.cast, startEx, end.cast, endEx).cast
        case Tag.Float  => new P.Floats(start.cast, startEx, end.cast, endEx).cast
        case Tag.Short  => new P.Shorts(start.cast, startEx, end.cast, endEx).cast
        case _          => Fail.state("Not Primitive: " + t)
      }
    }
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/

/**
 * @def get[ -> By values
 *
 *   Creates range with default inclusive values
 *
 *   {{{ Range.get(1,5) // Same as: (1 <> 5) }}}
 *
 * @def getGeneral -> By values
 *
 *   Creates range with explicit exclusive designations
 *
 *   {{{ Range.get(1,true,5,true) // Same as: (1 <<>> 5) }}}
 *
 * @object Range ->
 *
 *   [[Range]] can be created with special built-in constructors attached to every type, see [[Any._library._range]]
 *
 *   {{{
 *       'A' <> 'D'   // Range[Char] from 'A' to 'D'
 *
 *       "X" <>> "Z"  // Range[String] from "X" to "Z" exclusive
 *
 *       1.0 <<> 5.0  // Range[Double] from exclusive 1.0 to 5.0
 *
 *       1  <<>> 5    // Range[Int] from exclusive 1 to 5 exclusive
 *
 *       5L <>+ 3     // Range[Long] from 5 to 8
 *
 *       5D <>>+ 3    // Range[Double] from 5.0 to 8.0 exclusive
 *
 *       "abc" <>!    // Range[String] from "abc" to "abc"
 *
 *       "abc" <>>!   // Range[String] from "abc" to "abc" exclusive
 *   }}}
 */
