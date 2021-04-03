package scalqa; package `def`; package any; package self; package shape; import language.implicitConversions

import `def`.boolean.g.{ Stream as BOOLEAN}
import `def`.byte   .g.{ Stream as BYTE}
import `def`.char   .g.{ Stream as CHAR}
import `def`.short  .g.{ Stream as SHORT}
import `def`.int    .g.{ Stream as INT}
import `def`.long   .g.{ Stream as LONG}
import `def`.float  .g.{ Stream as FLOAT}
import `def`.double .g.{ Stream as DOUBLE}
import Any. { Raw as RAW }

object OfStream:

  type Any[A] = Val.~[A] | Raw[A]

  type Raw[A] = BOOLEAN[A & RAW.Boolean] | BYTE[A & RAW.Byte] | CHAR[A & RAW.Char] | SHORT[A & RAW.Short] | INT[A & RAW.Int] | LONG[A & RAW.Long] | FLOAT[A & RAW.Float] | DOUBLE[A & RAW.Double]

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Tag[A,STREAM<:Any[A]] = ofStream.Tag[A,STREAM];   val Tag = ofStream.Tag

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
