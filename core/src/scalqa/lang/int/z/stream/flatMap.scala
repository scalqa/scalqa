package scalqa; package lang; package int; package z; package stream; import language.implicitConversions

import `val`.stream.z.x.{ FlatMap => FM }

class  flatMap [A<:Raw,B](x: G.Stream[A], f: G.Fun.ToAny[A,Val.Stream[B]])  extends FM       [B](x){ def fewOpt = x.readOpt.map(f(_))}
object flatMap:
  class toBoolean[A<:Raw](x: G.Stream[A], f: G.Fun.ToAny[A,Boolean.Stream]) extends FM.AsBoolean(x){ def fewOpt = x.readRawOpt.map(f(_))}
  class toByte   [A<:Raw](x: G.Stream[A], f: G.Fun.ToAny[A,Byte.Stream])    extends FM.AsByte   (x){ def fewOpt = x.readRawOpt.map(f(_))}
  class toChar   [A<:Raw](x: G.Stream[A], f: G.Fun.ToAny[A,Char.Stream])    extends FM.AsChar   (x){ def fewOpt = x.readRawOpt.map(f(_))}
  class toShort  [A<:Raw](x: G.Stream[A], f: G.Fun.ToAny[A,Short.Stream])   extends FM.AsShort  (x){ def fewOpt = x.readRawOpt.map(f(_))}
  class toInt    [A<:Raw](x: G.Stream[A], f: G.Fun.ToAny[A,Int.Stream])     extends FM.AsInt    (x){ def fewOpt = x.readRawOpt.map(f(_))}
  class toLong   [A<:Raw](x: G.Stream[A], f: G.Fun.ToAny[A,Long.Stream])    extends FM.AsLong   (x){ def fewOpt = x.readRawOpt.map(f(_))}
  class toFloat  [A<:Raw](x: G.Stream[A], f: G.Fun.ToAny[A,Float.Stream])   extends FM.AsFloat  (x){ def fewOpt = x.readRawOpt.map(f(_))}
  class toDouble [A<:Raw](x: G.Stream[A], f: G.Fun.ToAny[A,Double.Stream])  extends FM.AsDouble (x){ def fewOpt = x.readRawOpt.map(f(_))}

  inline def apply[A<:Raw,B](inline x: G.Stream[A], inline f: A => Val.Stream[B])(using inline s:Specialized[B]): s.Stream =
    inline s match
      case _ : Specialized[B & Any.Boolean] => new toBoolean(x,f(_).cast[Stream[Boolean]].raw).cast[s.Stream]
      case _ : Specialized[B & Any.Byte   ] => new toByte   (x,f(_).cast[Stream[Byte   ]].raw).cast[s.Stream]
      case _ : Specialized[B & Any.Char   ] => new toChar   (x,f(_).cast[Stream[Char   ]].raw).cast[s.Stream]
      case _ : Specialized[B & Any.Short  ] => new toShort  (x,f(_).cast[Stream[Short  ]].raw).cast[s.Stream]
      case _ : Specialized[B & Any.Int    ] => new toInt    (x,f(_).cast[Stream[Int    ]].raw).cast[s.Stream]
      case _ : Specialized[B & Any.Long   ] => new toLong   (x,f(_).cast[Stream[Long   ]].raw).cast[s.Stream]
      case _ : Specialized[B & Any.Float  ] => new toFloat  (x,f(_).cast[Stream[Float  ]].raw).cast[s.Stream]
      case _ : Specialized[B & Any.Double ] => new toDouble (x,f(_).cast[Stream[Double ]].raw).cast[s.Stream]
      case _                                => new flatMap  (x,f(_)                     ).cast[s.Stream]

  inline def APPLY[A<:Raw,B](x: G.Stream[A], inline f: A => Val.Stream[B])(using inline s:Specialized[B]): s.Stream =
    inline s match
      case _ : Specialized[B & Any.Boolean] =>{ class flatMapToBoolean(x: G.Stream[A]) extends FM.AsBoolean(x){ def fewOpt=x.readRawOpt.map(f(_).cast[Stream[Boolean]].raw)}; new flatMapToBoolean(x).cast[s.Stream] }
      case _ : Specialized[B & Any.Byte   ] =>{ class flatMapToByte   (x: G.Stream[A]) extends FM.AsByte   (x){ def fewOpt=x.readRawOpt.map(f(_).cast[Stream[Byte   ]].raw)}; new flatMapToByte   (x).cast[s.Stream] }
      case _ : Specialized[B & Any.Char   ] =>{ class flatMapToChar   (x: G.Stream[A]) extends FM.AsChar   (x){ def fewOpt=x.readRawOpt.map(f(_).cast[Stream[Char   ]].raw)}; new flatMapToChar   (x).cast[s.Stream] }
      case _ : Specialized[B & Any.Short  ] =>{ class flatMapToShort  (x: G.Stream[A]) extends FM.AsShort  (x){ def fewOpt=x.readRawOpt.map(f(_).cast[Stream[Short  ]].raw)}; new flatMapToShort  (x).cast[s.Stream] }
      case _ : Specialized[B & Any.Int    ] =>{ class flatMapToInt    (x: G.Stream[A]) extends FM.AsInt    (x){ def fewOpt=x.readRawOpt.map(f(_).cast[Stream[Int    ]].raw)}; new flatMapToInt    (x).cast[s.Stream] }
      case _ : Specialized[B & Any.Long   ] =>{ class flatMapToLong   (x: G.Stream[A]) extends FM.AsLong   (x){ def fewOpt=x.readRawOpt.map(f(_).cast[Stream[Long   ]].raw)}; new flatMapToLong   (x).cast[s.Stream] }
      case _ : Specialized[B & Any.Float  ] =>{ class flatMapToFloat  (x: G.Stream[A]) extends FM.AsFloat  (x){ def fewOpt=x.readRawOpt.map(f(_).cast[Stream[Float  ]].raw)}; new flatMapToFloat  (x).cast[s.Stream] }
      case _ : Specialized[B & Any.Double ] =>{ class flatMapToDouble (x: G.Stream[A]) extends FM.AsDouble (x){ def fewOpt=x.readRawOpt.map(f(_).cast[Stream[Double ]].raw)}; new flatMapToDouble (x).cast[s.Stream] }
      case _                                =>{ class flatMap         (x: G.Stream[A]) extends FM       [B](x){ def fewOpt=x.readOpt   .map(f(_)                     )}; new flatMap         (x).cast[s.Stream] }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
