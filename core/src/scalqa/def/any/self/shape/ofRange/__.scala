package scalqa; package `def`; package any; package self; package shape; import language.implicitConversions

import `def`.byte   .g.{ Range as BYTE}
import `def`.char   .g.{ Range as CHAR}
import `def`.short  .g.{ Range as SHORT}
import `def`.int    .g.{ Range as INT}
import `def`.long   .g.{ Range as LONG}
import `def`.float  .g.{ Range as FLOAT}
import `def`.double .g.{ Range as DOUBLE}
import Any. { Raw as RAW }

object OfRange:

  type Any[A] = <>[A] | Raw[A]

  type Raw[A] = BYTE[A & RAW.Byte] | CHAR[A & RAW.Char] | SHORT[A & RAW.Short] | INT[A & RAW.Int] | LONG[A & RAW.Long] | FLOAT[A & RAW.Float] | DOUBLE[A & RAW.Double]

  // ~~~~~~~~~~~~~~~~~
  type Tag[A,RANGE<:Any[A]] = ofRange.Tag[A,RANGE];   val Tag = ofRange.Tag

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
