package scalqa; package `val`; package stream; import language.implicitConversions

object Custom:
  type Constructors        = custom.Constructors
  type Discharge[A]        = custom.Discharge[A]
  type Pipeline            = custom.Pipeline;               transparent inline def Pipeline   = custom.Pipeline
  type Event               = custom.Event;                  transparent inline def Event      = custom.Event
  type Monitor             = custom.event.Monitor;          transparent inline def Monitor    = custom.event.Monitor
  type Math[A]             = custom.Math[A];                transparent inline def Math       = custom.Math

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Custom -> ###

   Object [[Custom]] holds advanced stream features, average users should not be concerned about.

*/