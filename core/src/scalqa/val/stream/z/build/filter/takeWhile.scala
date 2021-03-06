package scalqa; package `val`; package stream; package z; package build; package filter; import language.implicitConversions

class takeWhile[A](x: ~[A], f: A => Boolean) extends a.Pipe[A](x):
  private         var ok     = true
  @tn("read_Opt") def read_? = { var o : Opt[A] = \/; if(ok) o = x.read_?.take(f).fornil{ok = false}; o }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
