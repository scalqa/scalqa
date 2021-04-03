package scalqa; package `val`; package stream; package z; package use; import language.implicitConversions

object process:

  inline def foreach[A,U](x: ~[A], inline f: A=>U): Unit  = {var o=x.read_?; while(o.nonEmpty){ f(o.`val`); o=x.read_?}}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
