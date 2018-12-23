package scalqa; package Any; package Datum

package object BigInteger {

  private[BigInteger] val Zero = java.math.BigInteger.valueOf(0)

  def undo(v: Datum.BigInteger[_]) = _Trait.real(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/