package scalqa; package lang; package array; package z; import language.implicitConversions

import gen.`given`.ArrayShape

object join:

  inline def apply[A,ARRAY<:Array.AnyType[A]](inline x: ARRAY, inline v: A, inline t: ArrayShape[A,ARRAY]) : ARRAY =
    inline t match
      case _ : ArrayShape[A&Boolean.Raw,Array[A&Boolean.Raw]] => boolean(x.cast[Array[Boolean]],v.cast[Boolean]).cast[ARRAY]
      case _ : ArrayShape[A&Byte.Raw,   Array[A&Byte.Raw   ]] => byte   (x.cast[Array[Byte   ]],v.cast[Byte   ]).cast[ARRAY]
      case _ : ArrayShape[A&Char.Raw,   Array[A&Char.Raw   ]] => char   (x.cast[Array[Char   ]],v.cast[Char   ]).cast[ARRAY]
      case _ : ArrayShape[A&Short.Raw,  Array[A&Short.Raw  ]] => short  (x.cast[Array[Short  ]],v.cast[Short  ]).cast[ARRAY]
      case _ : ArrayShape[A&Int.Raw,    Array[A&Int.Raw    ]] => int    (x.cast[Array[Int    ]],v.cast[Int    ]).cast[ARRAY]
      case _ : ArrayShape[A&Long.Raw,   Array[A&Long.Raw   ]] => long   (x.cast[Array[Long   ]],v.cast[Long   ]).cast[ARRAY]
      case _ : ArrayShape[A&Float.Raw,  Array[A&Float.Raw  ]] => float  (x.cast[Array[Float  ]],v.cast[Float  ]).cast[ARRAY]
      case _ : ArrayShape[A&Double.Raw, Array[A&Double.Raw ]] => double (x.cast[Array[Double ]],v.cast[Double ]).cast[ARRAY]
      case _ : ArrayShape[A&AnyRef,     Array[A&AnyRef     ]] => anyref (x.cast[Array[AnyRef ]],v.cast[AnyRef ]).cast[ARRAY]
      case _                                                  => any    (x.cast[Array[A      ]],v              ).cast[ARRAY]

  def any[A](x: Array[A], v: A): Array[A] =
    x match
       case x: Array[AnyRef]     => anyref (x,v)
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
  def anyref (x: Array[AnyRef],  v: AnyRef) : Array[AnyRef]  = {val a=x.copySize(x.length+1); a(x.length)=v; a}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
