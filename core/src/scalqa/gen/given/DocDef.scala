package scalqa; package gen; package `given`; import language.implicitConversions

import `given`.{ DocDef as Y }
import `given`.z.{ ProductDoc as PD }

trait DocDef[-A]:
  def value_tag(v: A): String
  def value_doc(v: A): Doc

object DocDef:
  inline given givenBoolean   : DocDef[Boolean]    = ZZ.BooleanDef.cast[DocDef[Boolean]]
  inline given givenByte      : DocDef[Byte]       = ZZ.ByteDef.cast[DocDef[Byte]]
  inline given givenChar      : DocDef[Char]       = ZZ.CharDef.cast[DocDef[Char]]
  inline given givenShort     : DocDef[Short]      = ZZ.ShortDef.cast[DocDef[Short]]
  inline given givenInt       : DocDef[Int]        = ZZ.IntDef.cast[DocDef[Int]]
  inline given givenLong      : DocDef[Long]       = ZZ.LongDef.cast[DocDef[Long]]
  inline given givenFloat     : DocDef[Float]      = ZZ.FloatDef.cast[DocDef[Float]]
  inline given givenDouble    : DocDef[Double]     = ZZ.DoubleDef.cast[DocDef[Double]]
  inline given givenArray[A]  : DocDef[Array[A]]   = ZZ.ArrayDoc.cast[DocDef[Array[A]]]
  inline given givenMath[A]   : DocDef[Math[A]]    = ZZ.MathDoc.cast[DocDef[Math[A]]]
  inline given givenDefault[A]: DocDef[A]          = ZZ.Def.cast[DocDef[A]]

  inline given givenProduct1 [A:Y]                                                                                     : DocDef[Product1 [A]]                                           = PD._1()
  inline given givenProduct2 [A:Y,B:Y]                                                                                 : DocDef[Product2 [A,B]]                                         = PD._2()
  inline given givenProduct3 [A:Y,B:Y,C:Y]                                                                             : DocDef[Product3 [A,B,C]]                                       = PD._3()
  inline given givenProduct4 [A:Y,B:Y,C:Y,D:Y]                                                                         : DocDef[Product4 [A,B,C,D]]                                     = PD._4()
  inline given givenProduct5 [A:Y,B:Y,C:Y,D:Y,E:Y]                                                                     : DocDef[Product5 [A,B,C,D,E]]                                   = PD._5()
  inline given givenProduct6 [A:Y,B:Y,C:Y,D:Y,E:Y,F:Y]                                                                 : DocDef[Product6 [A,B,C,D,E,F]]                                 = PD._6()
  inline given givenProduct7 [A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y]                                                             : DocDef[Product7 [A,B,C,D,E,F,G]]                               = PD._7()
  inline given givenProduct8 [A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y]                                                         : DocDef[Product8 [A,B,C,D,E,F,G,H]]                             = PD._8()
  inline given givenProduct9 [A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y]                                                     : DocDef[Product9 [A,B,C,D,E,F,G,H,I]]                           = PD._9()
  inline given givenProduct10[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y]                                                 : DocDef[Product10[A,B,C,D,E,F,G,H,I,J]]                         = PD._10()
  inline given givenProduct11[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y]                                             : DocDef[Product11[A,B,C,D,E,F,G,H,I,J,K]]                       = PD._11()
  inline given givenProduct12[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y]                                         : DocDef[Product12[A,B,C,D,E,F,G,H,I,J,K,L]]                     = PD._12()
  inline given givenProduct13[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y]                                     : DocDef[Product13[A,B,C,D,E,F,G,H,I,J,K,L,M]]                   = PD._13()
  inline given givenProduct14[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y]                                 : DocDef[Product14[A,B,C,D,E,F,G,H,I,J,K,L,M,N]]                 = PD._14()
  inline given givenProduct15[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y]                             : DocDef[Product15[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O]]               = PD._15()
  inline given givenProduct16[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y]                         : DocDef[Product16[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P]]             = PD._16()
  inline given givenProduct17[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y,Q:Y]                     : DocDef[Product17[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q]]           = PD._17()
  inline given givenProduct18[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y,Q:Y,R:Y]                 : DocDef[Product18[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R]]         = PD._18()
  inline given givenProduct19[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y,Q:Y,R:Y,S:Y]             : DocDef[Product19[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S]]       = PD._19()
  inline given givenProduct20[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y,Q:Y,R:Y,S:Y,T:Y]         : DocDef[Product20[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T]]     = PD._20()
  inline given givenProduct21[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y,Q:Y,R:Y,S:Y,T:Y,U:Y]     : DocDef[Product21[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U]]   = PD._21()
  inline given givenProduct22[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y,Q:Y,R:Y,S:Y,T:Y,U:Y,V:Y] : DocDef[Product22[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V]] = PD._22()

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@def value_tag -> Instance tag

      Returns String tag describing provided value

@def value_doc -> Instance Doc

      Returns Doc describing provided value

*/