package scalqa; package `val`; package pro; import language.implicitConversions

trait Mutable[A] extends Pro[A]:
  def update(v: A) : Unit

object Mutable:
  def apply[A](value: A)                : Mutable[A]             = new X.Basic[A](value)
  def named[A](pName: String, value: A) : Mutable[A] & Able.Name = new X.Basic(value) with Able.Name { def name = pName }
  def sealable[A](value: A)             : Mutable[A] & Able.Seal = new Z.Sealable(value)

  extension[A](x: Mutable[A])
    def mutableMapView[B](m: A=>B, r: B => A)                 : Mutable[B]    = mutableMapView(using TwoWayFunction(m,r))
    def mutableMapView[B](using bm: TwoWayFunction[A,B])      : Mutable[B]    = new z.TwoWay_View.M(x, bm)
    def bindTo(v: Pro.O[_ <: A])                              : Event.Control = v.onChange(() => x() = v())
    def bindTo[B<:A](v: Idx.Selection.Observable[B], dflt: A) : Event.Control = v.onChangeRun { x() = v.valueOpt or dflt }

  // Members ~~~~~~~~~~~~~~~~~~~~~
  transparent inline def X = mutable.X

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Mutable -> ### Read/write property

       The usual implementation looks like:
       ```
       class Foo:
         val namePro           : Pro.M[String] = Pro.M[String]("")
         def name             : String        = namePro()
         def name_=(v :String): Unit          = namePro() = v
         val barPro            : Int.Pro.M     = Int.Pro.M(0)
         def bar              : Int           = valuePro()
         def bar_=(v :Int)    : Unit          = valuePro() = v
       ```

@def update -> Updates value

       Updates property value

       ```
           val pro: Pro.M[String] = Pro.M[String]("")

           pro.update("abc") // Regular call

           pro() = "abc"     // Scala "syntactic sugar" call
       ```
*/
