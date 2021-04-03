package scalqa; package `val`; package idx; import observable.*; import language.implicitConversions

trait Observable[A] extends Idx[A] with Val.Collection.Observable[A]:
  /**/  def onChange[U](l: ><[Event[A]] => U) : Gen.Event.Control
  final def onAdd   [U](l: A => U)              : Gen.Event.Control = z.observable.onAdd(this, l)
  final def onRemove[U](l: A => U)              : Gen.Event.Control = z.observable.onRemove(this, l)

object Observable:
  @tn("getVoid")inline def void[A]                   : Observable[A] = z.Void.OM.cast[Observable[A]]
  implicit      inline def xxRequest[A](inline v: \/): Observable[A] = void[A]

  extension[A]  (x: Observable[A])
    @tn("reversed_View")     def reversed_^                 : Idx.O[A] = z.Reversed_View.O(x)
    @tn("statefulMap_View")  def statefulMap_^[B](f: A => B): Idx.O[B] = z.Convert_View.O.Stateful(x, f)
    @tn("fun_View")          def fun_^[B](f: A => B)        : Idx.O[B] = z.Convert_View.O(x, f)

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  inline def Event = observable.Event;  type Event[A] = observable.Event[A]
  inline def X     = observable.X

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Observable -> ### Observable Idx Collection

       Observable Idx collection allows to track all the changes by subscribing to `onChange` event

@def onChange -> On event

    Subscribes given function to all element changes

    ```
    val idx: Idx.OM[Int] = Idx.OM[Int]()

    idx.onChange(_.~.TP)

    idx ++= 1 <> 5

    idx(2) = 22

    idx.remove_<>(3 <> 4)

    idx.~.TP

    // Output
    ~(IdxChange{type=Add,range=0 <> 4,items=[1,2,3,4,5]})
    ~(IdxChange{type=Update,range=2 <> 2,items=22,oldItems=3})
    ~(IdxChange{type=Remove,range=3 <> 4,items=[4,5]})
    ~(1, 2, 22)
    ```


@def void  -> Get void instance

@def xxRequest -> General void instance request \n\n It is possible to use general request \/ to get void instance of this type, thanks to this implicit conversion.

*/
