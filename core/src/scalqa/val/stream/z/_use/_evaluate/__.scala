package scalqa; package `val`; package stream; package z; package _use; import language.implicitConversions

object evaluate:

  def exists[A](x: Stream[A], f: A => Boolean)      : Boolean  = x.findOpt(f).nonEmpty

  def isEvery[A](x: Stream[A],f: A => Boolean)      : Boolean  = x.findOpt(v => !f(v)).isEmpty

  def contains[A](x: Stream[A],value: A)            : Boolean  = x.takeOnly(value).readOpt

  def containsSequence[A](x: Stream[A],v: Stream[A]): Boolean  = _evaluate.find.sequencePositionOpt(x,v)

  def lastOpt[A](x: Stream[A])                     : Opt[A]   = {var o: Opt[A]=VOID; x.FOREACH(o = _); o}


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
