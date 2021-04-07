package scalqa; package `val`; package stream; import _Use.*; import language.implicitConversions

transparent trait _use extends _aggregate with _calculate with _evaluate with _metadata with _print with _process with _read with _transformTo:
  self =>

object _use:
  type _aggregate   =  _Use._aggregate
  type _calculate   =  _Use._calculate
  type _evaluate    =  _Use._evaluate
  type _metadata    =  _Use._metadata
  type _print       =  _Use._print
  type _process     =  _Use._process
  type _read        =  _Use._read
  type _transformTo =  _Use._transformTo

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _use -> ### Consumption Interface

  Once a single stream consumption method is invoked, the stream object should generally be discarded.
  The only exceptions are methods defined in [_metadata](stream/_metadata.html) and [_read](stream/_read.html) interfaces.

*/