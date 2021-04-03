package scalqa; package `val`; package stream; package z; package build; package zip

class zipIndex[A](val x: ~[A], val start: Int) extends a.Pipe.Sized[(Int, A)](x):
  private         var i      = start - 1
  @tn("read_Opt") def read_? = x.read_?.map(v => { i += 1; (i, v) })

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
