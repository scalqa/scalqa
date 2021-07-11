package scalqa; package `val`; import range.*; import language.implicitConversions

import gen.`given`.RangeTag

abstract class Range[A] extends Able.Contain[A]:
  type THIS_TYPE <: Range[A]
  /**/              def start                                            : A
  /**/              def end                                              : A
  /**/              def endIsIn                                          : Boolean
  /**/              def ordering                                         : Ordering[A]
  /**/              def join(v: A)                                       : THIS_TYPE
  /**/              def join(v: Range[A])                                : THIS_TYPE
  /**/              def overlaps( r: Range[A])                           : Boolean
  @tn("overlap_Opt")def overlap_?(r: Range[A])                           : Opt[THIS_TYPE]
  /**/              def step_~(f: A => A)                                : ~[A]                = z.StepStream(this, f)
  /**/              def step_~(step: Int)(using Able.Sequence[A])        : ~[A]                = z.StepStream(this, step)
  /**/              def contains(v: Range[A])                            : Boolean             = z.Ops.contains(this,v)
  /**/              def contains(v: A)                                   : Boolean             = z.Ops.contains(this,v)
  /**/              def isEmpty                                          : Boolean             = z.Ops.isEmpty(this)
  override          def equals(v: Any)                                   : Boolean             = v.isInstanceOf[Range[_]] && {val r=v.cast[Range[A]]; this.contains(r) && r.contains(this)}
  inline            def raw[RAW<:Range.RawType[A]](using inline s:RangeTag.Raw[A,RAW]) : RAW     = z.raw(this,s)

object Range:
  type AnyType[A] = <>[A] | RawType[A]
  type RawType[A] = lang.byte.g.Range[A & Raw.Byte] | lang.char.g.Range[A & Raw.Char] | lang.short.g.Range[A & Raw.Short]
                  | lang.int .g.Range[A & Raw.Int]  | lang.long.g.Range[A & Raw.Long] | lang.float.g.Range[A & Raw.Float] | lang.double.g.Range[A & Raw.Double]

  def apply[A:Ordering  ](start:A,end:A, endIn:Boolean=true): Range[A] = if(endIn) Z.EndInclsive(start,end)  else Z.EndExclusive(start,end)
  def singleValue[A:Ordering  ](v:A,  endIn: Boolean = true): Range[A] = if(endIn) Z.SingleValueInclusive(v) else Z.SingleValueExclusive(v)

  extension[A](x: Range[A])
    @tn("stream")     def ~ (using Able.Sequence[A])             : ~[A]          = x match{ case v:Able.~[_] => v.cast[Able.~[A]].~; case _ => x.step_~(1) }
    /**/              def convert[B](f:A=>B)(using s:Ordering[B]): Range[B]      = Range(f(x.start),f(x.end),x.endIsIn)

  given givenCanEqualRange[A,B](using CanEqual[A,B]): CanEqual[<>[A],<>[B]] = CanEqual.derived
  given givenFor                                    : range.z.For           = new range.z.For{}
  given givenDocTag[A:Given.DocTag]                  : Given.DocTag[Range[A]] = new range.z.DocTag[A]

  // Members ~~~~~~~~~~~~~~~~~~~~~~
  transparent inline def X = range.X

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Range -> ### <> is Value Range

      <> is defined with the following defs:

          - `start`
          - `end`,
          - and `ordering`, which makes the above meaningful

      <> has a notion that an element can be within the range, i.e. between start and end, or outside

      Note. Scala provided range structures (Range and NumericRange) are implemented more as collections and this class is designed to close this void focusing on generic range operations


@def raw -> Raw range

     Returns primitive specialized range implementation.

     The method would not compile for a non specializable range.

@def ordering -> Ordering

      Ordering   defining range

      Ordering   defining type elements comparison


@def start -> From value

      Start value of the range


@def end -> Make value

      End value of the range


@def endIsIn -> Inclusive check

      If true, the `end` value is inclusive
      ```
        (10 <>> 15) contains 15   // Returns: false

        // Exclusive 15 does not contain 15
      ```


@def contains(v: A) -> Check if within

     Returns true if `this` range contains specified value
     ```
       (1 <> 9) contains 3  // Returns: true
     ```


@def contains(v: Range[A]) -> Check if within

     Returns true if `this` range contains specified range
     ```
       (1 <> 9) contains (3 <> 7)  // Returns: true

       (1 <> 5) contains (3 <> 7)  // Returns: false
       ```

@def overlaps -> Overlap check

    Returns true if two ranges overlap

@def overlap_? -> Optional intersection

    Optionally returns common intersection of `this` and `that`
    ```
      1 <> 6 overlap_? 3 <> 9  // Returns: Opt(3 <> 6)

      1 <> 3 overlap_? 6 <> 9  // Returns: Opt(\/)
    ```


@def join(v: Range[A]) -> Union

    Returns range with out-most reaches of `this` and specified
    ```
      'A' <> 'C' join 'X' <> 'Z' // Returns: A <> Z
    ```


@def join(v: A) -> Extend to

    `This` range is extended to contain the specified value
    ```
      'A' <> 'C' extendTo 'G' // Returns: A <> G

      'A' <> 'C' extendTo 'B' // Returns: A <> C
    ```

@def step_~ -> Mapped stream

    Returns a stream containing the first range value and the result of applying given function to this value and the produced results.
    The stream ends when the function result is no longer within range.

    ```
      (1 <> 10).step_~( _ + 3).TP  // Prints: ~(1, 4, 7, 10)
    ```

@def step_~ -> Stepped stream

    For sequential types, the method returns a stream of values with given step.

    ```
      (1 <> 10).step_~(2).TP  // Prints: ~(1, 3, 5, 7, 9)
    ```

@def isEmpty -> Empty check

    Checks if the range is able contain anything.

    For empty range the start and end values are the same and the end value is not inclusive


*/
