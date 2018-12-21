package scalqa; package Fx; package A

package object Module {

  def biMap = BiMap[javafx.scene.Node, Module](make, _.real)

  def make[T <: Module](r: javafx.scene.Node): T = Delegate.Gui.make(r.onZoomFinishedProperty)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
