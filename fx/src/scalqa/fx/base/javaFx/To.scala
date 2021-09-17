package scalqa; package fx; package base; package javaFx; import language.implicitConversions

import javafx.beans.{ value, property }
import z.Pro.O.{ JavaFxWrap => PO }
import z.Pro.OM.{ JavaFxWrap => POM }

object To:

  def idx_O [A](v: javafx.collections.ObservableList[A]): Idx.O[A]   = new z.IdxO[A](v)
  def idx_OM[A](v: javafx.collections.ObservableList[A]): Idx.OM[A]  = new z.IdxOM[A](v)

  def parseChanges[A](v: javafx.collections.ListChangeListener.Change[_ <: A]) : ><[Idx.O.Event[A]] = javaFx.z.list.List.parseChanges(v)

  def pro_O[A] (v: value.ObservableObjectValue[A]) : Val.Pro.O[A]    = new PO.ObjectProO(v)
  def pro_O    (v: value.ObservableBooleanValue)   : Boolean.Pro.O   = new PO.BooleanProO(v)
  def pro_O    (v: value.ObservableDoubleValue)    : Double.Pro.O    = new PO.DoubleProO(v)
  def pro_O    (v: value.ObservableLongValue)      : Long.Pro.O      = new PO.LongProO(v)
  def pro_O    (v: value.ObservableIntegerValue)   : Int.Pro.O       = new PO.IntProO(v)
  def pro_O    (v: value.ObservableStringValue)    : Pro.O[String]   = new PO.StringProO(v)

  def pro_OM[A](v: property.ObjectProperty[A])    : Val.Pro.OM[A]    = new POM.ObjectProOM(v)
  def pro_OM   (v: property.BooleanProperty)      : Boolean.Pro.OM   = new POM.BooleanProOM(v)
  def pro_OM   (v: property.DoubleProperty)       : Double.Pro.OM    = new POM.DoubleProOM(v)
  def pro_OM   (v: property.LongProperty)         : Long.Pro.OM      = new POM.LongProOM(v)
  def pro_OM   (v: property.IntegerProperty)      : Int.Pro.OM       = new POM.IntProOM(v)
  def pro_OM   (v: property.StringProperty)       : Pro.OM[String]   = new POM.StringProOM(v)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
