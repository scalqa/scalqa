package scalqa; package `val`; package stream; package z; package _use; import language.implicitConversions

object evaluate:

  def exists[A](x: ~[A], f: A => Boolean) : Boolean  = x.find_?(f).nonEmpty

  def isEvery[A](x: ~[A],f: A => Boolean) : Boolean  = x.find_?(v => !f(v)).isEmpty

  def contains[A](x: ~[A],value: A)       : Boolean  = x.takeOnly(value).read_?

  def containsSequence[A](x: ~[A],v: ~[A]): Boolean  = _evaluate.find.sequencePosition_Opt(x,v)

  def last_Opt[A](x: ~[A])                : Opt[A]   = {var o: Opt[A] = \/; x.FOREACH(o = _); o}


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
