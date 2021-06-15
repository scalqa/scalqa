package scalqa; package fx; package base; package javaFx; package z; import language.implicitConversions

import javafx.beans.{ value, property }

private[fx] object Pro:

  protected abstract class Base[A](real: javafx.beans.Observable) extends Val.Pro.O.X.ActivationBasis[A] with javafx.beans.InvalidationListener:
    def invalidated(o: javafx.beans.Observable): Unit = fireChange
    protected override def _afterFirstListenerAdded   = real.addListener(this)
    protected override def _afterLastListenerRemoved  = real.removeListener(this)

  object O:
    object JavaFxWrap:
      class ObjectProO[A]( real: value.ObservableObjectValue[A]) extends Base[A](real)       with Val.Pro.O[A]   { override def apply() = real.get }
      class StringProO(    real: value.ObservableStringValue)    extends Base[String](real)  with String.Pro.O   { override def apply() = real.get }
      class BooleanProO(   real: value.ObservableBooleanValue)   extends Base[Boolean](real) with Boolean.Pro.O  { override def apply() = real.get }
      class DoubleProO(    real: value.ObservableDoubleValue)    extends Base[Double](real)  with Double.Pro.O   { override def apply() = real.get }
      class IntProO(       real: value.ObservableIntegerValue)   extends Base[Int](real)     with Int.Pro.O      { override def apply() = real.get }
      class LongProO(      real: value.ObservableLongValue)      extends Base[Long](real)    with Long.Pro.O     { override def apply() = real.get }

  object OM:
    import Pro.O.{JavaFxWrap => PO}
    object JavaFxWrap:
      class ObjectProOM[A](real: property.ObjectProperty[A])     extends PO.ObjectProO(real)  with Val.Pro.OM[A] { def update(v: A)       = real.set(v) }
      class StringProOM(   real: property.StringProperty)        extends PO.StringProO(real)  with String.Pro.OM { def update(v: String)  = real.set(v) }
      class BooleanProOM(  real: property.BooleanProperty)       extends PO.BooleanProO(real) with Boolean.Pro.OM{ def update(v: Boolean) = real.set(v) }
      class DoubleProOM(   real: property.DoubleProperty)        extends PO.DoubleProO(real)  with Double.Pro.OM { def update(v: Double)  = real.set(v) }
      class LongProOM(     real: property.LongProperty)          extends PO.LongProO(real)    with Long.Pro.OM   { def update(v: Long)    = real.set(v) }
      class IntProOM(      real: property.IntegerProperty)       extends PO.IntProO(real)     with Int.Pro.OM    { def update(v: Int)     = real.set(v) }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
