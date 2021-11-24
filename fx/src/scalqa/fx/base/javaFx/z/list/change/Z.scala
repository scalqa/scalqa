package scalqa; package fx; package base; package javaFx; package z; package list; package change; import language.implicitConversions

import javafx.{ collections as JFX }

private object Z:

  class InsertFrame[A](val change:  Idx.Event.Add[A], l: JFX.ObservableList[A]) extends z_Frame[A](l):
    override lazy  val getAddedSubList: java.util.List[A] = change.items.toJavaListView
    override       def wasAdded = true

  class DeleteFrame[A](val change:  Idx.Event.Remove[A], l: JFX.ObservableList[A]) extends z_Frame[A](l):
    override lazy  val getRemoved: java.util.List[A] = change.items.toJavaListView
    override       def wasRemoved = true

  class ReplaceFrame[A](val change:  Idx.Event.Update[A], l: JFX.ObservableList[A]) extends z_Frame[A](l):
    override lazy  val getAddedSubList: java.util.List[A] = change.items.toJavaListView
    override lazy  val getRemoved: java.util.List[A] = change.oldItems.toJavaListView
    override       def wasAdded = true
    override       def wasRemoved = true
    override       def wasReplaced = true

  class ReorderFrame[A](val change:  Idx.Event.Reposition[A], l: JFX.ObservableList[A]) extends z_Frame[A](l):
    override       def wasPermutated = true
    override       val getPermutation: Array[Int] = change.positions.stream.toArray

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
