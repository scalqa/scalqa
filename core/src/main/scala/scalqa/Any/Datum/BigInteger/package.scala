package scalqa; package Any; package Datum

package object BigInteger {

  private[BigInteger] val Zero = java.math.BigInteger.valueOf(0)

  def undo(v: Datum.BigInteger[_]) = _Trait.real(v)

}
