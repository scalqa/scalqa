package scalqa; package lang; package int; package g; import language.implicitConversions

abstract class Math[A<:Raw] extends Math.Ordering[A] with Gen.Math[A]:
  final override def compare(x:A,y:A): Int = java.lang.Integer.compare(x,y)

object Math:

  trait Ordering[A<:Raw] extends Gen.Math.Ordering[A]:
    /**/     def compare(x:A,y:A): Int
    override def reverse         : Ordering[A] = new zReversedOrdering(this);

  // *******************************************************************************
  private class zReversedOrdering[A<:Raw](c: Ordering[A]) extends Ordering[A]:
    /**/     def compare(x:A,y:A): Int         = c.compare(y,x)
    override def reverse         : Ordering[A] = c

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Math -> ### Generic Math

   Math is an implementation of scala.math.Numeric, an instance required for generic calculations on underlying type.

*/