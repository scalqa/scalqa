package scalqa; package `val`; package stream; package z; package _build; package _map; import language.implicitConversions;

class  mapOpt  [A,B](x: ~[A], f:A => Val.Opt[B]                    ) extends z.x.Pipe[B]       (x){@tn("read_Opt")    def read_?    ={var o=x.read_?; while(o){ val r=f(o.`val`); if(r) return r; o=x.read_? }; \/}}
object mapOpt:
  class toBoolean[A](x: ~[A], f:Byte  .G.Fun.FromAny[A,Boolean.Opt]) extends z.x.Pipe.asBoolean(x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o){ val r=f(o.`val`); if(r) return r; o=x.read_? }; \/}}
  class toByte   [A](x: ~[A], f:Short .G.Fun.FromAny[A,Byte   .Opt]) extends z.x.Pipe.asByte   (x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o){ val r=f(o.`val`); if(r) return r; o=x.read_? }; \/}}
  class toChar   [A](x: ~[A], f:Int   .G.Fun.FromAny[A,Char   .Opt]) extends z.x.Pipe.asChar   (x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o){ val r=f(o.`val`); if(r) return r; o=x.read_? }; \/}}
  class toShort  [A](x: ~[A], f:Int   .G.Fun.FromAny[A,Short  .Opt]) extends z.x.Pipe.asShort  (x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o){ val r=f(o.`val`); if(r) return r; o=x.read_? }; \/}}
  class toInt    [A](x: ~[A], f:Long  .G.Fun.FromAny[A,Int    .Opt]) extends z.x.Pipe.asInt    (x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o){ val r=f(o.`val`); if(r) return r; o=x.read_? }; \/}}
  class toLong   [A](x: ~[A], f:Long  .G.Fun.FromAny[A,Long   .Opt]) extends z.x.Pipe.asLong   (x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o){ val r=f(o.`val`); if(r) return r; o=x.read_? }; \/}}
  class toFloat  [A](x: ~[A], f:Float .G.Fun.FromAny[A,Float  .Opt]) extends z.x.Pipe.asFloat  (x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o){ val r=f(o.`val`); if(r) return r; o=x.read_? }; \/}}
  class toDouble [A](x: ~[A], f:Double.G.Fun.FromAny[A,Double .Opt]) extends z.x.Pipe.asDouble (x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o){ val r=f(o.`val`); if(r) return r; o=x.read_? }; \/}}

  inline def apply[A,B,OPT<:Any.Opt[B]](inline x: ~[A], inline f: A=>OPT)(using inline s:Specialized.Opt[B,OPT], inline B:Specialized[B]): B.~ =
    inline B match
      case _ : Specialized[B & Any.Boolean] => new toBoolean(x,v => s(v,f).cast[Boolean.Opt]).cast[B.~]
      case _ : Specialized[B & Any.Byte   ] => new toByte   (x,v => s(v,f).cast[Byte   .Opt]).cast[B.~]
      case _ : Specialized[B & Any.Char   ] => new toChar   (x,v => s(v,f).cast[Char   .Opt]).cast[B.~]
      case _ : Specialized[B & Any.Short  ] => new toShort  (x,v => s(v,f).cast[Short  .Opt]).cast[B.~]
      case _ : Specialized[B & Any.Int    ] => new toInt    (x,v => s(v,f).cast[Int    .Opt]).cast[B.~]
      case _ : Specialized[B & Any.Long   ] => new toLong   (x,v => s(v,f).cast[Long   .Opt]).cast[B.~]
      case _ : Specialized[B & Any.Float  ] => new toFloat  (x,v => s(v,f).cast[Float  .Opt]).cast[B.~]
      case _ : Specialized[B & Any.Double ] => new toDouble (x,v => s(v,f).cast[Double .Opt]).cast[B.~]
      case _                                => new mapOpt   (x,v => s(v,f).cast[Val .Opt[B]]).cast[B.~]

  inline def APPLY[A,B,OPT<:Any.Opt[B]](inline x: ~[A], inline f: A=>OPT)(using inline s:Specialized.Opt[B,OPT], inline B:Specialized[B]): B.~ =
    inline B match
      case _ : Specialized[B & Any.Boolean] => {class mapOptToBoolean(x: ~[A]) extends z.x.Pipe.asBoolean(x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o){val r= s(o.`val`,f).cast[Boolean.Opt]; if(r) return r; o=x.read_? }; \/}}; new mapOptToBoolean(x).cast[B.~] }
      case _ : Specialized[B & Any.Byte   ] => {class mapOptToByte   (x: ~[A]) extends z.x.Pipe.asByte   (x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o){val r= s(o.`val`,f).cast[Byte   .Opt]; if(r) return r; o=x.read_? }; \/}}; new mapOptToByte   (x).cast[B.~] }
      case _ : Specialized[B & Any.Char   ] => {class mapOptToChar   (x: ~[A]) extends z.x.Pipe.asChar   (x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o){val r= s(o.`val`,f).cast[Char   .Opt]; if(r) return r; o=x.read_? }; \/}}; new mapOptToChar   (x).cast[B.~] }
      case _ : Specialized[B & Any.Short  ] => {class mapOptToShort  (x: ~[A]) extends z.x.Pipe.asShort  (x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o){val r= s(o.`val`,f).cast[Short  .Opt]; if(r) return r; o=x.read_? }; \/}}; new mapOptToShort  (x).cast[B.~] }
      case _ : Specialized[B & Any.Int    ] => {class mapOptToInt    (x: ~[A]) extends z.x.Pipe.asInt    (x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o){val r= s(o.`val`,f).cast[Int    .Opt]; if(r) return r; o=x.read_? }; \/}}; new mapOptToInt    (x).cast[B.~] }
      case _ : Specialized[B & Any.Long   ] => {class mapOptToLong   (x: ~[A]) extends z.x.Pipe.asLong   (x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o){val r= s(o.`val`,f).cast[Long   .Opt]; if(r) return r; o=x.read_? }; \/}}; new mapOptToLong   (x).cast[B.~] }
      case _ : Specialized[B & Any.Float  ] => {class mapOptToFloat  (x: ~[A]) extends z.x.Pipe.asFloat  (x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o){val r= s(o.`val`,f).cast[Float  .Opt]; if(r) return r; o=x.read_? }; \/}}; new mapOptToFloat  (x).cast[B.~] }
      case _ : Specialized[B & Any.Double ] => {class mapOptToDouble (x: ~[A]) extends z.x.Pipe.asDouble (x){@tn("readRaw_Opt") def readRaw_? ={var o=x.read_?; while(o){val r= s(o.`val`,f).cast[Double .Opt]; if(r) return r; o=x.read_? }; \/}}; new mapOptToDouble (x).cast[B.~] }
      case _                                => {class mapOpt         (x: ~[A]) extends z.x.Pipe      [B ](x){@tn("read_Opt")    def read_?    ={var o=x.read_?; while(o){val r= s(o.`val`,f).cast[Val .Opt[B]]; if(r) return r; o=x.read_? }; \/}}; new mapOpt         (x).cast[B.~] }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
