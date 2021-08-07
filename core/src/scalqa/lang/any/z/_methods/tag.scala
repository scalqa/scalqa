package scalqa; package lang; package any; package z; package _methods; import language.implicitConversions

import gen.`given`. { DocDef }

transparent trait tag :

  extension(inline x: Boolean)              inline def tag                             : String = java.lang.String.valueOf(x)
  extension(inline x: Byte)                 inline def tag                             : String = java.lang.String.valueOf(x)
  extension(inline x: Char)                 inline def tag                             : String = java.lang.String.valueOf(x)
  extension(inline x: Short)                inline def tag                             : String = java.lang.String.valueOf(x)
  extension(inline x: Int)                  inline def tag                             : String = java.lang.String.valueOf(x)
  extension(inline x: Long)                 inline def tag                             : String = java.lang.String.valueOf(x)
  extension(inline x: Float)                inline def tag                             : String = java.lang.String.valueOf(x)
  extension(inline x: Double)               inline def tag                             : String = java.lang.String.valueOf(x)
  extension(inline x: String)               inline def tag                             : String = x
  extension(inline x: String.Builder)       inline def tag                             : String = x.toString

  extension[A<:Boolean.Opaque](inline x: A) inline def tag  (using inline d: DocDef[A]): String = inline x match{ case _ : DocDef.BooleanRaw[A] => d.cast[DocDef.BooleanRaw[A]].value_tag(x); case _ => d.value_tag(x) }
  extension[A<:Byte   .Opaque](inline x: A) inline def tag  (using inline d: DocDef[A]): String = inline x match{ case _ : DocDef.ByteRaw[A]    => d.cast[DocDef.ByteRaw   [A]].value_tag(x); case _ => d.value_tag(x) }
  extension[A<:Char   .Opaque](inline x: A) inline def tag  (using inline d: DocDef[A]): String = inline x match{ case _ : DocDef.CharRaw[A]    => d.cast[DocDef.CharRaw   [A]].value_tag(x); case _ => d.value_tag(x) }
  extension[A<:Short  .Opaque](inline x: A) inline def tag  (using inline d: DocDef[A]): String = inline x match{ case _ : DocDef.ShortRaw[A]   => d.cast[DocDef.ShortRaw  [A]].value_tag(x); case _ => d.value_tag(x) }
  extension[A<:Int    .Opaque](inline x: A) inline def tag  (using inline d: DocDef[A]): String = inline x match{ case _ : DocDef.IntRaw[A]     => d.cast[DocDef.IntRaw    [A]].value_tag(x); case _ => d.value_tag(x) }
  extension[A<:Long   .Opaque](inline x: A) inline def tag  (using inline d: DocDef[A]): String = inline x match{ case _ : DocDef.LongRaw[A]    => d.cast[DocDef.LongRaw   [A]].value_tag(x); case _ => d.value_tag(x) }
  extension[A<:Float  .Opaque](inline x: A) inline def tag  (using inline d: DocDef[A]): String = inline x match{ case _ : DocDef.FloatRaw[A]   => d.cast[DocDef.FloatRaw  [A]].value_tag(x); case _ => d.value_tag(x) }
  extension[A<:Double .Opaque](inline x: A) inline def tag  (using inline d: DocDef[A]): String = inline x match{ case _ : DocDef.DoubleRaw[A]  => d.cast[DocDef.DoubleRaw [A]].value_tag(x); case _ => d.value_tag(x) }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/