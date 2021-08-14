package scalqa; package lang; package int; package z; package stream; import language.implicitConversions

import `val`.stream.z.a.Pipe
import gen.`given`.StreamShape.{ Opt as SHAPE}

class  mapOpt    [A<:Raw,B]             (x: ~[A], f: A => Val.Opt[B]                        ) extends Pipe.ofRef    [B](x){@tn("read_Opt")    def read_?    ={var o=x.read_?; while(o.nonEmpty){ val r=f(o.`val`); if(r.nonEmpty) return r; o=x.read_? }; \/}}
object mapOpt:
  class toBoolean[A<:Raw,B<:Boolean.Raw](x: ~[A], f:Byte  .G.Fun.FromAny[A,Boolean.G.Opt[B]]) extends Pipe.ofBoolean[B](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){ val r=f(o.`val`); if(r.nonEmpty) return r; o=x.read_? }; \/}}
  class toByte   [A<:Raw,B<:Byte.Raw]   (x: ~[A], f:Short .G.Fun.FromAny[A,Byte   .G.Opt[B]]) extends Pipe.ofByte   [B](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){ val r=f(o.`val`); if(r.nonEmpty) return r; o=x.read_? }; \/}}
  class toChar   [A<:Raw,B<:Char.Raw]   (x: ~[A], f:Int   .G.Fun.FromAny[A,Char   .G.Opt[B]]) extends Pipe.ofChar   [B](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){ val r=f(o.`val`); if(r.nonEmpty) return r; o=x.read_? }; \/}}
  class toShort  [A<:Raw,B<:Short.Raw]  (x: ~[A], f:Int   .G.Fun.FromAny[A,Short  .G.Opt[B]]) extends Pipe.ofShort  [B](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){ val r=f(o.`val`); if(r.nonEmpty) return r; o=x.read_? }; \/}}
  class toInt    [A<:Raw,B<:Int.Raw]    (x: ~[A], f:Long  .G.Fun.FromAny[A,Int    .G.Opt[B]]) extends Pipe.ofInt    [B](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){ val r=f(o.`val`); if(r.nonEmpty) return r; o=x.read_? }; \/}}
  class toLong   [A<:Raw,B<:Long.Raw]   (x: ~[A], f:Long  .G.Fun.FromAny[A,Long   .G.Opt[B]]) extends Pipe.ofLong   [B](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){ val r=f(o.`val`); if(r.nonEmpty) return r; o=x.read_? }; \/}}
  class toFloat  [A<:Raw,B<:Float.Raw]  (x: ~[A], f:Float .G.Fun.FromAny[A,Float  .G.Opt[B]]) extends Pipe.ofFloat  [B](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){ val r=f(o.`val`); if(r.nonEmpty) return r; o=x.read_? }; \/}}
  class toDouble [A<:Raw,B<:Double.Raw] (x: ~[A], f:Double.G.Fun.FromAny[A,Double .G.Opt[B]]) extends Pipe.ofDouble [B](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){ val r=f(o.`val`); if(r.nonEmpty) return r; o=x.read_? }; \/}}

  inline def apply[A<:Raw,B,STM<: ~~.AnyType[B],OPT<:Val.Opt.AnyType[B]](inline x: ~[A], inline f: A => OPT, inline s:SHAPE[B,OPT,STM]): STM =
    type BB=B&Boolean.Raw;type BY=B&Byte.Raw;type BC=B&Char.Raw;type BS=B&Short.Raw;type BI=B&Int.Raw;type BL=B&Long.Raw;type BF=B&Float.Raw;type BD=B&Double.Raw
    inline s match
      case _ : SHAPE[B,Boolean.G.Opt[BB],Boolean.G.~[BB]] => new toBoolean(x,v => f(v).cast[Boolean.G.Opt[BB]])
      case _ : SHAPE[B,Byte   .G.Opt[BY],Byte   .G.~[BY]] => new toByte   (x,v => f(v).cast[Byte   .G.Opt[BY]])
      case _ : SHAPE[B,Char   .G.Opt[BC],Char   .G.~[BC]] => new toChar   (x,v => f(v).cast[Char   .G.Opt[BC]])
      case _ : SHAPE[B,Short  .G.Opt[BS],Short  .G.~[BS]] => new toShort  (x,v => f(v).cast[Short  .G.Opt[BS]])
      case _ : SHAPE[B,Int    .G.Opt[BI],Int    .G.~[BI]] => new toInt    (x,v => f(v).cast[Int    .G.Opt[BI]])
      case _ : SHAPE[B,Long   .G.Opt[BL],Long   .G.~[BL]] => new toLong   (x,v => f(v).cast[Long   .G.Opt[BL]])
      case _ : SHAPE[B,Float  .G.Opt[BF],Float  .G.~[BF]] => new toFloat  (x,v => f(v).cast[Float  .G.Opt[BF]])
      case _ : SHAPE[B,Double .G.Opt[BD],Double .G.~[BD]] => new toDouble (x,v => f(v).cast[Double .G.Opt[BD]])
      case _ : SHAPE[B,AnyRef .G.Opt[BB],Boolean.G.~[BB]] => new toBoolean(x,v => f(v).cast[Opt[BB]].raw)
      case _ : SHAPE[B,AnyRef .G.Opt[BY],Byte   .G.~[BY]] => new toByte   (x,v => f(v).cast[Opt[BY]].raw)
      case _ : SHAPE[B,AnyRef .G.Opt[BC],Char   .G.~[BC]] => new toChar   (x,v => f(v).cast[Opt[BC]].raw)
      case _ : SHAPE[B,AnyRef .G.Opt[BS],Short  .G.~[BS]] => new toShort  (x,v => f(v).cast[Opt[BS]].raw)
      case _ : SHAPE[B,AnyRef .G.Opt[BI],Int    .G.~[BI]] => new toInt    (x,v => f(v).cast[Opt[BI]].raw)
      case _ : SHAPE[B,AnyRef .G.Opt[BL],Long   .G.~[BL]] => new toLong   (x,v => f(v).cast[Opt[BL]].raw)
      case _ : SHAPE[B,AnyRef .G.Opt[BF],Float  .G.~[BF]] => new toFloat  (x,v => f(v).cast[Opt[BF]].raw)
      case _ : SHAPE[B,AnyRef .G.Opt[BD],Double .G.~[BD]] => new toDouble (x,v => f(v).cast[Opt[BD]].raw)
      case _ : SHAPE[B,AnyRef .G.Opt[B ],AnyRef .G.~[B ]] => new mapOpt   (x,v => f(v).cast[Opt[B ]])

  inline def APPLY[A<:Raw,B,STM<: ~~.AnyType[B],OPT<:Val.Opt.AnyType[B]](inline x: ~[A], inline f: A => OPT, inline s:SHAPE[B,OPT,STM]): STM =
    type BB=B&Boolean.Raw;type BY=B&Byte.Raw;type BC=B&Char.Raw;type BS=B&Short.Raw;type BI=B&Int.Raw;type BL=B&Long.Raw;type BF=B&Float.Raw;type BD=B&Double.Raw
    inline s match
      case _ : SHAPE[B,Boolean.G.Opt[BB],Boolean.G.~[BB]] => {class mapOptToBoolean(x: ~[A]) extends Pipe.ofBoolean[BB](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[Boolean.G.Opt[BB]];     if(r.nonEmpty) return r; o=x.read_? }; \/}}; new mapOptToBoolean(x)}
      case _ : SHAPE[B,Byte   .G.Opt[BY],Byte   .G.~[BY]] => {class mapOptToByte   (x: ~[A]) extends Pipe.ofByte   [BY](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[Byte   .G.Opt[BY]];     if(r.nonEmpty) return r; o=x.read_? }; \/}}; new mapOptToByte   (x)}
      case _ : SHAPE[B,Char   .G.Opt[BC],Char   .G.~[BC]] => {class mapOptToChar   (x: ~[A]) extends Pipe.ofChar   [BC](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[Char   .G.Opt[BC]];     if(r.nonEmpty) return r; o=x.read_? }; \/}}; new mapOptToChar   (x)}
      case _ : SHAPE[B,Short  .G.Opt[BS],Short  .G.~[BS]] => {class mapOptToShort  (x: ~[A]) extends Pipe.ofShort  [BS](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[Short  .G.Opt[BS]];     if(r.nonEmpty) return r; o=x.read_? }; \/}}; new mapOptToShort  (x)}
      case _ : SHAPE[B,Int    .G.Opt[BI],Int    .G.~[BI]] => {class mapOptToInt    (x: ~[A]) extends Pipe.ofInt    [BI](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[Int    .G.Opt[BI]];     if(r.nonEmpty) return r; o=x.read_? }; \/}}; new mapOptToInt    (x)}
      case _ : SHAPE[B,Long   .G.Opt[BL],Long   .G.~[BL]] => {class mapOptToLong   (x: ~[A]) extends Pipe.ofLong   [BL](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[Long   .G.Opt[BL]];     if(r.nonEmpty) return r; o=x.read_? }; \/}}; new mapOptToLong   (x)}
      case _ : SHAPE[B,Float  .G.Opt[BF],Float  .G.~[BF]] => {class mapOptToFloat  (x: ~[A]) extends Pipe.ofFloat  [BF](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[Float  .G.Opt[BF]];     if(r.nonEmpty) return r; o=x.read_? }; \/}}; new mapOptToFloat  (x)}
      case _ : SHAPE[B,Double .G.Opt[BD],Double .G.~[BD]] => {class mapOptToDouble (x: ~[A]) extends Pipe.ofDouble [BD](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[Double .G.Opt[BD]];     if(r.nonEmpty) return r; o=x.read_? }; \/}}; new mapOptToDouble (x)}
      case _ : SHAPE[B,AnyRef .G.Opt[BB],Boolean.G.~[BB]] => {class mapOptToBoolean(x: ~[A]) extends Pipe.ofBoolean[BB](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[AnyRef .G.Opt[BB]].raw; if(r.nonEmpty) return r; o=x.read_? }; \/}}; new mapOptToBoolean(x)}
      case _ : SHAPE[B,AnyRef .G.Opt[BY],Byte   .G.~[BY]] => {class mapOptToByte   (x: ~[A]) extends Pipe.ofByte   [BY](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[AnyRef .G.Opt[BY]].raw; if(r.nonEmpty) return r; o=x.read_? }; \/}}; new mapOptToByte   (x)}
      case _ : SHAPE[B,AnyRef .G.Opt[BC],Char   .G.~[BC]] => {class mapOptToChar   (x: ~[A]) extends Pipe.ofChar   [BC](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[AnyRef .G.Opt[BC]].raw; if(r.nonEmpty) return r; o=x.read_? }; \/}}; new mapOptToChar   (x)}
      case _ : SHAPE[B,AnyRef .G.Opt[BS],Short  .G.~[BS]] => {class mapOptToShort  (x: ~[A]) extends Pipe.ofShort  [BS](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[AnyRef .G.Opt[BS]].raw; if(r.nonEmpty) return r; o=x.read_? }; \/}}; new mapOptToShort  (x)}
      case _ : SHAPE[B,AnyRef .G.Opt[BI],Int    .G.~[BI]] => {class mapOptToInt    (x: ~[A]) extends Pipe.ofInt    [BI](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[AnyRef .G.Opt[BI]].raw; if(r.nonEmpty) return r; o=x.read_? }; \/}}; new mapOptToInt    (x)}
      case _ : SHAPE[B,AnyRef .G.Opt[BL],Long   .G.~[BL]] => {class mapOptToLong   (x: ~[A]) extends Pipe.ofLong   [BL](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[AnyRef .G.Opt[BL]].raw; if(r.nonEmpty) return r; o=x.read_? }; \/}}; new mapOptToLong   (x)}
      case _ : SHAPE[B,AnyRef .G.Opt[BF],Float  .G.~[BF]] => {class mapOptToFloat  (x: ~[A]) extends Pipe.ofFloat  [BF](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[AnyRef .G.Opt[BF]].raw; if(r.nonEmpty) return r; o=x.read_? }; \/}}; new mapOptToFloat  (x)}
      case _ : SHAPE[B,AnyRef .G.Opt[BD],Double .G.~[BD]] => {class mapOptToDouble (x: ~[A]) extends Pipe.ofDouble [BD](x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[AnyRef .G.Opt[BD]].raw; if(r.nonEmpty) return r; o=x.read_? }; \/}}; new mapOptToDouble (x)}
      case _ : SHAPE[B,AnyRef .G.Opt[B ],AnyRef .G.~[B ]] => {class mapOpt         (x: ~[A]) extends Pipe.ofRef    [B ](x){@tn("read_Opt")    def read_?    ={var o=x.read_?; while(o.nonEmpty){val r= f(o.`val`).cast[AnyRef .G.Opt[B]];      if(r.nonEmpty) return r; o=x.read_? }; \/}}; new mapOpt         (x)}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
