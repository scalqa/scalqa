package scalqa; package Fx; package Custom; package ObservableList

private[Fx] abstract class Proxy[A] extends scalqa.Custom.Proxy.List[A] with javafx.collections.ObservableList[A] {

  protected def real: javafx.collections.ObservableList[A]

  def addListener(l: javafx.beans.InvalidationListener): Unit = real.addListener(l)
  def addListener(l: javafx.collections.ListChangeListener[_ >: A]): Unit = real.addListener(l)

  def removeListener(l: javafx.beans.InvalidationListener): Unit = real.removeListener(l)
  def removeListener(l: javafx.collections.ListChangeListener[_ >: A]): Unit = real.removeListener(l)

  def addAll(v: A*) = real.addAll(v: _*)

  def remove(from: Int, till: Int): Unit = real.remove(from, till)

  def removeAll(v: A*) = real.removeAll(v: _*)

  def retainAll(v: A*) = real.retainAll(v: _*)

  def setAll(v: java.util.Collection[_ <: A]) = real.setAll(v)

  def setAll(v: A*) = real.setAll(v: _*)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
