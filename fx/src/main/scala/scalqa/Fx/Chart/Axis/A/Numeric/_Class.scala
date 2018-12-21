package scalqa; package Fx; package Chart; package Axis; package A; package Numeric

class _Class[A](m: BiMap[A, Double]) extends Value[A](m) with _Setup[A] {
  def this(name: String, m: BiMap[A, Double]) = { this(m); name.I.Opt(label = _) }
  def this(name: String, a: A => Double, d: Double => A) = this(name, BiMap(a, d))

  override protected type REAL = Z.ValueAxis[A]
  protected override def _createGui = new REAL(this)
  type Span[T] = Numeric.Span[T]

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
