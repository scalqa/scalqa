package scalqa; package lang; package string; import language.implicitConversions

import java.lang.{ StringBuilder as SB }
import String.Builder

object Builder extends Any.Ref.Custom.Type[Builder,SB]("String.Builder"):
  inline def apply()                    : Builder = new SB().cast[Builder]
  inline def apply(inline capacity: Int): Builder = new SB(capacity).cast[Builder]

  extension(inline x: Builder)
    @tn("_add")        inline def += [T,A<:T|Boolean|Byte|Char|Short|Int|Long|Float|Double|CharSequence](inline v: A)(using inline tg:Given.DocTag[A]): Builder = add(v)
    @tn("addAt")       inline def +=@[T,A<:T|Boolean|Byte|Char|Short|Int|Long|Float|Double|CharSequence](inline off: Int, inline v: A)(using inline tg:Given.DocTag[A]): Builder = addAt(off,v)

    /**/               inline def charAt(inline i: Int)  : Char    = x.cast[SB].charAt(i)
    /**/               inline def size                   : Int     = x.cast[SB].length
    /**/               inline def isEmpty                : Boolean = x.cast[SB].length == 0
    @tn("remove_Range")inline def remove_<>(v: Int.<>)   : Builder = x.cast[SB].delete(v.start,v.endX).cast[Builder]
    /**/               inline def removeAt(inline v: Int): Builder = x.cast[SB].deleteCharAt(v).cast[Builder]
    /**/               inline def makeString             : String  = x.cast[SB].toString

    inline def add[T,A<:T|Boolean|Byte|Char|Short|Int|Long|Float|Double|CharSequence](inline v: A)(using inline tg:Given.DocTag[A]): Builder =
      inline v match
        case _ :Boolean      => x.cast[SB].append(v.cast[Boolean     ]).cast[Builder]
        case _ :Byte         => x.cast[SB].append(v.cast[Byte        ]).cast[Builder]
        case _ :Char         => x.cast[SB].append(v.cast[Char        ]).cast[Builder]
        case _ :Short        => x.cast[SB].append(v.cast[Short       ]).cast[Builder]
        case _ :Int          => x.cast[SB].append(v.cast[Int         ]).cast[Builder]
        case _ :Long         => x.cast[SB].append(v.cast[Long        ]).cast[Builder]
        case _ :Float        => x.cast[SB].append(v.cast[Float       ]).cast[Builder]
        case _ :Double       => x.cast[SB].append(v.cast[Double      ]).cast[Builder]
        case _ :CharSequence => x.cast[SB].append(v.cast[CharSequence]).cast[Builder]
        case _               => x.cast[SB].append(tg.tag(v)           ).cast[Builder]

    inline def addAt[T,A<:T|Boolean|Byte|Char|Short|Int|Long|Float|Double|CharSequence](inline off: Int, inline v: A)(using inline tg:Given.DocTag[A]): Builder =
      inline v match
        case _ :Boolean      => x.cast[SB].insert(off,v.cast[Boolean     ]).cast[Builder]
        case _ :Byte         => x.cast[SB].insert(off,v.cast[Byte        ]).cast[Builder]
        case _ :Char         => x.cast[SB].insert(off,v.cast[Char        ]).cast[Builder]
        case _ :Short        => x.cast[SB].insert(off,v.cast[Short       ]).cast[Builder]
        case _ :Int          => x.cast[SB].insert(off,v.cast[Int         ]).cast[Builder]
        case _ :Long         => x.cast[SB].insert(off,v.cast[Long        ]).cast[Builder]
        case _ :Float        => x.cast[SB].insert(off,v.cast[Float       ]).cast[Builder]
        case _ :Double       => x.cast[SB].insert(off,v.cast[Double      ]).cast[Builder]
        case _ :CharSequence => x.cast[SB].insert(off,v.cast[CharSequence]).cast[Builder]
        case _               => x.cast[SB].insert(off,tg.tag(v)           ).cast[Builder]

  object opaque:
    opaque type `type` <: Opaque.Ref & CharSequence  = SB & Opaque.Ref

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object opaque ->

    String.Builder is a zero overhead opaque wrap of java.lang.StringBuilder. The "add" methods handle primitives without boxing.

@def +=         -> Alias for add
@def +=@        -> Alias for addAt
@def add        -> Append
@def addAt      -> Insert at position
@def charAt     -> Char at position
@def remove_<>  -> Remove range
@def removeAt   -> Remove at position
@def size       -> Added char count
@def isEmpty    -> Zero size check
@def makeString -> Create String \n  Same as "toString"

*/