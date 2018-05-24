package scalqa; package Sorting

class _library[A] private[Sorting] (protected val This: Sorting[A]) extends AnyVal {

  def voidPosition = _Trait.voidPosition(This)

  def position(x: A, y: A) = _Trait.position(This, x, y)

  def asReversed: Sorting[A] = new Z.The.Reversed[A](This)

  def asPrioritized(priority: A => Int): Sorting[A] = new Z.The.Prioritized[A](This, priority)

  def asMap[B](f: B => A): Sorting[B] = if (This.isVoid) \/ else new Z.The.Mapped[A, B](This, f)

  def asOrdering: Ordering[A] = new Z.As.Ordering(This)

  def asComparator: java.util.Comparator[A] = new Z.As.JavaComparator(This)

  def asForOpt(optPosition: Sorting.Position): Sorting[Opt[A]] = { Assert(!optPosition.isEither, "optPosition cannot be 'Same'"); new Z.The.ValueOpt[A, Opt[A]](This, optPosition) }

  def asForTuple[B](o: Sorting[B]): Sorting[(A, B)] = new Z.The.Tuple2[A, B](This, o)

  def asForTuple[B, C](ob: Sorting[B], oc: Sorting[C]): Sorting[(A, B, C)] = new Z.The.Tuple3[A, B, C](This, ob, oc)

  def mapVoids(v: Position): Sorting[A] = This ? (_ => voidPosition != v, new The.Proxy(_) { override def voidPosition = v })

  def max[B <: A](x: B, y: B): B = if (This(x, y).isAsIs) y else x

  def min[B <: A](x: B, y: B): B = if (This(x, y).isAsIs) x else y

  def applyOpt(xo: Opt[A], yo: Opt[A]): Position = if (!xo) { if (!yo) Position.Either else Position.Inverse } else if (!yo) Position.AsIs else This(xo.value, yo.value)

  def join(o: Sorting[_ >: A]): Sorting[A] = if (This.isVoid) o else if (o.isVoid) This else new Sorting[A] { def position(x: A, y: A) = This(x, y) ifEither o(x, y); override val voidPosition = _library.this.voidPosition }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
