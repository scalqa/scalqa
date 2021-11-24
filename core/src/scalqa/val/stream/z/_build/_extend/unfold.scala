package scalqa; package `val`; package stream; package z; package _build; package _extend; import language.implicitConversions

class unfold[A](x: Stream[A], fun: Stream[A] => Opt[A]) extends z.x.Pipe[A](x):
  private val b = Val.Buffer[A]()
  private var pass, make = true

  def readOpt =
    if(pass)      x.readOpt.forval(b.add) orOpt { pass=false; readOpt }
    else if(make) fun(b).process(b.add, { make = false })
    else          \/

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
