package scalqa; package `val`; package stream; package z; package _build; package _mutate; import language.implicitConversions

class synchronize[A](s: Stream[A]) extends z.x.Pipe.Sized[A](s):

  def readOpt = synchronized{ s.readOpt }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
