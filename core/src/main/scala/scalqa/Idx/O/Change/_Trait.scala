package scalqa; package Idx; package O; package Change

trait _Trait[A] extends Any.Collection.Change[A] {

  def range: Idx.Range

  override def toInfo = super.toInfo += (if (range.size == 1) ("index", range.start) else ("range", range))

}

object _Trait {

  implicit def zzLibrary[A](v: Change[A]) = new _library(v)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def range -> Affected range
 *
 *     Range of items affected
 *
 */
