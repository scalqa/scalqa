package scalqa; package j

object Util:

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  /**/   val Concurrent   = util.Concurrent
  inline def WeakRef      = util.WeakRef;         type WeakRef[A]  = util.WeakRef.opaque.`type`[A]
  inline def Benchmark    = util.Benchmark
  inline def Random       = util.Random
  /**/                                            type Test        = util.Test
  inline def Proxy        = util.Proxy;           type Proxy[A]    = util.Proxy[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Util -> ### Utilities


*/