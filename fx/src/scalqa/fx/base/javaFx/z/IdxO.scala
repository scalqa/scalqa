package scalqa; package fx; package base; package javaFx; package z; import language.implicitConversions

import javafx.{ collections as JFX }

private[fx] class IdxO[A](val real: JFX.ObservableList[A]) extends Idx.O[A]:

  def size          : Int     = real.size
  def apply(i: Int) : A       = real.get(i)
  def contains(v: A): Boolean = real.contains(v)

  def onChange[U](l: ><[Idx.O.Event[A]] => U): Gen.Event.Control =
    if (l.isInstanceOf[Gen.Event.Id]) J.unsupportedOperation()
    else
      object Listener extends Gen.Event.Control.X.Basic(l) with JFX.ListChangeListener[A] { def onChanged(real: JFX.ListChangeListener.Change[_ <: A]) = target_?.forval(_(Fx.JavaFx.To.parseChanges(real))) }
      Listener.onCancel(() => real.removeListener(Listener))
      real.addListener(Listener)
      Listener

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
