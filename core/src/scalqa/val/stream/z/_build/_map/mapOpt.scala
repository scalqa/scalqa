package scalqa; package `val`; package stream; package z; package _build; package _map; import language.implicitConversions;

import gen.`given`.StreamShape.{ Opt as SHAPE}

class mapOpt     [A,B]             (x: ~[A], f: A => Val.Opt[B]                        ) extends a.Pipe.ofRef    [B](x){@tn("read_Opt")    def read_?    ={var o=x.read_?; while(o.nonEmpty){ val r=f(o.`val`); if(r.nonEmpty) return r; o=x.read_? }; \/}}

object mapOpt:
  class toBoolean[A,B<:Boolean.Raw](x: ~[A], f:Byte  .G.Fun.FromAny[A,Boolean.G.Opt[B]]) extends a.Pipe.ofBoolean[B](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){ val r=f(o.`val`); if(r.nonEmpty) return r; o=x.read_? }; \/}}
  class toByte   [A,B<:Byte.Raw]   (x: ~[A], f:Short .G.Fun.FromAny[A,Byte   .G.Opt[B]]) extends a.Pipe.ofByte   [B](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){ val r=f(o.`val`); if(r.nonEmpty) return r; o=x.read_? }; \/}}
  class toChar   [A,B<:Char.Raw]   (x: ~[A], f:Int   .G.Fun.FromAny[A,Char   .G.Opt[B]]) extends a.Pipe.ofChar   [B](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){ val r=f(o.`val`); if(r.nonEmpty) return r; o=x.read_? }; \/}}
  class toShort  [A,B<:Short.Raw]  (x: ~[A], f:Int   .G.Fun.FromAny[A,Short  .G.Opt[B]]) extends a.Pipe.ofShort  [B](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){ val r=f(o.`val`); if(r.nonEmpty) return r; o=x.read_? }; \/}}
  class toInt    [A,B<:Int.Raw]    (x: ~[A], f:Long  .G.Fun.FromAny[A,Int    .G.Opt[B]]) extends a.Pipe.ofInt    [B](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){ val r=f(o.`val`); if(r.nonEmpty) return r; o=x.read_? }; \/}}
  class toLong   [A,B<:Long.Raw]   (x: ~[A], f:Long  .G.Fun.FromAny[A,Long   .G.Opt[B]]) extends a.Pipe.ofLong   [B](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){ val r=f(o.`val`); if(r.nonEmpty) return r; o=x.read_? }; \/}}
  class toFloat  [A,B<:Float.Raw]  (x: ~[A], f:Float .G.Fun.FromAny[A,Float  .G.Opt[B]]) extends a.Pipe.ofFloat  [B](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){ val r=f(o.`val`); if(r.nonEmpty) return r; o=x.read_? }; \/}}
  class toDouble [A,B<:Double.Raw] (x: ~[A], f:Double.G.Fun.FromAny[A,Double .G.Opt[B]]) extends a.Pipe.ofDouble [B](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){ val r=f(o.`val`); if(r.nonEmpty) return r; o=x.read_? }; \/}}

  inline def apply[A,B,STM<: ~~.AnyType[B],OPT<:Val.Opt.AnyType[B]](inline x: ~[A], inline f: A => OPT, inline s:SHAPE[B,OPT,STM]): STM =
    type BB=B&Boolean.Raw;type BY=B&Byte.Raw;type BC=B&Char.Raw;type BS=B&Short.Raw;type BI=B&Int.Raw;type BL=B&Long.Raw;type BF=B&Float.Raw;type BD=B&Double.Raw
    inline s match
      case _ : SHAPE[B,Boolean.G.Opt[BB],Boolean.G.~[BB]] => toBoolean (x,v => f(v).cast[Boolean.G.Opt[BB]])
      case _ : SHAPE[B,Byte   .G.Opt[BY],Byte   .G.~[BY]] => toByte    (x,v => f(v).cast[Byte   .G.Opt[BY]])
      case _ : SHAPE[B,Char   .G.Opt[BC],Char   .G.~[BC]] => toChar    (x,v => f(v).cast[Char   .G.Opt[BC]])
      case _ : SHAPE[B,Short  .G.Opt[BS],Short  .G.~[BS]] => toShort   (x,v => f(v).cast[Short  .G.Opt[BS]])
      case _ : SHAPE[B,Int    .G.Opt[BI],Int    .G.~[BI]] => toInt     (x,v => f(v).cast[Int    .G.Opt[BI]])
      case _ : SHAPE[B,Long   .G.Opt[BL],Long   .G.~[BL]] => toLong    (x,v => f(v).cast[Long   .G.Opt[BL]])
      case _ : SHAPE[B,Float  .G.Opt[BF],Float  .G.~[BF]] => toFloat   (x,v => f(v).cast[Float  .G.Opt[BF]])
      case _ : SHAPE[B,Double .G.Opt[BD],Double .G.~[BD]] => toDouble  (x,v => f(v).cast[Double .G.Opt[BD]])
      case _ : SHAPE[B,      Val.Opt[BB],Boolean.G.~[BB]] => toBoolean (x,v => f(v).cast[Opt[BB]].raw)
      case _ : SHAPE[B,      Val.Opt[BY],Byte   .G.~[BY]] => toByte    (x,v => f(v).cast[Opt[BY]].raw)
      case _ : SHAPE[B,      Val.Opt[BC],Char   .G.~[BC]] => toChar    (x,v => f(v).cast[Opt[BC]].raw)
      case _ : SHAPE[B,      Val.Opt[BS],Short  .G.~[BS]] => toShort   (x,v => f(v).cast[Opt[BS]].raw)
      case _ : SHAPE[B,      Val.Opt[BI],Int    .G.~[BI]] => toInt     (x,v => f(v).cast[Opt[BI]].raw)
      case _ : SHAPE[B,      Val.Opt[BL],Long   .G.~[BL]] => toLong    (x,v => f(v).cast[Opt[BL]].raw)
      case _ : SHAPE[B,      Val.Opt[BF],Float  .G.~[BF]] => toFloat   (x,v => f(v).cast[Opt[BF]].raw)
      case _ : SHAPE[B,      Val.Opt[BD],Double .G.~[BD]] => toDouble  (x,v => f(v).cast[Opt[BD]].raw)
      case _ : SHAPE[B,      Val.Opt[B ],AnyRef .G.~[B ]] => new mapOpt(x,v => f(v).cast[Opt[B ]])

  inline def APPLY[A,B,STM<: ~~.AnyType[B],OPT<:Val.Opt.AnyType[B]](inline x: ~[A], inline f: A => OPT, inline s:SHAPE[B,OPT,STM]): STM =
    type BB=B&Boolean.Raw;type BY=B&Byte.Raw;type BC=B&Char.Raw;type BS=B&Short.Raw;type BI=B&Int.Raw;type BL=B&Long.Raw;type BF=B&Float.Raw;type BD=B&Double.Raw
    inline s match
      case _ : SHAPE[B,Boolean.G.Opt[BB],Boolean.G.~[BB]] => {class mapOptToBoolean(x: ~[A]) extends a.Pipe.ofBoolean[BB](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[Boolean.G.Opt[BB]]; if(r.nonEmpty) return r; o=x.read_? }; \/}}; mapOptToBoolean(x)}
      case _ : SHAPE[B,Byte   .G.Opt[BY],Byte   .G.~[BY]] => {class mapOptToByte   (x: ~[A]) extends a.Pipe.ofByte   [BY](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[Byte   .G.Opt[BY]]; if(r.nonEmpty) return r; o=x.read_? }; \/}}; mapOptToByte   (x)}
      case _ : SHAPE[B,Char   .G.Opt[BC],Char   .G.~[BC]] => {class mapOptToChar   (x: ~[A]) extends a.Pipe.ofChar   [BC](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[Char   .G.Opt[BC]]; if(r.nonEmpty) return r; o=x.read_? }; \/}}; mapOptToChar   (x)}
      case _ : SHAPE[B,Short  .G.Opt[BS],Short  .G.~[BS]] => {class mapOptToShort  (x: ~[A]) extends a.Pipe.ofShort  [BS](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[Short  .G.Opt[BS]]; if(r.nonEmpty) return r; o=x.read_? }; \/}}; mapOptToShort  (x)}
      case _ : SHAPE[B,Int    .G.Opt[BI],Int    .G.~[BI]] => {class mapOptToInt    (x: ~[A]) extends a.Pipe.ofInt    [BI](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[Int    .G.Opt[BI]]; if(r.nonEmpty) return r; o=x.read_? }; \/}}; mapOptToInt    (x)}
      case _ : SHAPE[B,Long   .G.Opt[BL],Long   .G.~[BL]] => {class mapOptToLong   (x: ~[A]) extends a.Pipe.ofLong   [BL](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[Long   .G.Opt[BL]]; if(r.nonEmpty) return r; o=x.read_? }; \/}}; mapOptToLong   (x)}
      case _ : SHAPE[B,Float  .G.Opt[BF],Float  .G.~[BF]] => {class mapOptToFloat  (x: ~[A]) extends a.Pipe.ofFloat  [BF](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[Float  .G.Opt[BF]]; if(r.nonEmpty) return r; o=x.read_? }; \/}}; mapOptToFloat  (x)}
      case _ : SHAPE[B,Double .G.Opt[BD],Double .G.~[BD]] => {class mapOptToDouble (x: ~[A]) extends a.Pipe.ofDouble [BD](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[Double .G.Opt[BD]]; if(r.nonEmpty) return r; o=x.read_? }; \/}}; mapOptToDouble (x)}
      case _ : SHAPE[B,      Val.Opt[BB],Boolean.G.~[BB]] => {class mapOptToBoolean(x: ~[A]) extends a.Pipe.ofBoolean[BB](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[  Val.Opt[BB]].raw; if(r.nonEmpty) return r; o=x.read_? }; \/}}; mapOptToBoolean(x)}
      case _ : SHAPE[B,      Val.Opt[BY],Byte   .G.~[BY]] => {class mapOptToByte   (x: ~[A]) extends a.Pipe.ofByte   [BY](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[  Val.Opt[BY]].raw; if(r.nonEmpty) return r; o=x.read_? }; \/}}; mapOptToByte   (x)}
      case _ : SHAPE[B,      Val.Opt[BC],Char   .G.~[BC]] => {class mapOptToChar   (x: ~[A]) extends a.Pipe.ofChar   [BC](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[  Val.Opt[BC]].raw; if(r.nonEmpty) return r; o=x.read_? }; \/}}; mapOptToChar   (x)}
      case _ : SHAPE[B,      Val.Opt[BS],Short  .G.~[BS]] => {class mapOptToShort  (x: ~[A]) extends a.Pipe.ofShort  [BS](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[  Val.Opt[BS]].raw; if(r.nonEmpty) return r; o=x.read_? }; \/}}; mapOptToShort  (x)}
      case _ : SHAPE[B,      Val.Opt[BI],Int    .G.~[BI]] => {class mapOptToInt    (x: ~[A]) extends a.Pipe.ofInt    [BI](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[  Val.Opt[BI]].raw; if(r.nonEmpty) return r; o=x.read_? }; \/}}; mapOptToInt    (x)}
      case _ : SHAPE[B,      Val.Opt[BL],Long   .G.~[BL]] => {class mapOptToLong   (x: ~[A]) extends a.Pipe.ofLong   [BL](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[  Val.Opt[BL]].raw; if(r.nonEmpty) return r; o=x.read_? }; \/}}; mapOptToLong   (x)}
      case _ : SHAPE[B,      Val.Opt[BF],Float  .G.~[BF]] => {class mapOptToFloat  (x: ~[A]) extends a.Pipe.ofFloat  [BF](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[  Val.Opt[BF]].raw; if(r.nonEmpty) return r; o=x.read_? }; \/}}; mapOptToFloat  (x)}
      case _ : SHAPE[B,      Val.Opt[BD],Double .G.~[BD]] => {class mapOptToDouble (x: ~[A]) extends a.Pipe.ofDouble [BD](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[  Val.Opt[BD]].raw; if(r.nonEmpty) return r; o=x.read_? }; \/}}; mapOptToDouble (x)}
      case _ : SHAPE[B,      Val.Opt[B ],AnyRef .G.~[B ]] => {class mapOpt         (x: ~[A]) extends a.Pipe.ofRef    [B ](x){@tn("read_Opt")    def read_?    ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[  Val.Opt[B]];      if(r.nonEmpty) return r; o=x.read_? }; \/}}; new mapOpt     (x)}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
