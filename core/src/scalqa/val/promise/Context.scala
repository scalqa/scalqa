package scalqa; package `val`; package promise; import language.implicitConversions

import scala.concurrent.ExecutionContext
import Promise.Context

object Context:

  inline given Context = ZZ.Context

  extension(inline x: Context)
    inline def real                                  : ExecutionContext = x.cast[ExecutionContext]
    inline def execute(inline r: Runnable)           : Unit             = x.real.execute(r)
    inline def reportFailure(inline cause: Throwable): Unit             = x.real.reportFailure(cause)

  object TYPE:
    opaque type DEF >: ExecutionContext = ExecutionContext


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@type DEF  -> ###

Promise context is an opaque type backed by scala.concurrent.ExecutionContext, esentially they are the same thing

    Thus value promise uses Scala concurrency framework for execution

@def real ->  Get implementation

    Returns scala.concurrent.ExecutionContext

@def execute -> Execute runnable

    Runs  scala.concurrent.ExecutionContext.execute

@def reportFailure -> Handle failure

    Runs  scala.concurrent.ExecutionContext.reportFailure

*/