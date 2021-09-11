package scalqa; package `val`; package stream; package z; package _build; package _mutate; import language.implicitConversions

class shuffle[A](x: ~[A]) extends z.x.Pipe.Calc[A](x):
  def calc = new Calc

  class Calc extends ~[A]:
    private         val b      = x.toBuffer
    private         var i      = b.size
    private         val perm   = Idx.Permutation.random(0 <>> i)
    @tn("read_Opt") def read_? = if(i==0) \/ else {i-=1; b(perm.position(i)) }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
