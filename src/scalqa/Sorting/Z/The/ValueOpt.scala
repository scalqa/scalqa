package scalqa; package Sorting; package Z; package The

private[Sorting] class ValueOpt[A, OPT_A](o: Sorting[A], override val voidPosition: Sorting.Position) extends Sorting[OPT_A] { // Compiler issues if defined as Opt[A]

  protected def position(x: OPT_A, y: OPT_A): Position = o.apply(x.cast[Opt[A]].value, y.cast[Opt[A]].value)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/