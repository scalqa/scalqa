package scalqa; package `val`; package stream; package z; package x; import language.implicitConversions

private[stream] class Stream_fromParallelFlow[A](src: Flow[A]) extends z.x.Pipe[A](src) with Able.Size.Opt.Long:
  private val deque                   = new J.Concurrent.Deque[A]()
  private val originalSizeOpt         = src.sizeLongOpt
  private var cnt                     = 0L
  private var check                   = true
  private var started, done, sleep    = false
  private var problem: Throwable      = null

  def readOpt =
    if (check)
      check = false
      if(!started) { started = true; J.schedule {start} }
      if (problem != null) throw problem

    var o = deque.popOpt
    while(!o)
      if(done) return deque.popOpt.forval(_ => cnt+=1)
      sleep = true
      while(sleep && !done) J.sleep(1000.Nanos)
      o = deque.popOpt
    cnt += 1
    o

  def sizeLongOpt : Long.Opt = originalSizeOpt.map(_ - cnt)

  private def start =
    try    { src.foreach(v => {deque.push(v); sleep = false}) }
    catch  { case v: Throwable => {check=true; problem = v }}
    finally{ done = true }


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
