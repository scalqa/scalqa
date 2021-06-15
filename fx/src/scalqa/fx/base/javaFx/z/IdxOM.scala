package scalqa; package fx; package base; package javaFx; package z; import language.implicitConversions

private[fx] class IdxOM[A](l: javafx.collections.ObservableList[A]) extends IdxO[A](l) with Idx.OM[A]:
  /**/                def addAt(i: Int, e: A)           : Unit = real.add(i, e)
  /**/                def updateAt(i: Int, e: A)        : Unit = real.set(i, e)
  @tn("remove_Range") def remove_<>(v: Int.<>)          : Unit = real.remove(v.start, v.endX)
  @tn("refresh_Range")def refresh_<>(v: Int.<>)         : Unit = v.~.foreach(i => real.set(i, real.get(i)))
  /**/                def modify(ch:  Idx.M[A] => Unit) : Unit = ch(this) //Think later

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
