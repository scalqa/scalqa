package scalqa; package Fx; package Custom

object ObservableValue {

  def apply[A](p: Pro.O[A]): javafx.beans.value.ObservableValue[A] = new javafx.beans.value.ObservableValueBase[A] {

    p.onChange(() => fireValueChangedEvent)

    def getValue: A = p()

  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
