package scalqa; package lang; package double; package z; package stream; import language.implicitConversions

import `val`.stream.z.a.Map
import gen.`given`.StreamShape

object map:
  class Booleans[A<:Raw,B<:Boolean.Raw](x: G.~[A], f: G.Fun.ToBooleanRaw[A,B]) extends Map.ToBoolean[B](x){ @tn("readRaw_Opt") def readRaw_? = x.readRaw_?.map(f(_))}
  class Bytes   [A<:Raw,B<:Byte.Raw   ](x: G.~[A], f: G.Fun.ToByteRaw[A,B]   ) extends Map.ToByte   [B](x){ @tn("readRaw_Opt") def readRaw_? = x.readRaw_?.map(f(_))}
  class Chars   [A<:Raw,B<:Char.Raw   ](x: G.~[A], f: G.Fun.ToCharRaw[A,B]   ) extends Map.ToChar   [B](x){ @tn("readRaw_Opt") def readRaw_? = x.readRaw_?.map(f(_))}
  class Shorts  [A<:Raw,B<:Short.Raw  ](x: G.~[A], f: G.Fun.ToShortRaw[A,B]  ) extends Map.ToShort  [B](x){ @tn("readRaw_Opt") def readRaw_? = x.readRaw_?.map(f(_))}
  class Ints    [A<:Raw,B<:Int.Raw    ](x: G.~[A], f: G.Fun.ToIntRaw[A,B]    ) extends Map.ToInt    [B](x){ @tn("readRaw_Opt") def readRaw_? = x.readRaw_?.map(f(_))}
  class Longs   [A<:Raw,B<:Long.Raw   ](x: G.~[A], f: G.Fun.ToLongRaw[A,B]   ) extends Map.ToLong   [B](x){ @tn("readRaw_Opt") def readRaw_? = x.readRaw_?.map(f(_))}
  class Floats  [A<:Raw,B<:Float.Raw  ](x: G.~[A], f: G.Fun.ToFloatRaw[A,B]  ) extends Map.ToFloat  [B](x){ @tn("readRaw_Opt") def readRaw_? = x.readRaw_?.map(f(_))}
  class Doubles [A<:Raw,B<:Double.Raw ](x: G.~[A], f: G.Fun.ToDoubleRaw[A,B] ) extends Map.ToDouble [B](x){ @tn("readRaw_Opt") def readRaw_? = x.readRaw_?.map(f(_))}
  class Refs    [A<:Raw,B             ](x: G.~[A], f: G.Fun.ToAny[A,B]       ) extends Map.ToRef    [B](x){ @tn("read_Opt")    def read_?    = x.readRaw_?.map(f(_))}

  inline def apply[A<:Raw,B,STM<: ~~.AnyType[B]](inline x: G.~[A], inline f: A=>B, inline s:StreamShape[B,STM] ): STM = inline s match
    case _ : StreamShape[B,Boolean.G.~[B & Boolean.Raw]] => Booleans(x,f(_).cast[B & Boolean.Raw])
    case _ : StreamShape[B,Byte   .G.~[B & Byte.Raw   ]] => Bytes   (x,f(_).cast[B & Byte.Raw   ])
    case _ : StreamShape[B,Char   .G.~[B & Char.Raw   ]] => Chars   (x,f(_).cast[B & Char.Raw   ])
    case _ : StreamShape[B,Short  .G.~[B & Short.Raw  ]] => Shorts  (x,f(_).cast[B & Short.Raw  ])
    case _ : StreamShape[B,Int    .G.~[B & Int.Raw    ]] => Ints    (x,f(_).cast[B & Int.Raw    ])
    case _ : StreamShape[B,Long   .G.~[B & Long.Raw   ]] => Longs   (x,f(_).cast[B & Long.Raw   ])
    case _ : StreamShape[B,Float  .G.~[B & Float.Raw  ]] => Floats  (x,f(_).cast[B & Float.Raw  ])
    case _ : StreamShape[B,Double .G.~[B & Double.Raw ]] => Doubles (x,f(_).cast[B & Double.Raw ])
    case _ : StreamShape[B,      Val.~[B]]               => Refs    (x,f(_))

  inline def APPLY[A<:Raw,B,STM<: ~~.AnyType[B]](inline x: G.~[A], inline f: A=>B, inline s:StreamShape[B,STM]): STM = inline s match
    case _ : StreamShape[B,Boolean.G.~[B & Boolean.Raw]] => {class Booleans(x: G.~[A]) extends Map.ToBoolean[B & Boolean.Raw](x){ @tn("readRaw_Opt") def readRaw_? =x.readRaw_?.map(f(_).cast[B & Boolean.Raw])}; Booleans(x)}
    case _ : StreamShape[B,Byte   .G.~[B & Byte.Raw   ]] => {class Bytes   (x: G.~[A]) extends Map.ToByte   [B & Byte.Raw   ](x){ @tn("readRaw_Opt") def readRaw_? =x.readRaw_?.map(f(_).cast[B & Byte.Raw   ])}; Bytes(x)   }
    case _ : StreamShape[B,Char   .G.~[B & Char.Raw   ]] => {class Chars   (x: G.~[A]) extends Map.ToChar   [B & Char.Raw   ](x){ @tn("readRaw_Opt") def readRaw_? =x.readRaw_?.map(f(_).cast[B & Char.Raw   ])}; Chars(x)   }
    case _ : StreamShape[B,Short  .G.~[B & Short.Raw  ]] => {class Shorts  (x: G.~[A]) extends Map.ToShort  [B & Short.Raw  ](x){ @tn("readRaw_Opt") def readRaw_? =x.readRaw_?.map(f(_).cast[B & Short.Raw  ])}; Shorts(x)  }
    case _ : StreamShape[B,Int    .G.~[B & Int.Raw    ]] => {class Ints    (x: G.~[A]) extends Map.ToInt    [B & Int.Raw    ](x){ @tn("readRaw_Opt") def readRaw_? =x.readRaw_?.map(f(_).cast[B & Int.Raw    ])}; Ints(x)    }
    case _ : StreamShape[B,Long   .G.~[B & Long.Raw   ]] => {class Longs   (x: G.~[A]) extends Map.ToLong   [B & Long.Raw   ](x){ @tn("readRaw_Opt") def readRaw_? =x.readRaw_?.map(f(_).cast[B & Long.Raw   ])}; Longs(x)   }
    case _ : StreamShape[B,Float  .G.~[B & Float.Raw  ]] => {class Floats  (x: G.~[A]) extends Map.ToFloat  [B & Float.Raw  ](x){ @tn("readRaw_Opt") def readRaw_? =x.readRaw_?.map(f(_).cast[B & Float.Raw  ])}; Floats(x)  }
    case _ : StreamShape[B,Double .G.~[B & Double.Raw ]] => {class Doubles (x: G.~[A]) extends Map.ToDouble [B & Double.Raw ](x){ @tn("readRaw_Opt") def readRaw_? =x.readRaw_?.map(f(_).cast[B & Double.Raw ])}; Doubles(x) }
    case _ : StreamShape[B,      Val.~[B]]               => {class Refs    (x: G.~[A]) extends Map.ToRef    [B              ](x){ @tn("read_Opt")    def read_?    =x.readRaw_?.map(f(_))};                       Refs(x)    }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
