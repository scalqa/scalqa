package scalqa; package Fx; package Custom; package ObservableList; package OM

class _Class[A](override val real: Idx.OM[A]) extends O[A](real) {

  override def set(i: Int, v: A) = { val ov = real(i); real.update(i, v); ov }
  override def add(i: Int, v: A) = real.addAt(i, v)
  override def remove(i: Int) = { val v = real(i); real removeAt i; v }

  override def addAll(v: A*): Boolean = { real.multiChange(_ +~= v); v.nonEmpty }
  override def remove(from: Int, end: Int): Unit = { real.removeAt(from <>> end) }
  override def removeAll(c: A*) = { var r = false; real.multiChange(l => r = l.removeFor(c.all.contains) > 0); r }
  override def retainAll(c: A*) = { var r = false; real.multiChange(l => r = l.removeFor(!c.all.contains(_)) > 0); r }
  override def setAll(v: java.util.Collection[_ <: A]) = { real.replaceAll(v); !real.isEmpty }
  override def setAll(v: A*) = { real.replaceAll(v); !real.isEmpty }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
