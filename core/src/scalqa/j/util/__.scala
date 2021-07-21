package scalqa; package j

object Util:

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  transparent inline def Concurrent   = util.Concurrent
  transparent inline def WeakRef      = util.WeakRef;         type WeakRef[A]  = util.WeakRef.opaque.`type`[A]
  transparent inline def Benchmark    = util.Benchmark
  transparent inline def Random       = util.Random
  transparent inline def Proxy        = util.Proxy;           type Proxy[A]    = util.Proxy[A]
  /**/                                                        type Test        = util.Test

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Util -> ### Utilities


*/
