package scalqa; package Any; package BiMap

class _library[A, B] private[BiMap] (private val This: BiMap[A, B]) extends AnyVal {

  def asReversed: BiMap[B, A] = This.I.letAs(classOf[Reversed[A, B]]).map(_.This) or new Reversed(This)

}

private class Reversed[A, B](val This: BiMap[B, A]) extends BiMap[A, B] {

  def apply(a: A): B = This.undo(a)

  def undo(b: B): A = This.apply(b)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def asReversed -> Reverses two functions
 *
 *   ''apply'' becomes ''undo'' and ''undo'' becomes ''apply''
 *
 */
