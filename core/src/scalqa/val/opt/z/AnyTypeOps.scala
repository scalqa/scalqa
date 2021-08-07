package scalqa; package `val`; package opt; package z; import language.implicitConversions;

object AnyTypeOps:

  extension[A](x: Opt.AnyType[A])

    inline def SOME: Boolean = inline x match
      case _: lang.boolean.G.Opt[A] => x.cast[lang.boolean.G.Opt[A & Boolean.Raw]].nonEmpty
      case _: lang.byte   .G.Opt[A] => x.cast[lang.byte   .G.Opt[A & Byte.Raw   ]].nonEmpty
      case _: lang.char   .G.Opt[A] => x.cast[lang.char   .G.Opt[A & Char.Raw   ]].nonEmpty
      case _: lang.short  .G.Opt[A] => x.cast[lang.short  .G.Opt[A & Short.Raw  ]].nonEmpty
      case _: lang.int    .G.Opt[A] => x.cast[lang.int    .G.Opt[A & Int.Raw    ]].nonEmpty
      case _: lang.long   .G.Opt[A] => x.cast[lang.long   .G.Opt[A & Long.Raw   ]].nonEmpty
      case _: lang.float  .G.Opt[A] => x.cast[lang.float  .G.Opt[A & Float.Raw  ]].nonEmpty
      case _: lang.double .G.Opt[A] => x.cast[lang.double .G.Opt[A & Double.Raw ]].nonEmpty
      case v:            Val.Opt[A] => x.cast[           Val.Opt[A              ]].nonEmpty

    inline def VAL: A = inline x match
      case _: lang.boolean.G.Opt[A] => x.cast[lang.boolean.G.Opt[A & Boolean.Raw]].`val`
      case _: lang.byte   .G.Opt[A] => x.cast[lang.byte   .G.Opt[A & Byte.Raw   ]].`val`
      case _: lang.char   .G.Opt[A] => x.cast[lang.char   .G.Opt[A & Char.Raw   ]].`val`
      case _: lang.short  .G.Opt[A] => x.cast[lang.short  .G.Opt[A & Short.Raw  ]].`val`
      case _: lang.int    .G.Opt[A] => x.cast[lang.int    .G.Opt[A & Int.Raw    ]].`val`
      case _: lang.long   .G.Opt[A] => x.cast[lang.long   .G.Opt[A & Long.Raw   ]].`val`
      case _: lang.float  .G.Opt[A] => x.cast[lang.float  .G.Opt[A & Float.Raw  ]].`val`
      case _: lang.double .G.Opt[A] => x.cast[lang.double .G.Opt[A & Double.Raw ]].`val`
      case v:            Val.Opt[A] => x.cast[           Val.Opt[A              ]].`val`

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
