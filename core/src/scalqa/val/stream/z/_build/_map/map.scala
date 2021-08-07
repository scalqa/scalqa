package scalqa; package `val`; package stream; package z; package _build; package _map; import language.implicitConversions

import gen.`given`.StreamShape

object map:
  class Booleans[A,B<:Boolean.Raw](x:Stream[A], f: Boolean.G.Fun.FromAny[A,B]) extends a.Map.ToBoolean[B](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.map(f(_))}
  class Bytes   [A,B<:Byte.Raw]   (x:Stream[A], f: Byte   .G.Fun.FromAny[A,B]) extends a.Map.ToByte   [B](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.map(f(_))}
  class Chars   [A,B<:Char.Raw]   (x:Stream[A], f: Char   .G.Fun.FromAny[A,B]) extends a.Map.ToChar   [B](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.map(f(_))}
  class Shorts  [A,B<:Short.Raw]  (x:Stream[A], f: Short  .G.Fun.FromAny[A,B]) extends a.Map.ToShort  [B](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.map(f(_))}
  class Ints    [A,B<:Int.Raw]    (x:Stream[A], f: Int    .G.Fun.FromAny[A,B]) extends a.Map.ToInt    [B](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.map(f(_))}
  class Longs   [A,B<:Long.Raw]   (x:Stream[A], f: Long   .G.Fun.FromAny[A,B]) extends a.Map.ToLong   [B](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.map(f(_))}
  class Floats  [A,B<:Float.Raw]  (x:Stream[A], f: Float  .G.Fun.FromAny[A,B]) extends a.Map.ToFloat  [B](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.map(f(_))}
  class Doubles [A,B<:Double.Raw] (x:Stream[A], f: Double .G.Fun.FromAny[A,B]) extends a.Map.ToDouble [B](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.map(f(_))}
  class Refs    [A,B]             (x:Stream[A], f: A => B)                     extends a.Map.ToRef    [B](x){ @tn("read_Opt")    def read_?    = x.read_?.map(f(_))}

  inline def apply[A,B,STM<: ~~.AnyType[B]](inline x:Stream[A], inline f: A=>B, inline s:StreamShape[B,STM] ): STM = inline s match
    case _ : StreamShape[B,Boolean.G.~[B & Boolean.Raw]] => Booleans(x,f(_).cast[B & Boolean.Raw])
    case _ : StreamShape[B,Byte   .G.~[B & Byte.Raw   ]] => Bytes   (x,f(_).cast[B & Byte.Raw   ])
    case _ : StreamShape[B,Char   .G.~[B & Char.Raw   ]] => Chars   (x,f(_).cast[B & Char.Raw   ])
    case _ : StreamShape[B,Short  .G.~[B & Short.Raw  ]] => Shorts  (x,f(_).cast[B & Short.Raw  ])
    case _ : StreamShape[B,Int    .G.~[B & Int.Raw    ]] => Ints    (x,f(_).cast[B & Int.Raw    ])
    case _ : StreamShape[B,Long   .G.~[B & Long.Raw   ]] => Longs   (x,f(_).cast[B & Long.Raw   ])
    case _ : StreamShape[B,Float  .G.~[B & Float.Raw  ]] => Floats  (x,f(_).cast[B & Float.Raw  ])
    case _ : StreamShape[B,Double .G.~[B & Double.Raw ]] => Doubles (x,f(_).cast[B & Double.Raw ])
    case _ : StreamShape[B,      Val.~[B]]               => Refs    (x,f(_))

  inline def APPLY[A,B,STM<: ~~.AnyType[B]](inline x: Stream[A], inline f: A=>B, inline s:StreamShape[B,STM]): STM = inline s match
    case _ : StreamShape[B,Boolean.G.~[B & Boolean.Raw]] => {class Booleans(x: Stream[A]) extends a.Map.ToBoolean[B & Boolean.Raw](x){ @tn("readRaw_Opt") def readRaw_? =x.read_?.map(f(_).cast[B & Boolean.Raw])}; Booleans(x)}
    case _ : StreamShape[B,Byte   .G.~[B & Byte.Raw   ]] => {class Bytes   (x: Stream[A]) extends a.Map.ToByte   [B & Byte.Raw   ](x){ @tn("readRaw_Opt") def readRaw_? =x.read_?.map(f(_).cast[B & Byte.Raw   ])}; Bytes(x)   }
    case _ : StreamShape[B,Char   .G.~[B & Char.Raw   ]] => {class Chars   (x: Stream[A]) extends a.Map.ToChar   [B & Char.Raw   ](x){ @tn("readRaw_Opt") def readRaw_? =x.read_?.map(f(_).cast[B & Char.Raw   ])}; Chars(x)   }
    case _ : StreamShape[B,Short  .G.~[B & Short.Raw  ]] => {class Shorts  (x: Stream[A]) extends a.Map.ToShort  [B & Short.Raw  ](x){ @tn("readRaw_Opt") def readRaw_? =x.read_?.map(f(_).cast[B & Short.Raw  ])}; Shorts(x)  }
    case _ : StreamShape[B,Int    .G.~[B & Int.Raw    ]] => {class Ints    (x: Stream[A]) extends a.Map.ToInt    [B & Int.Raw    ](x){ @tn("readRaw_Opt") def readRaw_? =x.read_?.map(f(_).cast[B & Int.Raw    ])}; Ints(x)    }
    case _ : StreamShape[B,Long   .G.~[B & Long.Raw   ]] => {class Longs   (x: Stream[A]) extends a.Map.ToLong   [B & Long.Raw   ](x){ @tn("readRaw_Opt") def readRaw_? =x.read_?.map(f(_).cast[B & Long.Raw   ])}; Longs(x)   }
    case _ : StreamShape[B,Float  .G.~[B & Float.Raw  ]] => {class Floats  (x: Stream[A]) extends a.Map.ToFloat  [B & Float.Raw  ](x){ @tn("readRaw_Opt") def readRaw_? =x.read_?.map(f(_).cast[B & Float.Raw  ])}; Floats(x)  }
    case _ : StreamShape[B,Double .G.~[B & Double.Raw ]] => {class Doubles (x: Stream[A]) extends a.Map.ToDouble [B & Double.Raw ](x){ @tn("readRaw_Opt") def readRaw_? =x.read_?.map(f(_).cast[B & Double.Raw ])}; Doubles(x) }
    case _ : StreamShape[B,      Val.~[B]]               => {class Refs    (x: Stream[A]) extends a.Map.ToRef    [B              ](x){ @tn("read_Opt")    def read_?    =x.read_?.map(f(_))};                       Refs(x)    }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
