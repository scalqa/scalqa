package scalqa; package lang; package double; package g; import language.implicitConversions

abstract class Math[A<:Raw] extends Math.Ordering[A] with Gen.Math[A] with ~~.Custom.Math.Average[A]:
  override def compare(x:A,y:A): Int              = java.lang.Double.compare(x,y)
  override def reverse         : Math.Ordering[A] = new Math.zReversedOrdering(this)

object Math:

  trait Ordering[A<:Raw] extends Gen.Math.Ordering[A]:
    override def compare(x:A,y:A): Int
    override def reverse         : Ordering[A] = new zReversedOrdering(this)

  // *******************************************************************************
  private class zReversedOrdering[A<:Raw](o: Ordering[A]) extends Ordering[A] with scala.Ordering[A]:
    /**/     def compare(x:A,y:A): Int         = o.compare(y,x)
    override def reverse         : Ordering[A] = o

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