package scalqa; package `def`; package array; package z; import language.implicitConversions

import Shape.OfArray.*

object joinAllAt:

  inline def apply[A,ARRAY<:Any[A]](inline x: ARRAY, inline i: Int, inline v: ~[A], inline t: Tag[A,ARRAY]) : ARRAY =
    inline t match
      case _ : Tag[A&Raw.Boolean,Array[A&Raw.Boolean]] => boolean(x.cast[Array[Boolean]],i,v.cast[~[Boolean]]).cast[ARRAY]
      case _ : Tag[A&Raw.Byte,   Array[A&Raw.Byte   ]] => byte   (x.cast[Array[Byte   ]],i,v.cast[~[Byte   ]]).cast[ARRAY]
      case _ : Tag[A&Raw.Char,   Array[A&Raw.Char   ]] => char   (x.cast[Array[Char   ]],i,v.cast[~[Char   ]]).cast[ARRAY]
      case _ : Tag[A&Raw.Short,  Array[A&Raw.Short  ]] => short  (x.cast[Array[Short  ]],i,v.cast[~[Short  ]]).cast[ARRAY]
      case _ : Tag[A&Raw.Int,    Array[A&Raw.Int    ]] => int    (x.cast[Array[Int    ]],i,v.cast[~[Int    ]]).cast[ARRAY]
      case _ : Tag[A&Raw.Long,   Array[A&Raw.Long   ]] => long   (x.cast[Array[Long   ]],i,v.cast[~[Long   ]]).cast[ARRAY]
      case _ : Tag[A&Raw.Float,  Array[A&Raw.Float  ]] => float  (x.cast[Array[Float  ]],i,v.cast[~[Float  ]]).cast[ARRAY]
      case _ : Tag[A&Raw.Double, Array[A&Raw.Double ]] => double (x.cast[Array[Double ]],i,v.cast[~[Double ]]).cast[ARRAY]
      case _ : Tag[A&Ref,        Array[A&Ref        ]] => ref    (x.cast[Array[Ref    ]],i,v.cast[~[Ref    ]]).cast[ARRAY]
      case _                                               => any    (x.cast[Array[A      ]],i,v                 ).cast[ARRAY]

  def any[A](x: Array[A], i:Int, v: ~[A]): Array[A] =
    x match
       case x: Array[Ref]        => ref    (x,i,v,x.length)
       case x: Array[Int]        => int    (x,i,v,x.length)
       case x: Array[Double]     => double (x,i,v,x.length)
       case x: Array[Long]       => long   (x,i,v,x.length)
       case x: Array[Float]      => float  (x,i,v,x.length)
       case x: Array[Char]       => char   (x,i,v,x.length)
       case x: Array[Byte]       => byte   (x,i,v,x.length)
       case x: Array[Short]      => short  (x,i,v,x.length)
       case x: Array[Boolean]    => boolean(x,i,v,x.length)

  inline def boolean(x:Array[Boolean],inline i:Int, inline v: ~[Boolean]): Array[Boolean]= boolean(x,i,v,x.length)
  inline def byte   (x:Array[Byte],   inline i:Int, inline v: ~[Byte])   : Array[Byte]   = byte   (x,i,v,x.length)
  inline def char   (x:Array[Char],   inline i:Int, inline v: ~[Char])   : Array[Char]   = char   (x,i,v,x.length)
  inline def short  (x:Array[Short],  inline i:Int, inline v: ~[Short])  : Array[Short]  = short  (x,i,v,x.length)
  inline def int    (x:Array[Int],    inline i:Int, inline v: ~[Int])    : Array[Int]    = int    (x,i,v,x.length)
  inline def long   (x:Array[Long],   inline i:Int, inline v: ~[Long])   : Array[Long]   = long   (x,i,v,x.length)
  inline def float  (x:Array[Float],  inline i:Int, inline v: ~[Float])  : Array[Float]  = float  (x,i,v,x.length)
  inline def double (x:Array[Double], inline i:Int, inline v: ~[Double]) : Array[Double] = double (x,i,v,x.length)
  inline def ref    (x:Array[Ref],    inline i:Int, inline v: ~[Ref])    : Array[Ref]    = ref    (x,i,v,x.length)

  def boolean(x:Array[Boolean],i:Int, v: ~[Boolean],sz:Int): Array[Boolean]={val b=`def`.boolean.g.Buffer.accessible(new Array[Boolean](v.size_?.map(_ + sz) or i+J.initSize),i).^(_ ++= v); var a=b.access; val s=b.size+sz-i; if(a.length != s) a=a.copySize(s); x.copyTo(a,0,0,i); x.copyTo(a,b.size,i,sz-i); a}
  def byte   (x:Array[Byte],   i:Int, v: ~[Byte],   sz:Int): Array[Byte]   ={val b=`def`.byte   .g.Buffer.accessible(new Array[Byte   ](v.size_?.map(_ + sz) or i+J.initSize),i).^(_ ++= v); var a=b.access; val s=b.size+sz-i; if(a.length != s) a=a.copySize(s); x.copyTo(a,0,0,i); x.copyTo(a,b.size,i,sz-i); a}
  def char   (x:Array[Char],   i:Int, v: ~[Char],   sz:Int): Array[Char]   ={val b=`def`.char   .g.Buffer.accessible(new Array[Char   ](v.size_?.map(_ + sz) or i+J.initSize),i).^(_ ++= v); var a=b.access; val s=b.size+sz-i; if(a.length != s) a=a.copySize(s); x.copyTo(a,0,0,i); x.copyTo(a,b.size,i,sz-i); a}
  def short  (x:Array[Short],  i:Int, v: ~[Short],  sz:Int): Array[Short]  ={val b=`def`.short  .g.Buffer.accessible(new Array[Short  ](v.size_?.map(_ + sz) or i+J.initSize),i).^(_ ++= v); var a=b.access; val s=b.size+sz-i; if(a.length != s) a=a.copySize(s); x.copyTo(a,0,0,i); x.copyTo(a,b.size,i,sz-i); a}
  def int    (x:Array[Int],    i:Int, v: ~[Int],    sz:Int): Array[Int]    ={val b=`def`.int    .g.Buffer.accessible(new Array[Int    ](v.size_?.map(_ + sz) or i+J.initSize),i).^(_ ++= v); var a=b.access; val s=b.size+sz-i; if(a.length != s) a=a.copySize(s); x.copyTo(a,0,0,i); x.copyTo(a,b.size,i,sz-i); a}
  def long   (x:Array[Long],   i:Int, v: ~[Long],   sz:Int): Array[Long]   ={val b=`def`.long   .g.Buffer.accessible(new Array[Long   ](v.size_?.map(_ + sz) or i+J.initSize),i).^(_ ++= v); var a=b.access; val s=b.size+sz-i; if(a.length != s) a=a.copySize(s); x.copyTo(a,0,0,i); x.copyTo(a,b.size,i,sz-i); a}
  def float  (x:Array[Float],  i:Int, v: ~[Float],  sz:Int): Array[Float]  ={val b=`def`.float  .g.Buffer.accessible(new Array[Float  ](v.size_?.map(_ + sz) or i+J.initSize),i).^(_ ++= v); var a=b.access; val s=b.size+sz-i; if(a.length != s) a=a.copySize(s); x.copyTo(a,0,0,i); x.copyTo(a,b.size,i,sz-i); a}
  def double (x:Array[Double], i:Int, v: ~[Double], sz:Int): Array[Double] ={val b=`def`.double .g.Buffer.accessible(new Array[Double ](v.size_?.map(_ + sz) or i+J.initSize),i).^(_ ++= v); var a=b.access; val s=b.size+sz-i; if(a.length != s) a=a.copySize(s); x.copyTo(a,0,0,i); x.copyTo(a,b.size,i,sz-i); a}
  def ref    (x:Array[Ref],    i:Int, v: ~[Ref],    sz:Int): Array[Ref]    ={val b=`def`.any.ref  .Buffer.accessible(new Array[Ref    ](v.size_?.map(_ + sz) or i+J.initSize),i).^(_ ++= v); var a=b.access; val s=b.size+sz-i; if(a.length != s) a=a.copySize(s); x.copyTo(a,0,0,i); x.copyTo(a,b.size,i,sz-i); a}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
