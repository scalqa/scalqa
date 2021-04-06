package scalqa; package lang; package byte; package z; package stream; import language.implicitConversions

import `val`.stream.z.a.Map
import Shape.OfStream.Any

object map:
  class Booleans[A<:RAW,B<:Raw.Boolean](x: G.~[A], f: G.Fun.ToRawBoolean[A,B]) extends Map.ToBoolean[B](x){ @tn("readRaw_Opt") def readRaw_? = x.readRaw_?.map(f(_))}
  class Bytes   [A<:RAW,B<:Raw.Byte   ](x: G.~[A], f: G.Fun.ToRawByte[A,B]   ) extends Map.ToByte   [B](x){ @tn("readRaw_Opt") def readRaw_? = x.readRaw_?.map(f(_))}
  class Chars   [A<:RAW,B<:Raw.Char   ](x: G.~[A], f: G.Fun.ToRawChar[A,B]   ) extends Map.ToChar   [B](x){ @tn("readRaw_Opt") def readRaw_? = x.readRaw_?.map(f(_))}
  class Shorts  [A<:RAW,B<:Raw.Short  ](x: G.~[A], f: G.Fun.ToRawShort[A,B]  ) extends Map.ToShort  [B](x){ @tn("readRaw_Opt") def readRaw_? = x.readRaw_?.map(f(_))}
  class Ints    [A<:RAW,B<:Raw.Int    ](x: G.~[A], f: G.Fun.ToRawInt[A,B]    ) extends Map.ToInt    [B](x){ @tn("readRaw_Opt") def readRaw_? = x.readRaw_?.map(f(_))}
  class Longs   [A<:RAW,B<:Raw.Long   ](x: G.~[A], f: G.Fun.ToRawLong[A,B]   ) extends Map.ToLong   [B](x){ @tn("readRaw_Opt") def readRaw_? = x.readRaw_?.map(f(_))}
  class Floats  [A<:RAW,B<:Raw.Float  ](x: G.~[A], f: G.Fun.ToRawFloat[A,B]  ) extends Map.ToFloat  [B](x){ @tn("readRaw_Opt") def readRaw_? = x.readRaw_?.map(f(_))}
  class Doubles [A<:RAW,B<:Raw.Double ](x: G.~[A], f: G.Fun.ToRawDouble[A,B] ) extends Map.ToDouble [B](x){ @tn("readRaw_Opt") def readRaw_? = x.readRaw_?.map(f(_))}
  class Refs    [A<:RAW,B             ](x: G.~[A], f: G.Fun.ToAny[A,B]       ) extends Map.ToRef    [B](x){ @tn("read_Opt")    def read_?    = x.readRaw_?.map(f(_))}

  inline def apply[A<:RAW,B,STM<:Any[B]](inline x: G.~[A], inline f: A=>B, inline s:Any.Def[B,STM] ): STM = inline s match
    case _ : Any.Def[B,Boolean.G.~[B & Raw.Boolean]] => Booleans(x,f(_).cast[B & Raw.Boolean])
    case _ : Any.Def[B,Byte   .G.~[B & Raw.Byte   ]] => Bytes   (x,f(_).cast[B & Raw.Byte   ])
    case _ : Any.Def[B,Char   .G.~[B & Raw.Char   ]] => Chars   (x,f(_).cast[B & Raw.Char   ])
    case _ : Any.Def[B,Short  .G.~[B & Raw.Short  ]] => Shorts  (x,f(_).cast[B & Raw.Short  ])
    case _ : Any.Def[B,Int    .G.~[B & Raw.Int    ]] => Ints    (x,f(_).cast[B & Raw.Int    ])
    case _ : Any.Def[B,Long   .G.~[B & Raw.Long   ]] => Longs   (x,f(_).cast[B & Raw.Long   ])
    case _ : Any.Def[B,Float  .G.~[B & Raw.Float  ]] => Floats  (x,f(_).cast[B & Raw.Float  ])
    case _ : Any.Def[B,Double .G.~[B & Raw.Double ]] => Doubles (x,f(_).cast[B & Raw.Double ])
    case _ : Any.Def[B,      Val.~[B]]               => Refs    (x,f(_))

  inline def APPLY[A<:RAW,B,STM<:Any[B]](inline x: G.~[A], inline f: A=>B, inline s:Any.Def[B,STM]): STM = inline s match
    case _ : Any.Def[B,Boolean.G.~[B & Raw.Boolean]] => {class Booleans(x: G.~[A]) extends Map.ToBoolean[B & Raw.Boolean](x){ @tn("readRaw_Opt") def readRaw_? =x.readRaw_?.map(f(_).cast[B & Raw.Boolean])}; Booleans(x)}
    case _ : Any.Def[B,Byte   .G.~[B & Raw.Byte   ]] => {class Bytes   (x: G.~[A]) extends Map.ToByte   [B & Raw.Byte   ](x){ @tn("readRaw_Opt") def readRaw_? =x.readRaw_?.map(f(_).cast[B & Raw.Byte   ])}; Bytes(x)   }
    case _ : Any.Def[B,Char   .G.~[B & Raw.Char   ]] => {class Chars   (x: G.~[A]) extends Map.ToChar   [B & Raw.Char   ](x){ @tn("readRaw_Opt") def readRaw_? =x.readRaw_?.map(f(_).cast[B & Raw.Char   ])}; Chars(x)   }
    case _ : Any.Def[B,Short  .G.~[B & Raw.Short  ]] => {class Shorts  (x: G.~[A]) extends Map.ToShort  [B & Raw.Short  ](x){ @tn("readRaw_Opt") def readRaw_? =x.readRaw_?.map(f(_).cast[B & Raw.Short  ])}; Shorts(x)  }
    case _ : Any.Def[B,Int    .G.~[B & Raw.Int    ]] => {class Ints    (x: G.~[A]) extends Map.ToInt    [B & Raw.Int    ](x){ @tn("readRaw_Opt") def readRaw_? =x.readRaw_?.map(f(_).cast[B & Raw.Int    ])}; Ints(x)    }
    case _ : Any.Def[B,Long   .G.~[B & Raw.Long   ]] => {class Longs   (x: G.~[A]) extends Map.ToLong   [B & Raw.Long   ](x){ @tn("readRaw_Opt") def readRaw_? =x.readRaw_?.map(f(_).cast[B & Raw.Long   ])}; Longs(x)   }
    case _ : Any.Def[B,Float  .G.~[B & Raw.Float  ]] => {class Floats  (x: G.~[A]) extends Map.ToFloat  [B & Raw.Float  ](x){ @tn("readRaw_Opt") def readRaw_? =x.readRaw_?.map(f(_).cast[B & Raw.Float  ])}; Floats(x)  }
    case _ : Any.Def[B,Double .G.~[B & Raw.Double ]] => {class Doubles (x: G.~[A]) extends Map.ToDouble [B & Raw.Double ](x){ @tn("readRaw_Opt") def readRaw_? =x.readRaw_?.map(f(_).cast[B & Raw.Double ])}; Doubles(x) }
    case _ : Any.Def[B,      Val.~[B]]               => {class Refs    (x: G.~[A]) extends Map.ToRef    [B              ](x){ @tn("read_Opt")    def read_?    =x.readRaw_?.map(f(_))};                       Refs(x)    }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
