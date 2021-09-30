package scalqa; package `val`; package stream; package z; package _build; package _mutate; import language.implicitConversions

object raw:
  class asBoolean(x: ~[Boolean]) extends z.x.Map.AsBoolean(x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.raw }
  class asByte   (x: ~[Byte])    extends z.x.Map.AsByte   (x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.raw }
  class asChar   (x: ~[Char])    extends z.x.Map.AsChar   (x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.raw }
  class asShort  (x: ~[Short])   extends z.x.Map.AsShort  (x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.raw }
  class asInt    (x: ~[Int])     extends z.x.Map.AsInt    (x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.raw }
  class asLong   (x: ~[Long])    extends z.x.Map.AsLong   (x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.raw }
  class asFloat  (x: ~[Float])   extends z.x.Map.AsFloat  (x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.raw }
  class asDouble (x: ~[Double])  extends z.x.Map.AsDouble (x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.raw }

  def asBoolean(x: ~[Boolean]): Boolean.~ = x match{ case x: Boolean.~ => x; case x => new asBoolean(x)}
  def asByte   (x: ~[Byte   ]): Byte   .~ = x match{ case x: Byte.~    => x; case x => new asByte(x)   }
  def asChar   (x: ~[Char   ]): Char   .~ = x match{ case x: Char.~    => x; case x => new asChar(x)   }
  def asShort  (x: ~[Short  ]): Short  .~ = x match{ case x: Short.~   => x; case x => new asShort(x)  }
  def asInt    (x: ~[Int    ]): Int    .~ = x match{ case x: Int.~     => x; case x => new asInt(x)    }
  def asLong   (x: ~[Long   ]): Long   .~ = x match{ case x: Long.~    => x; case x => new asLong(x)   }
  def asFloat  (x: ~[Float  ]): Float  .~ = x match{ case x: Float.~   => x; case x => new asFloat(x)  }
  def asDouble (x: ~[Double ]): Double .~ = x match{ case x: Double.~  => x; case x => new asDouble(x) }

  inline def apply[A](inline x:Stream[A])(using inline A: Specialized.Primitive[A]): A.~ =
    inline x match
      case _ : Boolean.G.~[A] => x.cast[A.~]
      case _ : Byte   .G.~[A] => x.cast[A.~]
      case _ : Char   .G.~[A] => x.cast[A.~]
      case _ : Short  .G.~[A] => x.cast[A.~]
      case _ : Int    .G.~[A] => x.cast[A.~]
      case _ : Long   .G.~[A] => x.cast[A.~]
      case _ : Float  .G.~[A] => x.cast[A.~]
      case _ : Double .G.~[A] => x.cast[A.~]
      case _ =>
        inline A  match
          case _ : Specialized.Primitive[A & Any.Boolean] => asBoolean(x.cast[~[Boolean]]).cast[A.~]
          case _ : Specialized.Primitive[A & Any.Byte   ] => asByte   (x.cast[~[Byte   ]]).cast[A.~]
          case _ : Specialized.Primitive[A & Any.Char   ] => asChar   (x.cast[~[Char   ]]).cast[A.~]
          case _ : Specialized.Primitive[A & Any.Short  ] => asShort  (x.cast[~[Short  ]]).cast[A.~]
          case _ : Specialized.Primitive[A & Any.Int    ] => asInt    (x.cast[~[Int    ]]).cast[A.~]
          case _ : Specialized.Primitive[A & Any.Long   ] => asLong   (x.cast[~[Long   ]]).cast[A.~]
          case _ : Specialized.Primitive[A & Any.Float  ] => asFloat  (x.cast[~[Float  ]]).cast[A.~]
          case _ : Specialized.Primitive[A & Any.Double ] => asDouble (x.cast[~[Double ]]).cast[A.~]
          case _                                          => J.illegalState()

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
