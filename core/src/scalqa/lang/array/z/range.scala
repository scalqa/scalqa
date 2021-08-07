package scalqa; package lang; package array; package z; import language.implicitConversions

import java.util.{ Arrays }
import gen.`given`.ArrayShape

object range:

  inline def take[A,ARRAY<:Array.AnyType[A]](inline x: ARRAY, s:Int, inline sz: Int, inline t: ArrayShape[A,ARRAY]): ARRAY =
    inline t match
      case _ : ArrayShape[A&Boolean.Raw,Array[A&Boolean.Raw]] => Arrays.copyOfRange(x.cast[Array[Boolean]],s,s+sz).cast[ARRAY]
      case _ : ArrayShape[A&Byte.Raw,   Array[A&Byte.Raw   ]] => Arrays.copyOfRange(x.cast[Array[Byte   ]],s,s+sz).cast[ARRAY]
      case _ : ArrayShape[A&Char.Raw,   Array[A&Char.Raw   ]] => Arrays.copyOfRange(x.cast[Array[Char   ]],s,s+sz).cast[ARRAY]
      case _ : ArrayShape[A&Short.Raw,  Array[A&Short.Raw  ]] => Arrays.copyOfRange(x.cast[Array[Short  ]],s,s+sz).cast[ARRAY]
      case _ : ArrayShape[A&Int.Raw,    Array[A&Int.Raw    ]] => Arrays.copyOfRange(x.cast[Array[Int    ]],s,s+sz).cast[ARRAY]
      case _ : ArrayShape[A&Long.Raw,   Array[A&Long.Raw   ]] => Arrays.copyOfRange(x.cast[Array[Long   ]],s,s+sz).cast[ARRAY]
      case _ : ArrayShape[A&Float.Raw,  Array[A&Float.Raw  ]] => Arrays.copyOfRange(x.cast[Array[Float  ]],s,s+sz).cast[ARRAY]
      case _ : ArrayShape[A&Double.Raw, Array[A&Double.Raw ]] => Arrays.copyOfRange(x.cast[Array[Double ]],s,s+sz).cast[ARRAY]
      case _ : ArrayShape[A&AnyRef,     Array[A&AnyRef     ]] => Arrays.copyOfRange(x.cast[Array[AnyRef ]],s,s+sz).cast[ARRAY]
      case _                                                  =>            takeAny(x.cast[Array[A]]      ,s,sz  ).cast[ARRAY]

  def takeAny[A](x: Array[A], s:Int, sz: Int): Array[A] =
    x match
       case x: Array[AnyRef]     => Arrays.copyOfRange(x.cast[Array[AnyRef ]],s,s+sz).cast[Array[A]]
       case x: Array[Int]        => Arrays.copyOfRange(x.cast[Array[Int    ]],s,s+sz).cast[Array[A]]
       case x: Array[Double]     => Arrays.copyOfRange(x.cast[Array[Double ]],s,s+sz).cast[Array[A]]
       case x: Array[Long]       => Arrays.copyOfRange(x.cast[Array[Long   ]],s,s+sz).cast[Array[A]]
       case x: Array[Float]      => Arrays.copyOfRange(x.cast[Array[Float  ]],s,s+sz).cast[Array[A]]
       case x: Array[Char]       => Arrays.copyOfRange(x.cast[Array[Char   ]],s,s+sz).cast[Array[A]]
       case x: Array[Byte]       => Arrays.copyOfRange(x.cast[Array[Byte   ]],s,s+sz).cast[Array[A]]
       case x: Array[Short]      => Arrays.copyOfRange(x.cast[Array[Short  ]],s,s+sz).cast[Array[A]]
       case x: Array[Boolean]    => Arrays.copyOfRange(x.cast[Array[Boolean]],s,s+sz).cast[Array[A]]

  def drop[A,ARRAY<:Array.AnyType[A]](x: ARRAY, start:Int, sz:Int)(using t: ArrayShape[A,ARRAY]): ARRAY =
    val len = x.length
    val end = start+sz
    val a   = x.newArray(len - sz)
    System.arraycopy(x,0,a,0,start)
    System.arraycopy(x,end,a,start,len-end)
    a.cast[ARRAY]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
