package scalqa; package j; package util; import language.implicitConversions

object Concurrent:
  type Ref[A]   = concurrent.Ref.opaque.`type`[A];    transparent inline def Ref     = concurrent.Ref
  type Counter  = concurrent.Counter.opaque.`type`;   transparent inline def Counter = concurrent.Counter
  type Deque[A] = concurrent.Deque[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Concurrent -> ###

   A set of concurrent utility implementations which do not use synchronization, but rather more finely grained java.util.concurrent.atomic technology.

*/