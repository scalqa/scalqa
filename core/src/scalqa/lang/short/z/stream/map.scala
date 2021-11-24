package scalqa; package lang; package short; package z; package stream; import language.implicitConversions

import `val`.stream.z.x.Map

class  map     [A<:Raw,B](x: G.Stream[A], f: G.Fun.ToAny[A,B]  ) extends Map       [B](x){ def readOpt    = x.readRawOpt.map(f(_))}
object map:
  class toBoolean[A<:Raw](x: G.Stream[A], f: G.Fun.ToBoolean[A]) extends Map.AsBoolean(x){ def readRawOpt = x.readRawOpt.map(f(_))}
  class toByte   [A<:Raw](x: G.Stream[A], f: G.Fun.ToByte[A]   ) extends Map.AsByte   (x){ def readRawOpt = x.readRawOpt.map(f(_))}
  class toChar   [A<:Raw](x: G.Stream[A], f: G.Fun.ToChar[A]   ) extends Map.AsChar   (x){ def readRawOpt = x.readRawOpt.map(f(_))}
  class toShort  [A<:Raw](x: G.Stream[A], f: G.Fun.ToShort[A]  ) extends Map.AsShort  (x){ def readRawOpt = x.readRawOpt.map(f(_))}
  class toInt    [A<:Raw](x: G.Stream[A], f: G.Fun.ToInt[A]    ) extends Map.AsInt    (x){ def readRawOpt = x.readRawOpt.map(f(_))}
  class toLong   [A<:Raw](x: G.Stream[A], f: G.Fun.ToLong[A]   ) extends Map.AsLong   (x){ def readRawOpt = x.readRawOpt.map(f(_))}
  class toFloat  [A<:Raw](x: G.Stream[A], f: G.Fun.ToFloat[A]  ) extends Map.AsFloat  (x){ def readRawOpt = x.readRawOpt.map(f(_))}
  class toDouble [A<:Raw](x: G.Stream[A], f: G.Fun.ToDouble[A] ) extends Map.AsDouble (x){ def readRawOpt = x.readRawOpt.map(f(_))}

  inline def apply[A<:Raw,B](inline x: G.Stream[A], inline f: A=>B)(using inline B:Specialized[B]): B.Stream = inline B match
    case _ : Specialized[B & Any.Boolean] => new toBoolean(x,f(_).cast[Boolean]).cast[B.Stream]
    case _ : Specialized[B & Any.Byte   ] => new toByte   (x,f(_).cast[Byte   ]).cast[B.Stream]
    case _ : Specialized[B & Any.Char   ] => new toChar   (x,f(_).cast[Char   ]).cast[B.Stream]
    case _ : Specialized[B & Any.Short  ] => new toShort  (x,f(_).cast[Short  ]).cast[B.Stream]
    case _ : Specialized[B & Any.Int    ] => new toInt    (x,f(_).cast[Int    ]).cast[B.Stream]
    case _ : Specialized[B & Any.Long   ] => new toLong   (x,f(_).cast[Long   ]).cast[B.Stream]
    case _ : Specialized[B & Any.Float  ] => new toFloat  (x,f(_).cast[Float  ]).cast[B.Stream]
    case _ : Specialized[B & Any.Double ] => new toDouble (x,f(_).cast[Double ]).cast[B.Stream]
    case _                                => new map      (x,f(_)              ).cast[B.Stream]

  inline def APPLY[A<:Raw,B](inline x: G.Stream[A], inline f: A=>B)(using inline B:Specialized[B]): B.Stream = inline B match
    case _ : Specialized[B & Any.Boolean] => {class mapToBoolean(x: G.Stream[A]) extends Map.AsBoolean(x){ def readRawOpt =x.readRawOpt.map(f(_).cast[Boolean])}; new mapToBoolean(x).cast[B.Stream] }
    case _ : Specialized[B & Any.Byte   ] => {class mapToByte   (x: G.Stream[A]) extends Map.AsByte   (x){ def readRawOpt =x.readRawOpt.map(f(_).cast[Byte   ])}; new mapToByte(x)   .cast[B.Stream] }
    case _ : Specialized[B & Any.Char   ] => {class mapToChar   (x: G.Stream[A]) extends Map.AsChar   (x){ def readRawOpt =x.readRawOpt.map(f(_).cast[Char   ])}; new mapToChar(x)   .cast[B.Stream] }
    case _ : Specialized[B & Any.Short  ] => {class mapToShort  (x: G.Stream[A]) extends Map.AsShort  (x){ def readRawOpt =x.readRawOpt.map(f(_).cast[Short  ])}; new mapToShort(x)  .cast[B.Stream] }
    case _ : Specialized[B & Any.Int    ] => {class mapToInt    (x: G.Stream[A]) extends Map.AsInt    (x){ def readRawOpt =x.readRawOpt.map(f(_).cast[Int    ])}; new mapToInt(x)    .cast[B.Stream] }
    case _ : Specialized[B & Any.Long   ] => {class mapToLong   (x: G.Stream[A]) extends Map.AsLong   (x){ def readRawOpt =x.readRawOpt.map(f(_).cast[Long   ])}; new mapToLong(x)   .cast[B.Stream] }
    case _ : Specialized[B & Any.Float  ] => {class mapToFloat  (x: G.Stream[A]) extends Map.AsFloat  (x){ def readRawOpt =x.readRawOpt.map(f(_).cast[Float  ])}; new mapToFloat(x)  .cast[B.Stream] }
    case _ : Specialized[B & Any.Double ] => {class mapToDouble (x: G.Stream[A]) extends Map.AsDouble (x){ def readRawOpt =x.readRawOpt.map(f(_).cast[Double ])}; new mapToDouble(x) .cast[B.Stream] }
    case _                                => {class map         (x: G.Stream[A]) extends Map      [B] (x){ def readOpt    =x.readRawOpt.map(f(_)).cast[Opt[B]] }; new map(x)         .cast[B.Stream] }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
