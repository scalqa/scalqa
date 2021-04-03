package scalqa; package `val`; package stream; package z; package build; package zip

class zipNext[A](x: ~[A]) extends a.Pipe.Sized[(A, Opt[A])](x):
  private         val buf    = x.enablePreview
  @tn("read_Opt") def read_? = buf.read_?.map((_, buf.preview_?))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
