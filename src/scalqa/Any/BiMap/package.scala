package scalqa; package Any

package object BiMap {
  private[scalqa] def This = this

  def get[A, B](applyFun: A => B, undoFun: B => A): BiMap[A, B] = new BiMap[A, B] { def apply(a: A) = applyFun(a); def undo(b: B) = undoFun(b) }

  def getOneWay[A, B](applyFun: A => B): BiMap[A, B] = new BiMap[A, B] { def apply(a: A) = applyFun(a); def undo(b: B) = Fail.unsupported() }

  def getMatch[A, B](listA: A*)(listB: B*): BiMap[A, B] = {
    Assert(listA.size == listB.size, "List sizes do not match: " + listA.size + " <> " + listB.size)
    get(Lookup.getAll(listA.all.zipOnly(listB)), Lookup.getAll(listB.all.zipOnly(listA)))
  }

  @inline def getCast[A, B]: BiMap[A, B] = Cast.cast

  // ********************************************
  private object Cast extends BiMap[Any, Any] {
    @inline def apply(a: Any) = a
    @inline def undo(b: Any) = b
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *  @def get[ -> By functions
 *
 *    Creates [[BiMap]] with provided ''applyFun'' and ''undoFun'' functions
 *    {{{
 *        val bm: BiMap[Int, Long] = BiMap.get(_ * 1000, l => (l / 1000).toInt)
 *    }}}
 *
 *  @def getOneWay -> By function
 *
 *    Creates [[BiMap]] with provided ''applyFun''
 *
 *    ''undo'' functionality will ''Fail.unsupported''
 *
 *  @def getCast -> Simple cast
 *
 *    Returns [[BiMap]] where all conversion is done by simple cast
 *
 *    Essentially, target and result types must be same
 *    {{{
 *        val bm : BiMap[Int,Int] = BiMap.getCast
 *    }}}
 *
 *  @def getMatch -> Two lists
 *
 *    The provided parameter lists must have the same size
 *
 *    The created [[BiMap]] will map between corresponding elements of the lists
 *    {{{
 *        val bm: BiMap[Int, Char] = BiMap.getMatch(1, 2, 3, 4, 5, 6)('A', 'B', 'C', 'D', 'E', 'F')
 *    }}}
 */
