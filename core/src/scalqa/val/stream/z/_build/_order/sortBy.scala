package scalqa; package `val`; package stream; package z; package _build; package _order; import language.implicitConversions

class sortBy[A,B](x: ~[A], f: A => B)(using c: Ordering[B]) extends a.Pipe.Calculated[A](x):

  def calculate =
    val b = x.toBuffer
    b.sortBy(f)
    b.~

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
