package scalqa; package `val`; package pro; import language.implicitConversions

trait Mutable[A] extends Pro[A]:
  def update(v: A) : Unit

object Mutable:
  def apply[A](value: A)                : Mutable[A]             = new X.Basic[A](value)
  def named[A](pName: String, value: A) : Mutable[A] & Able.Name = new X.Basic(value) with Able.Name { def name = pName }
  def sealable[A](value: A)             : Mutable[A] & Able.Seal = new Z.Sealable(value)

  extension[A](x: Mutable[A])
    @tn("mutableMap_View") def mutableMap_^[B](m: A=>B, r: B => A)                   : Mutable[B]    = mutableMap_^(using ReversibleFunction(m,r))
    @tn("mutableMap_View") def mutableMap_^[B](using bm: ReversibleFunction[A,B])    : Mutable[B]    = new z.TwoWay_View.M(x, bm)
    /**/                   def bindTo(v: Pro.O[_ <: A])                              : Event.Control = v.onChange(() => x() = v())
    /**/                   def bindTo[B<:A](v: Idx.Selection.Observable[B], dflt: A) : Event.Control = v.onChangeRun { x() = v.value_? or dflt }

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
         val name_*           : Pro.M[String] = Pro.M[String]("")
         def name             : String        = name_*()
         def name_=(v :String): Unit          = name_*() = v
         val bar_*            : Int.Pro.M     = Int.Pro.M(0)
         def bar              : Int           = value_*()
         def bar_=(v :Int)    : Unit          = value_*() = v
       ```

@def update -> Updates value

       Updates property value

       ```
           val pro: Pro.M[String] = Pro.M[String]("")

           pro.update("abc") // Regular call

           pro() = "abc"     // Scala "syntactic sugar" call
       ```
*/
