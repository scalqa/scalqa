package scalqa; package `val`; package stream; package z; package _build; package _mutate; import language.implicitConversions

class transpose[A,B](x: Stream[A], f: A => Stream[B]) extends z.x.Pipe.Calc[Stream[B]](x):
  def calc = new Calc

  class Calc extends Stream[Stream[B]]:
    private val pack: Pack[Stream[B]] = x.map(f(_)).pack

    def readOpt = pack(0).readOpt.map(v =>{
      val a = new Array[AnyRef](pack.size)
      a(0) = v.cast[AnyRef]
      (1 <>> a.length).foreach(i => a(i) = pack(i).readOpt.cast[Opt[AnyRef]].or{ J.illegalState("All transposed collections must be of the same size") })
      a.stream.cast[Stream[B]]
    })


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
