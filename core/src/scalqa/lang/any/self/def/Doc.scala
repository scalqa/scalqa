package scalqa; package lang; package any; package self; package `def`; import language.implicitConversions

import `def`.{ Doc as Y }
import `def`.z.{ ProductDoc as PT }

trait Doc[-A]:
  def tag(v: A): String
  def doc(v: A): Self.Doc

object Doc:
  inline given xxDefault[A]: Doc[A]          = ZZ.Doc
  inline given xxBoolean   : Doc[Boolean]    = ZZ.BooleanDef.cast[Doc[Boolean]]
  inline given xxByte      : Doc[Byte]       = ZZ.ByteDef.cast[Doc[Byte]]
  inline given xxChar      : Doc[Char]       = ZZ.CharDef.cast[Doc[Char]]
  inline given xxShort     : Doc[Short]      = ZZ.ShortDef.cast[Doc[Short]]
  inline given xxInt       : Doc[Int]        = ZZ.IntDef.cast[Doc[Int]]
  inline given xxLong      : Doc[Long]       = ZZ.LongDef.cast[Doc[Long]]
  inline given xxFloat     : Doc[Float]      = ZZ.FloatDef.cast[Doc[Float]]
  inline given xxDouble    : Doc[Double]     = ZZ.DoubleDef.cast[Doc[Double]]
  inline given xxArray[A]  : Doc[Array[A]]   = ZZ.ArrayDoc.cast[Doc[Array[A]]]
  inline given xxMath[A]   : Doc[Math[A]]    = ZZ.MathDoc.cast[Doc[Math[A]]]

  inline given xxProduct1 [A:Y]                                                                                     : Doc[Product1 [A]]                                           = PT._1()
  inline given xxProduct2 [A:Y,B:Y]                                                                                 : Doc[Product2 [A,B]]                                         = PT._2()
  inline given xxProduct3 [A:Y,B:Y,C:Y]                                                                             : Doc[Product3 [A,B,C]]                                       = PT._3()
  inline given xxProduct4 [A:Y,B:Y,C:Y,D:Y]                                                                         : Doc[Product4 [A,B,C,D]]                                     = PT._4()
  inline given xxProduct5 [A:Y,B:Y,C:Y,D:Y,E:Y]                                                                     : Doc[Product5 [A,B,C,D,E]]                                   = PT._5()
  inline given xxProduct6 [A:Y,B:Y,C:Y,D:Y,E:Y,F:Y]                                                                 : Doc[Product6 [A,B,C,D,E,F]]                                 = PT._6()
  inline given xxProduct7 [A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y]                                                             : Doc[Product7 [A,B,C,D,E,F,G]]                               = PT._7()
  inline given xxProduct8 [A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y]                                                         : Doc[Product8 [A,B,C,D,E,F,G,H]]                             = PT._8()
  inline given xxProduct9 [A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y]                                                     : Doc[Product9 [A,B,C,D,E,F,G,H,I]]                           = PT._9()
  inline given xxProduct10[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y]                                                 : Doc[Product10[A,B,C,D,E,F,G,H,I,J]]                         = PT._10()
  inline given xxProduct11[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y]                                             : Doc[Product11[A,B,C,D,E,F,G,H,I,J,K]]                       = PT._11()
  inline given xxProduct12[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y]                                         : Doc[Product12[A,B,C,D,E,F,G,H,I,J,K,L]]                     = PT._12()
  inline given xxProduct13[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y]                                     : Doc[Product13[A,B,C,D,E,F,G,H,I,J,K,L,M]]                   = PT._13()
  inline given xxProduct14[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y]                                 : Doc[Product14[A,B,C,D,E,F,G,H,I,J,K,L,M,N]]                 = PT._14()
  inline given xxProduct15[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y]                             : Doc[Product15[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O]]               = PT._15()
  inline given xxProduct16[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y]                         : Doc[Product16[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P]]             = PT._16()
  inline given xxProduct17[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y,Q:Y]                     : Doc[Product17[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q]]           = PT._17()
  inline given xxProduct18[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y,Q:Y,R:Y]                 : Doc[Product18[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R]]         = PT._18()
  inline given xxProduct19[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y,Q:Y,R:Y,S:Y]             : Doc[Product19[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S]]       = PT._19()
  inline given xxProduct20[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y,Q:Y,R:Y,S:Y,T:Y]         : Doc[Product20[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T]]     = PT._20()
  inline given xxProduct21[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y,Q:Y,R:Y,S:Y,T:Y,U:Y]     : Doc[Product21[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U]]   = PT._21()
  inline given xxProduct22[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y,Q:Y,R:Y,S:Y,T:Y,U:Y,V:Y] : Doc[Product22[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V]] = PT._22()

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
