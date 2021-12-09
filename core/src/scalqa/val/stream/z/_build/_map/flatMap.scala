package scalqa; package `val`; package stream; package z; package _build; package _map; import language.implicitConversions

import x.{ FlatMap as FM }

class flatMap[A,B] (x:Stream[A], f: A => Stream[B]) extends FM[B](x){ def fewOpt = x.readOpt.map(f(_))}

object flatMap:
  class toBoolean[A](x:Stream[A], f: A => Boolean.Stream) extends FM.AsBoolean(x){ def fewOpt = x.readOpt.map(f(_)) }
  class toByte   [A](x:Stream[A], f: A => Byte.Stream)    extends FM.AsByte   (x){ def fewOpt = x.readOpt.map(f(_)) }
  class toChar   [A](x:Stream[A], f: A => Char.Stream)    extends FM.AsChar   (x){ def fewOpt = x.readOpt.map(f(_)) }
  class toShort  [A](x:Stream[A], f: A => Short.Stream)   extends FM.AsShort  (x){ def fewOpt = x.readOpt.map(f(_)) }
  class toInt    [A](x:Stream[A], f: A => Int.Stream)     extends FM.AsInt    (x){ def fewOpt = x.readOpt.map(f(_)) }
  class toLong   [A](x:Stream[A], f: A => Long.Stream)    extends FM.AsLong   (x){ def fewOpt = x.readOpt.map(f(_)) }
  class toFloat  [A](x:Stream[A], f: A => Float.Stream)   extends FM.AsFloat  (x){ def fewOpt = x.readOpt.map(f(_)) }
  class toDouble [A](x:Stream[A], f: A => Double.Stream)  extends FM.AsDouble (x){ def fewOpt = x.readOpt.map(f(_)) }

  inline def apply[A,B](inline x: Stream[A], inline f: A => Stream[B])(using inline s:Specialized[B]): s.Stream =
    inline s match
      case _ : Specialized[B & Any.Boolean] => toBoolean(x,f(_).cast[Stream[Boolean]].raw).cast[s.Stream]
      case _ : Specialized[B & Any.Byte   ] => toByte   (x,f(_).cast[Stream[Byte   ]].raw).cast[s.Stream]
      case _ : Specialized[B & Any.Char   ] => toChar   (x,f(_).cast[Stream[Char   ]].raw).cast[s.Stream]
      case _ : Specialized[B & Any.Short  ] => toShort  (x,f(_).cast[Stream[Short  ]].raw).cast[s.Stream]
      case _ : Specialized[B & Any.Int    ] => toInt    (x,f(_).cast[Stream[Int    ]].raw).cast[s.Stream]
      case _ : Specialized[B & Any.Long   ] => toLong   (x,f(_).cast[Stream[Long   ]].raw).cast[s.Stream]
      case _ : Specialized[B & Any.Float  ] => toFloat  (x,f(_).cast[Stream[Float  ]].raw).cast[s.Stream]
      case _ : Specialized[B & Any.Double ] => toDouble (x,f(_).cast[Stream[Double ]].raw).cast[s.Stream]
      case _                                => new flatMap(x,f(_))                   .cast[s.Stream]

  inline def APPLY[A,B](x: Stream[A], inline f: A => Stream[B]) (using inline s:Specialized[B]): s.Stream =
    inline s match
      case _ : Specialized[B & Any.Boolean] =>{ class flatMapToBoolean(x: Stream[A]) extends FM.AsBoolean(x){ def fewOpt=x.readOpt.map(f(_).cast[Stream[Boolean]].raw)}; flatMapToBoolean(x).cast[s.Stream]}
      case _ : Specialized[B & Any.Byte   ] =>{ class flatMapToByte   (x: Stream[A]) extends FM.AsByte   (x){ def fewOpt=x.readOpt.map(f(_).cast[Stream[Byte   ]].raw)}; flatMapToByte   (x).cast[s.Stream]}
      case _ : Specialized[B & Any.Char   ] =>{ class flatMapToChar   (x: Stream[A]) extends FM.AsChar   (x){ def fewOpt=x.readOpt.map(f(_).cast[Stream[Char   ]].raw)}; flatMapToChar   (x).cast[s.Stream]}
      case _ : Specialized[B & Any.Short  ] =>{ class flatMapToShort  (x: Stream[A]) extends FM.AsShort  (x){ def fewOpt=x.readOpt.map(f(_).cast[Stream[Short  ]].raw)}; flatMapToShort  (x).cast[s.Stream]}
      case _ : Specialized[B & Any.Int    ] =>{ class flatMapToInt    (x: Stream[A]) extends FM.AsInt    (x){ def fewOpt=x.readOpt.map(f(_).cast[Stream[Int    ]].raw)}; flatMapToInt    (x).cast[s.Stream]}
      case _ : Specialized[B & Any.Long   ] =>{ class flatMapToLong   (x: Stream[A]) extends FM.AsLong   (x){ def fewOpt=x.readOpt.map(f(_).cast[Stream[Long   ]].raw)}; flatMapToLong   (x).cast[s.Stream]}
      case _ : Specialized[B & Any.Float  ] =>{ class flatMapToFloat  (x: Stream[A]) extends FM.AsFloat  (x){ def fewOpt=x.readOpt.map(f(_).cast[Stream[Float  ]].raw)}; flatMapToFloat  (x).cast[s.Stream]}
      case _ : Specialized[B & Any.Double ] =>{ class flatMapToDouble (x: Stream[A]) extends FM.AsDouble (x){ def fewOpt=x.readOpt.map(f(_).cast[Stream[Double ]].raw)}; flatMapToDouble (x).cast[s.Stream]}
      case _                                =>{ class flatMap         (x: Stream[A]) extends FM [B](x){ def fewOpt=x.readOpt.map(f(_))};                      new flatMap     (x).cast[s.Stream]}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
