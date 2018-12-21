package scalqa; package Fx; package Custom

object EventHandler {

  def apply[A <: javafx.event.Event](h: A => Any): javafx.event.EventHandler[A] = new javafx.event.EventHandler[A] {

    def handle(e: A) = h(e)

  }
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
