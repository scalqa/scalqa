package scalqa; package Numeric

import java.{ math => J }

package object BigDecimal {

  def get(v: J.BigDecimal) = new BigDecimal(v)

  def get(v: Double): BigDecimal = J.BigDecimal.valueOf(v)

  def get(v: String): BigDecimal = new J.BigDecimal(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/