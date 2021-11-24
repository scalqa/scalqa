package scalqa; package gen; package math; package z; import language.implicitConversions

object Ordering:

  object OrderingComparable extends Ordering[Comparable[Any]]:
    override def compare(x: Comparable[Any], y: Comparable[Any]) = x.compareTo(y)

  object Boolean          extends Ordering[Boolean]:
    def compare(x: Boolean, y: Boolean) = if (!x && y) -1 else if (x && !y) 1 else 0

  // ******************************************************************************************************************************
  transparent trait _methods:

    extension[A](inline x: Ordering[A])
      @tn("join") inline def + (inline c: Ordering[A])              : Ordering[A]      = Ordering.join(x,c)
      /**/        inline def join(inline c: Ordering[A])            : Ordering[A]      = Ordering.join(x,c)
      /**/        inline def rankView(fun: A => Int)                : Ordering[A]      = Ordering.rank_View(x,fun)
      /**/        inline def optView(voidPosition: Int)             : Ordering[Opt[A]] = Ordering.opt_View(x,voidPosition)
      /**/        inline def voidFirstView  (using Any.Def.Void[A]) : Ordering[A]      = Ordering.voidFirst_View(x)
      /**/        inline def voidLastView   (using Any.Def.Void[A]) : Ordering[A]      = Ordering.voidLast_View(x)
      /**/        inline def compareOpt(v:Opt[A],w:Opt[A], none:Int): Int              = Ordering.compareOpt(x,v,w,none)
      /**/        inline def reverse                                : Ordering[A]      = View.ReversedOrdering[A](x)
      /**/        inline def map[U](f: U => A)                      : Ordering[U]      = View.MappedOrdering[A,U](x,f)

  // ------------------------------------------------------------------------------------------------------------------
  def join[A](x: Ordering[A], c: Ordering[A])                    : Ordering[A]      = if (x.self.isVoid) c else if (c.self.isVoid) x else View.JoinedOrdering[A](x, c)
  def rank_View[A](x: Ordering[A],fun: A => Int)                 : Ordering[A]      = View.ByRankOrdering[A](x, fun)
  def opt_View[A](x: Ordering[A],voidPosition: Int)              : Ordering[Opt[A]] = View.OptionOrdering[A](x, voidPosition)
  def voidFirst_View[A](x: Ordering[A])   (using Any.Def.Void[A]): Ordering[A]      = View.VoidPositionFirstOrdering[A](x)
  def voidLast_View [A](x: Ordering[A])   (using Any.Def.Void[A]): Ordering[A]      = View.VoidPositionLastOrdering[A](x)
  def compareOpt[A](x: Ordering[A],v:Opt[A], w:Opt[A], none:Int): Int              = if (v.isEmpty) if (w.nonEmpty) none else 0 else if (w.isEmpty) none * -1 else x.compare(v.cast[A], w.cast[A])

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
