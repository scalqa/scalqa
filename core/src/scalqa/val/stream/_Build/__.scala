package scalqa; package `val`; package stream; import _Build.*; import language.implicitConversions


transparent trait _build extends _extend with _filter with _group with _map with _mutate with _order with _parallel with _peek with _zip:
  self: Stream.type =>

object _build:
  type _extend    =  _Build._extend
  type _filter    =  _Build._filter;   val _filter =  _Build._filter
  type _mutate    =  _Build._mutate
  type _parallel  =  _Build._parallel
  type _group     =  _Build._group
  type _map       =  _Build._map
  type _order     =  _Build._order
  type _peek      =  _Build._peek
  type _zip       =  _Build._zip

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _build -> ### Build Interface

   Build methods extend stream pipeline creating functionality which will add, remove or modify stream elements, when they finally start moving throught the pipeline

*/