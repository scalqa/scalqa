package scalqa; package lang; package string; import language.implicitConversions

import String.Builder

object Builder extends Any.Ref.Custom.Type[Builder,StringBuilder]("String.Builder"):
  inline def apply()              : Builder = new StringBuilder().asOpaque[Builder]
  inline def apply(capacity: Int) : Builder = new StringBuilder(capacity).asOpaque[Builder]

  extension(inline x: Builder)
    /**/               inline def charAt(i: Int)                             : Char    = x.real.charAt(i)
    /**/               inline def length                                     : Int     = x.real.length
    @tn("remove_Range")inline def remove_<>(v: Int.<>)                       : Builder = x.real.delete(v.start,v.endX).asOpaque[Builder]
    /**/               inline def removeAt(inline v: Int)                    : Builder = x.real.deleteCharAt(v).asOpaque[Builder]
    /**/               inline def isEmpty                                    : Boolean = x.real.isEmpty
    @tn("add")   infix inline def += (inline v: Boolean)                     : Builder = x.real.append(v).asOpaque[Builder]
    @tn("add")   infix inline def += (inline v: Byte)                        : Builder = x.real.append(v).asOpaque[Builder]
    @tn("add")   infix inline def += (inline v: Char)                        : Builder = x.real.append(v).asOpaque[Builder]
    @tn("add")   infix inline def += (inline v: Short)                       : Builder = x.real.append(v).asOpaque[Builder]
    @tn("add")   infix inline def += (inline v: Int)                         : Builder = x.real.append(v).asOpaque[Builder]
    @tn("add")   infix inline def += (inline v: Long)                        : Builder = x.real.append(v).asOpaque[Builder]
    @tn("add")   infix inline def += (inline v: Float)                       : Builder = x.real.append(v).asOpaque[Builder]
    @tn("add")   infix inline def += (inline v: Double)                      : Builder = x.real.append(v).asOpaque[Builder]
    @tn("add")   infix inline def += (inline v: CharSequence)                : Builder = x.real.append(v).asOpaque[Builder]

    @tn("addAt") infix inline def +=@(off: Int, inline v: Boolean)           : Builder = x.real.insert(off,v).asOpaque[Builder]
    @tn("addAt") infix inline def +=@(off: Int, inline v: Byte)              : Builder = x.real.insert(off,v).asOpaque[Builder]
    @tn("addAt") infix inline def +=@(off: Int, inline v: Char)              : Builder = x.real.insert(off,v).asOpaque[Builder]
    @tn("addAt") infix inline def +=@(off: Int, inline v: Short)             : Builder = x.real.insert(off,v).asOpaque[Builder]
    @tn("addAt") infix inline def +=@(off: Int, inline v: Int)               : Builder = x.real.insert(off,v).asOpaque[Builder]
    @tn("addAt") infix inline def +=@(off: Int, inline v: Long)              : Builder = x.real.insert(off,v).asOpaque[Builder]
    @tn("addAt") infix inline def +=@(off: Int, inline v: Float)             : Builder = x.real.insert(off,v).asOpaque[Builder]
    @tn("addAt") infix inline def +=@(off: Int, inline v: Double)            : Builder = x.real.insert(off,v).asOpaque[Builder]
    @tn("addAt") infix inline def +=@(off: Int, inline v: CharSequence)      : Builder = x.real.insert(off,v).asOpaque[Builder]
  extension[A](inline x: Builder)
    @tn("add")   infix inline def += (inline v: A)(using tg:Def.Doc[A])          : Builder = x.real.append(tg.tag(v)).asOpaque[Builder]
    @tn("addAt") infix inline def +=@(off: Int, inline v: A)(using tg:Def.Doc[A]): Builder = x.real.insert(off,tg.tag(v)).asOpaque[Builder]

  object opaque:
    opaque type `type` <: Opaque.Ref & CharSequence  = StringBuilder & Opaque.Ref
/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
