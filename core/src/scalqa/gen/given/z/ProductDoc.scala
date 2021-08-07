package scalqa; package gen; package `given`; package z; import language.implicitConversions

import `given`.{ DocDef as Y }

abstract class ProductDoc[P <: Product] extends DocDef[P]:
  def value_tag(v: P) : String = "(" + value_doc(v).value_~.makeString(",") + ")"
  extension[A](x:Doc) @tn("add") def +(v:A)(using t:Y[A]): Doc = { x += ("_"+(x.size + 1), t.value_tag(v)); x }

object ProductDoc:
  class _1[A:Y]                                                                                      extends ProductDoc[Product1[A]]:
    def value_doc(v: Product1 [A])                                           = Doc(v)+v._1
  class _2[A:Y,B:Y]                                                                                  extends ProductDoc[Product2[A,B]]:
    def value_doc(v: Product2 [A,B])                                         = Doc(v)+v._1+v._2
  class _3[A:Y,B:Y,C:Y]                                                                              extends ProductDoc[Product3[A,B,C]]:
    def value_doc(v: Product3 [A,B,C])                                       = Doc(v)+v._1+v._2+v._3
  class _4[A:Y,B:Y,C:Y,D:Y]                                                                          extends ProductDoc[Product4[A,B,C,D]]:
    def value_doc(v: Product4 [A,B,C,D])                                     = Doc(v)+v._1+v._2+v._3+v._4
  class _5[A:Y,B:Y,C:Y,D:Y,E:Y]                                                                      extends ProductDoc[Product5[A,B,C,D,E]]:
    def value_doc(v: Product5 [A,B,C,D,E])                                   = Doc(v)+v._1+v._2+v._3+v._4+v._5
  class _6[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y]                                                                  extends ProductDoc[Product6[A,B,C,D,E,F]]:
    def value_doc(v: Product6 [A,B,C,D,E,F])                                 = Doc(v)+v._1+v._2+v._3+v._4+v._5+v._6
  class _7[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y]                                                              extends ProductDoc[Product7[A,B,C,D,E,F,G]]:
    def value_doc(v: Product7 [A,B,C,D,E,F,G])                               = Doc(v)+v._1+v._2+v._3+v._4+v._5+v._6+v._7
  class _8[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y]                                                          extends ProductDoc[Product8[A,B,C,D,E,F,G,H]]:
    def value_doc(v: Product8 [A,B,C,D,E,F,G,H])                             = Doc(v)+v._1+v._2+v._3+v._4+v._5+v._6+v._7+v._8
  class _9[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y]                                                      extends ProductDoc[Product9[A,B,C,D,E,F,G,H,I]]:
    def value_doc(v: Product9 [A,B,C,D,E,F,G,H,I])                           = Doc(v)+v._1+v._2+v._3+v._4+v._5+v._6+v._7+v._8+v._9
  class _10[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y]                                                 extends ProductDoc[Product10[A,B,C,D,E,F,G,H,I,J]]:
    def value_doc(v: Product10[A,B,C,D,E,F,G,H,I,J])                         = Doc(v)+v._1+v._2+v._3+v._4+v._5+v._6+v._7+v._8+v._9+v._10
  class _11[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y]                                             extends ProductDoc[Product11[A,B,C,D,E,F,G,H,I,J,K]]:
    def value_doc(v: Product11[A,B,C,D,E,F,G,H,I,J,K])                       = Doc(v)+v._1+v._2+v._3+v._4+v._5+v._6+v._7+v._8+v._9+v._10+v._11
  class _12[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y]                                         extends ProductDoc[Product12[A,B,C,D,E,F,G,H,I,J,K,L]]:
    def value_doc(v: Product12[A,B,C,D,E,F,G,H,I,J,K,L])                     = Doc(v)+v._1+v._2+v._3+v._4+v._5+v._6+v._7+v._8+v._9+v._10+v._11+v._12
  class _13[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y]                                     extends ProductDoc[Product13[A,B,C,D,E,F,G,H,I,J,K,L,M]]:
    def value_doc(v: Product13[A,B,C,D,E,F,G,H,I,J,K,L,M])                   = Doc(v)+v._1+v._2+v._3+v._4+v._5+v._6+v._7+v._8+v._9+v._10+v._11+v._12+v._13
  class _14[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y]                                  extends ProductDoc[Product14[A,B,C,D,E,F,G,H,I,J,K,L,M,N]]:
    def value_doc(v: Product14[A,B,C,D,E,F,G,H,I,J,K,L,M,N])                 = Doc(v)+v._1+v._2+v._3+v._4+v._5+v._6+v._7+v._8+v._9+v._10+v._11+v._12+v._13+v._14
  class _15[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y]                              extends ProductDoc[Product15[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O]]:
    def value_doc(v: Product15[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O])               = Doc(v)+v._1+v._2+v._3+v._4+v._5+v._6+v._7+v._8+v._9+v._10+v._11+v._12+v._13+v._14+v._15
  class _16[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y]                          extends ProductDoc[Product16[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P]]:
    def value_doc(v: Product16[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P])             = Doc(v)+v._1+v._2+v._3+v._4+v._5+v._6+v._7+v._8+v._9+v._10+v._11+v._12+v._13+v._14+v._15+v._16
  class _17[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y,Q:Y]                      extends ProductDoc[Product17[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q]]:
    def value_doc(v: Product17[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q])           = Doc(v)+v._1+v._2+v._3+v._4+v._5+v._6+v._7+v._8+v._9+v._10+v._11+v._12+v._13+v._14+v._15+v._16+v._17
  class _18[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y,Q:Y,R:Y]                  extends ProductDoc[Product18[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R]]:
    def value_doc(v: Product18[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R])         = Doc(v)+v._1+v._2+v._3+v._4+v._5+v._6+v._7+v._8+v._9+v._10+v._11+v._12+v._13+v._14+v._15+v._16+v._17+v._18
  class _19[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y,Q:Y,R:Y,S:Y]              extends ProductDoc[Product19[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S]]:
    def value_doc(v: Product19[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S])       = Doc(v)+v._1+v._2+v._3+v._4+v._5+v._6+v._7+v._8+v._9+v._10+v._11+v._12+v._13+v._14+v._15+v._16+v._17+v._18+v._19
  class _20[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y,Q:Y,R:Y,S:Y,T:Y]          extends ProductDoc[Product20[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T]]:
    def value_doc(v: Product20[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T])     = Doc(v)+v._1+v._2+v._3+v._4+v._5+v._6+v._7+v._8+v._9+v._10+v._11+v._12+v._13+v._14+v._15+v._16+v._17+v._18+v._19+v._20
  class _21[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y,Q:Y,R:Y,S:Y,T:Y,U:Y]      extends ProductDoc[Product21[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U]]:
    def value_doc(v: Product21[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U])   = Doc(v)+v._1+v._2+v._3+v._4+v._5+v._6+v._7+v._8+v._9+v._10+v._11+v._12+v._13+v._14+v._15+v._16+v._17+v._18+v._19+v._20+v._21
  class _22[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y,Q:Y,R:Y,S:Y,T:Y,U:Y,V:Y]  extends ProductDoc[Product22[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V]]:
    def value_doc(v: Product22[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V]) = Doc(v)+v._1+v._2+v._3+v._4+v._5+v._6+v._7+v._8+v._9+v._10+v._11+v._12+v._13+v._14+v._15+v._16+v._17+v._18+v._19+v._20+v._21+v._22


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
