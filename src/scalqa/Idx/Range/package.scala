package scalqa; package Idx

package object Range {
  type Reposition = Reposition._Trait

  @inline private[scalqa] def fromStartAndSize(start: Int, size: Int) = new Range((start.toLong << 32) + (if (size < 0) 0 else size))

  def make(r: scalqa.Range[Int]): Range =
    if (!r.startExclusive) if (r.endExclusive) r.start <>> r.end else r.start <> r.end
    else if (r.endExclusive) r.start <<> r.end
    else r.start <<>> r.end

  def make(start: Int, startExclusive: Boolean, end: Int, endExclusive: Boolean): Range =
    if (startExclusive) make(start + 1, false, end, endExclusive)
    else if (!endExclusive) make(start, false, end + 1, true)
    else new Range(start.toLong << 32 + end - start)
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object Range ->
 *
 *   The easiest way to construct an [[Idx.Range]] is by using ranging operators on Int value
 *   {{{
 *       3 <> 6   // Idx.Range from 3 to 6
 *
 *       3 <>> 6  // Idx.Range from 3 to 6 exclusive
 *
 *       3 <>+ 3  // Idx.Range from 3 to 6
 *
 *       3 <>>+ 3 // Idx.Range from 3 to 6 exclusive
 *
 *   }}}
 *
 * @def make(r -> By general range
 *
 *     Creates [[Idx.Range]] based on general [[scalqa.Range]] of Ints
 *
 *     {{{
 *        val r = Range.make(0, 5)
 *        r.lp                      //Prints: 0 <> 5
 *        Idx.Range.make(r).lp       //Prints: 0 <>> 6
 *     }}}
 *
 * @def make(start -> By start and end
 *
 *     Creates [[Idx.Range]] based on `start`, `end`, and their exclusive designations
 *
 *     This constructor is not very usable in applications, it is mostly for tools
 */
