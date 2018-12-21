package scalqa; package Fx; package Custom; package ObservableList

private[Fx] object Void extends Base[Nothing] with Void {

  def get(i: Int) = App.Fail()
  def size = 0

  def addListener(l: javafx.beans.InvalidationListener) {}
  def removeListener(l: javafx.beans.InvalidationListener) {}

  def addListener(l: javafx.collections.ListChangeListener[_]) {}
  def removeListener(l: javafx.collections.ListChangeListener[_]) {}
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
