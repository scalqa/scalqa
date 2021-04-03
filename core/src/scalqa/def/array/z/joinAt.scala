package scalqa; package `def`; package array; package z; import language.implicitConversions

import Shape.OfArray.*

object joinAt:

  inline def apply[A,ARRAY<:Any[A]](inline x: ARRAY, inline i: Int, inline v: A, inline t: Tag[A,ARRAY]) : ARRAY =
    inline t match
      case _ : Tag[A&Raw.Boolean,Array[A&Raw.Boolean]] => boolean(x.cast[Array[Boolean]],i,v.cast[Boolean]).cast[ARRAY]
      case _ : Tag[A&Raw.Byte,   Array[A&Raw.Byte   ]] => byte   (x.cast[Array[Byte   ]],i,v.cast[Byte   ]).cast[ARRAY]
      case _ : Tag[A&Raw.Char,   Array[A&Raw.Char   ]] => char   (x.cast[Array[Char   ]],i,v.cast[Char   ]).cast[ARRAY]
      case _ : Tag[A&Raw.Short,  Array[A&Raw.Short  ]] => short  (x.cast[Array[Short  ]],i,v.cast[Short  ]).cast[ARRAY]
      case _ : Tag[A&Raw.Int,    Array[A&Raw.Int    ]] => int    (x.cast[Array[Int    ]],i,v.cast[Int    ]).cast[ARRAY]
      case _ : Tag[A&Raw.Long,   Array[A&Raw.Long   ]] => long   (x.cast[Array[Long   ]],i,v.cast[Long   ]).cast[ARRAY]
      case _ : Tag[A&Raw.Float,  Array[A&Raw.Float  ]] => float  (x.cast[Array[Float  ]],i,v.cast[Float  ]).cast[ARRAY]
      case _ : Tag[A&Raw.Double, Array[A&Raw.Double ]] => double (x.cast[Array[Double ]],i,v.cast[Double ]).cast[ARRAY]
      case _ : Tag[A&Ref,        Array[A&Ref        ]] => ref    (x.cast[Array[Ref    ]],i,v.cast[Ref    ]).cast[ARRAY]
      case _                                               => any    (x.cast[Array[A      ]],i,v              ).cast[ARRAY]

  def any[A](x: Array[A], i: Int, v: A): Array[A] =
    x match
       case x: Array[Ref]        => ref    (x,i,v)
       case x: Array[Int]        => int    (x,i,v)
       case x: Array[Double]     => double (x,i,v)
       case x: Array[Long]       => long   (x,i,v)
       case x: Array[Float]      => float  (x,i,v)
       case x: Array[Char]       => char   (x,i,v)
       case x: Array[Byte]       => byte   (x,i,v)
       case x: Array[Short]      => short  (x,i,v)
       case x: Array[Boolean]    => boolean(x,i,v)

  def boolean(x: Array[Boolean], i: Int, v: Boolean): Array[Boolean] = {val a=x.newArray(x.length+1); x.copyTo(a,0,0,i); a(i)=v; x.copyTo(a,i+1,i,x.length-i); a}
  def byte   (x: Array[Byte],    i: Int, v: Byte)   : Array[Byte]    = {val a=x.newArray(x.length+1); x.copyTo(a,0,0,i); a(i)=v; x.copyTo(a,i+1,i,x.length-i); a}
  def char   (x: Array[Char],    i: Int, v: Char)   : Array[Char]    = {val a=x.newArray(x.length+1); x.copyTo(a,0,0,i); a(i)=v; x.copyTo(a,i+1,i,x.length-i); a}
  def short  (x: Array[Short],   i: Int, v: Short)  : Array[Short]   = {val a=x.newArray(x.length+1); x.copyTo(a,0,0,i); a(i)=v; x.copyTo(a,i+1,i,x.length-i); a}
  def int    (x: Array[Int],     i: Int, v: Int)    : Array[Int]     = {val a=x.newArray(x.length+1); x.copyTo(a,0,0,i); a(i)=v; x.copyTo(a,i+1,i,x.length-i); a}
  def long   (x: Array[Long],    i: Int, v: Long)   : Array[Long]    = {val a=x.newArray(x.length+1); x.copyTo(a,0,0,i); a(i)=v; x.copyTo(a,i+1,i,x.length-i); a}
  def float  (x: Array[Float],   i: Int, v: Float)  : Array[Float]   = {val a=x.newArray(x.length+1); x.copyTo(a,0,0,i); a(i)=v; x.copyTo(a,i+1,i,x.length-i); a}
  def double (x: Array[Double],  i: Int, v: Double) : Array[Double]  = {val a=x.newArray(x.length+1); x.copyTo(a,0,0,i); a(i)=v; x.copyTo(a,i+1,i,x.length-i); a}
  def ref    (x: Array[Ref],     i: Int, v: Ref)    : Array[Ref]     = {val a=x.newArray(x.length+1); x.copyTo(a,0,0,i); a(i)=v; x.copyTo(a,i+1,i,x.length-i); a}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
