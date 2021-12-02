package scalqa; package `val`; package stream; package z; package _build; package _group; import language.implicitConversions

class splitAt[A](x: Stream[A], pos: Stream[Int]) extends z.x.Pipe[Stream[A]](x):
  private var i     = 0
  private var ended = false

  def readOpt = pos.readOpt.map(j => x.readStream({val v = j - i; i = j; v})) orOpt (if(ended) VOID else {ended=true; x })

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
