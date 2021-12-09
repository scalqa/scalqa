package scalqa; package `val`; package stream; package z; package _build; package _map; import language.implicitConversions

class map[A,B](x: Stream[A], f: A=>B) extends z.x.Map      [B](x):
  def readOpt = x.readOpt.map(f(_))

object map:
  class toBoolean[A](x:Stream[A], f: AnyRef.G.Fun.ToBoolean[A]) extends z.x.Map.AsBoolean(x){ def readRawOpt = x.readOpt.map(f(_))}
  class toByte   [A](x:Stream[A], f: AnyRef.G.Fun.ToByte   [A]) extends z.x.Map.AsByte   (x){ def readRawOpt = x.readOpt.map(f(_))}
  class toChar   [A](x:Stream[A], f: AnyRef.G.Fun.ToChar   [A]) extends z.x.Map.AsChar   (x){ def readRawOpt = x.readOpt.map(f(_))}
  class toShort  [A](x:Stream[A], f: AnyRef.G.Fun.ToShort  [A]) extends z.x.Map.AsShort  (x){ def readRawOpt = x.readOpt.map(f(_))}
  class toInt    [A](x:Stream[A], f: AnyRef.G.Fun.ToInt    [A]) extends z.x.Map.AsInt    (x){ def readRawOpt = x.readOpt.map(f(_))}
  class toLong   [A](x:Stream[A], f: AnyRef.G.Fun.ToLong   [A]) extends z.x.Map.AsLong   (x){ def readRawOpt = x.readOpt.map(f(_))}
  class toFloat  [A](x:Stream[A], f: AnyRef.G.Fun.ToFloat  [A]) extends z.x.Map.AsFloat  (x){ def readRawOpt = x.readOpt.map(f(_))}
  class toDouble [A](x:Stream[A], f: AnyRef.G.Fun.ToDouble [A]) extends z.x.Map.AsDouble (x){ def readRawOpt = x.readOpt.map(f(_))}

  inline def apply[A,B](inline x:Stream[A], inline f: A=>B)(using inline s:Specialized[B]): s.Stream = inline s match
    case _ : Specialized[B & Any.Boolean] => toBoolean(x,f(_).cast[Boolean]).cast[s.Stream]
    case _ : Specialized[B & Any.Byte   ] => toByte   (x,f(_).cast[Byte   ]).cast[s.Stream]
    case _ : Specialized[B & Any.Char   ] => toChar   (x,f(_).cast[Char   ]).cast[s.Stream]
    case _ : Specialized[B & Any.Short  ] => toShort  (x,f(_).cast[Short  ]).cast[s.Stream]
    case _ : Specialized[B & Any.Int    ] => toInt    (x,f(_).cast[Int    ]).cast[s.Stream]
    case _ : Specialized[B & Any.Long   ] => toLong   (x,f(_).cast[Long   ]).cast[s.Stream]
    case _ : Specialized[B & Any.Float  ] => toFloat  (x,f(_).cast[Float  ]).cast[s.Stream]
    case _ : Specialized[B & Any.Double ] => toDouble (x,f(_).cast[Double ]).cast[s.Stream]
    case _                                => new map  (x,f(_)              ).cast[s.Stream]

  inline def APPLY[A,B](inline x: Stream[A], inline f: A=>B)(using inline SB:Specialized[B]): SB.Stream = inline SB match
    case _ : Specialized[B & Any.Boolean] => {class mapToBoolean(x: Stream[A]) extends z.x.Map.AsBoolean(x){ def readRawOpt =x.readOpt.map(f(_).cast[Boolean])}; mapToBoolean(x).cast[SB.Stream]}
    case _ : Specialized[B & Any.Byte   ] => {class mapToByte   (x: Stream[A]) extends z.x.Map.AsByte   (x){ def readRawOpt =x.readOpt.map(f(_).cast[Byte   ])}; mapToByte(x)   .cast[SB.Stream]}
    case _ : Specialized[B & Any.Char   ] => {class mapToChar   (x: Stream[A]) extends z.x.Map.AsChar   (x){ def readRawOpt =x.readOpt.map(f(_).cast[Char   ])}; mapToChar(x)   .cast[SB.Stream]}
    case _ : Specialized[B & Any.Short  ] => {class mapToShort  (x: Stream[A]) extends z.x.Map.AsShort  (x){ def readRawOpt =x.readOpt.map(f(_).cast[Short  ])}; mapToShort(x)  .cast[SB.Stream]}
    case _ : Specialized[B & Any.Int    ] => {class mapToInt    (x: Stream[A]) extends z.x.Map.AsInt    (x){ def readRawOpt =x.readOpt.map(f(_).cast[Int    ])}; mapToInt(x)    .cast[SB.Stream]}
    case _ : Specialized[B & Any.Long   ] => {class mapToLong   (x: Stream[A]) extends z.x.Map.AsLong   (x){ def readRawOpt =x.readOpt.map(f(_).cast[Long   ])}; mapToLong(x)   .cast[SB.Stream]}
    case _ : Specialized[B & Any.Float  ] => {class mapToFloat  (x: Stream[A]) extends z.x.Map.AsFloat  (x){ def readRawOpt =x.readOpt.map(f(_).cast[Float  ])}; mapToFloat(x)  .cast[SB.Stream]}
    case _ : Specialized[B & Any.Double ] => {class mapToDouble (x: Stream[A]) extends z.x.Map.AsDouble (x){ def readRawOpt =x.readOpt.map(f(_).cast[Double ])}; mapToDouble(x) .cast[SB.Stream]}
    case _                                => {class map         (x: Stream[A]) extends z.x.Map       [B](x){ def readOpt    =x.readOpt.map(f(_)).cast[Opt[B]]};  new map(x)     .cast[SB.Stream]}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
