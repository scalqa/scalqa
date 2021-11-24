package scalqa; package `val`; package stream; package z; package _build; package _zip

class zipNext[A](x: Stream[A]) extends z.x.Pipe.Sized[(A, Opt[A])](x):
  private         val buf    = x.enablePreview
  def readOpt = buf.readOpt.map((_, buf.previewOpt))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
