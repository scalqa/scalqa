package scalqa; package Int

package object Range {
  type Reposition = Reposition._Trait

  @inline private[Int] def getByStartSize(start: Int, size: Int) = new Range((start.toLong << 32) + size)

  def get(r: scalqa.Range[Int]): Range =
    if (!r.startExclusive) if (r.endExclusive) r.start <>> r.end else r.start <> r.end
    else if (r.endExclusive) r.start <<> r.end
    else r.start <<>> r.end

  def get(start: Int, startExclusive: Boolean, end: Int, endExclusive: Boolean): Range =
    if (startExclusive) get(start + 1, false, end, endExclusive)
    else if (!endExclusive) get(start, false, end + 1, true)
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
 *   The easiest way to construct an [[Int.Range]] is by using ranging operators on [[Int]] value
 *   {{{
 *       3 <> 6   // Int.Range from 3 to 6
 *
 *       3 <>> 6  // Int.Range from 3 to 6 exclusive
 *
 *       3 <>+ 3  // Int.Range from 3 to 6
 *
 *       3 <>>+ 3 // Int.Range from 3 to 6 exclusive
 *
 *   }}}
 *
 * @def get(r -> By general range
 *
 *     Creates [[Int.Range]] based on general [[scalqa.Range]] of [[Int]]s
 *
 *     {{{
 *        val r = Range.get(0, 5)
 *        r.lp                      //Prints: 0 <> 5
 *        Int.Range.get(r).lp       //Prints: 0 <>> 6
 *     }}}
 *
 * @def get(start -> By start and end
 *
 *     Creates [[Int.Range]] based on ''start'', ''end'', and their exclusive designations
 *
 *     This constructor is not very usable in applications, it is mostly for tools
 */
