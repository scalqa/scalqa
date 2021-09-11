package scalqa; package `val`; package stream; package z; package _build; package _mutate; import language.implicitConversions

class enableSize[A](_s: ~[A]) extends z.x.Pipe[A](_s) with Able.Size:
  self =>
  private         var s      = _s
  @tn("read_Opt") def read_? = s.read_?
  /**/            def size   = s.size_? or { val b=s.toBuffer; s = b.~; b.size }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
