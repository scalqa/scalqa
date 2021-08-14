package scalqa; package lang; package int; package z; package stream; import language.implicitConversions

import `val`.stream.z.a.Map
import gen.`given`.StreamShape

class  map       [A<:Raw,B             ](x: G.~[A], f: G.Fun.ToAny[A,B]       ) extends Map.ToRef    [B](x){ @tn("read_Opt")    def read_?    = x.readRaw_?.map(f(_))}
object map:
  class toBoolean[A<:Raw,B<:Boolean.Raw](x: G.~[A], f: G.Fun.ToBooleanRaw[A,B]) extends Map.ToBoolean[B](x){ @tn("readRaw_Opt") def readRaw_? = x.readRaw_?.map(f(_))}
  class toByte   [A<:Raw,B<:Byte.Raw   ](x: G.~[A], f: G.Fun.ToByteRaw[A,B]   ) extends Map.ToByte   [B](x){ @tn("readRaw_Opt") def readRaw_? = x.readRaw_?.map(f(_))}
  class toChar   [A<:Raw,B<:Char.Raw   ](x: G.~[A], f: G.Fun.ToCharRaw[A,B]   ) extends Map.ToChar   [B](x){ @tn("readRaw_Opt") def readRaw_? = x.readRaw_?.map(f(_))}
  class toShort  [A<:Raw,B<:Short.Raw  ](x: G.~[A], f: G.Fun.ToShortRaw[A,B]  ) extends Map.ToShort  [B](x){ @tn("readRaw_Opt") def readRaw_? = x.readRaw_?.map(f(_))}
  class toInt    [A<:Raw,B<:Int.Raw    ](x: G.~[A], f: G.Fun.ToIntRaw[A,B]    ) extends Map.ToInt    [B](x){ @tn("readRaw_Opt") def readRaw_? = x.readRaw_?.map(f(_))}
  class toLong   [A<:Raw,B<:Long.Raw   ](x: G.~[A], f: G.Fun.ToLongRaw[A,B]   ) extends Map.ToLong   [B](x){ @tn("readRaw_Opt") def readRaw_? = x.readRaw_?.map(f(_))}
  class toFloat  [A<:Raw,B<:Float.Raw  ](x: G.~[A], f: G.Fun.ToFloatRaw[A,B]  ) extends Map.ToFloat  [B](x){ @tn("readRaw_Opt") def readRaw_? = x.readRaw_?.map(f(_))}
  class toDouble [A<:Raw,B<:Double.Raw ](x: G.~[A], f: G.Fun.ToDoubleRaw[A,B] ) extends Map.ToDouble [B](x){ @tn("readRaw_Opt") def readRaw_? = x.readRaw_?.map(f(_))}

  inline def apply[A<:Raw,B,STM<: ~~.AnyType[B]](inline x: G.~[A], inline f: A=>B, inline s:StreamShape[B,STM] ): STM = inline s match
    case _ : StreamShape[B,Boolean.G.~[B & Boolean.Raw]] => new toBoolean(x,f(_).cast[B & Boolean.Raw])
    case _ : StreamShape[B,Byte   .G.~[B & Byte.Raw   ]] => new toByte   (x,f(_).cast[B & Byte.Raw   ])
    case _ : StreamShape[B,Char   .G.~[B & Char.Raw   ]] => new toChar   (x,f(_).cast[B & Char.Raw   ])
    case _ : StreamShape[B,Short  .G.~[B & Short.Raw  ]] => new toShort  (x,f(_).cast[B & Short.Raw  ])
    case _ : StreamShape[B,Int    .G.~[B & Int.Raw    ]] => new toInt    (x,f(_).cast[B & Int.Raw    ])
    case _ : StreamShape[B,Long   .G.~[B & Long.Raw   ]] => new toLong   (x,f(_).cast[B & Long.Raw   ])
    case _ : StreamShape[B,Float  .G.~[B & Float.Raw  ]] => new toFloat  (x,f(_).cast[B & Float.Raw  ])
    case _ : StreamShape[B,Double .G.~[B & Double.Raw ]] => new toDouble (x,f(_).cast[B & Double.Raw ])
    case _ : StreamShape[B,AnyRef .G.~[B]]               => new map      (x,f(_))

  inline def APPLY[A<:Raw,B,STM<: ~~.AnyType[B]](inline x: G.~[A], inline f: A=>B, inline s:StreamShape[B,STM]): STM = inline s match
    case _ : StreamShape[B,Boolean.G.~[B & Boolean.Raw]] => {class mapToBoolean(x: G.~[A]) extends Map.ToBoolean[B & Boolean.Raw](x){ @tn("readRaw_Opt") def readRaw_? =x.readRaw_?.map(f(_).cast[B & Boolean.Raw])}; new mapToBoolean(x)}
    case _ : StreamShape[B,Byte   .G.~[B & Byte.Raw   ]] => {class mapToByte   (x: G.~[A]) extends Map.ToByte   [B & Byte.Raw   ](x){ @tn("readRaw_Opt") def readRaw_? =x.readRaw_?.map(f(_).cast[B & Byte.Raw   ])}; new mapToByte(x)   }
    case _ : StreamShape[B,Char   .G.~[B & Char.Raw   ]] => {class mapToChar   (x: G.~[A]) extends Map.ToChar   [B & Char.Raw   ](x){ @tn("readRaw_Opt") def readRaw_? =x.readRaw_?.map(f(_).cast[B & Char.Raw   ])}; new mapToChar(x)   }
    case _ : StreamShape[B,Short  .G.~[B & Short.Raw  ]] => {class mapToShort  (x: G.~[A]) extends Map.ToShort  [B & Short.Raw  ](x){ @tn("readRaw_Opt") def readRaw_? =x.readRaw_?.map(f(_).cast[B & Short.Raw  ])}; new mapToShort(x)  }
    case _ : StreamShape[B,Int    .G.~[B & Int.Raw    ]] => {class mapToInt    (x: G.~[A]) extends Map.ToInt    [B & Int.Raw    ](x){ @tn("readRaw_Opt") def readRaw_? =x.readRaw_?.map(f(_).cast[B & Int.Raw    ])}; new mapToInt(x)    }
    case _ : StreamShape[B,Long   .G.~[B & Long.Raw   ]] => {class mapToLong   (x: G.~[A]) extends Map.ToLong   [B & Long.Raw   ](x){ @tn("readRaw_Opt") def readRaw_? =x.readRaw_?.map(f(_).cast[B & Long.Raw   ])}; new mapToLong(x)   }
    case _ : StreamShape[B,Float  .G.~[B & Float.Raw  ]] => {class mapToFloat  (x: G.~[A]) extends Map.ToFloat  [B & Float.Raw  ](x){ @tn("readRaw_Opt") def readRaw_? =x.readRaw_?.map(f(_).cast[B & Float.Raw  ])}; new mapToFloat(x)  }
    case _ : StreamShape[B,Double .G.~[B & Double.Raw ]] => {class mapToDouble (x: G.~[A]) extends Map.ToDouble [B & Double.Raw ](x){ @tn("readRaw_Opt") def readRaw_? =x.readRaw_?.map(f(_).cast[B & Double.Raw ])}; new mapToDouble(x) }
    case _ : StreamShape[B,AnyRef .G.~[B]]               => {class map         (x: G.~[A]) extends Map.ToRef    [B              ](x){ @tn("read_Opt")    def read_?    =x.readRaw_?.map(f(_))};                       new map(x)         }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
