package scalqa; package `val`; package stream; package z; package _build; package _mutate; import language.implicitConversions

object raw:
  class toBoolean(x: ~[Boolean]) extends z.x.Map.AsBoolean(x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.raw }
  class toByte   (x: ~[Byte])    extends z.x.Map.AsByte   (x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.raw }
  class toChar   (x: ~[Char])    extends z.x.Map.AsChar   (x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.raw }
  class toShort  (x: ~[Short])   extends z.x.Map.AsShort  (x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.raw }
  class toInt    (x: ~[Int])     extends z.x.Map.AsInt    (x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.raw }
  class toLong   (x: ~[Long])    extends z.x.Map.AsLong   (x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.raw }
  class toFloat  (x: ~[Float])   extends z.x.Map.AsFloat  (x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.raw }
  class toDouble (x: ~[Double])  extends z.x.Map.AsDouble (x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.raw }

  def toBoolean(x: ~[Boolean]): Boolean.~ = x match{ case x: Boolean.~ => x; case x => new toBoolean(x)}
  def toByte   (x: ~[Byte   ]): Byte   .~ = x match{ case x: Byte.~    => x; case x => new toByte(x)   }
  def toChar   (x: ~[Char   ]): Char   .~ = x match{ case x: Char.~    => x; case x => new toChar(x)   }
  def toShort  (x: ~[Short  ]): Short  .~ = x match{ case x: Short.~   => x; case x => new toShort(x)  }
  def toInt    (x: ~[Int    ]): Int    .~ = x match{ case x: Int.~     => x; case x => new toInt(x)    }
  def toLong   (x: ~[Long   ]): Long   .~ = x match{ case x: Long.~    => x; case x => new toLong(x)   }
  def toFloat  (x: ~[Float  ]): Float  .~ = x match{ case x: Float.~   => x; case x => new toFloat(x)  }
  def toDouble (x: ~[Double ]): Double .~ = x match{ case x: Double.~  => x; case x => new toDouble(x) }

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
          case _ : Specialized.Primitive[A & Any.Boolean] => toBoolean(x.cast[~[Boolean]]).cast[A.~]
          case _ : Specialized.Primitive[A & Any.Byte   ] => toByte   (x.cast[~[Byte   ]]).cast[A.~]
          case _ : Specialized.Primitive[A & Any.Char   ] => toChar   (x.cast[~[Char   ]]).cast[A.~]
          case _ : Specialized.Primitive[A & Any.Short  ] => toShort  (x.cast[~[Short  ]]).cast[A.~]
          case _ : Specialized.Primitive[A & Any.Int    ] => toInt    (x.cast[~[Int    ]]).cast[A.~]
          case _ : Specialized.Primitive[A & Any.Long   ] => toLong   (x.cast[~[Long   ]]).cast[A.~]
          case _ : Specialized.Primitive[A & Any.Float  ] => toFloat  (x.cast[~[Float  ]]).cast[A.~]
          case _ : Specialized.Primitive[A & Any.Double ] => toDouble (x.cast[~[Double ]]).cast[A.~]
          case _                                          => J.illegalState()

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
