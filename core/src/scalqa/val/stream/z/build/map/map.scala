package scalqa; package `val`; package stream; package z; package build; package map; import language.implicitConversions

import Gen.Given.StreamTag

object map:
  class Booleans[A,B<:Raw.Boolean](x:Stream[A], f: Boolean.G.Fun.FromAny[A,B]) extends a.Map.ToBoolean[B](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.map(f(_))}
  class Bytes   [A,B<:Raw.Byte]   (x:Stream[A], f: Byte   .G.Fun.FromAny[A,B]) extends a.Map.ToByte   [B](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.map(f(_))}
  class Chars   [A,B<:Raw.Char]   (x:Stream[A], f: Char   .G.Fun.FromAny[A,B]) extends a.Map.ToChar   [B](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.map(f(_))}
  class Shorts  [A,B<:Raw.Short]  (x:Stream[A], f: Short  .G.Fun.FromAny[A,B]) extends a.Map.ToShort  [B](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.map(f(_))}
  class Ints    [A,B<:Raw.Int]    (x:Stream[A], f: Int    .G.Fun.FromAny[A,B]) extends a.Map.ToInt    [B](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.map(f(_))}
  class Longs   [A,B<:Raw.Long]   (x:Stream[A], f: Long   .G.Fun.FromAny[A,B]) extends a.Map.ToLong   [B](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.map(f(_))}
  class Floats  [A,B<:Raw.Float]  (x:Stream[A], f: Float  .G.Fun.FromAny[A,B]) extends a.Map.ToFloat  [B](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.map(f(_))}
  class Doubles [A,B<:Raw.Double] (x:Stream[A], f: Double .G.Fun.FromAny[A,B]) extends a.Map.ToDouble [B](x){ @tn("readRaw_Opt") def readRaw_? = x.read_?.map(f(_))}
  class Refs    [A,B]             (x:Stream[A], f: A => B)                     extends a.Map.ToRef    [B](x){ @tn("read_Opt")    def read_?    = x.read_?.map(f(_))}

  inline def apply[A,B,STM<: ~~.AnyType[B]](inline x:Stream[A], inline f: A=>B, inline s:StreamTag[B,STM] ): STM = inline s match
    case _ : StreamTag[B,Boolean.G.~[B & Raw.Boolean]] => Booleans(x,f(_).cast[B & Raw.Boolean])
    case _ : StreamTag[B,Byte   .G.~[B & Raw.Byte   ]] => Bytes   (x,f(_).cast[B & Raw.Byte   ])
    case _ : StreamTag[B,Char   .G.~[B & Raw.Char   ]] => Chars   (x,f(_).cast[B & Raw.Char   ])
    case _ : StreamTag[B,Short  .G.~[B & Raw.Short  ]] => Shorts  (x,f(_).cast[B & Raw.Short  ])
    case _ : StreamTag[B,Int    .G.~[B & Raw.Int    ]] => Ints    (x,f(_).cast[B & Raw.Int    ])
    case _ : StreamTag[B,Long   .G.~[B & Raw.Long   ]] => Longs   (x,f(_).cast[B & Raw.Long   ])
    case _ : StreamTag[B,Float  .G.~[B & Raw.Float  ]] => Floats  (x,f(_).cast[B & Raw.Float  ])
    case _ : StreamTag[B,Double .G.~[B & Raw.Double ]] => Doubles (x,f(_).cast[B & Raw.Double ])
    case _ : StreamTag[B,      Val.~[B]]               => Refs    (x,f(_))

  inline def APPLY[A,B,STM<: ~~.AnyType[B]](inline x: Stream[A], inline f: A=>B, inline s:StreamTag[B,STM]): STM = inline s match
    case _ : StreamTag[B,Boolean.G.~[B & Raw.Boolean]] => {class Booleans(x: Stream[A]) extends a.Map.ToBoolean[B & Raw.Boolean](x){ @tn("readRaw_Opt") def readRaw_? =x.read_?.map(f(_).cast[B & Raw.Boolean])}; Booleans(x)}
    case _ : StreamTag[B,Byte   .G.~[B & Raw.Byte   ]] => {class Bytes   (x: Stream[A]) extends a.Map.ToByte   [B & Raw.Byte   ](x){ @tn("readRaw_Opt") def readRaw_? =x.read_?.map(f(_).cast[B & Raw.Byte   ])}; Bytes(x)   }
    case _ : StreamTag[B,Char   .G.~[B & Raw.Char   ]] => {class Chars   (x: Stream[A]) extends a.Map.ToChar   [B & Raw.Char   ](x){ @tn("readRaw_Opt") def readRaw_? =x.read_?.map(f(_).cast[B & Raw.Char   ])}; Chars(x)   }
    case _ : StreamTag[B,Short  .G.~[B & Raw.Short  ]] => {class Shorts  (x: Stream[A]) extends a.Map.ToShort  [B & Raw.Short  ](x){ @tn("readRaw_Opt") def readRaw_? =x.read_?.map(f(_).cast[B & Raw.Short  ])}; Shorts(x)  }
    case _ : StreamTag[B,Int    .G.~[B & Raw.Int    ]] => {class Ints    (x: Stream[A]) extends a.Map.ToInt    [B & Raw.Int    ](x){ @tn("readRaw_Opt") def readRaw_? =x.read_?.map(f(_).cast[B & Raw.Int    ])}; Ints(x)    }
    case _ : StreamTag[B,Long   .G.~[B & Raw.Long   ]] => {class Longs   (x: Stream[A]) extends a.Map.ToLong   [B & Raw.Long   ](x){ @tn("readRaw_Opt") def readRaw_? =x.read_?.map(f(_).cast[B & Raw.Long   ])}; Longs(x)   }
    case _ : StreamTag[B,Float  .G.~[B & Raw.Float  ]] => {class Floats  (x: Stream[A]) extends a.Map.ToFloat  [B & Raw.Float  ](x){ @tn("readRaw_Opt") def readRaw_? =x.read_?.map(f(_).cast[B & Raw.Float  ])}; Floats(x)  }
    case _ : StreamTag[B,Double .G.~[B & Raw.Double ]] => {class Doubles (x: Stream[A]) extends a.Map.ToDouble [B & Raw.Double ](x){ @tn("readRaw_Opt") def readRaw_? =x.read_?.map(f(_).cast[B & Raw.Double ])}; Doubles(x) }
    case _ : StreamTag[B,      Val.~[B]]               => {class Refs    (x: Stream[A]) extends a.Map.ToRef    [B              ](x){ @tn("read_Opt")    def read_?    =x.read_?.map(f(_))};                       Refs(x)    }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
