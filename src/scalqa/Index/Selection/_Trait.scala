package scalqa; package Index; package Selection

trait _Trait[A] extends Index[A] with Able.Info {

  def target: Index[A]

  def positions: Index[Int]

  def size = positions.size

  def apply(i: Int) = target(positions(i))

  protected def info = \/.info ~ ("positions", positions.all.format(","))

}

object _Trait extends Able.Void.Companion.Typed[_Trait](new Selection[Nothing] with Void { def target = \/; def positions = \/ }) {

  import scala.language.implicitConversions

  implicit def zzLibrary[A](v: Selection[A]) = new _library[A](v)

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
 *     Lists selected values for some ''target'' Index
 *
 * @def target: -> Selection target
 *
 *     The [[Index]] targeted by this selection
 *
 * @def positions: -> Selected positions
 *
 *     Selected positions from target index
 *
 *     Note. ''positions.size == This.size''
 *
 */
