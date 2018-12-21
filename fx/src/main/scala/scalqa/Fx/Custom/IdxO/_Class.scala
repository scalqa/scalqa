package scalqa; package Fx; package Custom; package IdxO

import javafx.{ collections => J }

class _Class[A](val real: J.ObservableList[A]) extends Idx.O[A] {

  def size = real.size

  def apply(i: Int) = real.get(i)

  def onChange(on: Idx[Idx.Change[A]] => Any): EventControl =
    if (on.isInstanceOf[Util.EventControl.WithId]) App.Fail.unsupported()
    else new Util.EventControl.A.Base with J.ListChangeListener[A] {

      def onChanged(real: J.ListChangeListener.Change[_ <: A]): Unit = if (isActive) on(changes(real))

      onCancel(() => real.removeListener(this))

      real.addListener(this)
    }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
