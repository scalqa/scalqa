package scalqa; package Fx; package Custom; package ObservableList; package O; package Change

import javafx.{ collections => JAVA }

private object ParseFrames {

  def apply[A](in: ~[Idx.Change[A]], owner: JAVA.ObservableList[A]): ~[Frame[A]] = {

    def isReplace(f: Idx.Change[A], l: Idx.Change[A]) = f.ifRemoveOpt.let(r => l.ifAddOpt.let(_.range == r.range))

    in.zipNext.zipPrior
      .drop(t => t._1.let(ft => isReplace(ft._1, t._2._1))).map(_._2)
      .map(_ match {
        case (v, no) if (no.let(isReplace(v, _))) => new ReplaceFrame(v.ifRemoveOpt.value, no.value.ifAddOpt.value, owner)
        case (v, _) if (v.ifRefreshOpt) => new RefreshAsReplaceFrame(v, owner)
        case (v, _) => new Frame(v, owner)
      })
  }
}

// ********************************************************************************************************************
private class ReplaceFrame[A](remove: Idx.Remove[A], add: Idx.Add[A], l: JAVA.ObservableList[A]) extends Frame[A](add, l) {
  override lazy val getRemoved = remove.items.asJavaListView
  override def wasRemoved = true
  override def wasReplaced = true
}

// ********************************************************************************************************************
private class RefreshAsReplaceFrame[A](c: Idx.Change[A], l: JAVA.ObservableList[A]) extends Frame[A](c, l) {
  override def wasAdded = true
  override def wasRemoved = true
  override def wasReplaced = true
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
