package scalqa; package Any; package O

trait _Trait {

  protected def onObservableChange(on: () => Any): Concurrent.Control

}

object _Trait extends Able.Void.Companion[O](new O with Void { def onObservableChange(f: () => Any) = \/ }) {

  @inline private[O] def onObservableChange(o: O, f: () => Any): Concurrent.Control = o.onObservableChange(f)

  import scala.language.implicitConversions

  implicit def zzLibrary[A <: O](a: A) = new _library[A](a)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait -> '''Any Observable'''
 *
 *     ''Any Observable'' is the root interface of all observable types.
 *
 *     Note: Its only method is protected, but can be accessed through the 'library'
 *
 *     {{{
 *        val property = Pro.WO.get[Int](0)
 *        property.onObservableChange("Change detected".lp)
 *        property() = 1
 *
 *        // Output
 *        Change detected
 *     }}}
 *
 * @def onObservableChange(on -> On change event
 *
 *    This is the most general event indicating any change.
 *
 *    Usually an object will have other more usable events, but they will also trigger this one.
 *
 *    The method is protected in order not to pollute application name space.
 *
 *    This event will likely be used by GUI controls, which will call it through the 'library'
 *
 */
