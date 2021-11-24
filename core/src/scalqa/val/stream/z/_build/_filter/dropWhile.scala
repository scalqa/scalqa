package scalqa; package `val`; package stream; package z; package _build; package _filter

class dropWhile[A](x: Stream[A], f: A => Boolean) extends z.x.Pipe[A](x):
  private var b = true

  def readOpt =
    var o = x.readOpt
    while(b && o){ if(!f(o.cast[A])){ b=false; return o}; o = x.readOpt }
    o

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
