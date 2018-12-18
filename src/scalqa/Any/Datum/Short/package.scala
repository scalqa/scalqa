package scalqa; package Any; package Datum

package object Short {
  type Ordered[A <: Ordered[A]] = Ordered._Trait[A]
  type Sequential[A <: Sequential[A]] = Sequential._Trait[A]
  type Computable[A <: Computable[A]] = Computable._Trait[A]
  type Number[A <: Number[A]] = Number._Trait[A]

  def undo(v: Short[_]) = _Trait.real(v)

}
