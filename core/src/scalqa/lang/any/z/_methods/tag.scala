package scalqa; package lang; package any; package z; package _methods; import language.implicitConversions

transparent trait tag :

  extension(inline x: Boolean)              inline def tag                              : String = java.lang.String.valueOf(x)
  extension(inline x: Byte)                 inline def tag                              : String = java.lang.String.valueOf(x)
  extension(inline x: Char)                 inline def tag                              : String = java.lang.String.valueOf(x)
  extension(inline x: Short)                inline def tag                              : String = java.lang.String.valueOf(x)
  extension(inline x: Int)                  inline def tag                              : String = java.lang.String.valueOf(x)
  extension(inline x: Long)                 inline def tag                              : String = java.lang.String.valueOf(x)
  extension(inline x: Float)                inline def tag                              : String = java.lang.String.valueOf(x)
  extension(inline x: Double)               inline def tag                              : String = java.lang.String.valueOf(x)
  extension(inline x: String)               inline def tag                              : String = x
  extension(inline x: String.Builder)       inline def tag                              : String = x.toString

  extension[A<:Boolean.Opaque](inline x: A) inline def tag  (using inline d: Def.Doc[A]): String = ZZ.tag(x.cast[Boolean],d)
  extension[A<:Byte   .Opaque](inline x: A) inline def tag  (using inline d: Def.Doc[A]): String = ZZ.tag(x.cast[Byte   ],d)
  extension[A<:Char   .Opaque](inline x: A) inline def tag  (using inline d: Def.Doc[A]): String = ZZ.tag(x.cast[Char   ],d)
  extension[A<:Short  .Opaque](inline x: A) inline def tag  (using inline d: Def.Doc[A]): String = ZZ.tag(x.cast[Short  ],d)
  extension[A<:Int    .Opaque](inline x: A) inline def tag  (using inline d: Def.Doc[A]): String = ZZ.tag(x.cast[Int    ],d)
  extension[A<:Long   .Opaque](inline x: A) inline def tag  (using inline d: Def.Doc[A]): String = ZZ.tag(x.cast[Long   ],d)
  extension[A<:Float  .Opaque](inline x: A) inline def tag  (using inline d: Def.Doc[A]): String = ZZ.tag(x.cast[Float  ],d)
  extension[A<:Double .Opaque](inline x: A) inline def tag  (using inline d: Def.Doc[A]): String = ZZ.tag(x.cast[Double ],d)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/