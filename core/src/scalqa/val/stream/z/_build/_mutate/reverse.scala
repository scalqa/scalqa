package scalqa; package `val`; package stream; package z; package _build; package _mutate; import language.implicitConversions

class reverse[A](x: ~[A]) extends a.Pipe.Calculated[A](x):

  def calculate = new ~[A]{
    private         val b      = x.toBuffer
    private         var i      = b.size
    @tn("read_Opt") def read_? = if(i==0) \/ else {i-=1; b(i) }
  }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
