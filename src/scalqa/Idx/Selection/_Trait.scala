package scalqa; package Idx; package Selection

trait _Trait[A] extends Idx[A] with Any.Able.ToInfo {

  def target: Idx[A]

  def positions: Idx[Int]

  def size = positions.size

  def apply(i: Int) = target(positions(i))

  def toInfo = new Pro.Info(this) += ("positions", positions.all.format(","))

}

object _Trait extends Util.Void.Setup.Typed[_Trait](new Selection[Any] with Void { def target = \/; def positions = \/ }) {

  implicit def zzLibrary[A](v: Selection[A]) = new _library._Class[A](v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait ->
 *
 *     Lists selected values for some `target` Idx
 *
 * @def target: -> Selection target
 *
 *     The [[Idx]] targeted by this selection
 *
 * @def positions: -> Selected positions
 *
 *     Selected positions from target index
 *
 *     Note. `positions.size == real.size`
 *
 */
