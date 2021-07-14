package scalqa; package lang; package array; package z; import language.implicitConversions

import gen.`given`.ArrayTag
import java.util.{ Arrays, Collections}

object sortRange:

  inline def apply[A,ARRAY<:Array.AnyType[A]](inline x: ARRAY, inline p: Int, inline sz: Int, inline c:Ordering[A], inline t: ArrayTag[A,ARRAY]): Unit =
    inline t match
              case _ : ArrayTag[A&Raw.Boolean,Array[A&Raw.Boolean]] => boolean(x.cast[Array[Boolean]],p,sz,c.cast[Ordering[Boolean]])
              case _ : ArrayTag[A&Raw.Byte,   Array[A&Raw.Byte   ]] => byte   (x.cast[Array[Byte   ]],p,sz,c.cast[Ordering[Byte   ]])
              case _ : ArrayTag[A&Raw.Char,   Array[A&Raw.Char   ]] => char   (x.cast[Array[Char   ]],p,sz,c.cast[Ordering[Char   ]])
              case _ : ArrayTag[A&Raw.Short,  Array[A&Raw.Short  ]] => short  (x.cast[Array[Short  ]],p,sz,c.cast[Ordering[Short  ]])
              case _ : ArrayTag[A&Raw.Int,    Array[A&Raw.Int    ]] => int    (x.cast[Array[Int    ]],p,sz,c.cast[Ordering[Int    ]])
              case _ : ArrayTag[A&Raw.Long,   Array[A&Raw.Long   ]] => long   (x.cast[Array[Long   ]],p,sz,c.cast[Ordering[Long   ]])
              case _ : ArrayTag[A&Raw.Float,  Array[A&Raw.Float  ]] => float  (x.cast[Array[Float  ]],p,sz,c.cast[Ordering[Float  ]])
              case _ : ArrayTag[A&Raw.Double, Array[A&Raw.Double ]] => double (x.cast[Array[Double ]],p,sz,c.cast[Ordering[Double ]])
              case _ : ArrayTag[A&Ref,        Array[A&Ref        ]] => ref    (x.cast[Array[Ref    ]],p,sz,c.cast[Ordering[Ref    ]])
              case _                                               => any    (x.cast[Array[A      ]],p,sz,c                          )

  def any[A](x: Array[A], p:Int, sz:Int, c:Ordering[A]): Unit =
    x match
       case x: Array[Ref]        => ref(x,p,sz,c)
       case x: Array[Int]        => int(x,p,sz,c)
       case x: Array[Double]     => double(x,p,sz,c)
       case x: Array[Long]       => long(x,p,sz,c)
       case x: Array[Float]      => float(x,p,sz,c)
       case x: Array[Char]       => char(x,p,sz,c)
       case x: Array[Byte]       => byte(x,p,sz,c)
       case x: Array[Short]      => short(x,p,sz,c)
       case x: Array[Boolean]    => boolean(x,p,sz,c)

  def boolean(a:Array[Boolean],p:Int, sz:Int, c:Ordering[Boolean]): Unit = Collections.sort(sort.BooleanList(a,p,sz),c)
  def byte   (a:Array[Byte],   p:Int, sz:Int, c:Ordering[Byte])   : Unit = if(c eq Byte.ordering)   Arrays.sort(a,p,p+sz) else Collections.sort(sort.ByteList  (a,p,sz),c)
  def char   (a:Array[Char],   p:Int, sz:Int, c:Ordering[Char])   : Unit = if(c eq Char.ordering)   Arrays.sort(a,p,p+sz) else Collections.sort(sort.CharList  (a,p,sz),c)
  def short  (a:Array[Short],  p:Int, sz:Int, c:Ordering[Short])  : Unit = if(c eq Short.ordering)  Arrays.sort(a,p,p+sz) else Collections.sort(sort.ShortList (a,p,sz),c)
  def int    (a:Array[Int],    p:Int, sz:Int, c:Ordering[Int])    : Unit = if(c eq Int.ordering)    Arrays.sort(a,p,p+sz) else Collections.sort(sort.IntList   (a,p,sz),c)
  def long   (a:Array[Long],   p:Int, sz:Int, c:Ordering[Long])   : Unit = if(c eq Long.ordering)   Arrays.sort(a,p,p+sz) else Collections.sort(sort.LongList  (a,p,sz),c)
  def float  (a:Array[Float],  p:Int, sz:Int, c:Ordering[Float])  : Unit = if(c eq Float.ordering)  Arrays.sort(a,p,p+sz) else Collections.sort(sort.FloatList (a,p,sz),c)
  def double (a:Array[Double], p:Int, sz:Int, c:Ordering[Double]) : Unit = if(c eq Double.ordering) Arrays.sort(a,p,p+sz) else Collections.sort(sort.DoubleList(a,p,sz),c)
  def ref    (a:Array[Ref],    p:Int, sz:Int, c:Ordering[Ref])    : Unit = Collections.sort(sort.RefList(a,p,sz),c)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
