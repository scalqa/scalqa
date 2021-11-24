package scalqa; package `val`; package pro; import language.implicitConversions

trait ObservableMutable[A] extends Observable[A] with Mutable[A]

object ObservableMutable:
  def apply[A](v: A)                : ObservableMutable[A]             = new X.Basic(v)
  def named[A](pName: String, v: A) : ObservableMutable[A] & Able.Name = new X.Basic(v) with Able.Name { def name = pName }

  extension[A](x: ObservableMutable[A])
    def mutableMapView[B](m: A=>B, r: B => A)          : Pro.OM[B] = mutableMapView(using TwoWayFunction(m,r))
    def mutableMapView[B](using m: TwoWayFunction[A,B]): Pro.OM[B] = z.TwoWay_View.ObservableMutable[A,B](x, m)

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  transparent inline def X = observableMutable.X

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait ObservableMutable -> ### Read/write/listenTo Property`

       The usual implementation looks like:
       ```
       class Foo:
          val namePro          : Pro.OM[String] = String.Pro.OM("")
          def name            : String         = namePro()
          def name_=(v:String): Unit           = namePro() = v
          val barPro           : Int.Pro.OM     = Int.Pro.OM(0)
          def bar             : Int            = valuePro()
          def bar_=(v:Int)    : Unit           = valuePro() = v
       ```
*/
