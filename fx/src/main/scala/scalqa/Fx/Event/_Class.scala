package scalqa; package Fx; package Event

abstract class _Class(fxEvent: javafx.event.Event) /*extends A.Delegate */ {
  protected  type REAL <: javafx.event.Event

  def real: REAL = fxEvent.asInstanceOf[REAL]

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
