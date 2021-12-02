package scalqa; package `val`; package stream; package z; package _build; package _mutate; import language.implicitConversions

class reverse[A](x: Stream[A]) extends z.x.Pipe.Calc[A](x):
  def calc = new Calc

  class Calc extends Stream[A]:
    private         val b      = x.toBuffer
    private         var i      = b.size
    def readOpt = if(i==0) VOID else {i-=1; b(i) }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
