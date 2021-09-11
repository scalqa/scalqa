package scalqa; package `val`; package stream; package z; package flow; import language.implicitConversions

private[flow] class CustomThreadPoolParallelFlow[A](priority: J.Vm.Priority, parallelism: Int, val base: JavaStreamParallelFlow[A]) extends custom.pipeline.ParallelFlow[A] with Custom.Pipeline:
  /**/                def name                                      : String                          = \/
  @tn("sizeLong_Opt") def sizeLong_?                                : Long.Opt                        = base.sizeLong_?
  /**/                def take( f: A => Boolean)                    : CustomThreadPoolParallelFlow[A] = CustomThreadPoolParallelFlow(priority, parallelism, base.take(f))
  /**/                def drop(f: A => Boolean)                     : CustomThreadPoolParallelFlow[A] = CustomThreadPoolParallelFlow(priority, parallelism, base.drop(f))
  /**/                def peek(f: A => Unit)                        : CustomThreadPoolParallelFlow[A] = CustomThreadPoolParallelFlow(priority, parallelism, base.peek(f))
  /**/                def map[B](f: A => B)                         : CustomThreadPoolParallelFlow[B] = CustomThreadPoolParallelFlow(priority, parallelism, base.map(f))
  /**/                def flatMap[B](f: A => ~[B])                  : CustomThreadPoolParallelFlow[B] = CustomThreadPoolParallelFlow(priority, parallelism, base.flatMap(f))
  /**/                def foreach[U](f: A => U)                     : Unit                            = runWithinPool{ base.foreach(f) }
  @tn("reduce_Opt")   def reduce_?(f: (A,A) => A)                   : Opt[A]                          = runWithinPool{ base.reduce_?(f) }
  /**/                def foldAs[B](start:B)(op:(B,A)=>B,f:(B,B)=>B): B                               = runWithinPool{ base.foldAs(start)(op,f) }
  @tn("findAny_Opt")  def findAny_?                                 : Opt[A]                          = runWithinPool{ base.findAny_? }
  override            def count                                     : Int                             = runWithinPool{ base.count }
  override            def doc                                       : Doc                             = super.doc += ("priority",priority) += ("parallelism",parallelism)

  private def runWithinPool[A](f: => A): A = {
    import java.util.concurrent.ForkJoinPool
    val x = new ForkJoinPool(parallelism, x => ForkJoinPool.defaultForkJoinWorkerThreadFactory.newThread(x).^(_.setPriority(priority.real)), null, false)
    val v: A = x.submit(() => f).get
    x.shutdownNow
    v
  }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
