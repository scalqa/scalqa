package scalqa; package fx; package base; package javaFx; package z; package list; package change; import language.implicitConversions

import javafx.{ collections as JFX }

object Change:

  def apply[A](in: Idx[Idx.O.Event[A]], o: JFX.ObservableList[A]): JFX.ListChangeListener.Change[A] & Able.Doc =

    val frames: Idx[z_Frame[A]] = in.stream.map[z_Frame[A]]{
      case v:  Idx.Event.Add[A]        => new Z.InsertFrame[A](v, o)
      case v:  Idx.Event.Remove[A]     => new Z.DeleteFrame[A](v, o)
      case v:  Idx.Event.Update[A]     => new Z.ReplaceFrame[A](v, o)
      case v:  Idx.Event.Reposition[A] => new Z.ReorderFrame[A](v, o)
      case _                           => J.illegalState()
    }.toIdx

    new JFX.ListChangeListener.Change[A](o) with Able.Doc {
      private var i = -1
      private var current: z_Frame[A] = z_Frame.BeforeFirst.cast[z_Frame[A]]

      def reset: Unit = { i = -1; current = z_Frame.BeforeFirst.cast[z_Frame[A]] }

      def next: Boolean = {
        i += 1;
        current = if (i < frames.size) frames(i) else z_Frame.Void.cast[z_Frame[A]]
        current != z_Frame.Void
      }

      override def getFrom         = current.getFrom
      override def getTo           = current.getTo
      override def getPermutation  = current.getPermutation
      override def getRemoved()    = current.getRemoved
      override def getAddedSubList = current.getAddedSubList
      override def wasPermutated   = current.wasPermutated
      override def wasAdded        = current.wasAdded
      override def wasRemoved      = current.wasRemoved
      override def wasUpdated      = current.wasUpdated
      override def wasReplaced     = current.wasReplaced

      def doc = new Doc(this){ override def text = frames.stream.toText }
    }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
