package scalqa; package lang; package array; package z; import language.implicitConversions

import Shape.OfArray.Any

object newArray:

  inline def apply[A,ARRAY<:Any[A]](inline x: ARRAY, inline sz: Int, inline t: Any.Def[A,ARRAY]): ARRAY =
    inline t match
              case _ : Any.Def[A&Raw.Boolean,Array[A&Raw.Boolean]] => new Array[Boolean](sz).cast[ARRAY]
              case _ : Any.Def[A&Raw.Byte,   Array[A&Raw.Byte   ]] => new Array[Byte](sz).cast[ARRAY]
              case _ : Any.Def[A&Raw.Char,   Array[A&Raw.Char   ]] => new Array[Char](sz).cast[ARRAY]
              case _ : Any.Def[A&Raw.Short,  Array[A&Raw.Short  ]] => new Array[Short](sz).cast[ARRAY]
              case _ : Any.Def[A&Raw.Int,    Array[A&Raw.Int    ]] => new Array[Int](sz).cast[ARRAY]
              case _ : Any.Def[A&Raw.Long,   Array[A&Raw.Long   ]] => new Array[Long](sz).cast[ARRAY]
              case _ : Any.Def[A&Raw.Float,  Array[A&Raw.Float  ]] => new Array[Float](sz).cast[ARRAY]
              case _ : Any.Def[A&Raw.Double, Array[A&Raw.Double ]] => new Array[Double](sz).cast[ARRAY]
              case _                                               => java.lang.reflect.Array.newInstance(x.getClass().getComponentType(), sz).cast[ARRAY]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
