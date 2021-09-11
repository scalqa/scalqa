package scalqa; package lang; package any; package z; package _methods; import language.implicitConversions

transparent trait tp :

  extension(inline x: String)           inline def tp                            : Unit   = ZZ.tp(x)
  extension(inline x: String)           inline def tp(v:Unit = ())               : Unit   = ZZ.tp(x)
  extension(inline x: Boolean)          inline def tp                            : Unit   = ZZ.tp(x)
  extension(inline x: Byte)             inline def tp                            : Unit   = ZZ.tp(x)
  extension(inline x: Char)             inline def tp                            : Unit   = ZZ.tp(x)
  extension(inline x: Short)            inline def tp                            : Unit   = ZZ.tp(x)
  extension(inline x: Int)              inline def tp                            : Unit   = ZZ.tp(x)
  extension(inline x: Long)             inline def tp                            : Unit   = ZZ.tp(x)
  extension(inline x: Float)            inline def tp                            : Unit   = ZZ.tp(x)
  extension(inline x: Double)           inline def tp                            : Unit   = ZZ.tp(x)
  extension(inline x: gen.able.Tag)     inline def tp                            : Unit   = ZZ.tp(x.tag)
  extension(inline x: Unit)             inline def tp                            : Unit   = {val v=x /*need to realize x for side effects*/; ZZ.tp(" ") /*keep one space*/}

  extension[A<:Any.Boolean](inline x:A) inline def tp (using inline d:Def.Doc[A]): Unit   = ZZ.tp(x.cast[Boolean],d)
  extension[A<:Any.Byte]   (inline x:A) inline def tp (using inline d:Def.Doc[A]): Unit   = ZZ.tp(x.cast[Byte]   ,d)
  extension[A<:Any.Char]   (inline x:A) inline def tp (using inline d:Def.Doc[A]): Unit   = ZZ.tp(x.cast[Char]   ,d)
  extension[A<:Any.Short]  (inline x:A) inline def tp (using inline d:Def.Doc[A]): Unit   = ZZ.tp(x.cast[Short]  ,d)
  extension[A<:Any.Int]    (inline x:A) inline def tp (using inline d:Def.Doc[A]): Unit   = ZZ.tp(x.cast[Int]    ,d)
  extension[A<:Any.Long]   (inline x:A) inline def tp (using inline d:Def.Doc[A]): Unit   = ZZ.tp(x.cast[Long]   ,d)
  extension[A<:Any.Float]  (inline x:A) inline def tp (using inline d:Def.Doc[A]): Unit   = ZZ.tp(x.cast[Float]  ,d)
  extension[A<:Any.Double] (inline x:A) inline def tp (using inline d:Def.Doc[A]): Unit   = ZZ.tp(x.cast[Double] ,d)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/