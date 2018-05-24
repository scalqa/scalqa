package scalqa; package App

object Pro {

  private def define[A](v: A) : scalqa.Pro.W[A] with Able.Seal = scalqa.Pro.W.getSealable[A](v)

  lazy val PipeParallelFactory =  define[(Pipe[Any], Int) => Pipe.Flow[Any]]((p: ~[Any], sz: Int) => Pipe.Z.flow.ParallelJavaStream.get[Any](p, sz))

  lazy val JsonFormat = define[J.Json.Format](J.Json.Z.DefaultFormat)

  lazy val ConfigRootOpt = define[Opt[J.File.Directory]](\/)

  lazy val TempPathOpt = define[Opt[J.Path]]( \/)

  lazy val RandomEngine = define[General.Tool.Random.Engine](General.Tool.Random.Engine.TheJava)

  lazy val DefaultBufferSize = define[Int](100)

  lazy val DefaultScheduler = define[Concurrent.Scheduler](Concurrent.Scheduler.Z.Default)

  lazy val DefaultExecutor = define[Concurrent.Executor](java.util.concurrent.ForkJoinPool.commonPool)

  def all = ~[Pro[_] with Able.Seal] ~ PipeParallelFactory ~ JsonFormat ~ ConfigRootOpt ~ DefaultBufferSize ~ RandomEngine ~ DefaultExecutor ~ DefaultScheduler ~ TempPathOpt

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *  @val DefaultExecutor -> Default executor
 *
 *    By default executor is java.util.concurrent.ForkJoinPool.commonPool
 *
 *  @val DefaultScheduler -> Default scheduler
 *
 *    By default schedular is lazily allocated java.util.concurrent.Executors.newScheduledThreadPool(App.availableProcessors - 1 minDefault 2)
 *
 *  @val PipeParallelFactory -> Pipe parallel engine
 *
 *     Factory to create parallel [[Pipe.Flow]]
 *
 *     Default creates parallel java.stream.Stream based implementation
 *
 *     The factory gets [[Pipe]] of elements and Int parallel group size
 *
 *     Group size specifies how many consecutive elements should be sent together to each parallel thread for processing
 *
 *     @return Parallel [[Pipe.Flow]]
 *
 *  @val JsonFormat -> JSON engine
 *
 *     Parsing engine to be used in [[J.Json]] framework
 *
 *     Default implementation is lousy and would not handle, but simplest cases
 *
 * @def all -> All properties
 *
 *     Returns [[Pipe]] of all properties
 *
 * @object Pro -> '''Application Configuration Properties'''
 *
 *   The properties can be set in an [[App]] class and then sealed, so they cannot be changed anymore
 *   {{{
 *     object MyApp extends App {
 *
 *        App.Pro.ConfigRootOpt() = J.Path.get("C:", "config").directoryOpt
 *
 *        App.Pro.all(_.seal)
 *
 *        "Hello Configured World" lp
 *
 *        App.Pro.ConfigRootOpt() = J.Path.get("C:", "other").directoryOpt // Fails because sealed
 *     }
 *  }}}
 */
