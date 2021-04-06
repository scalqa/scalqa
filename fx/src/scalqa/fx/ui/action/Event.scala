package scalqa; package fx; package ui; package action

import javafx.event.ActionEvent

class Event protected (real: ActionEvent) extends Ui.Event(real):
  protected type REAL <: ActionEvent

object Event:
  def apply(e: ActionEvent) = new Event(e)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
