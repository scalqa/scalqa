package scalqa; package fx; package scene; package chart; package xy; package as; package z; package Basic; import language.implicitConversions

private[as] trait Real_Base:
  self: Real[_,_,_,_,_,_] =>

  private var jobs =  Idx.M[() => Unit]()

  protected[Basic] def runFx(job: => Unit): Unit = chart.synchronized {
    if (jobs.size == 0 && fx.Thread.is) job
    else
      jobs += (() => job);
      if (jobs.size == 1) Application.Thread(chart.synchronized { val v = jobs; jobs =  Idx.M[() => Unit](); v.~.foreach(_()) })
  }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
