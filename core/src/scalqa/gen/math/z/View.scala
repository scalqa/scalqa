package scalqa; package gen; package math; package z; import language.implicitConversions

object View:

  class MappedOrdering[A,B](c: Ordering[A], f: B => A) extends Ordering[B]:
    def compare(x: B, y: B) = c.compare(f(x),f(y))

  class JoinedOrdering[A](o1: Ordering[A], o2: Ordering[A]) extends Ordering[A]:
    def compare(x: A, y: A) = { val i = o1.compare(x, y); if (i == 0) o2.compare(x, y) else i }

  class VoidPositionFirstOrdering[A :Any.Def.Void](val real: Ordering[A]) extends Ordering[A]:
    def compare(x: A, y: A): Int = if (x.self.isVoid) { if (y.self.isVoid) 0 else 1 } else if (y.self.isVoid) -1 else real.compare(x, y)

  class VoidPositionLastOrdering[A :Any.Def.Void](val real: Ordering[A]) extends Ordering[A]:
    def compare(x: A, y: A): Int = if (x.self.isVoid) { if (y.self.isVoid) 0 else -1 } else if (y.self.isVoid) 1 else real.compare(x, y)

  class OptionOrdering[A](c: Ordering[A], nonePosition: Int) extends Ordering[Opt[A]]  /*Compiler issues if defined as Opt[A]*/ :
    assert(nonePosition != 0, "nonePosition cannot be 0");
    def compare(v: Opt[A], w: Opt[A]): Int = if (v.isEmpty) if (w.nonEmpty) nonePosition else 0 else if (w.isEmpty) nonePosition * -1 else c.compare(v.cast[A], w.cast[A])

  class ByRankOrdering[A](c: Ordering[A], rank: A => Int) extends Ordering[A]:
    def compare(x: A, y: A) =
      val xr = rank(x)
      val yr = rank(y)
      if (xr < yr) -1 else if (xr > yr) 1 else c.compare(x, y)

  class ReversedOrdering[A](c: Ordering[A]) extends Ordering[A]:
    override def compare(x:A,y:A): Int         = c.compare(y,x)
    override def reverse         : Ordering[A] = c

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
