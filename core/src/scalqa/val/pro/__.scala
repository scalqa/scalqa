package scalqa; package `val`; import pro.*; import language.implicitConversions

trait Pro[+A]:
  def apply(): A

object Pro:
  /**/            def apply[A](source: => A)          : Pro[A]    = Z.Function0(source)
  /**/            def unapply[A](v: Pro[A])           : Option[A] = Some(v())
  implicit inline def implicitToFunction[A](v: Pro[A]): () => A   = () => v()

  extension[A]  (x: Pro[A])
    /**/   def mapView[B](f: A => B)                                            : Pro[B]   = new z.Convert_View(x, f)
    /**/   def observableView(v1: Gen.Observable, v2: Opt[Gen.Observable] =VOID): Pro.O[A] = z.Observable_View(x, v1, v2)
    inline def contains(inline v: A)                                            : Boolean  = x() == v

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  transparent inline def Mutable           = pro.Mutable;           type Mutable[A]           = pro.Mutable[A]
  transparent inline def M                 = pro.Mutable;           type M[A]                 = pro.Mutable[A]
  transparent inline def Observable        = pro.Observable;        type Observable[A]        = pro.Observable[A]
  transparent inline def O                 = pro.Observable;        type O[A]                 = pro.Observable[A]
  transparent inline def ObservableMutable = pro.ObservableMutable; type ObservableMutable[A] = pro.ObservableMutable[A]
  transparent inline def OM                = pro.ObservableMutable; type OM[A]                = pro.ObservableMutable[A]
  transparent inline def X                 = pro.X

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Pro -> ### Value Provider

      Whenever value provider belongs to an object, it effectively becomes a property holder for this object.

      #### Properties Framework

      There are 4 types of standard properties:

       - [[Pro]]  - read only
       - [[Pro.Mutable]]  - read/write, aliased as [[Pro.M]]
       - [[Pro.Observable]] - read/listenTo, aliased as [[Pro.O]]
       - [[Pro.ObservableMutable]] - read/write/listenTo, aliased as [[Pro.OM]]

       The inheritance graph looks like:
       ```
              Pro.O
             /      \
          Pro        Pro.OM
             \     /
              Pro.M
       ```
       Here is an example of 'name' property definition hierarchy:
       ```
               trait Foo:                                     // 'name' is read only
                 def namePro          : Pro[String]
                 def name             : String = namePro()    // required shortcut

               trait Foo_M extends Foo:                       // 'name' is read/write
                 def namePro          : Pro.M[String]
                 def name_=(v:String) : Unit = namePro() = v  // required shortcut

               trait Foo_O extends Foo:                       // 'name' is read/listenTo
                 def namePro          : Pro.O[String]

               trait Foo_OM extends Foo_O with Foo_M:         // 'name' is read/write/listenTo
                 def namePro          : Pro.OM[String]
       ```

       Note. The 'required shortcuts' must be implemented. They will not even show up in documentation, because they are assumed to be there

@def apply -> Get value

       Returns property value

       ```
           val pro: Pro.M[String] = Pro.M[String]("abc")

           val v1 = pro.apply() // Regular call
           val v2 = pro()       // Scala "syntactic sugar" call
       ```

*/
