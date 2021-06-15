package scalqa; package lang; package array; package z; import language.implicitConversions

import Gen.Given.ArrayTag
import java.util.{ Arrays, Collections}

object sort:

  inline def apply[A,ARRAY<:Array.AnyType[A]](inline x: ARRAY, inline c:Ordering[A], inline t: ArrayTag[A,ARRAY]): Unit =
    inline t match
              case _ : ArrayTag[A&Raw.Boolean,Array[A&Raw.Boolean]] => boolean(x.cast[Array[Boolean]],c.cast[Ordering[Boolean]])
              case _ : ArrayTag[A&Raw.Byte,   Array[A&Raw.Byte   ]] => byte   (x.cast[Array[Byte   ]],c.cast[Ordering[Byte   ]])
              case _ : ArrayTag[A&Raw.Char,   Array[A&Raw.Char   ]] => char   (x.cast[Array[Char   ]],c.cast[Ordering[Char   ]])
              case _ : ArrayTag[A&Raw.Short,  Array[A&Raw.Short  ]] => short  (x.cast[Array[Short  ]],c.cast[Ordering[Short  ]])
              case _ : ArrayTag[A&Raw.Int,    Array[A&Raw.Int    ]] => int    (x.cast[Array[Int    ]],c.cast[Ordering[Int    ]])
              case _ : ArrayTag[A&Raw.Long,   Array[A&Raw.Long   ]] => long   (x.cast[Array[Long   ]],c.cast[Ordering[Long   ]])
              case _ : ArrayTag[A&Raw.Float,  Array[A&Raw.Float  ]] => float  (x.cast[Array[Float  ]],c.cast[Ordering[Float  ]])
              case _ : ArrayTag[A&Raw.Double, Array[A&Raw.Double ]] => double (x.cast[Array[Double ]],c.cast[Ordering[Double ]])
              case _ : ArrayTag[A&Ref,        Array[A&Ref        ]] => ref    (x.cast[Array[Ref    ]],c.cast[Ordering[Ref    ]])
              case _                                               => any    (x.cast[Array[A      ]],c                          )

  def any  [A](x: Array[A], c:Ordering[A]): Unit =
    x match
       case x: Array[Ref]        => ref(x,c)
       case x: Array[Int]        => int(x,c)
       case x: Array[Double]     => double(x,c)
       case x: Array[Long]       => long(x,c)
       case x: Array[Float]      => float(x,c)
       case x: Array[Char]       => char(x,c)
       case x: Array[Byte]       => byte(x,c)
       case x: Array[Short]      => short(x,c)
       case x: Array[Boolean]    => boolean(x,c)

  def boolean(a:Array[Boolean],c:Ordering[Boolean])               : Unit = Collections.sort(BooleanList(a,0,a.length),c)
  def byte   (a:Array[Byte],   c:Ordering[Byte])                  : Unit = if(c eq Byte.ordering)   Arrays.sort(a) else Collections.sort(ByteList  (a,0,a.length),c)
  def char   (a:Array[Char],   c:Ordering[Char])                  : Unit = if(c eq Char.ordering)   Arrays.sort(a) else Collections.sort(CharList  (a,0,a.length),c)
  def short  (a:Array[Short],  c:Ordering[Short])                 : Unit = if(c eq Short.ordering)  Arrays.sort(a) else Collections.sort(ShortList (a,0,a.length),c)
  def int    (a:Array[Int],    c:Ordering[Int])                   : Unit = if(c eq Int.ordering)    Arrays.sort(a) else Collections.sort(IntList   (a,0,a.length),c)
  def long   (a:Array[Long],   c:Ordering[Long])                  : Unit = if(c eq Long.ordering)   Arrays.sort(a) else Collections.sort(LongList  (a,0,a.length),c)
  def float  (a:Array[Float],  c:Ordering[Float])                 : Unit = if(c eq Float.ordering)  Arrays.sort(a) else Collections.sort(FloatList (a,0,a.length),c)
  def double (a:Array[Double], c:Ordering[Double])                : Unit = if(c eq Double.ordering) Arrays.sort(a) else Collections.sort(DoubleList(a,0,a.length),c)
  def ref    (a:Array[Ref],    c:Ordering[Ref])                   : Unit = Collections.sort(RefList(a,0,a.length),c)

  class BooleanList(a: Array[Boolean],p:Int, val size:Int) extends java.util.AbstractList[Boolean]{def get(i:Int)=a(p+i); override def set(i:Int,v:Boolean)={val j=p+i; val o=a(j); a(j)=v; o}}
  class ByteList   (a: Array[Byte],   p:Int, val size:Int) extends java.util.AbstractList[Byte]   {def get(i:Int)=a(p+i); override def set(i:Int,v:Byte)   ={val j=p+i; val o=a(j); a(j)=v; o}}
  class CharList   (a: Array[Char],   p:Int, val size:Int) extends java.util.AbstractList[Char]   {def get(i:Int)=a(p+i); override def set(i:Int,v:Char)   ={val j=p+i; val o=a(j); a(j)=v; o}}
  class ShortList  (a: Array[Short],  p:Int, val size:Int) extends java.util.AbstractList[Short]  {def get(i:Int)=a(p+i); override def set(i:Int,v:Short)  ={val j=p+i; val o=a(j); a(j)=v; o}}
  class IntList    (a: Array[Int],    p:Int, val size:Int) extends java.util.AbstractList[Int]    {def get(i:Int)=a(p+i); override def set(i:Int,v:Int)    ={val j=p+i; val o=a(j); a(j)=v; o}}
  class LongList   (a: Array[Long],   p:Int, val size:Int) extends java.util.AbstractList[Long]   {def get(i:Int)=a(p+i); override def set(i:Int,v:Long)   ={val j=p+i; val o=a(j); a(j)=v; o}}
  class FloatList  (a: Array[Float],  p:Int, val size:Int) extends java.util.AbstractList[Float]  {def get(i:Int)=a(p+i); override def set(i:Int,v:Float)  ={val j=p+i; val o=a(j); a(j)=v; o}}
  class DoubleList (a: Array[Double], p:Int, val size:Int) extends java.util.AbstractList[Double] {def get(i:Int)=a(p+i); override def set(i:Int,v:Double) ={val j=p+i; val o=a(j); a(j)=v; o}}
  class RefList    (a: Array[Ref],    p:Int, val size:Int) extends java.util.AbstractList[Ref]    {def get(i:Int)=a(p+i); override def set(i:Int,v:Ref)    ={val j=p+i; val o=a(j); a(j)=v; o}}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
