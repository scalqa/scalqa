package scalqa; package `val`; package stream; package z; package build; package peek; import language.implicitConversions

class peek[A,U](x: ~[A], f: A => U) extends a.Pipe.Sized[A](x):

  @tn("read_Opt") def read_? = x.read_?.forval(f)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
