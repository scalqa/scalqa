package scalqa; package `val`; package stream; package z; package _build; package _order; import language.implicitConversions

class sort[A](x: ~[A])(using c: Ordering[A]) extends a.Pipe.Calculated[A](x):

  def calculate = x.toBuffer.^(_.sort).~

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
