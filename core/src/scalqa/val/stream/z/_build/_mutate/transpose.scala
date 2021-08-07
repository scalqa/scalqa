package scalqa; package `val`; package stream; package z; package _build; package _mutate; import language.implicitConversions

class transpose[A](x: ~[A], f: A => ~[AnyRef]) extends a.Pipe[~[AnyRef]](x):

  lazy val idx: Idx[~[AnyRef]] =
    val l = x.map(f(_)).><
    if(l.isEmpty) ><(Stream.void[AnyRef]) else l

  @tn("read_Opt") def read_? = idx(0).read_?.map(v =>{
    val a = new Array[AnyRef](idx.size)
    a(0) = v
    (1 <>> a.length).foreach(i => a(i) = idx(i).read_? or { J.illegalState("All transposed collections must be of the same size") })
    a.~
  })

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
