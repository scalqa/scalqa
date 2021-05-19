package scalqa; package `val`; package range

object Z:

  abstract class Base[A] extends X.Base[A,Range[A]]:
    def make(s:A, e:A, in:Boolean)(using Ordering[A]): Range[A] = ???

  class EndInclsive[A:Ordering  ](val start: A, val end: A)(using val ordering: Ordering  [A]) extends Base[A]:
    /**/     def endIsIn       = true

  class EndExclusive[A:Ordering  ](val start: A, val end: A)(using val ordering: Ordering  [A]) extends Base[A]:
    /**/     def endIsIn       = false

  class SingleValueInclusive[A: Ordering  ](val start: A)(using val ordering: Ordering  [A]) extends Base[A]:
    /**/     def end           = start
    /**/     def endIsIn       = true
    override def contains(v:A) = ordering.compare(start,v) == 0

  class SingleValueExclusive[A: Ordering  ](val start: A)(using val ordering: Ordering  [A]) extends Base[A]:
    /**/     def end           = start
    /**/     def endIsIn       = false
    override def contains(v:A) = false

  // **********************************************************************************************************************
  class Void[A](using val ordering: Ordering  [A]) extends Base[A] with Self.Void:
    override def start                   : A       = J.unsupportedOperation("Void range does not have a start")
    override def end                     : A       = J.unsupportedOperation("Void range does not have an end")
    override def endIsIn                 : Boolean = false
    override def contains(a: A)          : Boolean = false
    override def contains(that: Range[A]): Boolean = false

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
