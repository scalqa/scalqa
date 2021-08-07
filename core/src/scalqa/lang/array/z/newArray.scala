package scalqa; package lang; package array; package z; import language.implicitConversions

import gen.`given`.ArrayShape

object newArray:

  inline def apply[A,ARRAY<:Array.AnyType[A]](inline x: ARRAY, inline sz: Int, inline t: ArrayShape[A,ARRAY]): ARRAY =
    inline t match
              case _ : ArrayShape[A&Boolean.Raw,Array[A&Boolean.Raw]] => new Array[Boolean](sz).cast[ARRAY]
              case _ : ArrayShape[A&Byte.Raw,   Array[A&Byte.Raw   ]] => new Array[Byte   ](sz).cast[ARRAY]
              case _ : ArrayShape[A&Char.Raw,   Array[A&Char.Raw   ]] => new Array[Char   ](sz).cast[ARRAY]
              case _ : ArrayShape[A&Short.Raw,  Array[A&Short.Raw  ]] => new Array[Short  ](sz).cast[ARRAY]
              case _ : ArrayShape[A&Int.Raw,    Array[A&Int.Raw    ]] => new Array[Int    ](sz).cast[ARRAY]
              case _ : ArrayShape[A&Long.Raw,   Array[A&Long.Raw   ]] => new Array[Long   ](sz).cast[ARRAY]
              case _ : ArrayShape[A&Float.Raw,  Array[A&Float.Raw  ]] => new Array[Float  ](sz).cast[ARRAY]
              case _ : ArrayShape[A&Double.Raw, Array[A&Double.Raw ]] => new Array[Double ](sz).cast[ARRAY]
              case _                                                  => java.lang.reflect.Array.newInstance(x.getClass().getComponentType(), sz).cast[ARRAY]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
