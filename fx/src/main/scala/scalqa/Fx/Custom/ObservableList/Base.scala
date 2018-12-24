package scalqa; package Fx; package Custom; package ObservableList

import javafx.{ collections => JAVA }

private[Fx] abstract class Base[A] extends java.util.AbstractList[A] with JAVA.ObservableList[A] {

  def addAll(v: A*): Boolean = App.Fail.unsupported()
  override def add(i: Int, e: A): Unit = App.Fail.unsupported()

  def remove(from: Int, exclTo: Int): Unit = App.Fail.unsupported()
  def removeAll(v: A*): Boolean = App.Fail.unsupported()

  def retainAll(v: A*): Boolean = App.Fail.unsupported()

  def setAll(v: java.util.Collection[_ <: A]): Boolean = App.Fail.unsupported()
  def setAll(v: A*): Boolean = App.Fail.unsupported()

  override def set(i: Int, e: A): A = App.Fail.unsupported()
  override def remove(i: Int): A = App.Fail.unsupported()

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
