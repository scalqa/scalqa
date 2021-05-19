package scalqa; package lang; package any; package self; package `given`; import language.implicitConversions

import `given`.{ DocTag as Y }
import `given`.z.{ ProductTag as PT }

trait DocTag[-A]:
  def tag(v: A): String
  def doc(v: A): Self.Doc

object DocTag:
  inline given givenDefault[A]: DocTag[A]          = ZZ.Tag
  inline given givenBoolean   : DocTag[Boolean]    = ZZ.BooleanTag.cast[DocTag[Boolean]]
  inline given givenByte      : DocTag[Byte]       = ZZ.ByteTag.cast[DocTag[Byte]]
  inline given givenChar      : DocTag[Char]       = ZZ.CharTag.cast[DocTag[Char]]
  inline given givenShort     : DocTag[Short]      = ZZ.ShortTag.cast[DocTag[Short]]
  inline given givenInt       : DocTag[Int]        = ZZ.IntTag.cast[DocTag[Int]]
  inline given givenLong      : DocTag[Long]       = ZZ.LongTag.cast[DocTag[Long]]
  inline given givenFloat     : DocTag[Float]      = ZZ.FloatTag.cast[DocTag[Float]]
  inline given givenDouble    : DocTag[Double]     = ZZ.DoubleTag.cast[DocTag[Double]]
  inline given givenArray[A]  : DocTag[Array[A]]   = ZZ.ArrayTag.cast[DocTag[Array[A]]]
  inline given givenMath[A]   : DocTag[Math[A]]    = ZZ.MathTag.cast[DocTag[Math[A]]]

  inline given givenProduct1 [A:Y]                                                                                     : DocTag[Product1 [A]]                                           = PT._1()
  inline given givenProduct2 [A:Y,B:Y]                                                                                 : DocTag[Product2 [A,B]]                                         = PT._2()
  inline given givenProduct3 [A:Y,B:Y,C:Y]                                                                             : DocTag[Product3 [A,B,C]]                                       = PT._3()
  inline given givenProduct4 [A:Y,B:Y,C:Y,D:Y]                                                                         : DocTag[Product4 [A,B,C,D]]                                     = PT._4()
  inline given givenProduct5 [A:Y,B:Y,C:Y,D:Y,E:Y]                                                                     : DocTag[Product5 [A,B,C,D,E]]                                   = PT._5()
  inline given givenProduct6 [A:Y,B:Y,C:Y,D:Y,E:Y,F:Y]                                                                 : DocTag[Product6 [A,B,C,D,E,F]]                                 = PT._6()
  inline given givenProduct7 [A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y]                                                             : DocTag[Product7 [A,B,C,D,E,F,G]]                               = PT._7()
  inline given givenProduct8 [A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y]                                                         : DocTag[Product8 [A,B,C,D,E,F,G,H]]                             = PT._8()
  inline given givenProduct9 [A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y]                                                     : DocTag[Product9 [A,B,C,D,E,F,G,H,I]]                           = PT._9()
  inline given givenProduct10[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y]                                                 : DocTag[Product10[A,B,C,D,E,F,G,H,I,J]]                         = PT._10()
  inline given givenProduct11[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y]                                             : DocTag[Product11[A,B,C,D,E,F,G,H,I,J,K]]                       = PT._11()
  inline given givenProduct12[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y]                                         : DocTag[Product12[A,B,C,D,E,F,G,H,I,J,K,L]]                     = PT._12()
  inline given givenProduct13[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y]                                     : DocTag[Product13[A,B,C,D,E,F,G,H,I,J,K,L,M]]                   = PT._13()
  inline given givenProduct14[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y]                                 : DocTag[Product14[A,B,C,D,E,F,G,H,I,J,K,L,M,N]]                 = PT._14()
  inline given givenProduct15[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y]                             : DocTag[Product15[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O]]               = PT._15()
  inline given givenProduct16[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y]                         : DocTag[Product16[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P]]             = PT._16()
  inline given givenProduct17[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y,Q:Y]                     : DocTag[Product17[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q]]           = PT._17()
  inline given givenProduct18[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y,Q:Y,R:Y]                 : DocTag[Product18[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R]]         = PT._18()
  inline given givenProduct19[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y,Q:Y,R:Y,S:Y]             : DocTag[Product19[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S]]       = PT._19()
  inline given givenProduct20[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y,Q:Y,R:Y,S:Y,T:Y]         : DocTag[Product20[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T]]     = PT._20()
  inline given givenProduct21[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y,Q:Y,R:Y,S:Y,T:Y,U:Y]     : DocTag[Product21[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U]]   = PT._21()
  inline given givenProduct22[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y,Q:Y,R:Y,S:Y,T:Y,U:Y,V:Y] : DocTag[Product22[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V]] = PT._22()

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
