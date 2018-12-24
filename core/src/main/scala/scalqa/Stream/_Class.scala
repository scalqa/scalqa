package scalqa; package Stream

import Any.Ilk.Z.Shift.{ RefRef, PrimPrim, PrimRef, RefPrim }

abstract class _Class[@specialized(DATA) A] protected extends Interface[A] with Flow[A] with Any.Able.Void
  with _extend._Trait[A] with _consume._Trait[A] with _iterate._Trait[A] with _info._Trait[A] {

  // **********************************************************************************************
  // *                                    ITERATE                           specialized overrides *
  // **********************************************************************************************
  override def next: A = if (prime) pump else Stream.failEmpty
  override def nextOpt: Opt[A] = if (prime) pump else Opt.Void
  override def findNextOpt(f: Filter[A]): Opt[A] = { while (prime) { var v = pump; if (f.allow(v)) return v }; Opt.Void }
  override def take(cnt: Int): Stream[A] = Z.iterate.take(this, cnt)

  // **********************************************************************************************
  // *                                     EXTEND                           specialized overrides *
  // **********************************************************************************************
  // add ------------------------------------------------------------
  override def +(element: A): Stream[A] = Z.extend.add.append(this, element)
  override def +~(that: ~[A]): Stream[A] = Z.extend.add.appendAll(this, that)
  override def append(element: A): ~[A] = Z.extend.add.append(this, element)
  override def appendAll(that: ~[A]): ~[A] = Z.extend.add.appendAll(this, that)
  override def insertAt(index: Int, element: A): Stream[A] = Z.extend.add.insertAt(this, index, element)
  override def insertAllAt(index: Int, that: ~[A]): Stream[A] = Z.extend.add.insertAt.all(this, index, that)
  override def default(element: => A): Stream[A] = if (prime) this else Z.A.One(element)

  // filter ---------------------------------------------------------
  override def let(f: Filter[A]): Stream[A] = Z.extend.filter.let(this, f)
  override def letMap[@specialized(DATA) B](f: Mapping[A, Opt[B]])(implicit i: Ilk[B]): Stream[B] = ilkDefault.shift(i) match {
    case PrimPrim => Z.extend.filter.letMap.primPrim[A, B](this, f, i)
    case PrimRef  => ilkDefault.mkLetMapIlkRef(this, f)
    case RefPrim  => i.mkLetMapRefIlk(this, f)
    case _        => Z.extend.filter.letMap.refRef[A, B](this, f, i)
  }
  override def letLookup[B: Ilk](f: PartialFunction[A, B]): Stream[B] = let(f.isDefinedAt).map(f(_))
  override def letType[B](implicit t: ClassTag[B]): Stream[B] = Z.extend.filter.letType(this, t)
  override def letBy[T](as: Mapping[A, T], f: Filter[T]): Stream[A] = Z.extend.filter.letBy(this, as, f)
  override def letIdx(f: Filter.Idx[A], start: Int = 0): Stream[A] = Z.extend.filter.letIdx(this, f, start)
  override def letAt(r: Idx.Range): Stream[A] = Z.extend.filter.letAt(this, r)
  override def letNext(n: Int): Stream[A] = Z.extend.filter.letAt(this, 0 <>> n)
  override def letLast(n: Int): Stream[A] = Z.extend.filter.letLast(this, n)
  override def letWhile(f: Filter[A]): Stream[A] = Z.extend.filter.letWhile(this, f)
  override def letAll(that: ~[A])(implicit o: Ordering[A] = \/): Stream[A] = Z.extend.filter.letAll[A](this, that)
  override def letAllBy[B](f: Mapping[A, B], that: ~[B])(implicit c: Ordering[B] = \/): Stream[A] = Z.extend.filter.letAll.By[A, B](this, f, that)
  override def drop(f: Filter[A]): Stream[A] = Z.extend.filter.drop(this, f)
  override def dropVoid: Stream[A] = Z.extend.filter.dropVoid(this)
  override def dropNext(n: Int): Stream[A] = Z.extend.filter.dropNext(this, n)
  override def dropLast(n: Int): Stream[A] = Z.extend.filter.dropLast(this, n)
  override def dropAt(r: Idx.Range): Stream[A] = Z.extend.filter.dropAt(this, r)
  override def dropWhile(f: Filter[A]): Stream[A] = Z.extend.filter.dropWhile(this, f)
  override def dropAll(a: ~[A])(implicit c: Ordering[A] = \/): Stream[A] = Z.extend.filter.dropAll[A](this, a)
  override def dropAllBy[B](f: Mapping[A, B], a: ~[B])(implicit c: Ordering[B] = \/): Stream[A] = Z.extend.filter.dropAll.By[A, B](this, f, a)
  override def dropEverythingIf(b: Boolean): Stream[A] = if (b) \/ else this
  final def withFilter(f: Filter[A]): Stream[A] = let(f)

  // Flow  ----------------------------------------------------------
  override def sequential: Stream[A] = this
  override def parallel: Flow[A] = Z.extend.flow.parallel(this)
  override def parallelIf(boolean: Boolean): Flow[A] = Z.extend.flow.parallel.If(this, boolean)
  override def parallelIfOver(threshold: Int): Flow[A] = Z.extend.flow.parallel.ifOver(this, threshold)
  override def preview: Stream[A] with Preview[A] = Z.extend.flow.preview.apply(this)
  override def reverse: Stream[A] = Z.extend.flow.reverse(this)
  override def shuffle: Stream[A] = Z.extend.flow.shuffle(this)
  override def transpose[B](implicit f: Mapping[A, ~[B]]): Stream[~[B]] = Z.extend.flow.transpose[A, B](this, f)
  override def unfold(f: Mapping[~[A], A]): Stream[A] = Z.extend.flow.unfold(this, f)

  // Group  ---------------------------------------------------------
  override def group: Stream[~[A]] = Z.extend.group.group[A](this, _ == _, \/)
  override def group(test: (A, A) => Boolean, peekSplit: (A, Boolean) => Any = \/): Stream[~[A]] = Z.extend.group.group(this, test, peekSplit)
  override def groupBy(properties: Mapping[A, Any]*): Stream[~[A]] = Z.extend.group.groupBy(this, properties.all)
  override def groupBySize(size: Int): Stream[~[A]] = Z.extend.group.groupBySize(this, size)
  override def partition(groupFilters: Filter[A]*): Stream[~[A]] = Z.extend.group.partition(this, groupFilters.toArray)
  override def sliding(size: Int, step: Int = 1): Stream[~[A]] = Z.extend.group.sliding(this, size, step)

  // Map ------------------------------------------------------------
  //  override def map[B](f: A => B): Stream[B] = ???
  override def map[@specialized(DATA) B](f: Mapping[A, B])(implicit i: Ilk[B]): Stream[B] = ilkDefault.shift(i) match {
    case PrimPrim => Z.extend.map.map.primPrim[A, B](this, f, i)
    case PrimRef  => ilkDefault.mkMapIlkRef(this, f)
    case RefPrim  => i.mkMapRefIlk(this, f)
    case _        => Z.extend.map.map.refRef[A, B](this, f, i)
  }
  override def mapRef[B](f: Mapping[A, B])(implicit i: Ilk[B]): Stream[B] = Z.extend.map.map.refRef(this, f, i)
  override def mapType[B]: Stream[B] = this.asInstanceOf[Stream[B]]
  override def mapIdx[B: Ilk](f: Mapping.Idx[A, B], start: Int = 0): Stream[B] = { var j = start - 1; map[B](f({ j += 1; j }, _)) }
  override def flatMap[@specialized(DATA) B](f: Mapping[A, ~[B]])(implicit i: Ilk[B]): Stream[B] = ilkDefault.shift(i) match {
    case PrimPrim => Z.extend.map.flatMap.primPrim[A, B](this, f, i)
    case PrimRef  => ilkDefault.mkFlatMapIlkRef(this, f)
    case RefPrim  => i.mkFlatMapRefIlk(this, f)
    case _        => Z.extend.map.flatMap.refRef[A, B](this, f, i)
  }
  override def flatten[B](implicit f: Mapping[A, ~[B]], i: Ilk[B]): Stream[B] = flatMap(f)

  // Order --------------------------------------------------------
  override def sort(implicit c: Ordering[A]): Stream[A] = Z.extend.order.sort(this, c)
  override def sortBy[B](f: Mapping[A, B])(implicit c: Ordering[B]): Stream[A] = Z.extend.order.sortBy(this, c, f)
  override def sortBy[B: Ordering, C: Ordering](f1: Mapping[A, B], f2: Mapping[A, C]): Stream[A] = sortBy(new Mapping[A, (B, C)] { def apply(v: A) = (f1(v), f2(v)) })
  override def sortBy[B: Ordering, C: Ordering, D: Ordering](f1: Mapping[A, B], f2: Mapping[A, C], f3: Mapping[A, D]): Stream[A] = sortBy(new Mapping[A, (B, C, D)] { def apply(v: A) = (f1(v), f2(v), f3(v)) })
  override def sortReversed(implicit c: Ordering[A]): Stream[A] = Z.extend.order.sort(this, c.reverse)

  // Peek -----------------------------------------------------------
  override def peek(f: Consumer[A]): Stream[A] = Z.extend.peek.peek[A](this, f)
  override def peekIdx(f: Consumer.Idx[A], start: Int = 0): Stream[A] = Z.extend.peek.peekIdx[A](this, f, start)

  // trigger  -------------------------------------------------------
  override def triggerEmpty(f: => Unit): Stream[A] = Z.extend.trigger.triggerEmpty(this, f)
  override def triggerFirst(f: Time => Unit): Stream[A] = Z.extend.trigger.triggerFirst(this, f)
  override def triggerLast(f: (Int, Duration) => Unit): Stream[A] = Z.extend.trigger.triggerLast(this, f)
  override def triggerEvery(time: Duration, f: (Int, Duration) => Unit): Stream[A] = Z.extend.trigger.triggerEvery[A](this, time, f)

  // zip  -----------------------------------------------------------
  override def zip[B](that: ~[B]): Stream[(A, B)] = new Z.extend.zip.zip[A, B](this, that)
  override def zipAll[B](that: ~[B], thisDflt: Opt[A], thatDflt: Opt[B]): Stream[(A, B)] = Z.extend.zip.zipAll(this, that, thisDflt, thatDflt)
  override def zipIdx: Stream[(Int, A)] = new Z.extend.zip.zipIdx(this, 0)
  override def zipIdx(start: Int): Stream[(Int, A)] = new Z.extend.zip.zipIdx(this, start)
  override def zipMap[B](f: Mapping[A, B]): Stream[(A, B)] = new Z.extend.zip.zipMap[A, B](this, f)
  override def zipNext: Stream[(A, Opt[A])] = new Z.extend.zip.zipNext(this)
  override def zipPrior: Stream[(Opt[A], A)] = new Z.extend.zip.zipPrior(this)
  override def zipFoldAs[B](start: B)(f: Folding.As[B, A]): Stream[(A, B)] = new Z.extend.zip.zipFoldAs(this, start, f)
  override def unzip[B, C](implicit f: A => (B, C)): (Stream[B], Stream[C]) = Z.extend.zip.unzip(this, f)

  // **********************************************************************************************
  // *                                    CONSUME                           specialized overrides *
  // **********************************************************************************************
  // aggregate ---------------------------------------------------------
  override def fold(start: A)(op: Folding[A]): A = Z.consume.aggregate.fold(this, start, op)
  override def average(implicit n: Numeric[A]): A = Z.consume.aggregate.average.Opt(this) or n.zero
  override def averageFew[B: Numeric](f: Mapping[A, B]*): Idx[B] = Z.consume.aggregate.average.Few(this, f)
  override def sum(implicit n: Numeric[A]): A = Z.consume.aggregate.sum(this)
  override def sumFew[B: Numeric](f: Mapping[A, B]*): Idx[B] = Z.consume.aggregate.sum.few(this, f)
  override def range(implicit c: Ordering[A]): Range[A] = foldAs[Range[A]](\/)(_ extendTo _)
  override def min(implicit c: Ordering[A]): A = Z.consume.aggregate.min.Opt(this).value
  override def minOpt(implicit o: Ordering[A]): Opt[A] = Z.consume.aggregate.min.Opt(this)
  override def minBy[B: Ordering](f: Mapping[A, B]): A = Z.consume.aggregate.min.ByOpt(this, f).value
  override def minByOpt[B: Ordering](f: Mapping[A, B]): Opt[A] = Z.consume.aggregate.min.ByOpt(this, f)
  override def max(implicit c: Ordering[A]): A = Z.consume.aggregate.max.Opt(this).value
  override def maxOpt(implicit o: Ordering[A]): Opt[A] = Z.consume.aggregate.max.Opt(this)
  override def maxBy[B: Ordering](f: Mapping[A, B]): A = Z.consume.aggregate.max.ByOpt(this, f).value
  override def maxByOpt[B: Ordering](f: Mapping[A, B]): Opt[A] = Z.consume.aggregate.max.ByOpt(this, f)
  override def reduce(op: Folding[A]): A = Z.consume.aggregate.reduce.Opt(this, op).value
  override def reduceOpt(op: Folding[A]): Opt[A] = Z.consume.aggregate.reduce.Opt(this, op)
  override def foldFlowAs[@specialized(DATA) B: Ilk](start: B)(op: Folding.As[B, A], cf: Folding[B] = null): B = foldAs(start)(op)
  override def foldAs[@specialized(DATA) B](start: B)(op: Folding.As[B, A])(implicit i: Ilk[B]): B = ilkDefault.shift(i) match {
    case PrimRef => ilkDefault.mkFoldAsRefWithIlk(this, start, op)
    case RefPrim => i.mkFoldAsIlkWithRef(this, start, op)
    case _       => Stream.Z.consume.aggregate.fold.as(this, start, op)
  }

  // convert  -------------------------------------------------------
  override def toText: String = Z.consume.convert.toText(this, false)
  override def format(s: Opt[String] = \/, pb: Opt[String] = \/, pa: Opt[String] = \/, c: Opt[A => String] = \/): String = Z.consume.convert.format(this, s, pb, pa, c)
  override def toLookup[KEY, VAL](implicit ev: A <:< (KEY, VAL)): Lookup[KEY, VAL] = Z.consume.convert.ToLookup(this)
  override def copyTo(b: Idx.Array.Buffer.Loader[A]): Unit = Z.consume.convert.copyTo[A](this, b)
  override def toArray(implicit ct: ClassTag[A]): Array[A] = to[Idx.Array.Buffer].toArray
  override def to[TRGT[_]](implicit c: Interface.To.Converter[TRGT]): TRGT[A] = c.make(this)
  override def toRaw[TRGT](implicit c: Interface.To.Primitive.Converter[A, TRGT]): TRGT = c.make(this)
  override def toVals(implicit c: Any.Datum.Setup[A]): Vals[A] = Vals.fromFlow(this)
  override def toString: String = toString("~")
  override def toBuffer: Stream[A] = to[Idx.Array.Buffer].all

  // evaluate -------------------------------------------------------
  override def findOpt(f: Filter[A]): Opt[A] = findNextOpt(f)
  override def lookupOpt[B](f: PartialFunction[A, B]): Opt[B] = findNextOpt(f.isDefinedAt).map(f)
  override def find(f: Filter[A]): A = findNextOpt(f).value
  override def isAny(f: Filter[A]): Boolean = findNextOpt(f)
  override def isEvery(f: Filter[A]): Boolean = drop(f).findNextOpt(ANY).isVoid
  override def contains[B >: A](value: B): Boolean = findNextOpt(_ == value)
  override def findIdxOpt(f: Filter[A]): Opt.Int = Z.consume.evaluate.find.indexOpt(this, f)
  override def count: Int = Z.consume.evaluate.count(this)
  override def count(f: Filter[A]): Int = Z.consume.evaluate.count(this, f)
  override def countFew(f: Filter[A]*): Idx[Int] = Z.consume.evaluate.count.few(this, f.toArray)
  override def countAndTime: (Int, Duration) = Z.consume.evaluate.count.andTime(this)
  override def unequalOpt(that: ~[A], check: (A, A) => Boolean = _ == _): Opt[String] = Z.consume.evaluate.unequalOpt(this, that, check)
  override def lastOpt: Opt[A] = if (!prime) Opt.Void else { var v = pump; while (prime) v = pump; v }
  override def last: A = lastOpt.value

  // foreach --------------------------------------------------------
  override def apply(c: Consumer[A], forEmpty: => Any = \/): Unit = { if (prime) foreach(c) else forEmpty; () }
  override def foreachIdx(f: Consumer.Idx[A], start: Int = 0) = Z.consume.foreach.Idx(this, f)
  override def foreachSynchronized(f: Consumer[A]) = foreach(f)
  override def drain = foreach(\/)

  // -----------------------------------------------------------------------------------------------------------------------------
  protected def _pumpIndexed = A.Specialized.Indexed.pump(asInstanceOf[A.Specialized.Indexed[A]])
  protected def _consumeIndexed(f: Consumer[A]) = A.Specialized.Indexed.foreach(asInstanceOf[A.Specialized.Indexed[A]], f)
}

