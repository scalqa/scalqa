package scalqa; package lang; package byte; package z; package stream; import language.implicitConversions

import `val`.stream.z.a.Pipe
import lang.any.{Raw as RAW}
import gen.`given`.StreamTag

object mapOpt:
  class Booleans[A<:RAW,B<:RAW.Boolean](x: ~[A], f:Byte  .G.Fun.FromAny[A,Boolean.G.Opt[B]]) extends Pipe.Booleans[B](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){ val r=f(o.`val`); if(r.nonEmpty) return r; o=x.read_? }; \/}}
  class Bytes   [A<:RAW,B<:RAW.Byte]   (x: ~[A], f:Short .G.Fun.FromAny[A,Byte   .G.Opt[B]]) extends Pipe.Bytes   [B](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){ val r=f(o.`val`); if(r.nonEmpty) return r; o=x.read_? }; \/}}
  class Chars   [A<:RAW,B<:RAW.Char]   (x: ~[A], f:Int   .G.Fun.FromAny[A,Char   .G.Opt[B]]) extends Pipe.Chars   [B](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){ val r=f(o.`val`); if(r.nonEmpty) return r; o=x.read_? }; \/}}
  class Shorts  [A<:RAW,B<:RAW.Short]  (x: ~[A], f:Int   .G.Fun.FromAny[A,Short  .G.Opt[B]]) extends Pipe.Shorts  [B](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){ val r=f(o.`val`); if(r.nonEmpty) return r; o=x.read_? }; \/}}
  class Ints    [A<:RAW,B<:RAW.Int]    (x: ~[A], f:Long  .G.Fun.FromAny[A,Int    .G.Opt[B]]) extends Pipe.Ints    [B](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){ val r=f(o.`val`); if(r.nonEmpty) return r; o=x.read_? }; \/}}
  class Longs   [A<:RAW,B<:RAW.Long]   (x: ~[A], f:Long  .G.Fun.FromAny[A,Long   .G.Opt[B]]) extends Pipe.Longs   [B](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){ val r=f(o.`val`); if(r.nonEmpty) return r; o=x.read_? }; \/}}
  class Floats  [A<:RAW,B<:RAW.Float]  (x: ~[A], f:Float .G.Fun.FromAny[A,Float  .G.Opt[B]]) extends Pipe.Floats  [B](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){ val r=f(o.`val`); if(r.nonEmpty) return r; o=x.read_? }; \/}}
  class Doubles [A<:RAW,B<:RAW.Double] (x: ~[A], f:Double.G.Fun.FromAny[A,Double .G.Opt[B]]) extends Pipe.Doubles [B](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){ val r=f(o.`val`); if(r.nonEmpty) return r; o=x.read_? }; \/}}
  class Refs    [A<:RAW,B]             (x: ~[A], f: A => Val.Opt[B]                        ) extends Pipe.Ref     [B](x){@tn("read_Opt")    def read_?    ={var o=x.read_?; while(o.nonEmpty){ val r=f(o.`val`); if(r.nonEmpty) return r; o=x.read_? }; \/}}

  inline def apply[A<:RAW,B,STM<: ~~.AnyType[B],OPT<:Val.Opt.AnyType[B]](inline x: ~[A], inline f: A => OPT, inline s:StreamTag.Opt[B,OPT,STM]): STM =
    type BB=B&Raw.Boolean;type BY=B&Raw.Byte;type BC=B&Raw.Char;type BS=B&Raw.Short;type BI=B&Raw.Int;type BL=B&Raw.Long;type BF=B&Raw.Float;type BD=B&Raw.Double
    inline s match
      case _ : StreamTag.Opt[B,Boolean.G.Opt[BB],Boolean.G.~[BB]] => Booleans(x,v => f(v).cast[Boolean.G.Opt[BB]])
      case _ : StreamTag.Opt[B,Byte   .G.Opt[BY],Byte   .G.~[BY]] => Bytes   (x,v => f(v).cast[Byte   .G.Opt[BY]])
      case _ : StreamTag.Opt[B,Char   .G.Opt[BC],Char   .G.~[BC]] => Chars   (x,v => f(v).cast[Char   .G.Opt[BC]])
      case _ : StreamTag.Opt[B,Short  .G.Opt[BS],Short  .G.~[BS]] => Shorts  (x,v => f(v).cast[Short  .G.Opt[BS]])
      case _ : StreamTag.Opt[B,Int    .G.Opt[BI],Int    .G.~[BI]] => Ints    (x,v => f(v).cast[Int    .G.Opt[BI]])
      case _ : StreamTag.Opt[B,Long   .G.Opt[BL],Long   .G.~[BL]] => Longs   (x,v => f(v).cast[Long   .G.Opt[BL]])
      case _ : StreamTag.Opt[B,Float  .G.Opt[BF],Float  .G.~[BF]] => Floats  (x,v => f(v).cast[Float  .G.Opt[BF]])
      case _ : StreamTag.Opt[B,Double .G.Opt[BD],Double .G.~[BD]] => Doubles (x,v => f(v).cast[Double .G.Opt[BD]])
      case _ : StreamTag.Opt[B,      Val.Opt[BB],Boolean.G.~[BB]] => Booleans(x,v => f(v).cast[Opt[BB]].raw)
      case _ : StreamTag.Opt[B,      Val.Opt[BY],Byte   .G.~[BY]] => Bytes   (x,v => f(v).cast[Opt[BY]].raw)
      case _ : StreamTag.Opt[B,      Val.Opt[BC],Char   .G.~[BC]] => Chars   (x,v => f(v).cast[Opt[BC]].raw)
      case _ : StreamTag.Opt[B,      Val.Opt[BS],Short  .G.~[BS]] => Shorts  (x,v => f(v).cast[Opt[BS]].raw)
      case _ : StreamTag.Opt[B,      Val.Opt[BI],Int    .G.~[BI]] => Ints    (x,v => f(v).cast[Opt[BI]].raw)
      case _ : StreamTag.Opt[B,      Val.Opt[BL],Long   .G.~[BL]] => Longs   (x,v => f(v).cast[Opt[BL]].raw)
      case _ : StreamTag.Opt[B,      Val.Opt[BF],Float  .G.~[BF]] => Floats  (x,v => f(v).cast[Opt[BF]].raw)
      case _ : StreamTag.Opt[B,      Val.Opt[BD],Double .G.~[BD]] => Doubles (x,v => f(v).cast[Opt[BD]].raw)
      case _ : StreamTag.Opt[B,      Val.Opt[B ],      Val.~[B ]] => Refs    (x,v => f(v).cast[Opt[B ]])

  inline def APPLY[A<:RAW,B,STM<: ~~.AnyType[B],OPT<:Val.Opt.AnyType[B]](inline x: ~[A], inline f: A => OPT, inline s:StreamTag.Opt[B,OPT,STM]): STM =
    type BB=B&Raw.Boolean;type BY=B&Raw.Byte;type BC=B&Raw.Char;type BS=B&Raw.Short;type BI=B&Raw.Int;type BL=B&Raw.Long;type BF=B&Raw.Float;type BD=B&Raw.Double
    inline s match
      case _ : StreamTag.Opt[B,Boolean.G.Opt[BB],Boolean.G.~[BB]] => {class Booleans(x: ~[A]) extends Pipe.Booleans[BB](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[Boolean.G.Opt[BB]]; if(r.nonEmpty) return r; o=x.read_? }; \/}}; Booleans(x)}
      case _ : StreamTag.Opt[B,Byte   .G.Opt[BY],Byte   .G.~[BY]] => {class Bytes   (x: ~[A]) extends Pipe.Bytes   [BY](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[Byte   .G.Opt[BY]]; if(r.nonEmpty) return r; o=x.read_? }; \/}}; Bytes   (x)}
      case _ : StreamTag.Opt[B,Char   .G.Opt[BC],Char   .G.~[BC]] => {class Chars   (x: ~[A]) extends Pipe.Chars   [BC](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[Char   .G.Opt[BC]]; if(r.nonEmpty) return r; o=x.read_? }; \/}}; Chars   (x)}
      case _ : StreamTag.Opt[B,Short  .G.Opt[BS],Short  .G.~[BS]] => {class Shorts  (x: ~[A]) extends Pipe.Shorts  [BS](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[Short  .G.Opt[BS]]; if(r.nonEmpty) return r; o=x.read_? }; \/}}; Shorts  (x)}
      case _ : StreamTag.Opt[B,Int    .G.Opt[BI],Int    .G.~[BI]] => {class Ints    (x: ~[A]) extends Pipe.Ints    [BI](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[Int    .G.Opt[BI]]; if(r.nonEmpty) return r; o=x.read_? }; \/}}; Ints    (x)}
      case _ : StreamTag.Opt[B,Long   .G.Opt[BL],Long   .G.~[BL]] => {class Longs   (x: ~[A]) extends Pipe.Longs   [BL](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[Long   .G.Opt[BL]]; if(r.nonEmpty) return r; o=x.read_? }; \/}}; Longs   (x)}
      case _ : StreamTag.Opt[B,Float  .G.Opt[BF],Float  .G.~[BF]] => {class Floats  (x: ~[A]) extends Pipe.Floats  [BF](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[Float  .G.Opt[BF]]; if(r.nonEmpty) return r; o=x.read_? }; \/}}; Floats  (x)}
      case _ : StreamTag.Opt[B,Double .G.Opt[BD],Double .G.~[BD]] => {class Doubles (x: ~[A]) extends Pipe.Doubles [BD](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[Double .G.Opt[BD]]; if(r.nonEmpty) return r; o=x.read_? }; \/}}; Doubles (x)}
      case _ : StreamTag.Opt[B,      Val.Opt[BB],Boolean.G.~[BB]] => {class Booleans(x: ~[A]) extends Pipe.Booleans[BB](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[  Val.Opt[BB]].raw; if(r.nonEmpty) return r; o=x.read_? }; \/}}; Booleans(x)}
      case _ : StreamTag.Opt[B,      Val.Opt[BY],Byte   .G.~[BY]] => {class Bytes   (x: ~[A]) extends Pipe.Bytes   [BY](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[  Val.Opt[BY]].raw; if(r.nonEmpty) return r; o=x.read_? }; \/}}; Bytes   (x)}
      case _ : StreamTag.Opt[B,      Val.Opt[BC],Char   .G.~[BC]] => {class Chars   (x: ~[A]) extends Pipe.Chars   [BC](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[  Val.Opt[BC]].raw; if(r.nonEmpty) return r; o=x.read_? }; \/}}; Chars   (x)}
      case _ : StreamTag.Opt[B,      Val.Opt[BS],Short  .G.~[BS]] => {class Shorts  (x: ~[A]) extends Pipe.Shorts  [BS](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[  Val.Opt[BS]].raw; if(r.nonEmpty) return r; o=x.read_? }; \/}}; Shorts  (x)}
      case _ : StreamTag.Opt[B,      Val.Opt[BI],Int    .G.~[BI]] => {class Ints    (x: ~[A]) extends Pipe.Ints    [BI](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[  Val.Opt[BI]].raw; if(r.nonEmpty) return r; o=x.read_? }; \/}}; Ints    (x)}
      case _ : StreamTag.Opt[B,      Val.Opt[BL],Long   .G.~[BL]] => {class Longs   (x: ~[A]) extends Pipe.Longs   [BL](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[  Val.Opt[BL]].raw; if(r.nonEmpty) return r; o=x.read_? }; \/}}; Longs   (x)}
      case _ : StreamTag.Opt[B,      Val.Opt[BF],Float  .G.~[BF]] => {class Floats  (x: ~[A]) extends Pipe.Floats  [BF](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[  Val.Opt[BF]].raw; if(r.nonEmpty) return r; o=x.read_? }; \/}}; Floats  (x)}
      case _ : StreamTag.Opt[B,      Val.Opt[BD],Double .G.~[BD]] => {class Doubles (x: ~[A]) extends Pipe.Doubles [BD](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[  Val.Opt[BD]].raw; if(r.nonEmpty) return r; o=x.read_? }; \/}}; Doubles (x)}
      case _ : StreamTag.Opt[B,      Val.Opt[B ],      Val.~[B ]] => {class Refs    (x: ~[A]) extends Pipe.Ref     [B ](x){@tn("read_Opt")    def read_?    ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[  Val.Opt[B]];      if(r.nonEmpty) return r; o=x.read_? }; \/}}; Refs    (x)}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
