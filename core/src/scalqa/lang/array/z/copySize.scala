package scalqa; package lang; package array; package z; import language.implicitConversions

import java.util.Arrays
import gen.`given`.ArrayShape

object copySize:

  inline def apply[A,ARRAY<:Array.AnyType[A]](inline x: ARRAY, inline sz: Int, inline t: ArrayShape[A,ARRAY]): ARRAY =
    inline t match
              case _ : ArrayShape[A&Boolean.Raw,Array[A&Boolean.Raw]] => Arrays.copyOf(x.cast[Array[Boolean]],sz).cast[ARRAY]
              case _ : ArrayShape[A&Byte.Raw,   Array[A&Byte.Raw   ]] => Arrays.copyOf(x.cast[Array[Byte   ]],sz).cast[ARRAY]
              case _ : ArrayShape[A&Char.Raw,   Array[A&Char.Raw   ]] => Arrays.copyOf(x.cast[Array[Char   ]],sz).cast[ARRAY]
              case _ : ArrayShape[A&Short.Raw,  Array[A&Short.Raw  ]] => Arrays.copyOf(x.cast[Array[Short  ]],sz).cast[ARRAY]
              case _ : ArrayShape[A&Int.Raw,    Array[A&Int.Raw    ]] => Arrays.copyOf(x.cast[Array[Int    ]],sz).cast[ARRAY]
              case _ : ArrayShape[A&Long.Raw,   Array[A&Long.Raw   ]] => Arrays.copyOf(x.cast[Array[Long   ]],sz).cast[ARRAY]
              case _ : ArrayShape[A&Float.Raw,  Array[A&Float.Raw  ]] => Arrays.copyOf(x.cast[Array[Float  ]],sz).cast[ARRAY]
              case _ : ArrayShape[A&Double.Raw, Array[A&Double.Raw ]] => Arrays.copyOf(x.cast[Array[Double ]],sz).cast[ARRAY]
              case _ : ArrayShape[A&AnyRef,     Array[A&AnyRef     ]] => Arrays.copyOf(x.cast[Array[AnyRef ]],sz).cast[ARRAY]
              case _                                                  =>           any(x.cast[Array[A      ]],sz).cast[ARRAY]

  def any[A](x: Array[A], sz:Int): Array[A] =
    x match
      case x: Array[AnyRef]     => Arrays.copyOf(x.cast[Array[AnyRef ]],sz).cast[Array[A]]
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
