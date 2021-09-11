package scalqa; package `val`; package stream; package z; package _build; import language.implicitConversions

class peek[A,U](x: ~[A], f: A => U) extends z.x.Pipe.Sized[A](x):
  @tn("read_Opt") def read_? = x.read_?.forval(f)

object peek:

  def start [A,U](x: ~[A], f: Time=>U)              : ~[A]  = events(x,_.onBeforeFirst(f))
  def end   [A,U](x: ~[A], f: (Int,Time.Length)=>U) : ~[A]  = events(x,_.onAfterLast(f))
  def empty [A,U](x: ~[A], f: => U)                 : ~[A]  = events(x,_.onEmpty(() => f))
  def events[A,U](x: ~[A], f: Custom.Event => U)    : ~[A]  = new _peek.monitor(x, new Custom.Event().^(f(_)))
  def monitor[A] (x: ~[A], v: Custom.Event.Monitor) : ~[A]  = if (v.^.isVoid) x else new _peek.monitor(x, v)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
