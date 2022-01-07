package scalqa; package `val`; import range.*; import language.implicitConversions

abstract class Range[A] extends gen.able.Contain[A] with gen.able.Empty:
  type THIS_TYPE <: Range[A]
  /**/     def start                                        : A
  /**/     def end                                          : A
  /**/     def endIsIn                                      : Boolean
  /**/     def ordering                                     : Ordering[A]
  /**/     def join(v: A)                                   : THIS_TYPE
  /**/     def join(v: Range[A])                            : THIS_TYPE
  /**/     def overlaps( r: Range[A])                       : Boolean
  /**/     def overlapOpt(r: Range[A])                      : Opt[THIS_TYPE]
  /**/     def stepStream(f: A => A)                        : Stream[A]     = z.StepStream(this, f)
  /**/     def contains(v: Range[A])                        : Boolean       = z.ops.contains(this,v)
  /**/     def contains(v: A)                               : Boolean       = z.ops.contains(this,v)
  /**/     def isEmpty                                      : Boolean       = z.ops.isEmpty(this)
  override def equals(v: Any)                               : Boolean       = v.isInstanceOf[Range[_]] && {val r=v.cast[Range[A]]; this.contains(r) && r.contains(this)}
  inline   def raw(using inline sp:Specialized.Primitive[A]): sp.Range      = z.raw(this)

object Range:
  def apply[A](start:A,end:A, endIn:Boolean=true)(using Ordering[A]): Range[A] = if(endIn) Z.EndInclsive(start,end)  else Z.EndExclusive(start,end)
  def singleValue[A](v:A,  endIn: Boolean = true)(using Ordering[A]): Range[A] = if(endIn) Z.SingleValueInclusive(v) else Z.SingleValueExclusive(v)

  extension[A](x: Range[A])
    inline def ~~     (using inline s:Able.Sequence[A]): Stream[A] = x.stream
    /**/   def stream (using        s:Able.Sequence[A]): Stream[A] = x match{ case v:Able.Stream[_] => v.cast[Able.Stream[A]].stream; case _ => x.stepStream(v => s.step(v,1)) }
    /**/   def convert[B](f:A=>B)(using o:Ordering[B]) : Range[B]  = Range(f(x.start),f(x.end),x.endIsIn)

  extension[A](inline x: Range[A])
    inline def withFilter(inline f: A => Boolean)(using inline s:Able.Sequence[A]): Stream[A] = x.stream.take(f)
    inline def map[B](    inline f: A => B)      (using inline s:Able.Sequence[A]): Stream[B] = x.stream.map(f)
    inline def flatMap[B](inline f: A=>Stream[B])(using inline s:Able.Sequence[A]): Stream[B] = x.stream.flatMap(f)
    inline def foreach[U](inline f: A => U)      (using inline s:Able.Sequence[A]): Unit      = x.stream.foreach(f)

  given z_CanEqualRange[A,B](using CanEqual[A,B]): CanEqual[Range[A],Range[B]] = CanEqual.derived
  given z_Doc[A]           (using Any.Def.Tag[A]): Any.Def.Doc[Range[A]]       = new range.Z.DocDef[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Range -> ### Value Range

      Range is logically defined with the following defs:

          - `start`
          - `end`,
          - and `ordering`, which makes the above meaningful

      Range has a notion that an element can be within the range, i.e. between start and end, or outside

      Note. Scala provided range structures (scala.collection.immutable.Range and scala.collection.immutable.NumericRange)
            are implemented more as collections and this class is designed to close this void focusing on basic range features.

@def ~~ -> Alias to "stream"

@def raw -> Primitive range

     Returns primitive specialized range implementation.

     The method will not compile for reference types.

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

@def overlapOpt -> Optional intersection

    Optionally returns common intersection of `this` and `that`
    ```
      1 <> 6 overlapOpt 3 <> 9  // Returns: Opt(3 <> 6)

      1 <> 3 overlapOpt 6 <> 9  // Returns: Opt(VOID)
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

@def stepStream -> Stream of calculated values

    Returns a stream starting with the first range value.
    Every next value is calculated by applying the given function to the prior value.
    The stream ends when the function result is no longer within range.

    ```
      (1 <> 10).stepStream( _ + 3).TP  // Prints: Stream(1, 4, 7, 10)
    ```

@def isEmpty -> Empty check

    Checks if the range is able contain anything.

    For empty range the start and end values are the same and the end value is not inclusive


*/
