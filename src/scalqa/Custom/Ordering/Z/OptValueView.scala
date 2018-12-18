package scalqa; package Custom; package Ordering; package Z

private[Ordering] class OptValueView[A, OPT_A](o: math.Ordering[A], voidPosition: Int) extends Ordering[OPT_A] { // Compiler issues if defined as Opt[A]

  assert(voidPosition != 0, "voidPosition cannot be 0");

  def compare(x: OPT_A, y: OPT_A): Int = OptValueView.compare(o, voidPosition, x.asInstanceOf[Opt[A]], y.asInstanceOf[Opt[A]])

}

private[Ordering] object OptValueView {

  def compare[A](o: math.Ordering[A], voidPos: Int, xo: Opt[A], yo: Opt[A]): Int =
    if (xo.isVoid) if (yo.isVoid) 0 else voidPos
    else if (yo.isVoid) voidPos * -1
    else o.compare(xo.value, yo.value)
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
