package scalqa; package Sorting; package Z; package The

private[Sorting] class Reversed[A](private val real: Sorting[A]) extends Sorting[A] {

  def position(x: A, y: A) = real(y, x);

  override val voidPosition = real.voidPosition.reverse

  override def equals(v: Any): Boolean = v.I.letAs(classOf[Reversed[A]]).let(_.real == real)

  override def toString = real.toString + ".Reversed"

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/