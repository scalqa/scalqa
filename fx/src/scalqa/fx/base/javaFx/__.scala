package scalqa; package fx; package base; import language.implicitConversions

import javaFx.z

object JavaFx:

  def list[A](v: Idx.O[A])  : javafx.collections.ObservableList[A] = new z.list.Observable(v)
  def list[A](v: Idx.OM[A]) : javafx.collections.ObservableList[A] = new z.list.ObservableMutable(v)

  def observableValue[A](p: scalqa.Pro.O[A]): javafx.beans.value.ObservableValue[A] = new z.value.Base[A] {
    private var old = p()
    protected override def afterFirstListenerAdded = p.onChange(Gen.Event.Id.make0(this, () => {
      val v = p()
      fireChanged(v, old)
      old = v
    }))
    protected override def afterLastListenerRemoved = p.onChange(Gen.Event.Id.cancel0(this))
    def getValue: A = p()
  }

  def booleanPropertry(p: scalqa.Boolean.Pro.OM ): javafx.beans.property.BooleanProperty = new javafx.beans.property.BooleanPropertyBase {
    {
      bind(observableValue(p.map_^((b: Boolean) => b: java.lang.Boolean)))
    }
    def getBean(): AnyRef = "NoBean"
    def getName: String = "NoName"
    override def set(v: Boolean) = p() = v;
  }

  def stringConverter[A](bm: ReversibleFunction[A, String]): javafx.util.StringConverter[A] = new javafx.util.StringConverter[A] {
    def toString(a: A) = bm(a); def fromString(s: String) = bm.undo(s)
  }

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  inline def To   = javaFx.To
  inline def Enum = javaFx.Enum;  type Enum[A <: java.lang.Enum[A]] = javaFx.Enum[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/

/**
@object JavaFx -> ###

   Utilities to convert objects from JavaFx format to Scalqa and back

*/
