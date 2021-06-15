package scalqa; package lang; package array; package z; import language.implicitConversions

import Gen.Given.ArrayTag

object newArray:

  inline def apply[A,ARRAY<:Array.AnyType[A]](inline x: ARRAY, inline sz: Int, inline t: ArrayTag[A,ARRAY]): ARRAY =
    inline t match
              case _ : ArrayTag[A&Raw.Boolean,Array[A&Raw.Boolean]] => new Array[Boolean](sz).cast[ARRAY]
              case _ : ArrayTag[A&Raw.Byte,   Array[A&Raw.Byte   ]] => new Array[Byte](sz).cast[ARRAY]
              case _ : ArrayTag[A&Raw.Char,   Array[A&Raw.Char   ]] => new Array[Char](sz).cast[ARRAY]
              case _ : ArrayTag[A&Raw.Short,  Array[A&Raw.Short  ]] => new Array[Short](sz).cast[ARRAY]
              case _ : ArrayTag[A&Raw.Int,    Array[A&Raw.Int    ]] => new Array[Int](sz).cast[ARRAY]
              case _ : ArrayTag[A&Raw.Long,   Array[A&Raw.Long   ]] => new Array[Long](sz).cast[ARRAY]
              case _ : ArrayTag[A&Raw.Float,  Array[A&Raw.Float  ]] => new Array[Float](sz).cast[ARRAY]
              case _ : ArrayTag[A&Raw.Double, Array[A&Raw.Double ]] => new Array[Double](sz).cast[ARRAY]
              case _                                                        => java.lang.reflect.Array.newInstance(x.getClass().getComponentType(), sz).cast[ARRAY]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
