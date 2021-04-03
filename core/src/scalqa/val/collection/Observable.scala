package scalqa; package `val`; package collection

trait Observable[A] extends Collection[A] with gen.event.Observable:
  /**/      def onAdd             [U](l: A  => U): Event.Control
  /**/      def onRemove          [U](l: A  => U): Event.Control
  protected def onObservableChange[U](l: () => U): Event.Control = Z.onObservableChange(this,l)

object Observable


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Observable -> ### Observable Collection

    Observable collection allows to track `add`, `remove` changes by subscribing to the events

@def onAdd -> On element add

    Subscribes given function to element add event

    ```
    val co: Collection.ObservableMutable[Int] = Collection.OM[Int]()

    co.onAdd("Added: "+ _ TP())

    co ++= 1 <> 3

    // Output
    Added: 1
    Added: 2
    Added: 3
    ```

@def onRemove -> On element remove

    Subscribes given function to element remove event

    ```
    val co: Collection.ObservableMutable[Int] = Collection.OM[Int]()

    co.onRemove("Removed: "+ _ TP())

    co ++= 1 <> 10

    co --= 5 <> 7

    // Output
    Removed: 7
    Removed: 6
    Removed: 5
    ```
*/
