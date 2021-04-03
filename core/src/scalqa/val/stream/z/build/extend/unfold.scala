package scalqa; package `val`; package stream; package z; package build; package extend; import language.implicitConversions

class unfold[A](x: ~[A], fun: ~[A] => Opt[A]) extends a.Pipe[A](x):
  private val b = Val.Buffer[A]()
  private var pass, make = true

  @tn("read_Opt") def read_? =
    if(pass)      x.read_?.forval(b.add) or_? { pass=false; read_? }
    else if(make) fun(b).process(b.add, { make = false })
    else          \/

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
