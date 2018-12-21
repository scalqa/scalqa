package scalqa; package Fx; package Custom

import javafx.beans.property

object ProWO {

  def apply[A](v: property.ObjectProperty[A]): scalqa.Pro.OM[A] = new A.ObjectProperty(v)

  def apply(v: property.BooleanProperty): scalqa.Pro.OM[Boolean] = new A.BooleanProperty(v)

  def apply(v: property.DoubleProperty): scalqa.Pro.OM[Double] = new A.DoubleProperty(v)

  def apply(v: property.LongProperty): scalqa.Pro.OM[Long] = new A.LongProperty(v)

  def apply(v: property.IntegerProperty): scalqa.Pro.OM[Int] = new A.IntegerProperty(v)

  def apply(v: property.StringProperty): scalqa.Pro.OM[String] = new A.StringProperty(v)

  // *******************************************************************************************************************************************************
  object A {

    class ObjectProperty[A](real: property.ObjectProperty[A]) extends ProO.A.ObservableObjectValue(real) with Pro.OM[A] { def update(v: A) = real.set(v) }

    class StringProperty(real: property.StringProperty) extends ProO.A.ObservableStringValue(real) with Pro.OM[String] { def update(v: String) = real.set(v) }

    class BooleanProperty(real: property.BooleanProperty) extends ProO.A.ObservableBooleanValue(real) with Pro.OM[Boolean] { def update(v: Boolean) = real.set(v) }

    class DoubleProperty(real: property.DoubleProperty) extends ProO.A.ObservableDoubleValue(real) with Pro.OM[Double] { def update(v: Double) = real.set(v) }

    class LongProperty(real: property.LongProperty) extends ProO.A.ObservableLongValue(real) with Pro.OM[Long] { def update(v: Long) = real.set(v) }

    class IntegerProperty(real: property.IntegerProperty) extends ProO.A.ObservableIntegerValue(real) with Pro.OM[Int] { def update(v: Int) = real.set(v) }
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
