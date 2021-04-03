package scalqa; package `def`; package any; package self; package shape; import language.implicitConversions

import `def`.boolean.G.{ Opt as BOOLEAN}
import `def`.byte   .G.{ Opt as BYTE}
import `def`.char   .G.{ Opt as CHAR}
import `def`.short  .G.{ Opt as SHORT}
import `def`.int    .G.{ Opt as INT}
import `def`.long   .G.{ Opt as LONG}
import `def`.float  .G.{ Opt as FLOAT}
import `def`.double .G.{ Opt as DOUBLE}
import Any. { Raw as RAW }

object OfOpt:

  type Any[A] = Opt[A] | Raw[A]

  type Raw[A] = BOOLEAN[A & RAW.Boolean] | BYTE[A & RAW.Byte] | CHAR[A & RAW.Char] | SHORT[A & RAW.Short] | INT[A & RAW.Int] | LONG[A & RAW.Long] | FLOAT[A & RAW.Float] | DOUBLE[A & RAW.Double]

  extension[A](x: Any[A])
    inline def SOME: Boolean = inline x match
      case _: `def`.boolean.G.Opt[A] => x.cast[`def`.boolean.G.Opt[A & RAW.Boolean]].nonEmpty
      case _: `def`.byte   .G.Opt[A] => x.cast[`def`.byte   .G.Opt[A & RAW.Byte   ]].nonEmpty
      case _: `def`.char   .G.Opt[A] => x.cast[`def`.char   .G.Opt[A & RAW.Char   ]].nonEmpty
      case _: `def`.short  .G.Opt[A] => x.cast[`def`.short  .G.Opt[A & RAW.Short  ]].nonEmpty
      case _: `def`.int    .G.Opt[A] => x.cast[`def`.int    .G.Opt[A & RAW.Int    ]].nonEmpty
      case _: `def`.long   .G.Opt[A] => x.cast[`def`.long   .G.Opt[A & RAW.Long   ]].nonEmpty
      case _: `def`.float  .G.Opt[A] => x.cast[`def`.float  .G.Opt[A & RAW.Float  ]].nonEmpty
      case _: `def`.double .G.Opt[A] => x.cast[`def`.double .G.Opt[A & RAW.Double ]].nonEmpty
      case v:             Val.Opt[A] => x.cast[            Val.Opt[A                  ]].nonEmpty

    inline def VAL: A = inline x match
      case _: `def`.boolean.G.Opt[A] => x.cast[`def`.boolean.G.Opt[A & RAW.Boolean]].`val`
      case _: `def`.byte   .G.Opt[A] => x.cast[`def`.byte   .G.Opt[A & RAW.Byte   ]].`val`
      case _: `def`.char   .G.Opt[A] => x.cast[`def`.char   .G.Opt[A & RAW.Char   ]].`val`
      case _: `def`.short  .G.Opt[A] => x.cast[`def`.short  .G.Opt[A & RAW.Short  ]].`val`
      case _: `def`.int    .G.Opt[A] => x.cast[`def`.int    .G.Opt[A & RAW.Int    ]].`val`
      case _: `def`.long   .G.Opt[A] => x.cast[`def`.long   .G.Opt[A & RAW.Long   ]].`val`
      case _: `def`.float  .G.Opt[A] => x.cast[`def`.float  .G.Opt[A & RAW.Float  ]].`val`
      case _: `def`.double .G.Opt[A] => x.cast[`def`.double .G.Opt[A & RAW.Double ]].`val`
      case v:             Val.Opt[A] => x.cast[            Val.Opt[A                  ]].`val`

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Tag[A,OPT<:Any[A]] = ofOpt.Tag[A,OPT];  val Tag = ofOpt.Tag

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
