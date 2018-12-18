package scalqa; package Idx; package Selection

trait _library[A] extends Any with Any.Wrap[Selection[A]] {

  def asPro(dflt: A): Pro[A] = new Pro[A] { def apply = real.positions.getOpt(0).map(real(_)) or dflt }

  def isMultiple = real.positions.size > 1

}

object _library {

  class _Class[A] private[Selection] (protected val real: Selection[A]) extends AnyVal with _library[A]

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
