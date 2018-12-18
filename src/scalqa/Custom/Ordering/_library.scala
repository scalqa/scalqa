package scalqa; package Custom; package Ordering

class _library[A] private[scalqa] (protected val real: math.Ordering[A]) extends AnyVal {

  @inline def custom: Ordering[A] = real match {
    case o: Ordering[A] => o
    case _              => new Z.Wrap(real)
  }

  def asMappedView[B](f: B => A): Ordering[B] = new Ordering[B] {
    def compare(x: B, y: B) = real.compare(f(x), f(y))
  }

  def asPrioritizedView(priority: A => Int): Ordering[A] = new Z.PrioritizedView[A](real, priority)

  def optCompare(xo: Opt[A], yo: Opt[A], voidPosition: Int = 0): Int = Z.OptValueView.compare(real, voidPosition, xo, yo)

  def asOptValueView(voidPosition: Int): Ordering[Opt[A]] = new Z.OptValueView[A, Opt[A]](real, voidPosition)

  def asVoidFirstView: Ordering[A] = new Z.VoidPosition.FirstView[A](real)

  def asVoidLastView: Ordering[A] = new Z.VoidPosition.LastView[A](real)

  def +(o: math.Ordering[_ >: A]): math.Ordering[A] =
    if (real.isVoid) o.asInstanceOf[math.Ordering[A]]
    else if (o.isVoid) real
    else new Ordering[A] { def compare(x: A, y: A) = { val i = real.compare(x, y); if (i == 0) o.compare(x, y) else i } }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
