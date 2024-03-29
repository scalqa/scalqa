package scalqa; package `val`; package stream; package z; package _build; package _order; import language.implicitConversions

class sortBy[A,B](x: Stream[A], f: A => B)(using c: Ordering[B]) extends z.x.Pipe.Calc[A](x):

  def calc = x.toBuffer.self(_.sortBy(f)).stream

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
