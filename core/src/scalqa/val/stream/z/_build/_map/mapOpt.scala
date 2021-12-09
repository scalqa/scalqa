package scalqa; package `val`; package stream; package z; package _build; package _map; import language.implicitConversions;

class  mapOpt  [A,B](x: Stream[A], f:A => Val.Opt[B]                        ) extends z.x.Pipe[B]       (x){def readOpt    ={var o=x.readOpt; while(o){ val r=f(o.`val`); if(r) return r; o=x.readOpt }; VOID}}
object mapOpt:
  class toBoolean[A](x: Stream[A], f:AnyRef.G.Fun.ToAnyByte  [A,Boolean.Opt]) extends z.x.Pipe.asBoolean(x){def readRawOpt ={var o=x.readOpt; while(o){ val r=f(o.`val`); if(r) return r; o=x.readOpt }; VOID}}
  class toByte   [A](x: Stream[A], f:AnyRef.G.Fun.ToAnyShort [A,Byte   .Opt]) extends z.x.Pipe.asByte   (x){def readRawOpt ={var o=x.readOpt; while(o){ val r=f(o.`val`); if(r) return r; o=x.readOpt }; VOID}}
  class toChar   [A](x: Stream[A], f:AnyRef.G.Fun.ToAnyInt   [A,Char   .Opt]) extends z.x.Pipe.asChar   (x){def readRawOpt ={var o=x.readOpt; while(o){ val r=f(o.`val`); if(r) return r; o=x.readOpt }; VOID}}
  class toShort  [A](x: Stream[A], f:AnyRef.G.Fun.ToAnyInt   [A,Short  .Opt]) extends z.x.Pipe.asShort  (x){def readRawOpt ={var o=x.readOpt; while(o){ val r=f(o.`val`); if(r) return r; o=x.readOpt }; VOID}}
  class toInt    [A](x: Stream[A], f:AnyRef.G.Fun.ToAnyLong  [A,Int    .Opt]) extends z.x.Pipe.asInt    (x){def readRawOpt ={var o=x.readOpt; while(o){ val r=f(o.`val`); if(r) return r; o=x.readOpt }; VOID}}
  class toLong   [A](x: Stream[A], f:AnyRef.G.Fun.ToAnyLong  [A,Long   .Opt]) extends z.x.Pipe.asLong   (x){def readRawOpt ={var o=x.readOpt; while(o){ val r=f(o.`val`); if(r) return r; o=x.readOpt }; VOID}}
  class toFloat  [A](x: Stream[A], f:AnyRef.G.Fun.ToAnyFloat [A,Float  .Opt]) extends z.x.Pipe.asFloat  (x){def readRawOpt ={var o=x.readOpt; while(o){ val r=f(o.`val`); if(r) return r; o=x.readOpt }; VOID}}
  class toDouble [A](x: Stream[A], f:AnyRef.G.Fun.ToAnyDouble[A,Double .Opt]) extends z.x.Pipe.asDouble (x){def readRawOpt ={var o=x.readOpt; while(o){ val r=f(o.`val`); if(r) return r; o=x.readOpt }; VOID}}

  inline def apply[A,B,OPT<:Any.Opt[B]](inline x: Stream[A], inline f: A=>OPT)(using inline so:Specialized.Opt[B,OPT], inline s:Specialized[B]): s.Stream =
    inline s match
      case _ : Specialized[B & Any.Boolean] => new toBoolean(x,v => so(v,f).cast[Boolean.Opt]).cast[s.Stream]
      case _ : Specialized[B & Any.Byte   ] => new toByte   (x,v => so(v,f).cast[Byte   .Opt]).cast[s.Stream]
      case _ : Specialized[B & Any.Char   ] => new toChar   (x,v => so(v,f).cast[Char   .Opt]).cast[s.Stream]
      case _ : Specialized[B & Any.Short  ] => new toShort  (x,v => so(v,f).cast[Short  .Opt]).cast[s.Stream]
      case _ : Specialized[B & Any.Int    ] => new toInt    (x,v => so(v,f).cast[Int    .Opt]).cast[s.Stream]
      case _ : Specialized[B & Any.Long   ] => new toLong   (x,v => so(v,f).cast[Long   .Opt]).cast[s.Stream]
      case _ : Specialized[B & Any.Float  ] => new toFloat  (x,v => so(v,f).cast[Float  .Opt]).cast[s.Stream]
      case _ : Specialized[B & Any.Double ] => new toDouble (x,v => so(v,f).cast[Double .Opt]).cast[s.Stream]
      case _                                => new mapOpt   (x,v => so(v,f).cast[Val .Opt[B]]).cast[s.Stream]

  inline def APPLY[A,B,OPT<:Any.Opt[B]](inline x: Stream[A], inline f: A=>OPT)(using inline so:Specialized.Opt[B,OPT], inline s:Specialized[B]): s.Stream =
    inline s match
      case _ : Specialized[B & Any.Boolean] => {class mapOptToBoolean(x: Stream[A]) extends z.x.Pipe.asBoolean(x){def readRawOpt ={var o=x.readOpt; while(o){val r= so(o.`val`,f).cast[Boolean.Opt]; if(r) return r; o=x.readOpt }; VOID}}; new mapOptToBoolean(x).cast[s.Stream] }
      case _ : Specialized[B & Any.Byte   ] => {class mapOptToByte   (x: Stream[A]) extends z.x.Pipe.asByte   (x){def readRawOpt ={var o=x.readOpt; while(o){val r= so(o.`val`,f).cast[Byte   .Opt]; if(r) return r; o=x.readOpt }; VOID}}; new mapOptToByte   (x).cast[s.Stream] }
      case _ : Specialized[B & Any.Char   ] => {class mapOptToChar   (x: Stream[A]) extends z.x.Pipe.asChar   (x){def readRawOpt ={var o=x.readOpt; while(o){val r= so(o.`val`,f).cast[Char   .Opt]; if(r) return r; o=x.readOpt }; VOID}}; new mapOptToChar   (x).cast[s.Stream] }
      case _ : Specialized[B & Any.Short  ] => {class mapOptToShort  (x: Stream[A]) extends z.x.Pipe.asShort  (x){def readRawOpt ={var o=x.readOpt; while(o){val r= so(o.`val`,f).cast[Short  .Opt]; if(r) return r; o=x.readOpt }; VOID}}; new mapOptToShort  (x).cast[s.Stream] }
      case _ : Specialized[B & Any.Int    ] => {class mapOptToInt    (x: Stream[A]) extends z.x.Pipe.asInt    (x){def readRawOpt ={var o=x.readOpt; while(o){val r= so(o.`val`,f).cast[Int    .Opt]; if(r) return r; o=x.readOpt }; VOID}}; new mapOptToInt    (x).cast[s.Stream] }
      case _ : Specialized[B & Any.Long   ] => {class mapOptToLong   (x: Stream[A]) extends z.x.Pipe.asLong   (x){def readRawOpt ={var o=x.readOpt; while(o){val r= so(o.`val`,f).cast[Long   .Opt]; if(r) return r; o=x.readOpt }; VOID}}; new mapOptToLong   (x).cast[s.Stream] }
      case _ : Specialized[B & Any.Float  ] => {class mapOptToFloat  (x: Stream[A]) extends z.x.Pipe.asFloat  (x){def readRawOpt ={var o=x.readOpt; while(o){val r= so(o.`val`,f).cast[Float  .Opt]; if(r) return r; o=x.readOpt }; VOID}}; new mapOptToFloat  (x).cast[s.Stream] }
      case _ : Specialized[B & Any.Double ] => {class mapOptToDouble (x: Stream[A]) extends z.x.Pipe.asDouble (x){def readRawOpt ={var o=x.readOpt; while(o){val r= so(o.`val`,f).cast[Double .Opt]; if(r) return r; o=x.readOpt }; VOID}}; new mapOptToDouble (x).cast[s.Stream] }
      case _                                => {class mapOpt         (x: Stream[A]) extends z.x.Pipe      [B ](x){def readOpt    ={var o=x.readOpt; while(o){val r= so(o.`val`,f).cast[Val .Opt[B]]; if(r) return r; o=x.readOpt }; VOID}}; new mapOpt         (x).cast[s.Stream] }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
