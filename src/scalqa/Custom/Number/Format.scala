package scalqa; package Custom; package Number

import java.text.DecimalFormat

class Format(val real: DecimalFormat) {

  def apply(v: Double) = real.format(v)

  def apply(v: Long) = real.format(v)

  def apply(v: Any) = real.format(v match {
    case v: Like => Like.number(v)
    case v       => v
  })
}

object Format {

  def apply(v: Any, format: String): String = make(format).apply(v)

  def make(format: String) = new Format(new DecimalFormat(format))

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
