package scalqa; package fx; package base; package javaFx; package z; package list; import language.implicitConversions

class Observable[A](val real: Idx.O[A]) extends Base[A]:

  def get(i: Int) = real(i)
  def size        = real.size

  def addListener(   l: javafx.beans.InvalidationListener)             : Unit = Gen.Observable.onObservableChange(real)(Gen.Event.Id.make0(l, () => l.invalidated(Observable.this)))
  def removeListener(l: javafx.beans.InvalidationListener)             : Unit = Gen.Observable.onObservableChange(real)(Gen.Event.Id.cancel0(l))

  def addListener(   l: javafx.collections.ListChangeListener[_ >: A]) : Unit = real.onChange(Gen.Event.Id.make1(l,Listener(l)))
  def removeListener(l: javafx.collections.ListChangeListener[_ >: A]) : Unit = real.onChange(Gen.Event.Id.cancel1(l))

  // ****************************************************************************************************************
  private class Listener(l: javafx.collections.ListChangeListener[_ >: A]) extends (><[Idx.O.Event[A]] => Any):
    def apply(c: ><[Idx.O.Event[A]]) =
      val fxChange = List.createChange(c, Observable.this)
      try
        l.onChanged(fxChange)
      catch
      case t: Throwable =>
        System.err.println(fxChange.^.doc.text.indent("FxListChange"))
        System.err.println(Observable.this.~.zipIndex.toText.indent("Observable.List"))
        throw t

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
