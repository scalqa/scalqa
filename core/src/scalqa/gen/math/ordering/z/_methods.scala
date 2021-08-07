package scalqa; package gen; package math; package ordering; package z; import language.implicitConversions

import scala.math.Ordering

transparent trait _methods:

  extension[A](inline x: Ordering[A])
    @tn("_join")          inline def + (inline c: Ordering[A])              : Ordering[A]      = Z.join(x,c)
    /**/                  inline def join(inline c: Ordering[A])            : Ordering[A]      = Z.join(x,c)
    @tn("rank_View")      inline def rank_^(fun: A => Int)                  : Ordering[A]      = Z.rank_View(x,fun)
    @tn("opt_View")       inline def opt_^(voidPosition: Int)               : Ordering[Opt[A]] = Z.opt_View(x,voidPosition)
    @tn("voidFirst_View") inline def voidFirst_^   (using Given.VoidDef[A]) : Ordering[A]      = Z.voidFirst_View(x)
    @tn("voidLast_View")  inline def voidLast_^    (using Given.VoidDef[A]) : Ordering[A]      = Z.voidLast_View(x)
    @tn("compare_Opt")    inline def compare_?(v:Opt[A], w:Opt[A], none:Int): Int              = Z.compare_Opt(x,v,w,none)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
