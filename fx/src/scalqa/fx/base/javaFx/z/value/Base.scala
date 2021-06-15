package scalqa; package fx; package base; package javaFx; package z; package value; import language.implicitConversions

import javafx.beans.value.ChangeListener
import javafx.beans.InvalidationListener

private[fx] abstract class Base[A] extends java.util.concurrent.atomic.AtomicReference[AnyRef](Base) with javafx.beans.value.ObservableValue[A]:

  def addListener   (l: InvalidationListener)  : Unit = _addListener(l)
  def removeListener(l: InvalidationListener)  : Unit = _removeListener(l)
  def addListener   (l: ChangeListener[_ >: A]): Unit = _addListener(l)
  def removeListener(l: ChangeListener[_ >: A]): Unit = _removeListener(l)

  protected def fireInvalidated: Unit = get match
    case l: InvalidationListener => l.invalidated(this)
    case a: Array[Ref] => a.~.foreach {
      case l: InvalidationListener => l.invalidated(this)
      case _                       => ()
    }
    case _ => ()

  protected def fireChanged(v: A, old: A): Unit = get match
    case l: ChangeListener[_]    => l.cast[ChangeListener[A]].changed(this, old, v)
    case l: InvalidationListener => l.invalidated(this)
    case a: Array[Ref] => a.~.foreach {
      case l: ChangeListener[_]    => l.cast[ChangeListener[A]].changed(this, old, v)
      case l: InvalidationListener => l.invalidated(this)
      case _                       => ()
    }
    case _ => ()

  protected def listenerCount = get match { case Base => 0; case v: Array[_] => v.length; case _ => 1 }

  protected def afterFirstListenerAdded: Unit = ()
  protected def afterLastListenerRemoved: Unit = ()

  private def _addListener(l: AnyRef): Unit = get match
    case Base          => if (!compareAndSet(Base, l)) _addListener(l) else afterFirstListenerAdded
    case v: Array[Ref] => if (!compareAndSet(v, v + l)) _addListener(l)
    case v             => if (!compareAndSet(v, Array[Ref](v, l))) _addListener(l)

  private def _removeListener(l: AnyRef): Unit =
    def clear(v: AnyRef) = if (!compareAndSet(v, Base)) _removeListener(l) else afterLastListenerRemoved
    get match
      case Base => ()
      case v: Array[Ref] if v.length == 1 => if (v(0) == l) clear(v)
      case v: Array[Ref] =>
        val a = v.~.dropOnly(l).toArray
        if (a.length == 0) clear(v)
        else if ((v ne a) && !compareAndSet(v, a)) _removeListener(l)
      case v => if (v == l) clear(v)

private object Base
/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
