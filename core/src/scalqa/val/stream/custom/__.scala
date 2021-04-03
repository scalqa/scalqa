package scalqa; package `val`; package stream; import language.implicitConversions

object Custom:
  type _extension          = custom._extension;
  type Pipeline            = custom.Pipeline;                   inline def Pipeline   = custom.Pipeline
  type Event               = custom.Event;                  @fast lazy val Event      = custom.Event
  type Monitor             = custom.event.Monitor;              inline def Monitor    = custom.event.Monitor
  type Discharge[A]        = custom.Discharge[A]
  type Math[A]             = custom.Math[A];                @fast lazy val Math       = custom.Math

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Custom -> ### Advanced Functionality

   Object [[Custom]] holds advanced stream features
*/