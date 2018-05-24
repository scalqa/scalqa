package scalqa; package Any; package Class; package Tag; package Z

import scala.language.implicitConversions

private[Class] object Implicits {

  class Primary extends Secondary {
    implicit lazy val Boolean = The.Boolean
    implicit lazy val Byte = The.Byte
    implicit lazy val Char = The.Char
    implicit lazy val Short = The.Short
    implicit lazy val Int = The.Int
    implicit lazy val Long = The.Long
    implicit lazy val Float = The.Float
    implicit lazy val Double = The.Double
    implicit lazy val ByteValue = The.ByteValue
    implicit lazy val CharValue = The.CharValue
    implicit lazy val ShortValue = The.ShortValue
    implicit lazy val IntValue = The.IntValue
    implicit lazy val LongValue = The.LongValue
    implicit lazy val FloatValue = The.FloatValue
    implicit lazy val DoubleValue = The.DoubleValue
    implicit lazy val RefValue = The.RefValue
  }

  class Secondary extends Tertiary {
    implicit lazy val AnyVal = The.AnyVal
    implicit lazy val AnyRef = The.AnyRef
  }

  class Tertiary {
    implicit lazy val Void = The.Void
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
