package scalqa; package `val`; package stream; package z; package _build; package _filter; import language.implicitConversions

class takeWhile[A](x: Stream[A], f: A => Boolean) extends z.x.Pipe[A](x):
  private         var ok     = true
  def readOpt = { var o: Opt[A]=VOID; if(ok) o = x.readOpt.take(f).fornil{ok = false}; o }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
