package scalqa; package gen

object Event:
  transparent inline def Control       = event.Control;         type Control    = event.Control
  @fast       lazy   val Store         = event.Store;           type Store      = event.Store
  transparent inline def Id            = event.Id;              type Id         = event.Id
  transparent inline def Observable    = event.Observable;      type Observable = event.Observable
  transparent inline def CancelRequest = event.CancelRequest

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Event -> ###

    This object holds the event building framework

*/