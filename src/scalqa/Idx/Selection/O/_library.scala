package scalqa; package Idx; package Selection; package O

trait _library[A] extends Any with Selection._library[A] with Any.Wrap[Selection.O[A]] {

  def onChange(f: => Any): App.Event = real.onChange(_ => f)

  override def asPro(dflt: A): Pro.O[A] = new Pro.O[A] { def apply = real.positions.getOpt(0).map(real(_)) or dflt; def onChange(f: () => Any) = real.onChange(_ => f()) }

}

object _library {

  class _Class[A] private[O] (protected val real: O[A]) extends AnyVal with _library[A]
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
