package scalqa; package fx; package scene; package event; import language.implicitConversions

import javafx.scene.input.MouseEvent

class Mouse(e: MouseEvent, node: Node) extends Event.Input(e, node) with Able.Info:
  protected type REAL <: MouseEvent

  def clickCount : Int          = real.getClickCount
  def button     : Mouse.Button = Mouse.Button(real.getButton)
  def info       : Info         = Info(this) += ("button", button)

object Mouse:
  type Button = mouse.Button; val Button = mouse.Button;

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
