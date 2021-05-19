package scalqa; package lang; package array; package z; import language.implicitConversions

import java.util.{ Arrays }
import Self.Given.ArrayTag

object range:

  inline def take[A,ARRAY<:Array.AnyType[A]](inline x: ARRAY, s:Int, inline sz: Int, inline t: ArrayTag[A,ARRAY]): ARRAY =
    inline t match
      case _ : ArrayTag[A&Raw.Boolean,Array[A&Raw.Boolean]] => Arrays.copyOfRange(x.cast[Array[Boolean]],s,s+sz).cast[ARRAY]
      case _ : ArrayTag[A&Raw.Byte,   Array[A&Raw.Byte   ]] => Arrays.copyOfRange(x.cast[Array[Byte   ]],s,s+sz).cast[ARRAY]
      case _ : ArrayTag[A&Raw.Char,   Array[A&Raw.Char   ]] => Arrays.copyOfRange(x.cast[Array[Char   ]],s,s+sz).cast[ARRAY]
      case _ : ArrayTag[A&Raw.Short,  Array[A&Raw.Short  ]] => Arrays.copyOfRange(x.cast[Array[Short  ]],s,s+sz).cast[ARRAY]
      case _ : ArrayTag[A&Raw.Int,    Array[A&Raw.Int    ]] => Arrays.copyOfRange(x.cast[Array[Int    ]],s,s+sz).cast[ARRAY]
      case _ : ArrayTag[A&Raw.Long,   Array[A&Raw.Long   ]] => Arrays.copyOfRange(x.cast[Array[Long   ]],s,s+sz).cast[ARRAY]
      case _ : ArrayTag[A&Raw.Float,  Array[A&Raw.Float  ]] => Arrays.copyOfRange(x.cast[Array[Float  ]],s,s+sz).cast[ARRAY]
      case _ : ArrayTag[A&Raw.Double, Array[A&Raw.Double ]] => Arrays.copyOfRange(x.cast[Array[Double ]],s,s+sz).cast[ARRAY]
      case _ : ArrayTag[A&Ref,        Array[A&Ref        ]] => Arrays.copyOfRange(x.cast[Array[Ref    ]],s,s+sz).cast[ARRAY]
      case _                                               =>            takeAny(x.cast[Array[A]]      ,s,sz  ).cast[ARRAY]

  def takeAny[A](x: Array[A], s:Int, sz: Int): Array[A] =
    x match
       case x: Array[Ref]        => Arrays.copyOfRange(x.cast[Array[Ref    ]],s,s+sz).cast[Array[A]]
       case x: Array[Int]        => Arrays.copyOfRange(x.cast[Array[Int    ]],s,s+sz).cast[Array[A]]
       case x: Array[Double]     => Arrays.copyOfRange(x.cast[Array[Double ]],s,s+sz).cast[Array[A]]
       case x: Array[Long]       => Arrays.copyOfRange(x.cast[Array[Long   ]],s,s+sz).cast[Array[A]]
       case x: Array[Float]      => Arrays.copyOfRange(x.cast[Array[Float  ]],s,s+sz).cast[Array[A]]
       case x: Array[Char]       => Arrays.copyOfRange(x.cast[Array[Char   ]],s,s+sz).cast[Array[A]]
       case x: Array[Byte]       => Arrays.copyOfRange(x.cast[Array[Byte   ]],s,s+sz).cast[Array[A]]
       case x: Array[Short]      => Arrays.copyOfRange(x.cast[Array[Short  ]],s,s+sz).cast[Array[A]]
       case x: Array[Boolean]    => Arrays.copyOfRange(x.cast[Array[Boolean]],s,s+sz).cast[Array[A]]

  def drop[A,ARRAY<:Array.AnyType[A]](x: ARRAY, start:Int, sz:Int)(using t: ArrayTag[A,ARRAY]): ARRAY =
    val len = x.length
    val end = start+sz
    ???
//    val a   = x.newArray(len - sz)
//    System.arraycopy(x,0,a,0,start)
//    System.arraycopy(x,end,a,start,len-end)
//    a.cast[ARRAY]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
