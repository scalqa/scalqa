package scalqa; package `val`; package stream; package z; package build; package peek

class peekIndexed[A,U](x: ~[A], f: (Int, A) => U, start: Int) extends a.Pipe.Sized[A](x):
  private         var i      = start
  @tn("read_Opt") def read_? = x.read_?.forval(v => { f(i, v); i += 1 })

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
