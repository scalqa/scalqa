package scalqa; package `val`; package stream; package z; package _build; package _mutate; import language.implicitConversions

class transpose[A,B](x: ~[A], f: A => ~[B]) extends z.x.Pipe.Calc[~[B]](x):
  def calc = new Calc

  class Calc extends ~[~[B]]:
    private val pack: ><[~[B]] = x.map(f(_)).><

    @tn("read_Opt") def read_? = pack(0).read_?.map(v =>{
      val a = new Array[AnyRef](pack.size)
      a(0) = v.cast[AnyRef]
      (1 <>> a.length).foreach(i => a(i) = pack(i).read_?.cast[Opt[AnyRef]].or{ J.illegalState("All transposed collections must be of the same size") })
      a.~.cast[~[B]]
    })


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
