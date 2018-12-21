package scalqa; package Fx; package Custom; package ObservableList; package O; package Change

import javafx.{ collections => JAVA }

class _Class[A](in: ~[Idx.Change[A]], owner: JAVA.ObservableList[A]) extends JAVA.ListChangeListener.Change[A](owner) {
  private val frames: Refs[Frame[A]] = ParseFrames(in, owner).to[Refs]
  private var i = -1
  private var current: Frame[A] = VoidFrame.BeforeFirst.asInstanceOf[Frame[A]]

  def reset: Unit = { i = -1; current = VoidFrame.BeforeFirst.asInstanceOf[Frame[A]] }

  def next: Boolean = {
    i += 1;
    current = if (i < frames.size) frames(i) else VoidFrame.asInstanceOf[Frame[A]]
    current != VoidFrame
  }

  override def getFrom = current.getFrom
  override def getTo = current.getTo
  override def getPermutation = current.getPermutation
  override def getRemoved = current.getRemoved
  override def getAddedSubList = current.getAddedSubList
  override def wasPermutated = current.wasPermutated
  override def wasAdded = current.wasAdded
  override def wasRemoved = current.wasRemoved
  override def wasUpdated = current.wasUpdated
  override def wasReplaced = current.wasReplaced

  def all: ~[Frame[A]] = frames

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
