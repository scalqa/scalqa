package scalqa; package `def`; package any; package self; package info; import language.implicitConversions

import info.{ Tag as Y }
import tag.z.{ ProductTag as PT }

trait Tag[-A]:
  def tag(v: A)  : String
  def info(v: A) : Info

object Tag:
  inline given xxDefault[A]: Tag[A]          = ZZ.Tag
  inline given xxBoolean   : Tag[Boolean]    = ZZ.BooleanTag.cast[Tag[Boolean]]
  inline given xxByte      : Tag[Byte]       = ZZ.ByteTag.cast[Tag[Byte]]
  inline given xxChar      : Tag[Char]       = ZZ.CharTag.cast[Tag[Char]]
  inline given xxShort     : Tag[Short]      = ZZ.ShortTag.cast[Tag[Short]]
  inline given xxInt       : Tag[Int]        = ZZ.IntTag.cast[Tag[Int]]
  inline given xxLong      : Tag[Long]       = ZZ.LongTag.cast[Tag[Long]]
  inline given xxFloat     : Tag[Float]      = ZZ.FloatTag.cast[Tag[Float]]
  inline given xxDouble    : Tag[Double]     = ZZ.DoubleTag.cast[Tag[Double]]
  inline given xxArray[A]  : Tag[Array[A]]   = ZZ.ArrayTag.cast[Tag[Array[A]]]
  inline given xxMath[A]   : Tag[Math[A]]    = ZZ.MathTag.cast[Tag[Math[A]]]

  inline given xxProduct1 [A:Y]                                                                                     : Tag[Product1 [A]]                                           = PT._1()
  inline given xxProduct2 [A:Y,B:Y]                                                                                 : Tag[Product2 [A,B]]                                         = PT._2()
  inline given xxProduct3 [A:Y,B:Y,C:Y]                                                                             : Tag[Product3 [A,B,C]]                                       = PT._3()
  inline given xxProduct4 [A:Y,B:Y,C:Y,D:Y]                                                                         : Tag[Product4 [A,B,C,D]]                                     = PT._4()
  inline given xxProduct5 [A:Y,B:Y,C:Y,D:Y,E:Y]                                                                     : Tag[Product5 [A,B,C,D,E]]                                   = PT._5()
  inline given xxProduct6 [A:Y,B:Y,C:Y,D:Y,E:Y,F:Y]                                                                 : Tag[Product6 [A,B,C,D,E,F]]                                 = PT._6()
  inline given xxProduct7 [A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y]                                                             : Tag[Product7 [A,B,C,D,E,F,G]]                               = PT._7()
  inline given xxProduct8 [A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y]                                                         : Tag[Product8 [A,B,C,D,E,F,G,H]]                             = PT._8()
  inline given xxProduct9 [A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y]                                                     : Tag[Product9 [A,B,C,D,E,F,G,H,I]]                           = PT._9()
  inline given xxProduct10[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y]                                                 : Tag[Product10[A,B,C,D,E,F,G,H,I,J]]                         = PT._10()
  inline given xxProduct11[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y]                                             : Tag[Product11[A,B,C,D,E,F,G,H,I,J,K]]                       = PT._11()
  inline given xxProduct12[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y]                                         : Tag[Product12[A,B,C,D,E,F,G,H,I,J,K,L]]                     = PT._12()
  inline given xxProduct13[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y]                                     : Tag[Product13[A,B,C,D,E,F,G,H,I,J,K,L,M]]                   = PT._13()
  inline given xxProduct14[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y]                                 : Tag[Product14[A,B,C,D,E,F,G,H,I,J,K,L,M,N]]                 = PT._14()
  inline given xxProduct15[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y]                             : Tag[Product15[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O]]               = PT._15()
  inline given xxProduct16[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y]                         : Tag[Product16[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P]]             = PT._16()
  inline given xxProduct17[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y,Q:Y]                     : Tag[Product17[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q]]           = PT._17()
  inline given xxProduct18[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y,Q:Y,R:Y]                 : Tag[Product18[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R]]         = PT._18()
  inline given xxProduct19[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y,Q:Y,R:Y,S:Y]             : Tag[Product19[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S]]       = PT._19()
  inline given xxProduct20[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y,Q:Y,R:Y,S:Y,T:Y]         : Tag[Product20[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T]]     = PT._20()
  inline given xxProduct21[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y,Q:Y,R:Y,S:Y,T:Y,U:Y]     : Tag[Product21[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U]]   = PT._21()
  inline given xxProduct22[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y,Q:Y,R:Y,S:Y,T:Y,U:Y,V:Y] : Tag[Product22[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V]] = PT._22()

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Type[A]   = tag.Type[A];  inline def Type  = tag.Type
  type Void[A]   = tag.Void[A];  inline def Void  = tag.Void
  type Empty[-A] = tag.Empty[A]; inline def Empty = tag.Empty
  type In[A,-C]  = tag.In[A,C];  inline def In    = tag.In

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
