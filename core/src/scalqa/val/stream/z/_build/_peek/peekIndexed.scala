package scalqa; package `val`; package stream; package z; package _build; package _peek

class peekIndexed[A,U](x: Stream[A], f: (Int, A) => U, start: Int) extends z.x.Pipe.Sized[A](x):
  private         var i      = start
  def readOpt = x.readOpt.forval(v => { f(i, v); i += 1 })

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
