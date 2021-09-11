package scalqa; package `val`; package stream; package z; package _build; package _group; import language.implicitConversions

class splitAt[A](x: ~[A], pos: ~[Int]) extends z.x.Pipe[~[A]](x):
  private var i     = 0
  private var ended = false

  @tn("read_Opt") def read_? = pos.read_?.map(j => x.read_~({val v = j - i; i = j; v})) or_? (if(ended) \/ else {ended=true; x })

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
