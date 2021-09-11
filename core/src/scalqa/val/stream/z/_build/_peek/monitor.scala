package scalqa; package `val`; package stream; package z; package _build; package _peek; import language.implicitConversions

import Custom.Event.Monitor

class monitor[A](x: ~[A], monitor: Monitor) extends z.x.Pipe.Sized[A](x):
  private var nanoStart = 0L
  private var cnt = 0

  private inline def len = Time.Length.fromNanos(System.nanoTime - nanoStart)

  @tn("read_Opt") def read_? = x.read_?.process(
    v => {
      if (cnt == 0)
        nanoStart = System.nanoTime
        Monitor.runOnBeforeFirst(monitor)
      cnt += 1
      Monitor.runOnEvery(monitor, cnt, len)
     },
    if (cnt == 0) Monitor.runOnEmpty(monitor) else Monitor.runOnAfterLast(monitor, cnt, len)
  )


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
