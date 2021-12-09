package scalqa; package lang; package array; package z; import language.implicitConversions

object newArray:

  inline def apply[A](inline x: Array[A], inline sz: Int)(using inline s: Specialized[A]): s.Array =
    inline s match
              case _ : Specialized[A&Any.Boolean] => new Array[Boolean](sz).cast[s.Array]
              case _ : Specialized[A&Any.Byte   ] => new Array[Byte   ](sz).cast[s.Array]
              case _ : Specialized[A&Any.Char   ] => new Array[Char   ](sz).cast[s.Array]
              case _ : Specialized[A&Any.Short  ] => new Array[Short  ](sz).cast[s.Array]
              case _ : Specialized[A&Any.Int    ] => new Array[Int    ](sz).cast[s.Array]
              case _ : Specialized[A&Any.Long   ] => new Array[Long   ](sz).cast[s.Array]
              case _ : Specialized[A&Any.Float  ] => new Array[Float  ](sz).cast[s.Array]
              case _ : Specialized[A&Any.Double ] => new Array[Double ](sz).cast[s.Array]
              case _                              => java.lang.reflect.Array.newInstance(x.getClass().getComponentType(), sz).cast[s.Array]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
