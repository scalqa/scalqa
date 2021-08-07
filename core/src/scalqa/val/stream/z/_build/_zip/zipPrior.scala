package scalqa; package `val`; package stream; package z; package _build; package _zip; import language.implicitConversions

class zipPrior[A](x: ~[A]) extends a.Pipe.Sized[(Opt[A], A)](x):
  private         var o: Opt[A] = \/
  @tn("read_Opt") def read_?    = x.read_?.map(v => (o, v).self_^(v => o = v._2))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
