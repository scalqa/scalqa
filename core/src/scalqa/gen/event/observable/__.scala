package scalqa; package gen; package event; import language.implicitConversions

trait Observable:
  protected def onObservableChange[U](l: () => U): Event.Control

object Observable:
  /**/            val \/                     : Observable = zVoid
  implicit inline def implicitRequestVoid(inline v: \/): Observable = \/

  def onObservableChange[U](v: Observable)(l: () => U): Event.Control = v.onObservableChange(l)

  // **************************************************************************************
  private object zVoid extends Observable with Self.Void { def onObservableChange[U](v: () => U) = Event.Control.void }

  // ~~~~~~~~~~~~~~~~~~~~~~~~
  inline def X = observable.X

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Observable -> ### General Observable

       `General Observable` is the root interface of all observable types.

       Note: Its only method is protected, but can be accessed through companion method

       ```
          val pro = Pro.OM[Int](0)

          Observable.onObservableChange(pro)(() => "Change detected".TP)

          pro() = 1

          // Output
          Change detected
       ```

@def onObservableChange -> On any change event

      This is the most general event indicating a change

      Usually an object will have other more usable events, but they will also trigger this one

      The method is protected in order not to pollute object name space

      This event will likely be used by GUI controls, which will call it through companion object access method
*/
