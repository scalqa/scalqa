package scalqa; package lang; package array; package z; import language.implicitConversions

import gen.`given`.ArrayTag

object join:

  inline def apply[A,ARRAY<:Array.AnyType[A]](inline x: ARRAY, inline v: A, inline t: ArrayTag[A,ARRAY]) : ARRAY =
    inline t match
      case _ : ArrayTag[A&Raw.Boolean,Array[A&Raw.Boolean]] => boolean(x.cast[Array[Boolean]],v.cast[Boolean]).cast[ARRAY]
      case _ : ArrayTag[A&Raw.Byte,   Array[A&Raw.Byte   ]] => byte   (x.cast[Array[Byte   ]],v.cast[Byte   ]).cast[ARRAY]
      case _ : ArrayTag[A&Raw.Char,   Array[A&Raw.Char   ]] => char   (x.cast[Array[Char   ]],v.cast[Char   ]).cast[ARRAY]
      case _ : ArrayTag[A&Raw.Short,  Array[A&Raw.Short  ]] => short  (x.cast[Array[Short  ]],v.cast[Short  ]).cast[ARRAY]
      case _ : ArrayTag[A&Raw.Int,    Array[A&Raw.Int    ]] => int    (x.cast[Array[Int    ]],v.cast[Int    ]).cast[ARRAY]
      case _ : ArrayTag[A&Raw.Long,   Array[A&Raw.Long   ]] => long   (x.cast[Array[Long   ]],v.cast[Long   ]).cast[ARRAY]
      case _ : ArrayTag[A&Raw.Float,  Array[A&Raw.Float  ]] => float  (x.cast[Array[Float  ]],v.cast[Float  ]).cast[ARRAY]
      case _ : ArrayTag[A&Raw.Double, Array[A&Raw.Double ]] => double (x.cast[Array[Double ]],v.cast[Double ]).cast[ARRAY]
      case _ : ArrayTag[A&Ref,        Array[A&Ref        ]] => ref    (x.cast[Array[Ref    ]],v.cast[Ref    ]).cast[ARRAY]
      case _                                                => any    (x.cast[Array[A      ]],v              ).cast[ARRAY]

  def any[A](x: Array[A], v: A): Array[A] =
    x match
       case x: Array[Ref]        => ref    (x,v)
       case x: Array[Int]        => int    (x,v)
       case x: Array[Double]     => double (x,v)
       case x: Array[Long]       => long   (x,v)
       case x: Array[Float]      => float  (x,v)
       case x: Array[Char]       => char   (x,v)
       case x: Array[Byte]       => byte   (x,v)
       case x: Array[Short]      => short  (x,v)
       case x: Array[Boolean]    => boolean(x,v)

  def boolean(x: Array[Boolean], v: Boolean): Array[Boolean] = {val a=x.copySize(x.length+1); a(x.length)=v; a}
  def byte   (x: Array[Byte],    v: Byte)   : Array[Byte]    = {val a=x.copySize(x.length+1); a(x.length)=v; a}
  def char   (x: Array[Char],    v: Char)   : Array[Char]    = {val a=x.copySize(x.length+1); a(x.length)=v; a}
  def short  (x: Array[Short],   v: Short)  : Array[Short]   = {val a=x.copySize(x.length+1); a(x.length)=v; a}
  def int    (x: Array[Int],     v: Int)    : Array[Int]     = {val a=x.copySize(x.length+1); a(x.length)=v; a}
  def long   (x: Array[Long],    v: Long)   : Array[Long]    = {val a=x.copySize(x.length+1); a(x.length)=v; a}
  def float  (x: Array[Float],   v: Float)  : Array[Float]   = {val a=x.copySize(x.length+1); a(x.length)=v; a}
  def double (x: Array[Double],  v: Double) : Array[Double]  = {val a=x.copySize(x.length+1); a(x.length)=v; a}
  def ref    (x: Array[Ref],     v: Ref)    : Array[Ref]     = {val a=x.copySize(x.length+1); a(x.length)=v; a}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
