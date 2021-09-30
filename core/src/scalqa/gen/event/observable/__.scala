package scalqa; package gen; package event; import language.implicitConversions

trait Observable:
  def onObservableChange[U](l: () => U): Event.Control

object Observable:
  @tn("getVoid")  def void               : Observable = zVoid
  implicit inline def implicitRequest(v: \/): Observable = void

  // **************************************************************************************
  private object zVoid extends Observable with Gen.Void { def onObservableChange[U](v: () => U) = Event.Control.void }

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~
  transparent inline def X = observable.X

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Observable -> ### General Observable

       `General Observable` is the root interface of all observable types.

       ```
          val pro = Pro.OM[Int](0)

          pro.onObservableChange(() => "Change detected".TP)

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
