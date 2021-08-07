package scalqa; package `val`; package stream; import _build.*; import language.implicitConversions


transparent trait _Build extends _extend with _Filter with _group with _map with _mutate with _order with _parallel with _peek with _zip:
  self: Stream.type =>

object _Build:
  type _extend    =  _build._extend
  type _filter    =  _build._Filter;   val _filter =  _build._Filter
  type _mutate    =  _build._mutate
  type _parallel  =  _build._parallel
  type _group     =  _build._group
  type _map       =  _build._map
  type _order     =  _build._order
  type _peek      =  _build._peek
  type _zip       =  _build._zip

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _Build -> ### Build Stream Interface

  Build methods extend stream pipeline creating functionality which will add, remove or modify stream elements, when they finally start moving throught the pipeline.

  Once a single stream build method is invoked, the original stream object must not be used, all further processing must be done with the newly created stream.

*/