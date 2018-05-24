package scalqa; package Concurrent; package Scheduler; package Z

import java.util.concurrent._

private[scalqa] object Default extends AbstractExecutorService with ScheduledExecutorService {

  lazy val real: ScheduledExecutorService = java.util.concurrent.Executors.newScheduledThreadPool(App.availableProcessors - 1 minDefault 2)

  def execute(r: Runnable) = real.execute(r)

  def awaitTermination(v1: Long, v2: TimeUnit): Boolean = real.awaitTermination(v1, v2)

  def isShutdown = real.isShutdown

  def isTerminated = real.isTerminated

  def shutdown = real.shutdown

  def shutdownNow = real.shutdownNow

  def schedule[V](v1: Callable[V], v2: Long, v3: TimeUnit) = real.schedule(v1, v2, v3)

  def schedule(v1: Runnable, v2: Long, v3: TimeUnit) = real.schedule(v1, v2, v3)

  def scheduleAtFixedRate(v1: Runnable, v2: Long, v3: Long, v4: TimeUnit) = real.scheduleAtFixedRate(v1, v2, v3, v4)

  def scheduleWithFixedDelay(v1: Runnable, v2: Long, v3: Long, v4: TimeUnit) = real.scheduleWithFixedDelay(v1, v2, v3, v4)

}
