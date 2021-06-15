package scalqa; package gen

object Event:
  val Control            = event.Control;         type Control = event.Control
  val Store              = event.Store;           type Store   = event.Store
  val Id                 = event.Id;              type Id      = event.Id
  val CancelRequest      = event.CancelRequest
  inline def Observable  = event.Observable;      type Observable         = event.Observable

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