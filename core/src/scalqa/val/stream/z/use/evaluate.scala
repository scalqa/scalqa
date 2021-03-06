package scalqa; package `val`; package stream; package z; package use; import language.implicitConversions

object evaluate:

  def equals[A](s1: ~[A], s2: ~[A], all: Boolean): Result[true] =
    var i = 0
    var o1 = s1.read_?
    var o2 = s2.read_?
    while(o1.nonEmpty && o2.nonEmpty)
      if (o1.`val` != o2.`val`) return Result.Problem("Fail at index " + i + ": " + o1.`val`.tag + " != " + o2.`val`.tag)
      o1 = s1.read_?
      o2 = s2.read_?
      i += 1
    if(all)
      if(o1.nonEmpty)  return "Second stream has less elements".Problem
      if(o2.nonEmpty)  return "First stream has less elements".Problem
    true

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
