package scalqa; package Int; package Range

package object Reposition {

  def get(range: Int.Range, indexes: Ints): Reposition = new Z.The(range, indexes)

  def getEmpty(r: Int.Range): Reposition = get(r, r.toArray)

  def getByAll(p: ~[(Int, Int)]): Reposition = p.to[Index].I.to(lst => {
    if (lst.isEmpty) \/
    else {
      val r: Int.Range = lst.all.flatMap(t => t._1 ~ t._2).range
      get(r, r.toArray.I(a => lst.all.apply(_((i, j) => a(i - r.start) = j))))
    }
  })

  def getBySorting[A](index: Index[A], fullRange: Boolean = false)(implicit sorting: Sorting[A]): Int.Range.Reposition = Z.getBySorting(index, fullRange, sorting)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def getBySorting -> Sorting reposition
 *
 *     Creates a [[Reposition]] for the given index, which if applied, will be equivalent to doing sort
 *
 *     @param  fullRange By default reposition range is limited to the range of change.
 *             If this is true, reposition range will be 0 <>> index.size, even though some indexes will not be mapped.
 *
 * @def getEmpty -> No mappings
 *
 *     Creates a [[Reposition]] for the given range, where all indexes are at their right places.
 *
 *     Applying this [[Reposition]] will bring no actions
 *
 * @def get(range -> By range and indexes
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
 *       Int.Range.Reposition.get(3 <> 6, Ints.get(6, 5, 4, 3)).lp
 *       // Output
 *       Reposition{range=3 <>> 7,(3,6)(4,5)(5,4)(6,3)}
 *     }}}
 *
 * @def getByAll -> By mappings
 *
 *    Creates a [[Reposition]] by specifying a pipe of mappings
 *    {{{
 *       Int.Range.Reposition.getByAll((5, 7) ~ (7, 5)).lp
 *       // Output
 *       Reposition{range=5 <>> 8,(5,7)(7,5)}
 *    }}}
 */
