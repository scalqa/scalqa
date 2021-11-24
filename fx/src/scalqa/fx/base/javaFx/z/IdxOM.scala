package scalqa; package fx; package base; package javaFx; package z; import language.implicitConversions

private[fx] class IdxOM[A](l: javafx.collections.ObservableList[A]) extends IdxO[A](l) with Idx.OM[A]:
  def addAt(i: Int, e: A)           : Unit = real.add(i, e)
  def updateAt(i: Int, e: A)        : Unit = real.set(i, e)
  def removeRange(v: Int.Range)     : Unit = real.remove(v.start, v.endX)
  def refreshRange(v: Int.Range)    : Unit = v.stream.foreach(i => real.set(i, real.get(i)))
  def modify(ch:  Idx.M[A] => Unit) : Unit = ch(this) //Think later

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
