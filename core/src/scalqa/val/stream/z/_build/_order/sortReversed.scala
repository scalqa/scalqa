package scalqa; package `val`; package stream; package z; package _build; package _order; import language.implicitConversions

class sortReversed[A](x: Stream[A])(using c: Ordering[A]) extends z.x.Pipe.Calc[A](x):

  def calc = x.toBuffer.self(_.sort(using c.reverse)).stream

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
