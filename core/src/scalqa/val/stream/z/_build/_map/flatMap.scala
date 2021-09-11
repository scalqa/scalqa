package scalqa; package `val`; package stream; package z; package _build; package _map; import language.implicitConversions

import x.{ FlatMap as FM }

class flatMap[A,B] (x:Stream[A], f: A => ~[B]) extends FM[B](x){ def fewOpt = x.read_?.map(f(_))}

object flatMap:
  class toBoolean[A](x:Stream[A], f: A => Boolean.~) extends FM.AsBoolean(x){ def fewOpt = x.read_?.map(f(_)) }
  class toByte   [A](x:Stream[A], f: A => Byte.~)    extends FM.AsByte   (x){ def fewOpt = x.read_?.map(f(_)) }
  class toChar   [A](x:Stream[A], f: A => Char.~)    extends FM.AsChar   (x){ def fewOpt = x.read_?.map(f(_)) }
  class toShort  [A](x:Stream[A], f: A => Short.~)   extends FM.AsShort  (x){ def fewOpt = x.read_?.map(f(_)) }
  class toInt    [A](x:Stream[A], f: A => Int.~)     extends FM.AsInt    (x){ def fewOpt = x.read_?.map(f(_)) }
  class toLong   [A](x:Stream[A], f: A => Long.~)    extends FM.AsLong   (x){ def fewOpt = x.read_?.map(f(_)) }
  class toFloat  [A](x:Stream[A], f: A => Float.~)   extends FM.AsFloat  (x){ def fewOpt = x.read_?.map(f(_)) }
  class toDouble [A](x:Stream[A], f: A => Double.~)  extends FM.AsDouble (x){ def fewOpt = x.read_?.map(f(_)) }

  inline def apply[A,B](inline x: Stream[A], inline f: A => ~[B])(using inline B:Specialized[B]): B.~ =
    inline B match
      case _ : Specialized[B & Any.Boolean] => toBoolean(x,f(_).cast[~[Boolean]].raw).cast[B.~]
      case _ : Specialized[B & Any.Byte   ] => toByte   (x,f(_).cast[~[Byte   ]].raw).cast[B.~]
      case _ : Specialized[B & Any.Char   ] => toChar   (x,f(_).cast[~[Char   ]].raw).cast[B.~]
      case _ : Specialized[B & Any.Short  ] => toShort  (x,f(_).cast[~[Short  ]].raw).cast[B.~]
      case _ : Specialized[B & Any.Int    ] => toInt    (x,f(_).cast[~[Int    ]].raw).cast[B.~]
      case _ : Specialized[B & Any.Long   ] => toLong   (x,f(_).cast[~[Long   ]].raw).cast[B.~]
      case _ : Specialized[B & Any.Float  ] => toFloat  (x,f(_).cast[~[Float  ]].raw).cast[B.~]
      case _ : Specialized[B & Any.Double ] => toDouble (x,f(_).cast[~[Double ]].raw).cast[B.~]
      case _                                => new flatMap(x,f(_))                   .cast[B.~]

  inline def APPLY[A,B](x: Stream[A], inline f: A => ~[B]) (using inline B:Specialized[B]): B.~ =
    inline B match
      case _ : Specialized[B & Any.Boolean] =>{ class flatMapToBoolean(x: Stream[A]) extends FM.AsBoolean(x){ def fewOpt=x.read_?.map(f(_).cast[~[Boolean]].raw)}; flatMapToBoolean(x).cast[B.~]}
      case _ : Specialized[B & Any.Byte   ] =>{ class flatMapToByte   (x: Stream[A]) extends FM.AsByte   (x){ def fewOpt=x.read_?.map(f(_).cast[~[Byte   ]].raw)}; flatMapToByte   (x).cast[B.~]}
      case _ : Specialized[B & Any.Char   ] =>{ class flatMapToChar   (x: Stream[A]) extends FM.AsChar   (x){ def fewOpt=x.read_?.map(f(_).cast[~[Char   ]].raw)}; flatMapToChar   (x).cast[B.~]}
      case _ : Specialized[B & Any.Short  ] =>{ class flatMapToShort  (x: Stream[A]) extends FM.AsShort  (x){ def fewOpt=x.read_?.map(f(_).cast[~[Short  ]].raw)}; flatMapToShort  (x).cast[B.~]}
      case _ : Specialized[B & Any.Int    ] =>{ class flatMapToInt    (x: Stream[A]) extends FM.AsInt    (x){ def fewOpt=x.read_?.map(f(_).cast[~[Int    ]].raw)}; flatMapToInt    (x).cast[B.~]}
      case _ : Specialized[B & Any.Long   ] =>{ class flatMapToLong   (x: Stream[A]) extends FM.AsLong   (x){ def fewOpt=x.read_?.map(f(_).cast[~[Long   ]].raw)}; flatMapToLong   (x).cast[B.~]}
      case _ : Specialized[B & Any.Float  ] =>{ class flatMapToFloat  (x: Stream[A]) extends FM.AsFloat  (x){ def fewOpt=x.read_?.map(f(_).cast[~[Float  ]].raw)}; flatMapToFloat  (x).cast[B.~]}
      case _ : Specialized[B & Any.Double ] =>{ class flatMapToDouble (x: Stream[A]) extends FM.AsDouble (x){ def fewOpt=x.read_?.map(f(_).cast[~[Double ]].raw)}; flatMapToDouble (x).cast[B.~]}
      case _                                =>{ class flatMap         (x: Stream[A]) extends FM [B](x){ def fewOpt=x.read_?.map(f(_))};                      new flatMap     (x).cast[B.~]}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
