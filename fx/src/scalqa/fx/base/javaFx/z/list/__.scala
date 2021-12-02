package scalqa; package fx; package base; package javaFx; package z; package list; import language.implicitConversions

import javafx.{ collections as JFX }

object List:

  def createChange[A](in: Idx[Idx.O.Event[A]], o: JFX.ObservableList[A]): JFX.ListChangeListener.Change[A] & Able.Doc = change.Change(in, o)

// ---------------------------------------------------------------------------------------------------------------------------------------------------------------
  def parseChanges[A](v: javafx.collections.ListChangeListener.Change[_ <: A]): Pack[Idx.O.Event[A]] =
    var l : Pack[Idx.O.Event[A]]=VOID
    val fx = v.cast[javafx.collections.ListChangeListener.Change[A]]
    fx.reset
    while (fx.next)
      if (fx.wasPermutated)   l += Idx.Event.Reposition.apply { val r = fx.getFrom <>> fx.getTo; Idx.Permutation(r, r.stream.raw.map(fx.getPermutation(_)).pack) }
      else if (fx.wasUpdated) l += Idx.Event.Update(fx.getFrom, Idx.wrap[A](fx.getRemoved), Idx.wrap[A](fx.getAddedSubList))
      else
        if (fx.wasRemoved) l +=  Idx.Event.Remove(fx.getFrom, Idx.wrap[A](fx.getRemoved))
        if (fx.wasAdded)   l +=  Idx.Event.Add(fx.getFrom, Idx.wrap[A](fx.getAddedSubList))
    l

  // ---------------------------------------------------------------------------------------------------------------------------------------------------------------
  def singleChangeDoc[A](c: JFX.ListChangeListener.Change[A]): Doc      =
    def fun(a: Stream[Any]) = a.nonEmptyOpt.map(_.makeString(",")) or "empty"
    Doc(c)
      += ("was", "" ++ c.wasPermutated ? "permutated " ++ c.wasAdded ? "added " ++ c.wasRemoved ? "removed " ++ c.wasUpdated ? "updated " ++ c.wasReplaced ? "replaced")
      += ("interval", (c.getFrom <>> c.getTo).tag)
      += ("getRemoved", fun(c.getRemoved))
      += ("getAddedSubList", fun(c.getAddedSubList))
      += ("getPermutation", c.wasPermutated ? fun((c.getFrom <>> c.getTo).stream.zipValue(c.getPermutation).drop(t => t._1 == t._2)) or "")

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
