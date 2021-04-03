package scalqa; package `def`; package any; package z; package extension; import language.implicitConversions

import Info.Tag.Doc

transparent private[z] trait tp :

  extension(inline x: Boolean)              inline def tag                        : String = java.lang.String.valueOf(x)
  extension(inline x: Byte)                 inline def tag                        : String = java.lang.String.valueOf(x)
  extension(inline x: Char)                 inline def tag                        : String = java.lang.String.valueOf(x)
  extension(inline x: Short)                inline def tag                        : String = java.lang.String.valueOf(x)
  extension(inline x: Int)                  inline def tag                        : String = java.lang.String.valueOf(x)
  extension(inline x: Long)                 inline def tag                        : String = java.lang.String.valueOf(x)
  extension(inline x: Float)                inline def tag                        : String = java.lang.String.valueOf(x)
  extension(inline x: Double)               inline def tag                        : String = java.lang.String.valueOf(x)
  extension(inline x: String)               inline def tag                        : String = x
  extension(inline x: String.Builder)       inline def tag                        : String = x.toString

  extension(inline x: String)               inline def tp                         : Unit   = ZZ.tp(x)
  extension(inline x: String)               inline def tp(v:Unit = ())            : Unit   = ZZ.tp(x)
  extension(inline x: Boolean)              inline def tp                         : Unit   = ZZ.tp(x)
  extension(inline x: Byte)                 inline def tp                         : Unit   = ZZ.tp(x)
  extension(inline x: Char)                 inline def tp                         : Unit   = ZZ.tp(x)
  extension(inline x: Short)                inline def tp                         : Unit   = ZZ.tp(x)
  extension(inline x: Int)                  inline def tp                         : Unit   = ZZ.tp(x)
  extension(inline x: Long)                 inline def tp                         : Unit   = ZZ.tp(x)
  extension(inline x: Float)                inline def tp                         : Unit   = ZZ.tp(x)
  extension(inline x: Double)               inline def tp                         : Unit   = ZZ.tp(x)
  extension(inline x: gen.able.Tag)         inline def tp                         : Unit   = ZZ.tp(x.tag)
  extension(inline x: Unit)                 inline def tp                         : Unit   = {val v=x; /*need to realize x*/ ZZ.tp("")}

  extension[A<:Any.Raw.Boolean](inline x:A) inline def tp (using inline t:Doc[A]) : Unit   = ZZ.tp(x.real,t)
  extension[A<:Any.Raw.Byte]   (inline x:A) inline def tp (using inline t:Doc[A]) : Unit   = ZZ.tp(x.real,t)
  extension[A<:Any.Raw.Char]   (inline x:A) inline def tp (using inline t:Doc[A]) : Unit   = ZZ.tp(x.real,t)
  extension[A<:Any.Raw.Short]  (inline x:A) inline def tp (using inline t:Doc[A]) : Unit   = ZZ.tp(x.real,t)
  extension[A<:Any.Raw.Int]    (inline x:A) inline def tp (using inline t:Doc[A]) : Unit   = ZZ.tp(x.real,t)
  extension[A<:Any.Raw.Long]   (inline x:A) inline def tp (using inline t:Doc[A]) : Unit   = ZZ.tp(x.real,t)
  extension[A<:Any.Raw.Float]  (inline x:A) inline def tp (using inline t:Doc[A]) : Unit   = ZZ.tp(x.real,t)
  extension[A<:Any.Raw.Double] (inline x:A) inline def tp (using inline t:Doc[A]) : Unit   = ZZ.tp(x.real,t)

  extension[A]                 (inline x:A) inline def TP(using inline dt:Doc[A]) : Unit   = ZZ.tp(x,dt)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/