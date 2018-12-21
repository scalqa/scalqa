package scalqa; package Idx

trait _library[A] extends Any with Any.Wrap[Idx[A]] {

  def getOpt(position: Int): Opt[A] = if (position < 0 || position >= real.size) \/ else real(position)

  def first: A = firstOpt.value

  def last: A = lastOpt.value

  def firstOpt: Opt[A] = getOpt(0)

  def lastOpt: Opt[A] = getOpt(real.size - 1)

  def asMappedView[B](f: A => B): Idx[B] = new Z.A.MappedView(real, f)

  def asObservableView: O[A] = real.I.as[O[A]](new Z.A.Unsupported.O[A](_))

  def asMutableView: M[A] = real.I.as[M[A]](new Z.A.Unsupported.M[A](_))

  def asObservableMutableView: OM[A] = real match { case l: OM[A] => l; case l: M[A] => new M.Z.A.UnsupportedWO[A](l); case l: O[A] => new O.Z.A.UnsupportedWO[A](l); case l => new Z.A.Unsupported.OM[A](l) }

  def asTailView(fromPosition: Int): Idx[A] = if (fromPosition <= 0) real else new Z.A.Tail(real, fromPosition)

  def asRangeView(r: Idx.Range): Idx[A] = new Z.A.RangeView(real, r)

  def asJavaListView: java.util.List[A] = real match {
    case l: M[A] => new M.Z.A.JavaList(l)
    case l       => new Z.A.JavaList(l)
  }

  def asSeqView: IndexedSeq[A] = new Z.A.IndexedSeq(real)

  def asReversedView: Idx[A] = new Z.A.ReversedView(real)

  def asSynchronizedView(lock: Opt[AnyRef] = \/): Idx[A] = new Z.A.Synchronized(real, lock)

  @noinline def searchOrdered(element: A, maxFound: Int = 1)(implicit s: Ordering[A]): Idx.Range = Z.searchOrdered(real, element, maxFound)(s)

  @noinline def searchOrderedBy[B](map: A => B, value: B, maxFound: Int = 1, extraFilter: Opt[A => Boolean] = \/)(implicit s: Ordering[B]): Idx.Range = Z.searchOrdered.By(real, value, map, maxFound, extraFilter)(s)

  def toTuple2: (A, A) = (real(0), real(1))

  def toTuple3: (A, A, A) = (real(0), real(1), real(2))

  def toTuple4: (A, A, A, A) = (real(0), real(1), real(2), real(3))

}
object _library {

  class _Class[A] private[Idx] (protected val real: Idx[A]) extends AnyVal with _library[A]

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def toTuple2 -> As Tuple2
 *
 *    Returns first two elements as tuple
 *
 * @def toTuple3 -> As Tuple3
 *
 *    Returns first three elements as tuple
 *
 * @def toTuple4 -> As Tuple4
 *
 *    Returns first four elements as tuple
 *
 * @def getOpt -> Element at position
 *
 *    Returns element at given `position` or Opt.Void if `position` is out of [[Idx]] range
 *
 * @def first: -> First element
 *
 *    Returns first element or [[App.Fail]] for empty collection
 *
 * @def last: -> Last element
 *
 *    Returns last element or [[App.Fail]] for empty collection
 *
 * @def firstOpt -> First element
 *
 *    Returns first element or Opt.Void for empty collection
 *
 * @def lastOpt -> Last element
 *
 *    Returns last element or Opt.Void for empty collection
 *
 * @def asObservableMutableView -> Mutable observable view
 *
 *    If `this` implements [[OM]], `this` is returned
 *
 *    Otherwise, returns view of `this` as [[OM]], where any change will App.Fail.unsupported and no events will be generated
 *
 * @def asMutableView: -> Mutable view
 *
 *    If `this` implements writable, `this` is returned
 *
 *    Otherwise, returns view of `this` as writable, where any change will App.Fail.unsupported
 *
 * @def asObservableView -> Observable view
 *
 *    If `this` implements Observable, `this` is returned
 *
 *    Otherwise, returns view of `this` as Observable, without generating events
 *
 * @def asTailView -> Tail view
 *
 *     Creates view of `this` as last elements starting `fromPosition`
 *
 * @def asJavaListView -> Java List view
 *
 *     Creates view of `this` as Java List
 *
 * @def asRangeView -> Range projected view
 *
 *     Creates view of `this` projected on provided range
 *
 *
 * * @def asSynchronizedView -> Synchronized view
 *
 *     Creates view of `this' with all access synchronized
 *
 *     @param lock optional synchronization target. If empty the Idx itself is used
 *
 * @def searchOrdered( -> Binary search
 *
 *    Efficient search for the `element`, without scanning the entire index
 *
 *    The elements have to be already sorted with the `ordering` provided, otherwise results are random
 *
 *    Returns [[Idx.Range]], where range.start indicates position of the element. If range.size==0, then no element found, just its logical position.
 *
 *    {{{
 *       val x: Idx[Int] = (1 ~+ 2 + 3 + 5).flatMap(_.I repeat 4).to[Idx]
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
 *    @param maxFound maximum found returned range size. The returned range indicates how many elements found up to the max
 *
 * @def searchOrderedBy -> Binary search by property
 *
 *    Efficient search for the `element`, based on its property value, without scanning the entire index
 *
 *    The elements have to be already sorted by the property with the `ordering` provided, otherwise results are random
 *
 *    Returns [[Idx.Range]], where range.start indicates position of the element. If range.size==0, then no element found, just its logical position.
 *
 *    {{{
 *       val x: Idx[String] = ("1" ~+ "2" + "3" + "5").repeat(4).to[Idx]
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
 *    @param map property function
 *    @param maxFound maximum found returned range size. The returned range indicates how many elements found up to the max
 *
 */
