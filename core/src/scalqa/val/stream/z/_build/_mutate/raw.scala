package scalqa; package `val`; package stream; package z; package _build; package _mutate; import language.implicitConversions

object raw:
  class asBoolean(x: Stream[Boolean]) extends z.x.Map.AsBoolean(x){ def readRawOpt = x.readOpt.raw }
  class asByte   (x: Stream[Byte])    extends z.x.Map.AsByte   (x){ def readRawOpt = x.readOpt.raw }
  class asChar   (x: Stream[Char])    extends z.x.Map.AsChar   (x){ def readRawOpt = x.readOpt.raw }
  class asShort  (x: Stream[Short])   extends z.x.Map.AsShort  (x){ def readRawOpt = x.readOpt.raw }
  class asInt    (x: Stream[Int])     extends z.x.Map.AsInt    (x){ def readRawOpt = x.readOpt.raw }
  class asLong   (x: Stream[Long])    extends z.x.Map.AsLong   (x){ def readRawOpt = x.readOpt.raw }
  class asFloat  (x: Stream[Float])   extends z.x.Map.AsFloat  (x){ def readRawOpt = x.readOpt.raw }
  class asDouble (x: Stream[Double])  extends z.x.Map.AsDouble (x){ def readRawOpt = x.readOpt.raw }

  def asBoolean(x: Stream[Boolean]): Boolean.Stream = x match{ case x: Boolean.Stream => x; case x => new asBoolean(x)}
  def asByte   (x: Stream[Byte   ]): Byte   .Stream = x match{ case x: Byte.Stream    => x; case x => new asByte(x)   }
  def asChar   (x: Stream[Char   ]): Char   .Stream = x match{ case x: Char.Stream    => x; case x => new asChar(x)   }
  def asShort  (x: Stream[Short  ]): Short  .Stream = x match{ case x: Short.Stream   => x; case x => new asShort(x)  }
  def asInt    (x: Stream[Int    ]): Int    .Stream = x match{ case x: Int.Stream     => x; case x => new asInt(x)    }
  def asLong   (x: Stream[Long   ]): Long   .Stream = x match{ case x: Long.Stream    => x; case x => new asLong(x)   }
  def asFloat  (x: Stream[Float  ]): Float  .Stream = x match{ case x: Float.Stream   => x; case x => new asFloat(x)  }
  def asDouble (x: Stream[Double ]): Double .Stream = x match{ case x: Double.Stream  => x; case x => new asDouble(x) }

  inline def apply[A](inline x:Stream[A])(using inline A: Specialized.Primitive[A]): A.Stream =
    inline x match
      case _ : Boolean.G.Stream[A] => x.cast[A.Stream]
      case _ : Byte   .G.Stream[A] => x.cast[A.Stream]
      case _ : Char   .G.Stream[A] => x.cast[A.Stream]
      case _ : Short  .G.Stream[A] => x.cast[A.Stream]
      case _ : Int    .G.Stream[A] => x.cast[A.Stream]
      case _ : Long   .G.Stream[A] => x.cast[A.Stream]
      case _ : Float  .G.Stream[A] => x.cast[A.Stream]
      case _ : Double .G.Stream[A] => x.cast[A.Stream]
      case _ =>
        inline A  match
          case _ : Specialized.Primitive[A & Any.Boolean] => asBoolean(x.cast[Stream[Boolean]]).cast[A.Stream]
          case _ : Specialized.Primitive[A & Any.Byte   ] => asByte   (x.cast[Stream[Byte   ]]).cast[A.Stream]
          case _ : Specialized.Primitive[A & Any.Char   ] => asChar   (x.cast[Stream[Char   ]]).cast[A.Stream]
          case _ : Specialized.Primitive[A & Any.Short  ] => asShort  (x.cast[Stream[Short  ]]).cast[A.Stream]
          case _ : Specialized.Primitive[A & Any.Int    ] => asInt    (x.cast[Stream[Int    ]]).cast[A.Stream]
          case _ : Specialized.Primitive[A & Any.Long   ] => asLong   (x.cast[Stream[Long   ]]).cast[A.Stream]
          case _ : Specialized.Primitive[A & Any.Float  ] => asFloat  (x.cast[Stream[Float  ]]).cast[A.Stream]
          case _ : Specialized.Primitive[A & Any.Double ] => asDouble (x.cast[Stream[Double ]]).cast[A.Stream]
          case _                                          => J.illegalState()

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