object _Class extends Util.Void.Setup.Typed[Stream with Any.Able.Stream](Z.A.Void)
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _Class ->
 *
 *     [[Stream]] is a one time lazy channel to some source of elements
 *
 *     [[Stream]] can be [[_extend._Trait `extended`]] with a transformation operation, which can potentially add, remove or modify elements passing from original source.
 *     From this moment we deal only with new transformed stream.
 *     Extension is lazy and does not request any elements to be delivered
 *
 *     [[Stream]] can be [[_iterate._Trait `iterated`]], delivering elements one by one. Even after iteration stream can still be extended
 *
 *     At the end of life cycle [[Stream]] can be [[_consume._Trait `consumed`]].
 *     A consume operation may use all or some elements, nevertheless the [[Stream]] MUST be discarded, because its behavior is no longer predictable
 *
 *     {{{
 *       val stream = ('a' <> 'z')  // Range of Chars
 *         .all                     // A Stream of Chars from 'a' to 'z' is created
 *         .dropNext(3)             // Extended, loosing 'a', 'b', and 'c'
 *
 *       stream.next.lp             // Iterated, prints d
 *       stream.next.lp             // Iterated, prints e
 *       stream.take(5).lp          // Iterated, prints ~(f, g, h, i, j)
 *
 *       stream
 *         .let(_ <= 'w')           // Extended with filter to only allow Chars <= 'w'
 *         .map(_.toUpper)          // Extended with conversion to upper case
 *         .foreach(print)          // Consumed, while printing each element
 *
 *       // Output
 *       KLMNOPQRSTUVW
 *     }}}
 *
 * @def withFilter -> For Comprehension hook
 *
 *    This method should not be used directly
 *
 *    It allows [[Stream]] to be used in "For Comprehensions"
 */
