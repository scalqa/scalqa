package scalqa; package lang; package char; package z; package stream; import language.implicitConversions

import `val`.stream.z.x.{ FlatMap => FM }

class  flatMap [A<:Raw,B](x: G.~[A], f: G.Fun.ToAny[A,~[B]])      extends FM       [B](x){ def fewOpt = x.read_?.map(f(_))}
object flatMap:
  class toBoolean[A<:Raw](x: G.~[A], f: G.Fun.ToAny[A,Boolean.~]) extends FM.AsBoolean(x){ def fewOpt = x.readRaw_?.map(f(_))}
  class toByte   [A<:Raw](x: G.~[A], f: G.Fun.ToAny[A,Byte.~])    extends FM.AsByte   (x){ def fewOpt = x.readRaw_?.map(f(_))}
  class toChar   [A<:Raw](x: G.~[A], f: G.Fun.ToAny[A,Char.~])    extends FM.AsChar   (x){ def fewOpt = x.readRaw_?.map(f(_))}
  class toShort  [A<:Raw](x: G.~[A], f: G.Fun.ToAny[A,Short.~])   extends FM.AsShort  (x){ def fewOpt = x.readRaw_?.map(f(_))}
  class toInt    [A<:Raw](x: G.~[A], f: G.Fun.ToAny[A,Int.~])     extends FM.AsInt    (x){ def fewOpt = x.readRaw_?.map(f(_))}
  class toLong   [A<:Raw](x: G.~[A], f: G.Fun.ToAny[A,Long.~])    extends FM.AsLong   (x){ def fewOpt = x.readRaw_?.map(f(_))}
  class toFloat  [A<:Raw](x: G.~[A], f: G.Fun.ToAny[A,Float.~])   extends FM.AsFloat  (x){ def fewOpt = x.readRaw_?.map(f(_))}
  class toDouble [A<:Raw](x: G.~[A], f: G.Fun.ToAny[A,Double.~])  extends FM.AsDouble (x){ def fewOpt = x.readRaw_?.map(f(_))}

  inline def apply[A<:Raw,B](inline x: G.~[A], inline f: A => ~[B])(using inline B:Specialized[B]): B.~ =
    inline B match
      case _ : Specialized[B & Any.Boolean] => new toBoolean(x,f(_).cast[~[Boolean]].raw).cast[B.~]
      case _ : Specialized[B & Any.Byte   ] => new toByte   (x,f(_).cast[~[Byte   ]].raw).cast[B.~]
      case _ : Specialized[B & Any.Char   ] => new toChar   (x,f(_).cast[~[Char   ]].raw).cast[B.~]
      case _ : Specialized[B & Any.Short  ] => new toShort  (x,f(_).cast[~[Short  ]].raw).cast[B.~]
      case _ : Specialized[B & Any.Int    ] => new toInt    (x,f(_).cast[~[Int    ]].raw).cast[B.~]
      case _ : Specialized[B & Any.Long   ] => new toLong   (x,f(_).cast[~[Long   ]].raw).cast[B.~]
      case _ : Specialized[B & Any.Float  ] => new toFloat  (x,f(_).cast[~[Float  ]].raw).cast[B.~]
      case _ : Specialized[B & Any.Double ] => new toDouble (x,f(_).cast[~[Double ]].raw).cast[B.~]
      case _                                => new flatMap  (x,f(_)                     ).cast[B.~]

  inline def APPLY[A<:Raw,B](x: G.~[A], inline f: A => ~[B])(using inline B:Specialized[B]): B.~ =
    inline B match
      case _ : Specialized[B & Any.Boolean] =>{ class flatMapToBoolean(x: G.~[A]) extends FM.AsBoolean(x){ def fewOpt=x.readRaw_?.map(f(_).cast[~[Boolean]].raw)}; new flatMapToBoolean(x).cast[B.~] }
      case _ : Specialized[B & Any.Byte   ] =>{ class flatMapToByte   (x: G.~[A]) extends FM.AsByte   (x){ def fewOpt=x.readRaw_?.map(f(_).cast[~[Byte   ]].raw)}; new flatMapToByte   (x).cast[B.~] }
      case _ : Specialized[B & Any.Char   ] =>{ class flatMapToChar   (x: G.~[A]) extends FM.AsChar   (x){ def fewOpt=x.readRaw_?.map(f(_).cast[~[Char   ]].raw)}; new flatMapToChar   (x).cast[B.~] }
      case _ : Specialized[B & Any.Short  ] =>{ class flatMapToShort  (x: G.~[A]) extends FM.AsShort  (x){ def fewOpt=x.readRaw_?.map(f(_).cast[~[Short  ]].raw)}; new flatMapToShort  (x).cast[B.~] }
      case _ : Specialized[B & Any.Int    ] =>{ class flatMapToInt    (x: G.~[A]) extends FM.AsInt    (x){ def fewOpt=x.readRaw_?.map(f(_).cast[~[Int    ]].raw)}; new flatMapToInt    (x).cast[B.~] }
      case _ : Specialized[B & Any.Long   ] =>{ class flatMapToLong   (x: G.~[A]) extends FM.AsLong   (x){ def fewOpt=x.readRaw_?.map(f(_).cast[~[Long   ]].raw)}; new flatMapToLong   (x).cast[B.~] }
      case _ : Specialized[B & Any.Float  ] =>{ class flatMapToFloat  (x: G.~[A]) extends FM.AsFloat  (x){ def fewOpt=x.readRaw_?.map(f(_).cast[~[Float  ]].raw)}; new flatMapToFloat  (x).cast[B.~] }
      case _ : Specialized[B & Any.Double ] =>{ class flatMapToDouble (x: G.~[A]) extends FM.AsDouble (x){ def fewOpt=x.readRaw_?.map(f(_).cast[~[Double ]].raw)}; new flatMapToDouble (x).cast[B.~] }
      case _                                =>{ class flatMap         (x: G.~[A]) extends FM       [B](x){ def fewOpt=x.read_?   .map(f(_)                     )}; new flatMap         (x).cast[B.~] }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
