package scalqa; package lang; package array; package z; import language.implicitConversions

import gen.`given`.ArrayShape

object joinAllAt:

  inline def apply[A,ARRAY<:Array.AnyType[A]](inline x: ARRAY, inline i: Int, inline v: ~[A], inline t: ArrayShape[A,ARRAY]) : ARRAY =
    inline t match
      case _ : ArrayShape[A&Boolean.Raw,Array[A&Boolean.Raw]] => boolean(x.cast[Array[Boolean]],i,v.cast[~[Boolean]]).cast[ARRAY]
      case _ : ArrayShape[A&Byte.Raw,   Array[A&Byte.Raw   ]] => byte   (x.cast[Array[Byte   ]],i,v.cast[~[Byte   ]]).cast[ARRAY]
      case _ : ArrayShape[A&Char.Raw,   Array[A&Char.Raw   ]] => char   (x.cast[Array[Char   ]],i,v.cast[~[Char   ]]).cast[ARRAY]
      case _ : ArrayShape[A&Short.Raw,  Array[A&Short.Raw  ]] => short  (x.cast[Array[Short  ]],i,v.cast[~[Short  ]]).cast[ARRAY]
      case _ : ArrayShape[A&Int.Raw,    Array[A&Int.Raw    ]] => int    (x.cast[Array[Int    ]],i,v.cast[~[Int    ]]).cast[ARRAY]
      case _ : ArrayShape[A&Long.Raw,   Array[A&Long.Raw   ]] => long   (x.cast[Array[Long   ]],i,v.cast[~[Long   ]]).cast[ARRAY]
      case _ : ArrayShape[A&Float.Raw,  Array[A&Float.Raw  ]] => float  (x.cast[Array[Float  ]],i,v.cast[~[Float  ]]).cast[ARRAY]
      case _ : ArrayShape[A&Double.Raw, Array[A&Double.Raw ]] => double (x.cast[Array[Double ]],i,v.cast[~[Double ]]).cast[ARRAY]
      case _ : ArrayShape[A&AnyRef,     Array[A&AnyRef     ]] => anyref (x.cast[Array[AnyRef ]],i,v.cast[~[AnyRef ]]).cast[ARRAY]
      case _                                                  => any    (x.cast[Array[A      ]],i,v                 ).cast[ARRAY]

  def any[A](x: Array[A], i:Int, v: ~[A]): Array[A] =
    x match
       case x: Array[AnyRef]     => anyref (x,i,v,x.length)
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
  inline def anyref (x:Array[AnyRef], inline i:Int, inline v: ~[AnyRef]) : Array[AnyRef] = anyref (x,i,v,x.length)

  def boolean(x:Array[Boolean],i:Int, v: ~[Boolean],sz:Int): Array[Boolean]={val b=lang.boolean.g.Buffer.accessible(new Array[Boolean](v.size_?.map(_ + sz) or i+J.initSize),i).^(_ ++= v); var a=b.access; val s=b.size+sz-i; if(a.length != s) a=a.copySize(s); x.copyTo(a,0,0,i); x.copyTo(a,b.size,i,sz-i); a}
  def byte   (x:Array[Byte],   i:Int, v: ~[Byte],   sz:Int): Array[Byte]   ={val b=lang.byte   .g.Buffer.accessible(new Array[Byte   ](v.size_?.map(_ + sz) or i+J.initSize),i).^(_ ++= v); var a=b.access; val s=b.size+sz-i; if(a.length != s) a=a.copySize(s); x.copyTo(a,0,0,i); x.copyTo(a,b.size,i,sz-i); a}
  def char   (x:Array[Char],   i:Int, v: ~[Char],   sz:Int): Array[Char]   ={val b=lang.char   .g.Buffer.accessible(new Array[Char   ](v.size_?.map(_ + sz) or i+J.initSize),i).^(_ ++= v); var a=b.access; val s=b.size+sz-i; if(a.length != s) a=a.copySize(s); x.copyTo(a,0,0,i); x.copyTo(a,b.size,i,sz-i); a}
  def short  (x:Array[Short],  i:Int, v: ~[Short],  sz:Int): Array[Short]  ={val b=lang.short  .g.Buffer.accessible(new Array[Short  ](v.size_?.map(_ + sz) or i+J.initSize),i).^(_ ++= v); var a=b.access; val s=b.size+sz-i; if(a.length != s) a=a.copySize(s); x.copyTo(a,0,0,i); x.copyTo(a,b.size,i,sz-i); a}
  def int    (x:Array[Int],    i:Int, v: ~[Int],    sz:Int): Array[Int]    ={val b=lang.int    .g.Buffer.accessible(new Array[Int    ](v.size_?.map(_ + sz) or i+J.initSize),i).^(_ ++= v); var a=b.access; val s=b.size+sz-i; if(a.length != s) a=a.copySize(s); x.copyTo(a,0,0,i); x.copyTo(a,b.size,i,sz-i); a}
  def long   (x:Array[Long],   i:Int, v: ~[Long],   sz:Int): Array[Long]   ={val b=lang.long   .g.Buffer.accessible(new Array[Long   ](v.size_?.map(_ + sz) or i+J.initSize),i).^(_ ++= v); var a=b.access; val s=b.size+sz-i; if(a.length != s) a=a.copySize(s); x.copyTo(a,0,0,i); x.copyTo(a,b.size,i,sz-i); a}
  def float  (x:Array[Float],  i:Int, v: ~[Float],  sz:Int): Array[Float]  ={val b=lang.float  .g.Buffer.accessible(new Array[Float  ](v.size_?.map(_ + sz) or i+J.initSize),i).^(_ ++= v); var a=b.access; val s=b.size+sz-i; if(a.length != s) a=a.copySize(s); x.copyTo(a,0,0,i); x.copyTo(a,b.size,i,sz-i); a}
  def double (x:Array[Double], i:Int, v: ~[Double], sz:Int): Array[Double] ={val b=lang.double .g.Buffer.accessible(new Array[Double ](v.size_?.map(_ + sz) or i+J.initSize),i).^(_ ++= v); var a=b.access; val s=b.size+sz-i; if(a.length != s) a=a.copySize(s); x.copyTo(a,0,0,i); x.copyTo(a,b.size,i,sz-i); a}
  def anyref (x:Array[AnyRef], i:Int, v: ~[AnyRef], sz:Int): Array[AnyRef] ={val b=lang.anyref .g.Buffer.accessible(new Array[AnyRef ](v.size_?.map(_ + sz) or i+J.initSize),i).^(_ ++= v); var a=b.access; val s=b.size+sz-i; if(a.length != s) a=a.copySize(s); x.copyTo(a,0,0,i); x.copyTo(a,b.size,i,sz-i); a}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
