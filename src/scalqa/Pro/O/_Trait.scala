package scalqa; package Pro; package O

trait _Trait[+A] extends Pro[A] with Any.O {

  def onChange(f: () => Any): App.Event

  protected def onObservableChange(f: () => Any) = onChange(f)

}

object _Trait {

  implicit def zzLibrary[A](v: O[A]) = new _library._Class(v)

  implicit def zzMake[A](v: \/): O[Opt[A]] = VoidOpt.asInstanceOf[O[Opt[A]]]

}

private object VoidOpt extends O[Any] with Void {
  def apply: Any = Opt.Void
  def onChange(pf: () => Any) = \/
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait -> `Read Only Observable Property`
 *
 * @def onChange(f: -> On change subscription
 *
 *     Adds listener function to the property change event
 *     {{{
 *         val pro = Pro.OM.make[String]("abc")
 *
 *          // event subscription
 *         pro.onChange(() => "Change Detected".lp)
 *
 *         // library based event subscription
 *         pro.onValueChangeWithOld((v, old) => "Value changed from " + old + " to " + v lp))
 *
 *         pro() = "xyz"
 *
 *         // Output
 *         Value changed from abc to xyz
 *         Change Detected
 *     }}}
 */
