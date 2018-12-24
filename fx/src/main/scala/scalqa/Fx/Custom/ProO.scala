package scalqa; package Fx; package Custom

import javafx.beans.value

object ProO {

  def apply[A](v: value.ObservableObjectValue[A]): Pro.O[A] = new A.ObservableObjectValue(v)

  def apply(v: value.ObservableBooleanValue): Pro.O[Boolean] = new A.ObservableBooleanValue(v)

  def apply(v: value.ObservableDoubleValue): Pro.O[Double] = new A.ObservableDoubleValue(v)

  def apply(v: value.ObservableLongValue): Pro.O[Long] = new A.ObservableLongValue(v)

  def apply(v: value.ObservableIntegerValue): Pro.O[Int] = new A.ObservableIntegerValue(v)

  def apply(v: value.ObservableStringValue): Pro.O[String] = new A.ObservableStringValue(v)

  // *************************************************************************************************************************
  object A {
    abstract class ValueBase[A](real: javafx.beans.Observable) extends Pro.O.A.Base[A] {
      real.addListener(new javafx.beans.InvalidationListener {
        def invalidated(o: javafx.beans.Observable): Unit = fireChange
      })
    }

    class ObservableStringValue(real: value.ObservableStringValue) extends ValueBase[String](real) { override def apply = real.get }

    class ObservableBooleanValue(real: value.ObservableBooleanValue) extends ValueBase[Boolean](real) { override def apply = real.get }

    class ObservableDoubleValue(real: value.ObservableDoubleValue) extends ValueBase[Double](real) { override def apply = real.get }

    class ObservableIntegerValue(real: value.ObservableIntegerValue) extends ValueBase[Int](real) { override def apply = real.get }

    class ObservableLongValue(real: value.ObservableLongValue) extends ValueBase[Long](real) { override def apply = real.get }

    class ObservableObjectValue[A](real: value.ObservableObjectValue[A]) extends ValueBase[A](real) { override def apply = real.get }
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
