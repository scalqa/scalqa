package scalqa; package Fx; package Event; package Mouse

import javafx.scene.input.MouseEvent

class _Class(e: MouseEvent, node: A.Node) extends Event.Input(e, node) with Any.Able.ToInfo {
  protected type REAL <: MouseEvent

  def clickCount: Int = real.getClickCount

  def button = Button(real.getButton)

  def toInfo = new Pro.Info(this) += (("button", button))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
