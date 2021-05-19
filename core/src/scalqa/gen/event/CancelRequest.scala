package scalqa; package gen; package event

object CancelRequest extends RuntimeException

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
    @object CancelRequest -> ###

    [[CancelRequest]] can be thrown inside event code, so the event will be cancelled

     Note: This is more advanced facility, most events are cancelled with returned [[Event.Control]] methods

*/
