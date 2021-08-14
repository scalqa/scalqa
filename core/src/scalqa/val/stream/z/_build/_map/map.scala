package scalqa; package `val`; package stream; package z; package _build; package _map; import language.implicitConversions

import gen.`given`.StreamShape

class map[A,B](x:Stream[A], f: A => B) extends a.Map.ToRef    [B](x){ @tn("read_Opt")    def read_?    = x.read_?.map(f(_))}

object map:
  class toBoolean[A,B<:Boolean.Raw](x:Stream[A], f: Boolean.G.Fun.FromAny[A,B]) extends a.Map.ToBoolean[B](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.map(f(_))}
  class toByte   [A,B<:Byte.Raw]   (x:Stream[A], f: Byte   .G.Fun.FromAny[A,B]) extends a.Map.ToByte   [B](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.map(f(_))}
  class toChar   [A,B<:Char.Raw]   (x:Stream[A], f: Char   .G.Fun.FromAny[A,B]) extends a.Map.ToChar   [B](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.map(f(_))}
  class toShort  [A,B<:Short.Raw]  (x:Stream[A], f: Short  .G.Fun.FromAny[A,B]) extends a.Map.ToShort  [B](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.map(f(_))}
  class toInt    [A,B<:Int.Raw]    (x:Stream[A], f: Int    .G.Fun.FromAny[A,B]) extends a.Map.ToInt    [B](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.map(f(_))}
  class toLong   [A,B<:Long.Raw]   (x:Stream[A], f: Long   .G.Fun.FromAny[A,B]) extends a.Map.ToLong   [B](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.map(f(_))}
  class toFloat  [A,B<:Float.Raw]  (x:Stream[A], f: Float  .G.Fun.FromAny[A,B]) extends a.Map.ToFloat  [B](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.map(f(_))}
  class toDouble [A,B<:Double.Raw] (x:Stream[A], f: Double .G.Fun.FromAny[A,B]) extends a.Map.ToDouble [B](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.map(f(_))}

  inline def apply[A,B,STM<: ~~.AnyType[B]](inline x:Stream[A], inline f: A=>B, inline s:StreamShape[B,STM] ): STM = inline s match
    case _ : StreamShape[B,Boolean.G.~[B & Boolean.Raw]] => toBoolean(x,f(_).cast[B & Boolean.Raw])
    case _ : StreamShape[B,Byte   .G.~[B & Byte.Raw   ]] => toByte   (x,f(_).cast[B & Byte.Raw   ])
    case _ : StreamShape[B,Char   .G.~[B & Char.Raw   ]] => toChar   (x,f(_).cast[B & Char.Raw   ])
    case _ : StreamShape[B,Short  .G.~[B & Short.Raw  ]] => toShort  (x,f(_).cast[B & Short.Raw  ])
    case _ : StreamShape[B,Int    .G.~[B & Int.Raw    ]] => toInt    (x,f(_).cast[B & Int.Raw    ])
    case _ : StreamShape[B,Long   .G.~[B & Long.Raw   ]] => toLong   (x,f(_).cast[B & Long.Raw   ])
    case _ : StreamShape[B,Float  .G.~[B & Float.Raw  ]] => toFloat  (x,f(_).cast[B & Float.Raw  ])
    case _ : StreamShape[B,Double .G.~[B & Double.Raw ]] => toDouble (x,f(_).cast[B & Double.Raw ])
    case _ : StreamShape[B,      Val.~[B]]               => new map   (x,f(_))

  inline def APPLY[A,B,STM<: ~~.AnyType[B]](inline x: Stream[A], inline f: A=>B, inline s:StreamShape[B,STM]): STM = inline s match
    case _ : StreamShape[B,Boolean.G.~[B & Boolean.Raw]] => {class mapToBoolean(x: Stream[A]) extends a.Map.ToBoolean[B & Boolean.Raw](x){ @tn("readRaw_Opt") def readRaw_? =x.read_?.map(f(_).cast[B & Boolean.Raw])}; mapToBoolean(x)}
    case _ : StreamShape[B,Byte   .G.~[B & Byte.Raw   ]] => {class mapToByte   (x: Stream[A]) extends a.Map.ToByte   [B & Byte.Raw   ](x){ @tn("readRaw_Opt") def readRaw_? =x.read_?.map(f(_).cast[B & Byte.Raw   ])}; mapToByte(x)   }
    case _ : StreamShape[B,Char   .G.~[B & Char.Raw   ]] => {class mapToChar   (x: Stream[A]) extends a.Map.ToChar   [B & Char.Raw   ](x){ @tn("readRaw_Opt") def readRaw_? =x.read_?.map(f(_).cast[B & Char.Raw   ])}; mapToChar(x)   }
    case _ : StreamShape[B,Short  .G.~[B & Short.Raw  ]] => {class mapToShort  (x: Stream[A]) extends a.Map.ToShort  [B & Short.Raw  ](x){ @tn("readRaw_Opt") def readRaw_? =x.read_?.map(f(_).cast[B & Short.Raw  ])}; mapToShort(x)  }
    case _ : StreamShape[B,Int    .G.~[B & Int.Raw    ]] => {class mapToInt    (x: Stream[A]) extends a.Map.ToInt    [B & Int.Raw    ](x){ @tn("readRaw_Opt") def readRaw_? =x.read_?.map(f(_).cast[B & Int.Raw    ])}; mapToInt(x)    }
    case _ : StreamShape[B,Long   .G.~[B & Long.Raw   ]] => {class mapToLong   (x: Stream[A]) extends a.Map.ToLong   [B & Long.Raw   ](x){ @tn("readRaw_Opt") def readRaw_? =x.read_?.map(f(_).cast[B & Long.Raw   ])}; mapToLong(x)   }
    case _ : StreamShape[B,Float  .G.~[B & Float.Raw  ]] => {class mapToFloat  (x: Stream[A]) extends a.Map.ToFloat  [B & Float.Raw  ](x){ @tn("readRaw_Opt") def readRaw_? =x.read_?.map(f(_).cast[B & Float.Raw  ])}; mapToFloat(x)  }
    case _ : StreamShape[B,Double .G.~[B & Double.Raw ]] => {class mapToDouble (x: Stream[A]) extends a.Map.ToDouble [B & Double.Raw ](x){ @tn("readRaw_Opt") def readRaw_? =x.read_?.map(f(_).cast[B & Double.Raw ])}; mapToDouble(x) }
    case _ : StreamShape[B,      Val.~[B]]               => {class map         (x: Stream[A]) extends a.Map.ToRef    [B              ](x){ @tn("read_Opt")    def read_?    =x.read_?.map(f(_))};                       new map(x)     }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
