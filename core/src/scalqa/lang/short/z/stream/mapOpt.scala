package scalqa; package lang; package short; package z; package stream; import language.implicitConversions

import `val`.stream.z.x.Pipe

class  mapOpt  [A<:Raw,B](x:   Stream[A], f: A => Val.Opt[B]                ) extends Pipe       [B](x){def readOpt    ={var o=x.readOpt;    while(o){ val r=f(o.`val`); if(r) return r; o=x.readOpt    }; VOID}}
object mapOpt:
  class toBoolean[A<:Raw](x: G.Stream[A], f:G.Fun.ToAnyByte  [A,Boolean.Opt]) extends Pipe.asBoolean(x){def readRawOpt ={var o=x.readRawOpt; while(o){ val r=f(o.`val`); if(r) return r; o=x.readRawOpt }; VOID}}
  class toByte   [A<:Raw](x: G.Stream[A], f:G.Fun.ToAnyShort [A,Byte   .Opt]) extends Pipe.asByte   (x){def readRawOpt ={var o=x.readRawOpt; while(o){ val r=f(o.`val`); if(r) return r; o=x.readRawOpt }; VOID}}
  class toChar   [A<:Raw](x: G.Stream[A], f:G.Fun.ToAnyInt   [A,Char   .Opt]) extends Pipe.asChar   (x){def readRawOpt ={var o=x.readRawOpt; while(o){ val r=f(o.`val`); if(r) return r; o=x.readRawOpt }; VOID}}
  class toShort  [A<:Raw](x: G.Stream[A], f:G.Fun.ToAnyInt   [A,Short  .Opt]) extends Pipe.asShort  (x){def readRawOpt ={var o=x.readRawOpt; while(o){ val r=f(o.`val`); if(r) return r; o=x.readRawOpt }; VOID}}
  class toInt    [A<:Raw](x: G.Stream[A], f:G.Fun.ToAnyLong  [A,Int    .Opt]) extends Pipe.asInt    (x){def readRawOpt ={var o=x.readRawOpt; while(o){ val r=f(o.`val`); if(r) return r; o=x.readRawOpt }; VOID}}
  class toLong   [A<:Raw](x: G.Stream[A], f:G.Fun.ToAnyLong  [A,Long   .Opt]) extends Pipe.asLong   (x){def readRawOpt ={var o=x.readRawOpt; while(o){ val r=f(o.`val`); if(r) return r; o=x.readRawOpt }; VOID}}
  class toFloat  [A<:Raw](x: G.Stream[A], f:G.Fun.ToAnyFloat [A,Float  .Opt]) extends Pipe.asFloat  (x){def readRawOpt ={var o=x.readRawOpt; while(o){ val r=f(o.`val`); if(r) return r; o=x.readRawOpt }; VOID}}
  class toDouble [A<:Raw](x: G.Stream[A], f:G.Fun.ToAnyDouble[A,Double .Opt]) extends Pipe.asDouble (x){def readRawOpt ={var o=x.readRawOpt; while(o){ val r=f(o.`val`); if(r) return r; o=x.readRawOpt }; VOID}}

  inline def apply[A<:Raw,B,OPT<:Any.Opt[B]](inline x: G.Stream[A], inline f: A => OPT)(using inline s:Specialized.Opt[B,OPT], inline B:Specialized[B]): B.Stream =
    inline B match
      case _ : Specialized[B & Any.Boolean] => new toBoolean(x,v => s(v,f).cast[Boolean.Opt]).cast[B.Stream]
      case _ : Specialized[B & Any.Byte   ] => new toByte   (x,v => s(v,f).cast[Byte   .Opt]).cast[B.Stream]
      case _ : Specialized[B & Any.Char   ] => new toChar   (x,v => s(v,f).cast[Char   .Opt]).cast[B.Stream]
      case _ : Specialized[B & Any.Short  ] => new toShort  (x,v => s(v,f).cast[Short  .Opt]).cast[B.Stream]
      case _ : Specialized[B & Any.Int    ] => new toInt    (x,v => s(v,f).cast[Int    .Opt]).cast[B.Stream]
      case _ : Specialized[B & Any.Long   ] => new toLong   (x,v => s(v,f).cast[Long   .Opt]).cast[B.Stream]
      case _ : Specialized[B & Any.Float  ] => new toFloat  (x,v => s(v,f).cast[Float  .Opt]).cast[B.Stream]
      case _ : Specialized[B & Any.Double ] => new toDouble (x,v => s(v,f).cast[Double .Opt]).cast[B.Stream]
      case _                                => new mapOpt   (x,v => s(v,f).cast[Val .Opt[B]]).cast[B.Stream]

  inline def APPLY[A<:Raw,B,OPT<:Any.Opt[B]](inline x: G.Stream[A], inline f: A => OPT)(using inline s:Specialized.Opt[B,OPT], inline B:Specialized[B]): B.Stream =
    inline B match
      case _ : Specialized[B & Any.Boolean] => {class mapOpt_toBoolean(x: G.Stream[A]) extends Pipe.asBoolean(x){def readRawOpt ={var o=x.readRawOpt; while(o){val r= s(o.`val`,f).cast[Boolean.Opt]; if(r) return r; o=x.readRawOpt }; VOID}}; new mapOpt_toBoolean(x).cast[B.Stream] }
      case _ : Specialized[B & Any.Byte   ] => {class mapOpt_toByte   (x: G.Stream[A]) extends Pipe.asByte   (x){def readRawOpt ={var o=x.readRawOpt; while(o){val r= s(o.`val`,f).cast[Byte   .Opt]; if(r) return r; o=x.readRawOpt }; VOID}}; new mapOpt_toByte   (x).cast[B.Stream] }
      case _ : Specialized[B & Any.Char   ] => {class mapOpt_toChar   (x: G.Stream[A]) extends Pipe.asChar   (x){def readRawOpt ={var o=x.readRawOpt; while(o){val r= s(o.`val`,f).cast[Char   .Opt]; if(r) return r; o=x.readRawOpt }; VOID}}; new mapOpt_toChar   (x).cast[B.Stream] }
      case _ : Specialized[B & Any.Short  ] => {class mapOpt_toShort  (x: G.Stream[A]) extends Pipe.asShort  (x){def readRawOpt ={var o=x.readRawOpt; while(o){val r= s(o.`val`,f).cast[Short  .Opt]; if(r) return r; o=x.readRawOpt }; VOID}}; new mapOpt_toShort  (x).cast[B.Stream] }
      case _ : Specialized[B & Any.Int    ] => {class mapOpt_toInt    (x: G.Stream[A]) extends Pipe.asInt    (x){def readRawOpt ={var o=x.readRawOpt; while(o){val r= s(o.`val`,f).cast[Int    .Opt]; if(r) return r; o=x.readRawOpt }; VOID}}; new mapOpt_toInt    (x).cast[B.Stream] }
      case _ : Specialized[B & Any.Long   ] => {class mapOpt_toLong   (x: G.Stream[A]) extends Pipe.asLong   (x){def readRawOpt ={var o=x.readRawOpt; while(o){val r= s(o.`val`,f).cast[Long   .Opt]; if(r) return r; o=x.readRawOpt }; VOID}}; new mapOpt_toLong   (x).cast[B.Stream] }
      case _ : Specialized[B & Any.Float  ] => {class mapOpt_toFloat  (x: G.Stream[A]) extends Pipe.asFloat  (x){def readRawOpt ={var o=x.readRawOpt; while(o){val r= s(o.`val`,f).cast[Float  .Opt]; if(r) return r; o=x.readRawOpt }; VOID}}; new mapOpt_toFloat  (x).cast[B.Stream] }
      case _ : Specialized[B & Any.Double ] => {class mapOpt_toDouble (x: G.Stream[A]) extends Pipe.asDouble (x){def readRawOpt ={var o=x.readRawOpt; while(o){val r= s(o.`val`,f).cast[Double .Opt]; if(r) return r; o=x.readRawOpt }; VOID}}; new mapOpt_toDouble (x).cast[B.Stream] }
      case _                                => {class mapOpt          (x: G.Stream[A]) extends Pipe      [B ](x){def readOpt    ={var o=x.readRawOpt; while(o){val r= s(o.`val`,f).cast[Val .Opt[B]]; if(r) return r; o=x.readRawOpt }; VOID}}; new mapOpt          (x).cast[B.Stream] }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
