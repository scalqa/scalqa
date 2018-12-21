package scalqa; package Util; package EventControl

object CancelException extends RuntimeException
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object CancelException ->
 *
 *   [[CancelException]] can be thrown inside event code, so the event will be cancelled
 *
 *   Note: In application code event's [[EventControl]] provides nicer way for cancellation
 *
 */
