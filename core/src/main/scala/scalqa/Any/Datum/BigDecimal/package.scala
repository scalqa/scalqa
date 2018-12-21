package scalqa; package Any; package Datum

package object BigDecimal {

  private[BigDecimal] val Zero = java.math.BigDecimal.valueOf(0)

  def undo(v: BigDecimal[_]) = _Trait.real(v)

}
