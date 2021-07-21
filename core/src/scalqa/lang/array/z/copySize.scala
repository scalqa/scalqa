package scalqa; package lang; package array; package z; import language.implicitConversions

import java.util.Arrays
import gen.`given`.ArrayTag

object copySize:

  inline def apply[A,ARRAY<:Array.AnyType[A]](inline x: ARRAY, inline sz: Int, inline t: ArrayTag[A,ARRAY]): ARRAY =
    inline t match
              case _ : ArrayTag[A&Raw.Boolean,Array[A&Raw.Boolean]] => Arrays.copyOf(x.cast[Array[Boolean]],sz).cast[ARRAY]
              case _ : ArrayTag[A&Raw.Byte,   Array[A&Raw.Byte   ]] => Arrays.copyOf(x.cast[Array[Byte   ]],sz).cast[ARRAY]
              case _ : ArrayTag[A&Raw.Char,   Array[A&Raw.Char   ]] => Arrays.copyOf(x.cast[Array[Char   ]],sz).cast[ARRAY]
              case _ : ArrayTag[A&Raw.Short,  Array[A&Raw.Short  ]] => Arrays.copyOf(x.cast[Array[Short  ]],sz).cast[ARRAY]
              case _ : ArrayTag[A&Raw.Int,    Array[A&Raw.Int    ]] => Arrays.copyOf(x.cast[Array[Int    ]],sz).cast[ARRAY]
              case _ : ArrayTag[A&Raw.Long,   Array[A&Raw.Long   ]] => Arrays.copyOf(x.cast[Array[Long   ]],sz).cast[ARRAY]
              case _ : ArrayTag[A&Raw.Float,  Array[A&Raw.Float  ]] => Arrays.copyOf(x.cast[Array[Float  ]],sz).cast[ARRAY]
              case _ : ArrayTag[A&Raw.Double, Array[A&Raw.Double ]] => Arrays.copyOf(x.cast[Array[Double ]],sz).cast[ARRAY]
              case _ : ArrayTag[A&Ref,        Array[A&Ref        ]] => Arrays.copyOf(x.cast[Array[Ref    ]],sz).cast[ARRAY]
              case _                                                =>           any(x.cast[Array[A      ]],sz).cast[ARRAY]

  def any[A](x: Array[A], sz:Int): Array[A] =
    x match
      case x: Array[Ref]        => Arrays.copyOf(x.cast[Array[Ref    ]],sz).cast[Array[A]]
      case x: Array[Int]        => Arrays.copyOf(x.cast[Array[Int    ]],sz).cast[Array[A]]
      case x: Array[Double]     => Arrays.copyOf(x.cast[Array[Double ]],sz).cast[Array[A]]
      case x: Array[Long]       => Arrays.copyOf(x.cast[Array[Long   ]],sz).cast[Array[A]]
      case x: Array[Float]      => Arrays.copyOf(x.cast[Array[Float  ]],sz).cast[Array[A]]
      case x: Array[Char]       => Arrays.copyOf(x.cast[Array[Char   ]],sz).cast[Array[A]]
      case x: Array[Byte]       => Arrays.copyOf(x.cast[Array[Byte   ]],sz).cast[Array[A]]
      case x: Array[Short]      => Arrays.copyOf(x.cast[Array[Short  ]],sz).cast[Array[A]]
      case x: Array[Boolean]    => Arrays.copyOf(x.cast[Array[Boolean]],sz).cast[Array[A]]
      case _                    => J.illegalState()



/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
