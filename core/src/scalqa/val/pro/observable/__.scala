package scalqa; package `val`; package pro; import language.implicitConversions

trait Observable[+A] extends Pro[A] with gen.event.Observable:
  /**/      def onChange          [U](l: () => U): Event.Control
  protected def onObservableChange[U](l: () => U): Event.Control = onChange(l)

object Observable:
  def apply[A](v: => A, dependencies: ~[Gen.Observable] = \/)                          : Observable[A]                            = X.Basic[A](v, dependencies)
  def apply[A](v: => A, dependencies: Gen.Observable*)                                 : Observable[A]                            = apply(v, dependencies)
  def constant[A](v: A)                                                                : Observable[A]                            = Z.Constant(v)
  def named[A](name: String, v: => A, dependencies: ~[Gen.Observable] = \/)            : Observable[A] & Able.Name                = Z.Named[A](name, v, dependencies)
  def refreshable[A](v: => A, dependencies: ~[Gen.Observable] = \/)                    : Observable[A] & Able.Refresh             = Z.Refreshable[A](v, dependencies)
  def namedRefreshable[A](name: String, v: => A, dependencies: ~[Gen.Observable] = \/) : Observable[A] & Able.Name & Able.Refresh = Z.NamedRefreshable[A](name, v, dependencies)

  extension[A](x: Observable[A])
    /**/            def onChangeRun[U](f: => U)                 : Event.Control = x.onChange(() => f)
    /**/            def onValueChange[U](l: A => U)             : Event.Control = x.onChange(Event.Id.map0(l, () => l(x())))
    /**/            def onValueChangeWithOld[U](l: (A,A) => U)  : Event.Control = { var old = x.apply(); x.onChange(Event.Id.map0(l, () => { val v = x(); l.apply(v, old); old = v }))  }
    @tn("map_View") def map_^[B](f: A => B)                     : Pro.O[B]      = z.Convert_View.O(x, f)
    @tn("mix_View") def mix_^[B,C](v:Observable[B],mix:(A,B)=>C): Pro.O[C]      = z.Mix_View(x, v, mix)

  // ~~~~~~~~~~~~~~~~~~~~~~~~
  inline def X = observable.X

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Observable -> ### Read/listenTo property

@def onChange -> On change subscription

       Adds given function as listener to property change events
       ```
           val pro = String.Pro.OM("foo")

           // event subscription
           pro.onChange(() => "Change Detected".TP)

           // library based event subscription
           pro.onValueChangeWithOld((v, old) => "Value changed from " + old + " to " + v TP()))

           pro() = "bar"

           // Output
           Value changed from foo to bar
           Change Detected
       ```

*/
