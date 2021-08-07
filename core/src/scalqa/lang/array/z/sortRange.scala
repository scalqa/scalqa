package scalqa; package lang; package array; package z; import language.implicitConversions

import gen.`given`.ArrayShape
import java.util.{ Arrays, Collections}

object sortRange:

  inline def apply[A,ARRAY<:Array.AnyType[A]](inline x: ARRAY, inline p: Int, inline sz: Int, inline c:Ordering[A], inline t: ArrayShape[A,ARRAY]): Unit =
    inline t match
              case _ : ArrayShape[A&Boolean.Raw,Array[A&Boolean.Raw]] => boolean(x.cast[Array[Boolean]],p,sz,c.cast[Ordering[Boolean]])
              case _ : ArrayShape[A&Byte.Raw,   Array[A&Byte.Raw   ]] => byte   (x.cast[Array[Byte   ]],p,sz,c.cast[Ordering[Byte   ]])
              case _ : ArrayShape[A&Char.Raw,   Array[A&Char.Raw   ]] => char   (x.cast[Array[Char   ]],p,sz,c.cast[Ordering[Char   ]])
              case _ : ArrayShape[A&Short.Raw,  Array[A&Short.Raw  ]] => short  (x.cast[Array[Short  ]],p,sz,c.cast[Ordering[Short  ]])
              case _ : ArrayShape[A&Int.Raw,    Array[A&Int.Raw    ]] => int    (x.cast[Array[Int    ]],p,sz,c.cast[Ordering[Int    ]])
              case _ : ArrayShape[A&Long.Raw,   Array[A&Long.Raw   ]] => long   (x.cast[Array[Long   ]],p,sz,c.cast[Ordering[Long   ]])
              case _ : ArrayShape[A&Float.Raw,  Array[A&Float.Raw  ]] => float  (x.cast[Array[Float  ]],p,sz,c.cast[Ordering[Float  ]])
              case _ : ArrayShape[A&Double.Raw, Array[A&Double.Raw ]] => double (x.cast[Array[Double ]],p,sz,c.cast[Ordering[Double ]])
              case _ : ArrayShape[A&AnyRef,     Array[A&AnyRef     ]] => anyref (x.cast[Array[AnyRef ]],p,sz,c.cast[Ordering[AnyRef ]])
              case _                                                  => any    (x.cast[Array[A      ]],p,sz,c                        )

  def any[A](x: Array[A], p:Int, sz:Int, c:Ordering[A]): Unit =
    x match
       case x: Array[AnyRef]     => anyref(x,p,sz,c)
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
  def anyref (a:Array[AnyRef], p:Int, sz:Int, c:Ordering[AnyRef]) : Unit = Collections.sort(sort.RefList(a,p,sz),c)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
