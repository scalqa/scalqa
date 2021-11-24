package scalqa; package lang; package any; package `def`; import language.implicitConversions

import `def`.{ Tag as Y }
import z.{ ProductDoc as PD }

trait Tag[-A]:
  def value_tag(v: A): String

object Tag:
  inline given givenBoolean   : Doc[Boolean]    = ZZ.Boolean.cast[Doc[Boolean]]
  inline given givenByte      : Doc[Byte]       = ZZ.Byte.cast[Doc[Byte]]
  inline given givenChar      : Doc[Char]       = ZZ.Char.cast[Doc[Char]]
  inline given givenShort     : Doc[Short]      = ZZ.Short.cast[Doc[Short]]
  inline given givenInt       : Doc[Int]        = ZZ.Int.cast[Doc[Int]]
  inline given givenLong      : Doc[Long]       = ZZ.Long.cast[Doc[Long]]
  inline given givenFloat     : Doc[Float]      = ZZ.Float.cast[Doc[Float]]
  inline given givenDouble    : Doc[Double]     = ZZ.Double.cast[Doc[Double]]
  inline given givenArray[A]  : Doc[Array[A]]   = ZZ.Array.cast[Doc[Array[A]]]
  inline given givenDefault[A]: Doc[A]          = ZZ.Any()

  inline given givenProduct1 [A:Y]                                                                                     : Doc[Product1 [A]]                                           = PD._1()
  inline given givenProduct2 [A:Y,B:Y]                                                                                 : Doc[Product2 [A,B]]                                         = PD._2()
  inline given givenProduct3 [A:Y,B:Y,C:Y]                                                                             : Doc[Product3 [A,B,C]]                                       = PD._3()
  inline given givenProduct4 [A:Y,B:Y,C:Y,D:Y]                                                                         : Doc[Product4 [A,B,C,D]]                                     = PD._4()
  inline given givenProduct5 [A:Y,B:Y,C:Y,D:Y,E:Y]                                                                     : Doc[Product5 [A,B,C,D,E]]                                   = PD._5()
  inline given givenProduct6 [A:Y,B:Y,C:Y,D:Y,E:Y,F:Y]                                                                 : Doc[Product6 [A,B,C,D,E,F]]                                 = PD._6()
  inline given givenProduct7 [A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y]                                                             : Doc[Product7 [A,B,C,D,E,F,G]]                               = PD._7()
  inline given givenProduct8 [A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y]                                                         : Doc[Product8 [A,B,C,D,E,F,G,H]]                             = PD._8()
  inline given givenProduct9 [A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y]                                                     : Doc[Product9 [A,B,C,D,E,F,G,H,I]]                           = PD._9()
  inline given givenProduct10[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y]                                                 : Doc[Product10[A,B,C,D,E,F,G,H,I,J]]                         = PD._10()
  inline given givenProduct11[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y]                                             : Doc[Product11[A,B,C,D,E,F,G,H,I,J,K]]                       = PD._11()
  inline given givenProduct12[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y]                                         : Doc[Product12[A,B,C,D,E,F,G,H,I,J,K,L]]                     = PD._12()
  inline given givenProduct13[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y]                                     : Doc[Product13[A,B,C,D,E,F,G,H,I,J,K,L,M]]                   = PD._13()
  inline given givenProduct14[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y]                                 : Doc[Product14[A,B,C,D,E,F,G,H,I,J,K,L,M,N]]                 = PD._14()
  inline given givenProduct15[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y]                             : Doc[Product15[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O]]               = PD._15()
  inline given givenProduct16[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y]                         : Doc[Product16[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P]]             = PD._16()
  inline given givenProduct17[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y,Q:Y]                     : Doc[Product17[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q]]           = PD._17()
  inline given givenProduct18[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y,Q:Y,R:Y]                 : Doc[Product18[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R]]         = PD._18()
  inline given givenProduct19[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y,Q:Y,R:Y,S:Y]             : Doc[Product19[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S]]       = PD._19()
  inline given givenProduct20[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y,Q:Y,R:Y,S:Y,T:Y]         : Doc[Product20[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T]]     = PD._20()
  inline given givenProduct21[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y,Q:Y,R:Y,S:Y,T:Y,U:Y]     : Doc[Product21[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U]]   = PD._21()
  inline given givenProduct22[A:Y,B:Y,C:Y,D:Y,E:Y,F:Y,G:Y,H:Y,I:Y,J:Y,K:Y,L:Y,M:Y,N:Y,O:Y,P:Y,Q:Y,R:Y,S:Y,T:Y,U:Y,V:Y] : Doc[Product22[A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V]] = PD._22()

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Tag -> A given Any.Def.Tag instance for a specific type determines how this instance is converted to a String with universal ".tag" method.

  Usually there is no need to create Any.Def.Tag, because it is implicitly created for standard opaque types.
  Reference types can mix [[scalqa.gen.able.Tag Able.Tag]] instead.

  Defining Any.Def.Tag is usefull for third-party existing types, one has no control over.

@def value_tag -> Instance tag

      Returns String tag describing provided value

*/