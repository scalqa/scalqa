package scalqa; package `val`; package stream; package z; package _build; package _group; import language.implicitConversions

class groupEvery[A](x: ~[A], cnt: Int) extends z.x.Pipe[~[A]](x):

  @tn("read_Opt") def read_? = x.read_~(cnt).?.drop(_.isEmpty)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
