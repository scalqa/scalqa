package scalqa; package lang; package string; import language.implicitConversions

import java.lang.{ StringBuilder as REAL }
import String.Builder

object Builder extends AnyRef.Opaque.Base[Builder,REAL]("String.Builder"):
  inline def apply()                    : Builder = new REAL().cast[Builder]
  inline def apply(inline capacity: Int): Builder = new REAL(capacity).cast[Builder]

  extension(inline x: Builder)
    @tn("add")         inline def += [B,A<:B|Boolean|Byte|Char|Short|Int|Long|Float|Double|CharSequence](inline v: A)(using inline tg:Any.Def.Doc[A]): Builder = add(v)
    @tn("addAt")       inline def +@=[B,A<:B|Boolean|Byte|Char|Short|Int|Long|Float|Double|CharSequence](inline off: Int, inline v: A)(using inline tg:Any.Def.Doc[A]): Builder = addAt(off,v)

    /**/               inline def charAt(inline i: Int)  : Char    = x.real.charAt(i)
    /**/               inline def size                   : Int     = x.real.length
    /**/               inline def isEmpty                : Boolean = x.real.length == 0
    @tn("remove_Range")inline def remove_<>(v: Int.<>)   : Builder = x.real.delete(v.start,v.endX).cast[Builder]
    /**/               inline def removeAt(inline v: Int): Builder = x.real.deleteCharAt(v).cast[Builder]
    /**/               inline def tag                    : String  = x.real.toString

    inline def add[B,A<:B|Boolean|Byte|Char|Short|Int|Long|Float|Double|CharSequence](inline w: A)(using inline tg:Any.Def.Tag[A]): Builder =
      inline w match
        case v :Boolean      => x.real.append(v).cast[Builder]
        case v :Byte         => x.real.append(v).cast[Builder]
        case v :Char         => x.real.append(v).cast[Builder]
        case v :Short        => x.real.append(v).cast[Builder]
        case v :Int          => x.real.append(v).cast[Builder]
        case v :Long         => x.real.append(v).cast[Builder]
        case v :Float        => x.real.append(v).cast[Builder]
        case v :Double       => x.real.append(v).cast[Builder]
        case v :CharSequence => x.real.append(v).cast[Builder]
        case v               => x.real.append(tg.value_tag(v)).cast[Builder]

    inline def addAt[B,A<:B|Boolean|Byte|Char|Short|Int|Long|Float|Double|CharSequence](inline off: Int, inline w: A)(using inline tg:Any.Def.Tag[A]): Builder =
      inline w match
        case v :Boolean      => x.real.insert(off,v).cast[Builder]
        case v :Byte         => x.real.insert(off,v).cast[Builder]
        case v :Char         => x.real.insert(off,v).cast[Builder]
        case v :Short        => x.real.insert(off,v).cast[Builder]
        case v :Int          => x.real.insert(off,v).cast[Builder]
        case v :Long         => x.real.insert(off,v).cast[Builder]
        case v :Float        => x.real.insert(off,v).cast[Builder]
        case v :Double       => x.real.insert(off,v).cast[Builder]
        case v :CharSequence => x.real.insert(off,v).cast[Builder]
        case v               => x.real.insert(off,tg.value_tag(v)).cast[Builder]

  object TYPE:
    opaque type DEF <: AnyRef.Opaque & CharSequence  = REAL & AnyRef.Opaque

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@type DEF  ->

    String.Builder is a zero overhead opaque wrap of java.lang.StringBuilder. The "add" methods handle primitives without boxing.

@def +=         -> Alias for add
@def +@=        -> Alias for addAt
@def add        -> Append
@def addAt      -> Insert at position
@def charAt     -> Char at position
@def remove_<>  -> Remove range
@def removeAt   -> Remove at position
@def size       -> Added char count
@def isEmpty    -> Zero size check
@def tag        -> Create String \n\n  Same as "toString"

*/