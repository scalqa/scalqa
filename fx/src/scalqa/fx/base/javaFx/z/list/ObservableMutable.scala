package scalqa; package fx; package base; package javaFx; package z; package list; import language.implicitConversions

class ObservableMutable[A](override val real:  Idx.OM[A]) extends Observable[A](real):

  override def set(i: Int, v: A)           : A       = { val ov = real(i); real(i) = v; ov }
  override def add(i: Int, v: A)           : Unit    = real.addAt(i, v)
  override def remove(i: Int)              : A       = { val v = real(i); real.removeAt(i); v }

  override def addStream(v: Stream[A])     : Boolean = { val sz = size; real ++= v; sz != size }
  override def remove(from: Int, end: Int) : Unit    = real.removeRange(from <>> end)
  override def removeStream(v: Stream[A])  : Boolean = { val sz = size; real.removeAll(v); sz != size }
  override def retainStream(v: Stream[A])  : Boolean = { val sz = size; val rl = v.pack; real.modify(_.removeFor(!rl.contains(_))); sz != size }
  override def setStream(v: Stream[A])     : Boolean = { val b = size > 0; real.replaceWith(v); b || size > 0 }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
