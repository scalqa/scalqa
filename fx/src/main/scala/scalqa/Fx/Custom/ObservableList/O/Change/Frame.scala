package scalqa; package Fx; package Custom; package ObservableList; package O; package Change

import javafx.{ collections => JAVA }

class Frame[A](val range: Idx.Range, change: Idx.Change[A], l: JAVA.ObservableList[A]) extends JAVA.ListChangeListener.Change[A](l) with Any.Able.ToInfo {
  def this(c: Idx.Change[A], l: JAVA.ObservableList[A]) = this(c.range, c, l)

  override def reset = App.Fail.unsupported()
  override def next = App.Fail.unsupported()

  override lazy val getFrom = range.start
  override lazy val getTo = if (!wasReplaced && wasRemoved) getFrom else range.end
  override lazy val getPermutation: Array[Int] = change.ifRepositionOpt.map(_.indexes.toArray) or Array.emptyIntArray
  override lazy val getRemoved: java.util.List[A] = change.ifRemoveOpt.map(_.items.asJavaListView) or \/
  override lazy val getAddedSubList: java.util.List[A] = change.ifAddOpt.map(_.items.asJavaListView) or \/

  override def wasPermutated = change.ifRepositionOpt
  override def wasAdded = change.ifAddOpt
  override def wasRemoved = change.ifRemoveOpt
  override def wasUpdated = false
  override def wasReplaced = false

  def toInfo = {
    def all(a: ~[Any]) = a.I.let(_.prime).map(_.format(",")).or("empty")
    new Pro.Info(this) += (("wasPermutated", wasPermutated)) += (("wasAdded", wasAdded)) += (("wasRemoved", wasRemoved)) += (("wasUpdated", wasUpdated)) += (("wasReplaced", wasReplaced)) +=
      (("from", getFrom)) += (("to", getTo)) += (("getPermutation", all(getPermutation.all))) += (("getRemoved", all(getRemoved))) += (("getAddedSubList", all(getAddedSubList)))
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
