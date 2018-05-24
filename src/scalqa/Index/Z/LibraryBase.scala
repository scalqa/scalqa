package scalqa; package Index; package Z

private[scalqa] trait LibraryBase[A] extends Any with Coll.Z.LibraryBase[A] {

  def opt(position: Int): Opt[A] = if (position < 0 || position >= This.size) \/ else This(position)

  def first: A = firstOpt.value

  def last: A = lastOpt.value

  def firstOpt: Opt[A] = opt(0)

  def lastOpt: Opt[A] = opt(This.size - 1)

  override def asMap[B](f: A => B): Index[B] = new Z.As.Mapped(This, f)

  def asO: O[A] = This.I.as(classOf[O[A]], new Z.As.Unsupported.O[A](_))

  def asW: W[A] = This.I.as(classOf[W[A]], new Z.As.Unsupported.W[A](_))

  def asWO: WO[A] = This match { case l: WO[A] => l; case l: W[A] => new W.Z.As.UnsupportedWO[A](l); case l: O[A] => new O.Z.As.UnsupportedWO[A](l); case l => new Z.As.Unsupported.WO[A](l) }

  def asTail(fromPosition: Int): Index[A] = if (fromPosition <= 0) This else new Z.As.Tail(This, fromPosition)

  def asRanged(r: Int.Range): Index[A] = new Z.As.Ranged(This, r)

  def asJavaList: java.util.List[A] = This match {
    case l: W[A] => new W.Z.As.JavaList(l)
    case l       => new Z.As.JavaList(l)
  }

  def asReversed: Index[A] = new Z.As.Reversed(This)

  def asSynchronized(lock: Opt[AnyRef] = \/): Index[A] = new Z.As.Synchronized(This, lock)

  def searchOrdered(element: A, maxFound: Int = 1)(implicit s: Sorting[A]): Int.Range = Z.BinarySearch(This, element, maxFound)(s)

  def searchOrderedBy[B](map: A => B, value: B, maxFound: Int = 1, extraFilter: A => Boolean = EVERY)(implicit s: Sorting[B]): Int.Range = Z.BinarySearch(This, value, map, maxFound, extraFilter)(s)

  def to2: (A, A) = (This(0), This(1))

  def to3: (A, A, A) = (This(0), This(1), This(2))

  def to4: (A, A, A, A) = (This(0), This(1), This(2), This(3))

  protected def This: Index[A]
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def opt -> Element at position
 *
 *    Returns element at given ''position'' or Opt.Void if ''position'' is out of [[Index]] range
 *
 * @def first: -> First element
 *
 *    Returns first element or [[Fail]] for empty collection
 *
 * @def last: -> Last element
 *
 *    Returns last element or [[Fail]] for empty collection
 *
 * @def firstOpt -> First element
 *
 *    Returns first element or Opt.Void for empty collection
 *
 * @def lastOpt -> Last element
 *
 *    Returns last element or Opt.Void for empty collection
 *
 * @def asWO -> Writable observable view
 *
 *    If ''this'' implements [[WO]], ''this'' is returned
 *
 *    Otherwise, returns view of ''this'' as [[WO]], where any change will Fail.unsupported and no events will be generated
 *
 * @def asW: -> Writable view
 *
 *    If ''this'' implements writable, ''this'' is returned
 *
 *    Otherwise, returns view of ''this'' as writable, where any change will Fail.unsupported
 *
 * @def asO -> Observable view
 *
 *    If ''this'' implements Observable, ''this'' is returned
 *
 *    Otherwise, returns view of ''this'' as Observable, without generating events
 *
 * @def asTail -> Tail view
 *
 *     Creates view of ''this'' as last elements starting ''fromPosition''
 *
 * @def asJavaList -> Java List view
 *
 *     Creates view of ''this'' as Java List
 *
 * @def asRanged -> Range projected view
 *
 *     Creates view of ''this'' projected on provided range
 *
 * @def asRanged -> Range projected view
 *
 *     Creates view of ''this'' projected on provided range
 *
 * * @def asSynchronized -> Synchronized view
 *
 *     Creates view of ''this' with all access synchronized
 *
 *     @param lock optional synchronization target. If empty the Index itself is used
 *
 * @def searchOrdered( -> Binary search
 *
 *    Efficient search for the ''element'', without scanning the entire index
 *
 *    The elements have to be already sorted with the ''sorting'' provided, otherwise results are random
 *
 *    Returns [[Int.Range]], where range.start indicates position of the element. If range.size==0, then no element found, just its logical position.
 *
 *    @param maxFound maximum found returned range size. The returned range indicates how many elements found up to the max
 *    @example
 *    {{{
 *       val x :Index[Int] = (1 ~ 2 ~ 3 ~ 5).repeat(4).to[Index]
 *
 *       x.all.zipIdx.tp
 *       // Output
 *       -- -
 *       ?  ?
 *       -- -
 *       0  1
 *       1  1
 *       2  1
 *       3  1
 *       4  2
 *       5  2
 *       6  2
 *       7  2
 *       8  3
 *       9  3
 *       10 3
 *       11 3
 *       12 5
 *       13 5
 *       14 5
 *       15 5
 *       -- -
 *
 *       x.searchOrdered(0).lp    // Prints: 0 <>> 0
 *       x.searchOrdered(2).lp    // Prints: 4 <>> 5
 *       x.searchOrdered(2, 5).lp // Prints: 4 <>> 8
 *       x.searchOrdered(4).lp    // Prints: 12 <>> 12
 *       x.searchOrdered(6).lp    // Prints: 16 <>> 16
 *    }}}
 *
 * @def searchOrderedBy -> Binary search by property
 *
 *    Efficient search for the ''element'', based on its property value, without scanning the entire index
 *
 *    The elements have to be already sorted by the property with the ''sorting'' provided, otherwise results are random
 *
 *    Returns [[Int.Range]], where range.start indicates position of the element. If range.size==0, then no element found, just its logical position.
 *
 *    @param map property function
 *    @param maxFound maximum found returned range size. The returned range indicates how many elements found up to the max
 *    @example
 *    {{{
 *       val x: Index[String] = ("1" ~ "2" ~ "3" ~ "5").repeat(4).to[Index]
 *
 *       x.all.zipIdx.tp
 *       // Output
 *       -- -
 *       ?  ?
 *       -- -
 *       0  1
 *       1  1
 *       2  1
 *       3  1
 *       4  2
 *       5  2
 *       6  2
 *       7  2
 *       8  3
 *       9  3
 *       10 3
 *       11 3
 *       12 5
 *       13 5
 *       14 5
 *       15 5
 *       -- -
 *
 *       x.searchOrderedBy(_.toInt, 0).lp    // Prints: 0 <>> 0
 *       x.searchOrderedBy(_.toInt, 2).lp    // Prints: 4 <>> 5
 *       x.searchOrderedBy(_.toInt, 2, 5).lp // Prints: 4 <>> 8
 *       x.searchOrderedBy(_.toInt, 4).lp    // Prints: 12 <>> 12
 *       x.searchOrderedBy(_.toInt, 6).lp    // Prints: 16 <>> 16
 *    }}}
 */
