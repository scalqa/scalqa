package scalqa; package gen; package math; package ordering; package z; import language.implicitConversions

import scala.math.Ordering

transparent trait _extension:

  extension[A](x: Ordering[A])
    /**/                  def join(c: Ordering[A])                   : Ordering[A]      = if (x.^.isVoid) c.cast[Ordering[A]] else if (c.^.isVoid) x else z.View.Joined[A](x, c)
    @tn("_join")          def +   (c: Ordering[A])                   : Ordering[A]      = x.join(c)
    @tn("rank_View")      def rank_^(fun: A => Int)                  : Ordering[A]      = z.View.ByRank[A](x, fun)
    @tn("opt_View")       def opt_^(voidPosition: Int)               : Ordering[Opt[A]] = z.View.Option[A](x, voidPosition)
    @tn("voidFirst_View") def voidFirst_^        (using Def.Void[A]) : Ordering[A]      = z.View.VoidPositionFirst[A](x)
    @tn("voidLast_View")  def voidLast_^         (using Def.Void[A]) : Ordering[A]      = z.View.VoidPositionLast[A](x)
    @tn("compare_Opt")    def compare_?(v:Opt[A], w:Opt[A], none:Int): Int              = if (v.isEmpty) if (w.nonEmpty) none else 0 else if (w.isEmpty) none * -1 else x.compare(v.cast[A], w.cast[A])

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
