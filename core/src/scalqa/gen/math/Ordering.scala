package scalqa; package gen; package math; import language.implicitConversions

object Ordering:
  inline def apply[A](using inline o: Ordering[A]): Ordering[A] = o

  extension[A](inline x: Ordering[A])
    /**/                  inline def compare(v:A, w:A)                      : Int              = J.illegalState()
    @tn("compare_Opt")    inline def compare_?(v:Opt[A], w:Opt[A], none:Int): Int              = z.Ordering.compare_Opt(x,v,w,none)
    /**/                  inline def reverse                                : Ordering[A]      = z.View.ReversedOrdering[A](x)
    /**/                  inline def map[U](f: U => A)                      : Ordering[U]      = z.View.MappedOrdering[A,U](x,f)
    @tn("join")           inline def + (inline c: Ordering[A])              : Ordering[A]      = z.Ordering.join(x,c)
    /**/                  inline def join(inline c: Ordering[A])            : Ordering[A]      = z.Ordering.join(x,c)
    @tn("rank_View")      inline def rank_^(fun: A => Int)                  : Ordering[A]      = z.Ordering.rank_View(x,fun)
    @tn("opt_View")       inline def opt_^(voidPosition: Int)               : Ordering[Opt[A]] = z.Ordering.opt_View(x,voidPosition)
    @tn("voidFirst_View") inline def voidFirst_^    (using Any.Def.Void[A]) : Ordering[A]      = z.Ordering.voidFirst_View(x)
    @tn("voidLast_View")  inline def voidLast_^     (using Any.Def.Void[A]) : Ordering[A]      = z.Ordering.voidLast_View(x)

  object TYPE:
    type DEF[A] = scala.math.Ordering[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@type DEF  ->

  Scalqa Ordering is an alias to scala.Ordering. Both can be used interchangeably.

  Scalqa Ordering has a new set of methods provided as extensions.

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

@def map -> Map to type

    Maps current ordering to specified type.

    Note. Mapping function takes target type value and has to convert it to current type.

    ```
      val stringOrdering = Ordering[String]

      val intOrdering = stringOrdering.map[Int](i => i.toString)
    ```
@def reverse -> Reversed ordering

    Returns ordering with reversed order

*/

