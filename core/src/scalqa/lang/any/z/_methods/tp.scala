package scalqa; package lang; package any; package z; package _methods; import language.implicitConversions

import gen.`given`. { DocDef }

transparent trait tp :

  extension(inline x: String)           inline def tp                                   : Unit   = ZZ.tp(x)
  extension(inline x: String)           inline def tp(v:Unit = ())                      : Unit   = ZZ.tp(x)
  extension(inline x: Boolean)          inline def tp                                   : Unit   = ZZ.tp(x)
  extension(inline x: Byte)             inline def tp                                   : Unit   = ZZ.tp(x)
  extension(inline x: Char)             inline def tp                                   : Unit   = ZZ.tp(x)
  extension(inline x: Short)            inline def tp                                   : Unit   = ZZ.tp(x)
  extension(inline x: Int)              inline def tp                                   : Unit   = ZZ.tp(x)
  extension(inline x: Long)             inline def tp                                   : Unit   = ZZ.tp(x)
  extension(inline x: Float)            inline def tp                                   : Unit   = ZZ.tp(x)
  extension(inline x: Double)           inline def tp                                   : Unit   = ZZ.tp(x)
  extension(inline x: gen.able.Tag)     inline def tp                                   : Unit   = ZZ.tp(x.tag)
  extension(inline x: Unit)             inline def tp                                   : Unit   = {val v=x /*need to realize x for side effects*/; ZZ.tp(" ") /*keep one space*/}

  extension[A<:Boolean.Raw](inline x:A) inline def tp (using inline t :Given.DocDef[A]) : Unit   = ZZ.tp(x.cast[Boolean],t)
  extension[A<:Byte.Raw]   (inline x:A) inline def tp (using inline t :Given.DocDef[A]) : Unit   = ZZ.tp(x.cast[Byte]   ,t)
  extension[A<:Char.Raw]   (inline x:A) inline def tp (using inline t :Given.DocDef[A]) : Unit   = ZZ.tp(x.cast[Char]   ,t)
  extension[A<:Short.Raw]  (inline x:A) inline def tp (using inline t :Given.DocDef[A]) : Unit   = ZZ.tp(x.cast[Short]  ,t)
  extension[A<:Int.Raw]    (inline x:A) inline def tp (using inline t :Given.DocDef[A]) : Unit   = ZZ.tp(x.cast[Int]    ,t)
  extension[A<:Long.Raw]   (inline x:A) inline def tp (using inline t :Given.DocDef[A]) : Unit   = ZZ.tp(x.cast[Long]   ,t)
  extension[A<:Float.Raw]  (inline x:A) inline def tp (using inline t :Given.DocDef[A]) : Unit   = ZZ.tp(x.cast[Float]  ,t)
  extension[A<:Double.Raw] (inline x:A) inline def tp (using inline t :Given.DocDef[A]) : Unit   = ZZ.tp(x.cast[Double] ,t)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/