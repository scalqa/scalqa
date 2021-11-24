package scalqa; package `val`; package stream; package z; package _build; import language.implicitConversions

class peek[A,U](x: Stream[A], f: A => U) extends z.x.Pipe.Sized[A](x):
  def readOpt = x.readOpt.forval(f)

object peek:

  def start [A,U](x: Stream[A], f: Time=>U)              : Stream[A]  = events(x,_.onBeforeFirst(f))
  def end   [A,U](x: Stream[A], f: (Int,Time.Length)=>U) : Stream[A]  = events(x,_.onAfterLast(f))
  def empty [A,U](x: Stream[A], f: => U)                 : Stream[A]  = events(x,_.onEmpty(() => f))
  def events[A,U](x: Stream[A], f: Custom.Event => U)    : Stream[A]  = new _peek.monitor(x, new Custom.Event().self(f(_)))
  def monitor[A] (x: Stream[A], v: Custom.Event.Monitor) : Stream[A]  = if (v.self.isVoid) x else new _peek.monitor(x, v)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
