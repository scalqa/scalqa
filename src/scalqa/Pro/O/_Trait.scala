package scalqa; package Pro; package O

trait _Trait[+A] extends Pro[A] with Any.O {

  def onChange(f: () => Any): Concurrent.Control

  protected def onObservableChange(f: () => Any) = onChange(f)

}

object _Trait {

  import scala.language.implicitConversions

  implicit def zzLibrary[A](v: O[A]) = new _library(v)

  implicit def zzGet[A](v: \/.type): O[Opt[A]] = TheVoid

}

private object TheVoid extends Pro.O.The.Constant(Opt.Void) with Void
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait -> '''Read Only Observable Property'''
 *
 * @def onChange -> On change subscription
 *
 *     Adds listener function to the property change event
 *     {{{
 *         val pro = Pro.WO.get[String]("abc")
 *
 *          // event subscription
 *         pro.onChange(() => Print.ln("Change Detected"))
 *
 *         // library based event subscription
 *         pro.onValueChangeWithOld((v, old) => Print.ls("Value changed from", old, "to", v))
 *
 *         pro() = "xyz"
 *
 *         // Output
 *         Value changed from abc to xyz
 *         Change Detected
 *     }}}
 */
