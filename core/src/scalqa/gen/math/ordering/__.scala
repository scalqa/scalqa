package scalqa; package gen; package math; import ordering.*; import language.implicitConversions

import scala.math.{ Ordering as ORD }

trait Ordering[A] extends scala.math.Ordering[A]:

  override def compare(x:A,y:A) : Int
  /**/                  def join(c: ORD[A])                : ORD[A]      = if (this.^.isVoid) c.cast[Ordering[A]] else if (c.^.isVoid) this else z.View.Joined[A](this, c)
  @tn("_join")          def +   (c: ORD[A])                : ORD[A]      = this.join(c)
  @tn("rank_View")      def rank_^(fun: A => Int)          : ORD[A]      = z.View.ByRank[A](this, fun)
  @tn("opt_View")       def opt_^(voidPosition: Int)       : ORD[Opt[A]] = z.View.Option[A](this, voidPosition)
  @tn("voidFirst_View") def voidFirst_^(using Given.VoidTag[A]) : ORD[A]      = z.View.VoidPositionFirst[A](this)
  @tn("voidLast_View")  def voidLast_^ (using Given.VoidTag[A]) : ORD[A]      = z.View.VoidPositionLast[A](this)
  override              def reverse                        : ORD[A]      = z.View.Reversed[A](this)
  override              def on[U](f: U => A)               : ORD[U]      = z.View.Fun[A,U](this,f)


object Ordering:
  inline def apply[A](using inline o: ORD[A]): ORD[A] = o
  /**/   def anyAsString                     : ORD[Any]     = Z.AnyAsString
  /**/   def number                          : ORD[Number]  = Z.Number

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Ordering -> ### General Ordering

  Note. Scalqa classes do not use this trait directly, but rather its parent scala.math.Ordering

  All methods defined here are also available on scala.math.Ordering as extensions.

  This trait is usefull for creating new orderings.

@def join -> Join

    Creates a new Ordering, which will order elements based on this Ordering, and if they appear equal, on joined Ordering

@def + -> Alias for [[join]]

    Creates a new Ordering, which will order elements based on this Ordering, and if they appear equal, on joined Ordering

@def compare -> Compare elements

    This is the only abstract method to be implemented.

    Returns Int value < 0 (usually -1), if first element is less than second.

    Returns Int value > 0 (usually 1),  if first element is greater than second.

    Returns Int value of 0, if two elements are equal.

@def opt_^ -> Opt view

    Creates an ordering to sort Opt values of current type.

@def voidFirst_^ -> Void first view

    Creates an ordering, where all void elements will come first.

@def voidLast_^ -> Void last view

    Creates an ordering, where all void elements will come last.

@def rank_^ -> Ranked view

    Creates an ordering, where all elements are first ordered on rank (defined with given function) and than on merit.

@def on -> On type

    Creates an ordering on specified type. The mapping function from specified type to current type must be provided.

    ```
      val stringOrdering = Ordering[String]

      val intOrdering = stringOrdering.on[Int](i => i.toString)
    ```
@def reverse -> Reversed ordering

    Returns ordering with reversed order

*/

