package scalqa; package gen; package math; package ordering; package z; import language.implicitConversions

import java.util.Comparator

object View:

  class Fun[A,B](c: Comparator[A], f: B => A) extends Ordering[B]:
    def compare(x: B, y: B) = c.compare(f(x),f(y))

  class Joined[A](o1: Comparator[A], o2: Comparator[A]) extends Ordering[A]:
    def compare(x: A, y: A) = { val i = o1.compare(x, y); if (i == 0) o2.compare(x, y) else i }

  class VoidPositionFirst[A:Def.Void](val real: Comparator[A]) extends Ordering[A]:
    def compare(x: A, y: A): Int = if (x.^.isVoid) { if (y.^.isVoid) 0 else 1 } else if (y.^.isVoid) -1 else real.compare(x, y)

  class VoidPositionLast[A:Def.Void](val real: Comparator[A]) extends Ordering[A]:
    def compare(x: A, y: A): Int = if (x.^.isVoid) { if (y.^.isVoid) 0 else -1 } else if (y.^.isVoid) 1 else real.compare(x, y)

  class Option[A](c: Comparator[A], nonePosition: Int) extends Ordering[Opt[A]]  /*Compiler issues if defined as Opt[A]*/ :
    assert(nonePosition != 0, "nonePosition cannot be 0");
    def compare(v: Opt[A], w: Opt[A]): Int = if (v.isEmpty) if (w.nonEmpty) nonePosition else 0 else if (w.isEmpty) nonePosition * -1 else this.compare(v.cast[A], w.cast[A])

  class ByRank[A](c: Comparator[A], rank: A => Int) extends Ordering[A]:
    def compare(x: A, y: A) =
      val xr = rank(x)
      val yr = rank(y)
      if (xr < yr) -1 else if (xr > yr) 1 else c.compare(x, y)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
