package scalqa; package Concurrent

package object Executor {

  def getDefault: Executor = App.Pro.DefaultExecutor()

  //  def getNewPool(corePool: Int, maxPool: Opt[Int] = \/, keepAlive: Time.Precise.Length = \/): Executor = new java.util.concurrent.ScheduledThreadPoolExecutor(corePool).I(e => {
  //    maxPool(e.setMaximumPoolSize(_))
  //    keepAlive.Opt(tl => e.setKeepAliveTime(tl.totalNanos.toLong, java.util.concurrent.TimeUnit.NANOSECONDS))
  //  })

  def get(e: java.util.concurrent.Executor) = new Executor(e)

  // *************************************************************
  // private[scalqa] object Void extends Executor with Void {
  //
  //    def execute(v: Runnable) = App.Pro.DefaultExecutor().execute(v)
  //
  //  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def getDefault -> Default
 *
 *     Returns value of [[App.Pro.DefaultExecutor]]
 *
 * @def getNewPool -> Pool Executor
 *
 *     Creates new thread pool based Executor
 *
 *     ''java.util.concurrent.ScheduledThreadPoolExecutor'' is used
 *
 *     @param corePool the number of threads to keep in the pool, even if they are idle
 *     @param maxPool the maximum number of threads to allow in the pool
 *     @param keepAlive when the number of threads is greater than the core, this is the maximum time that excess idle threads will wait for new tasks before terminating
 */
