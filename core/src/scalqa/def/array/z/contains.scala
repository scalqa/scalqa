package scalqa; package `def`; package array; package z; import language.implicitConversions

import Shape.OfArray.*

object contains:

  inline def apply[A,ARRAY<:Any[A]](inline x: ARRAY, inline v: A, inline t: Tag[A,ARRAY]): Boolean =
    inline t match
              case _ : Tag[A&Raw.Boolean,Array[A&Raw.Boolean]] => boolean(x.cast[Array[Boolean]],v.cast[Boolean])
              case _ : Tag[A&Raw.Byte,   Array[A&Raw.Byte   ]] => byte   (x.cast[Array[Byte   ]],v.cast[Byte])
              case _ : Tag[A&Raw.Char,   Array[A&Raw.Char   ]] => char   (x.cast[Array[Char   ]],v.cast[Char])
              case _ : Tag[A&Raw.Short,  Array[A&Raw.Short  ]] => short  (x.cast[Array[Short  ]],v.cast[Short])
              case _ : Tag[A&Raw.Int,    Array[A&Raw.Int    ]] => int    (x.cast[Array[Int    ]],v.cast[Int])
              case _ : Tag[A&Raw.Long,   Array[A&Raw.Long   ]] => long   (x.cast[Array[Long   ]],v.cast[Long])
              case _ : Tag[A&Raw.Float,  Array[A&Raw.Float  ]] => float  (x.cast[Array[Float  ]],v.cast[Float])
              case _ : Tag[A&Raw.Double, Array[A&Raw.Double ]] => double (x.cast[Array[Double ]],v.cast[Double])
              case _ : Tag[A&Ref,        Array[A&Ref        ]] => ref    (x.cast[Array[Ref    ]],v.cast[Ref])
              case _                                               => any    (x.cast[Array[A      ]],v)

  def any[A](x: Array[A], v: A): Boolean =
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

  def boolean(a: Array[Boolean], v: Boolean, sz: Int): Boolean = {var i=0; while(i<sz){if(a(i)==v) return true; i+=1}; false}
  def byte   (a: Array[Byte],    v: Byte,    sz: Int): Boolean = {var i=0; while(i<sz){if(a(i)==v) return true; i+=1}; false}
  def char   (a: Array[Char],    v: Char,    sz: Int): Boolean = {var i=0; while(i<sz){if(a(i)==v) return true; i+=1}; false}
  def short  (a: Array[Short],   v: Short,   sz: Int): Boolean = {var i=0; while(i<sz){if(a(i)==v) return true; i+=1}; false}
  def int    (a: Array[Int],     v: Int,     sz: Int): Boolean = {var i=0; while(i<sz){if(a(i)==v) return true; i+=1}; false}
  def long   (a: Array[Long],    v: Long,    sz: Int): Boolean = {var i=0; while(i<sz){if(a(i)==v) return true; i+=1}; false}
  def float  (a: Array[Float],   v: Float,   sz: Int): Boolean = {var i=0; while(i<sz){if(a(i)==v) return true; i+=1}; false}
  def double (a: Array[Double],  v: Double,  sz: Int): Boolean = {var i=0; while(i<sz){if(a(i)==v) return true; i+=1}; false}
  def ref    (a: Array[Ref],     v: Ref,     sz: Int): Boolean = {var i=0; while(i<sz){if(a(i)==v) return true; i+=1}; false}

  inline def boolean(x:Array[Boolean],inline v: Boolean): Boolean = boolean(x,v,x.length)
  inline def byte   (x:Array[Byte],   inline v: Byte)   : Boolean = byte   (x,v,x.length)
  inline def char   (x:Array[Char],   inline v: Char)   : Boolean = char   (x,v,x.length)
  inline def short  (x:Array[Short],  inline v: Short)  : Boolean = short  (x,v,x.length)
  inline def int    (x:Array[Int],    inline v: Int)    : Boolean = int    (x,v,x.length)
  inline def long   (x:Array[Long],   inline v: Long)   : Boolean = long   (x,v,x.length)
  inline def float  (x:Array[Float],  inline v: Float)  : Boolean = float  (x,v,x.length)
  inline def double (x:Array[Double], inline v: Double) : Boolean = double (x,v,x.length)
  inline def ref    (x:Array[Ref],    inline v: Ref)    : Boolean = ref    (x,v,x.length)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
