package scalqa; package Idx; package Range

package object Reposition {

  def make(range: Range, indexes: Ints): Reposition = new Z.Basic(range, indexes)

  def empty(r: Range): Reposition = make(r, r.toInts)

  def fromAll(s: ~[(Int, Int)]): Reposition = {
    val lst = s.to[Idx]
    if (lst.isEmpty) \/
    else {
      val r: Range = lst.all.flatMap(t => t._1 ~+ t._2).range
      make(r, Ints.fromArray { val a = r.toArray; lst.all.foreach(_((i, j) => a(i - r.start) = j)); a })
    }
  }

  def fromOrdering[A](index: Idx[A], fullRange: Boolean = false)(implicit ordering: Ordering[A]): Reposition = Z.fromOrdering(index, fullRange, ordering)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def fromOrdering -> Ordering reposition
 *
 *     Creates a [[Reposition]] for the given index, which if applied, will be equivalent to doing sort
 *
 *     @param  fullRange By default reposition range is limited to the range of change.
 *             If this is true, reposition range will be 0 <>> index.size, even though some indexes will not be mapped.
 *
 * @def empty -> No mappings
 *
 *     Creates a [[Reposition]] for the given range, where all indexes are at their right places.
 *
 *     Applying this [[Reposition]] will bring no actions
 *
 * @def make(range -> By range and indexes
 *
 *    Creates a [[Reposition]] for the given range and indexes.
 *
 *    There are three rules which must be followed:
 *
 *       - Sizes must be equal -> range.size == indexes.size
 *       - Indexes must not repeat
 *       - Indexes must be within range -> indexes.all.isEvery(range.contains)
 *
 *     {{{
 *       Idx.Reposition.make(3 <> 6, Ints.*(6, 5, 4, 3)).lp
 *       // Output
 *       Reposition{range=3 <>> 7,(3,6)(4,5)(5,4)(6,3)}
 *     }}}
 *
 * @def fromAll -> By mappings
 *
 *    Creates a [[Reposition]] by specifying a stream of mappings
 *    {{{
 *       Idx.Reposition.getByAll((5, 7) ~+ (7, 5)).lp
 *       // Output
 *       Reposition{range=5 <>> 8,(5,7)(7,5)}
 *    }}}
 */
