package scalqa; package `val`; package pro; import language.implicitConversions

trait ObservableMutable[A] extends Observable[A] with Mutable[A]

object ObservableMutable:
  def apply[A](v: A)                : ObservableMutable[A]             = new X.Basic(v)
  def named[A](pName: String, v: A) : ObservableMutable[A] & Able.Name = new X.Basic(v) with Able.Name { def name = pName }

  extension[A](x: ObservableMutable[A])
    @tn("twoWay_View") def twoWay_^[B](m: A=>B, r: B => A)      : Pro.OM[B] = twoWay_^(using TwoWayFun(m,r))
    @tn("twoWay_View") def twoWay_^[B](using m: TwoWayFun[A,B]) : Pro.OM[B] = z.TwoWay_View.ObservableMutable[A,B](x, m)

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  inline def X = observableMutable.X

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
          val name_*          : Pro.OM[String] = String.Pro.OM("")
          def name            : String         = name_*()
          def name_=(v:String): Unit           = name_*() = v
          val bar_*           : Int.Pro.OM     = Int.Pro.OM(0)
          def bar             : Int            = value_*()
          def bar_=(v:Int)    : Unit           = value_*() = v
       ```
*/
