package scalqa; package `val`; package stream; package z; package _build; package _zip

class zipKey[A,B](x: Stream[A], f: A => B) extends z.x.Pipe.Sized[(B,A)](x):
  def readOpt = x.readOpt.map(v => (f(v),v))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
