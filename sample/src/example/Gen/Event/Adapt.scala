package example.gen.event;  import scalqa.{*, given};  import language.implicitConversions

/*
   Purpose: Show how to add a standard scalqa style onChange event to javafx.collections.ObservableList
*/

import javafx.collections.{ ObservableList => LIST }

object Adapt:

  extension[A](x: LIST[A]) {
    def onChange(f: => Unit): Event.Control = new Event.Control.X.Basic(() => f) with javafx.beans.InvalidationListener {
      def invalidated(o: javafx.beans.Observable) = target_?.forval(_())
      onCancel(() => x.removeListener(this))
      onCancel(() => "Listener Removed".tp)
      x.addListener(this)
    }
  }

  def main(sa:  Array[String]): Unit =

    val fxList: LIST[String] = javafx.collections.FXCollections.observableArrayList[String]

    val eventControl = fxList.onChange("List Changed".tp)

    fxList.add("1")
    fxList.add("2")
    fxList.add("3")
    fxList.add("4")
    eventControl.cancel
    fxList.add("5")
    fxList.add("6")
