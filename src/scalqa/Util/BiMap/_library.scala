package scalqa; package Util; package BiMap

class _library[A, B] private[BiMap] (private val real: BiMap[A, B]) extends AnyVal {

  def asReversedView: BiMap[B, A] = real.I.letType[Reversed[A, B]].map(_.real) or new Reversed(real)

}

private class Reversed[A, B](val real: BiMap[B, A]) extends BiMap[A, B] {

  def apply(a: A): B = real.undo(a)

  def undo(b: B): A = real.apply(b)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def asReversedView -> Reverses two functions
 *
 *   `apply` becomes `undo` and `undo` becomes `apply`
 *
 */
