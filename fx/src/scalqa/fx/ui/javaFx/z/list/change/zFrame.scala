package scalqa; package fx; package ui; package javaFx; package z; package list; package change; import language.implicitConversions

import javafx.{ collections as JFX }

private abstract class zFrame[A](l: JFX.ObservableList[A]) extends JFX.ListChangeListener.Change[A](l) with Able.Doc:

  def change:  Idx.O.Event[A]

  override def wasPermutated = false
  override def wasAdded = false
  override def wasRemoved = false
  override def wasReplaced = false
  override def wasUpdated = false

  def getPermutation: Array[Int] = Int.emptyArray
  def getRemoved(): java.util.List[A] = \/

  override lazy  val getFrom = change.range.start
  override lazy  val getTo = if (!wasReplaced && wasRemoved) getFrom else change.range.endX

  override def reset = J.unsupportedOperation()
  override def next = J.unsupportedOperation()

  def doc = List.singleChangeDoc(this)

object zFrame:

  object Void extends zFrame[Nothing](null) with Void:
    def change = J.unsupportedOperation()
    override lazy  val getFrom = 0
    override lazy  val getTo = 0

  object BeforeFirst extends zFrame[Nothing](null) with Void:
    def fail = J.illegalState("Was not fetched")
    def change = fail
    override lazy  val getFrom = fail
    override lazy  val getTo = fail
    override def getRemoved = fail
    override def getAddedSubList = fail
    override def wasPermutated = fail
    override def wasAdded = fail
    override def wasRemoved = fail

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
