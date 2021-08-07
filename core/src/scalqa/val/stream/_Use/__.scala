package scalqa; package `val`; package stream; import _use.*; import language.implicitConversions

transparent trait _Use extends _aggregate with _calculate with _evaluate with _metadata with _print with _process with _read with _transformTo:
  self =>

object _Use:
  type _aggregate   =  _use._aggregate
  type _calculate   =  _use._calculate
  type _evaluate    =  _use._evaluate
  type _metadata    =  _use._metadata
  type _print       =  _use._print
  type _process     =  _use._process
  type _read        =  _use._read
  type _transformTo =  _use._transformTo

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _Use -> ### Stream Consumption Interface

  Once a single stream consumption method is invoked, the stream object should generally be discarded.
  The only exceptions are methods defined in [_metadata](_use/_metadata.html) and [_read](_use/_read.html) interfaces.

*/