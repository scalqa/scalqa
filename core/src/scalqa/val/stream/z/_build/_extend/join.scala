package scalqa; package `val`; package stream; package z; package _build; package _extend; import language.implicitConversions

class join[A](x: Stream[A], value: A) extends z.x.Pipe[A](x) with Able.Size.Opt.Long:
  private var v = true
  def readOpt     : Opt[A]   = if(v) x.readOpt orOpt {v = false; value} else VOID
  def sizeLongOpt : Long.Opt = if(v) x.sizeLongOpt.map(_ + 1) else 0L

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
