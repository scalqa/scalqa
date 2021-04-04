package scalqa; package `def`; package any; package self; package info; package tag; package z; import language.implicitConversions

import info.{ Tag as Y }

abstract class ProductTag[P <: Product] extends Tag[P]:
  def tag(v: P) : String = "(" + info(v).value_~.makeString(",") + ")"
  extension[A](x:Info) @tn("add") def +(v:A)(using t:Y[A]): Info = { x += ("_"+(x.size + 1), t.tag(v)); x }

object ProductTag:
  class _1[A:Y]                                                                                      extends ProductTag[Product1[A]]:
    def info(v: Product1 [A])                                           = Info(v)+v._1
  class _2[A:Y,B:Y]                                                                                  extends ProductTag[Product2[A,B]]:
    def info(v: Product2 [A,B])                                         = Info(v)+v._1+v._2
  class _3[A:Y,B:Y,C:Y]                                                                              extends ProductTag[Product3[A,B,C]]:
    def info(v: Product3 [A,B,C])                                       = Info(v)+v._1+v._2+v._3
  class _4[A:Y,B:Y,C:Y,D:Y]                                                                          extends ProductTag[Product4[A,B,C,D]]:
    def info(v: Product4 [A,B,C,D])                                     = Info(v)+v._1+v._2+v._3+v._4
  class _5[A:Y,B:Y,C:Y,D:Y,E:Y]                                                                      extends ProductTag[Product5[A,B,C,D,E]]:
    def info(v: Product5 [A,B,C,D,E])                                   = Info(v)+v._1+v._2+v._3+v._4+v._5
  class _6[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y]                                                                  extends ProductTag[Product6[A,B,C,D,E,F]]:
    def info(v: Product6 [A,B,C,D,E,F])                                 = Info(v)+v._1+v._2+v._3+v._4+v._5+v._6
  class _7[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y]                                                              extends ProductTag[Product7[A,B,C,D,E,F,G]]:
    def info(v: Product7 [A,B,C,D,E,F,G])                               = Info(v)+v._1+v._2+v._3+v._4+v._5+v._6+v._7
  class _8[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y]                                                          extends ProductTag[Product8[A,B,C,D,E,F,G,H]]:
    def info(v: Product8 [A,B,C,D,E,F,G,H])                             = Info(v)+v._1+v._2+v._3+v._4+v._5+v._6+v._7+v._8
  class _9[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y]                                                      extends ProductTag[Product9[A,B,C,D,E,F,G,H,I]]:
    def info(v: Product9 [A,B,C,D,E,F,G,H,I])                           = Info(v)+v._1+v._2+v._3+v._4+v._5+v._6+v._7+v._8+v._9
  class _10[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y]                                                 extends ProductTag[Product10[A,B,C,D,E,F,G,H,I,J]]:
    def info(v: Product10[A,B,C,D,E,F,G,H,I,J])                         = Info(v)+v._1+v._2+v._3+v._4+v._5+v._6+v._7+v._8+v._9+v._10
  class _11[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y]                                             extends ProductTag[Product11[A,B,C,D,E,F,G,H,I,J,K]]:
    def info(v: Product11[A,B,C,D,E,F,G,H,I,J,K])                       = Info(v)+v._1+v._2+v._3+v._4+v._5+v._6+v._7+v._8+v._9+v._10+v._11
  class _12[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y]                                         extends ProductTag[Product12[A,B,C,D,E,F,G,H,I,J,K,L]]:
    def info(v: Product12[A,B,C,D,E,F,G,H,I,J,K,L])                     = Info(v)+v._1+v._2+v._3+v._4+v._5+v._6+v._7+v._8+v._9+v._10+v._11+v._12
  class _13[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y]                                     extends ProductTag[Product13[A,B,C,D,E,F,G,H,I,J,K,L,M]]:
    def info(v: Product13[A,B,C,D,E,F,G,H,I,J,K,L,M])                   = Info(v)+v._1+v._2+v._3+v._4+v._5+v._6+v._7+v._8+v._9+v._10+v._11+v._12+v._13
  class _14[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y]                                  extends ProductTag[Product14[A,B,C,D,E,F,G,H,I,J,K,L,M,N]]:
    def info(v: Product14[A,B,C,D,E,F,G,H,I,J,K,L,M,N])                 = Info(v)+v._1+v._2+v._3+v._4+v._5+v._6+v._7+v._8+v._9+v._10+v._11+v._12+v._13+v._14
  class _15[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y]                              extends ProductTag[Product15[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O]]:
    def info(v: Product15[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O])               = Info(v)+v._1+v._2+v._3+v._4+v._5+v._6+v._7+v._8+v._9+v._10+v._11+v._12+v._13+v._14+v._15
  class _16[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y]                          extends ProductTag[Product16[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P]]:
    def info(v: Product16[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P])             = Info(v)+v._1+v._2+v._3+v._4+v._5+v._6+v._7+v._8+v._9+v._10+v._11+v._12+v._13+v._14+v._15+v._16
  class _17[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y,Q:Y]                      extends ProductTag[Product17[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q]]:
    def info(v: Product17[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q])           = Info(v)+v._1+v._2+v._3+v._4+v._5+v._6+v._7+v._8+v._9+v._10+v._11+v._12+v._13+v._14+v._15+v._16+v._17
  class _18[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y,Q:Y,R:Y]                  extends ProductTag[Product18[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R]]:
    def info(v: Product18[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R])         = Info(v)+v._1+v._2+v._3+v._4+v._5+v._6+v._7+v._8+v._9+v._10+v._11+v._12+v._13+v._14+v._15+v._16+v._17+v._18
  class _19[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y,Q:Y,R:Y,S:Y]              extends ProductTag[Product19[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S]]:
    def info(v: Product19[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S])       = Info(v)+v._1+v._2+v._3+v._4+v._5+v._6+v._7+v._8+v._9+v._10+v._11+v._12+v._13+v._14+v._15+v._16+v._17+v._18+v._19
  class _20[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y,Q:Y,R:Y,S:Y,T:Y]          extends ProductTag[Product20[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T]]:
    def info(v: Product20[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T])     = Info(v)+v._1+v._2+v._3+v._4+v._5+v._6+v._7+v._8+v._9+v._10+v._11+v._12+v._13+v._14+v._15+v._16+v._17+v._18+v._19+v._20
  class _21[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y,Q:Y,R:Y,S:Y,T:Y,U:Y]      extends ProductTag[Product21[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U]]:
    def info(v: Product21[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U])   = Info(v)+v._1+v._2+v._3+v._4+v._5+v._6+v._7+v._8+v._9+v._10+v._11+v._12+v._13+v._14+v._15+v._16+v._17+v._18+v._19+v._20+v._21
  class _22[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y,Q:Y,R:Y,S:Y,T:Y,U:Y,V:Y]  extends ProductTag[Product22[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V]]:
    def info(v: Product22[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V]) = Info(v)+v._1+v._2+v._3+v._4+v._5+v._6+v._7+v._8+v._9+v._10+v._11+v._12+v._13+v._14+v._15+v._16+v._17+v._18+v._19+v._20+v._21+v._22


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
