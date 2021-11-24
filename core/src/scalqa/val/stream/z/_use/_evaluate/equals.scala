package scalqa; package `val`; package stream; package z; package _use; package _evaluate; import language.implicitConversions

object equals:

  def sequence[A](s1: Stream[A], s2: Stream[A], all: Boolean): Result[true] =
    var i = 0
    var o1 = s1.readOpt
    var o2 = s2.readOpt
    while(o1.nonEmpty && o2.nonEmpty)
      if (o1.`val` != o2.`val`) return Result.Problem("Fail at index " + i + ": " + o1.`val`.tag + " != " + o2.`val`.tag)
      o1 = s1.readOpt
      o2 = s2.readOpt
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
