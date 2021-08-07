package scalqa; package `val`; package stream; package z; package _build; package _zip

class zipFoldAs[A,B](x: ~[A], v: B, f: (B,A) => B) extends a.Pipe.Sized[(A, B)](x):
  private         var b      = v
  @tn("read_Opt") def read_? = x.read_?.map(v => { b = f(b, v); (v, b) })

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
