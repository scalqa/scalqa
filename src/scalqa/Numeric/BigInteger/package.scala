package scalqa; package Numeric

import java.{ math => J }

package object BigInteger {

  def get(v: J.BigInteger) = new BigInteger(v)

  def get(v: Long): BigInteger = J.BigInteger.valueOf(v)

  def get(v: String): BigInteger = new J.BigInteger(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/