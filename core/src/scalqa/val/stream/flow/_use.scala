package scalqa; package `val`; package stream; package flow; import language.implicitConversions

transparent trait _use[A]:
  self: Flow[A] =>

  def findAnyOpt                                    : Opt[A]
  def findOpt( f: A => Boolean)                     : Opt[A]
  def find(   f: A => Boolean)                      : A
  def isEvery(f: A => Boolean)                      : Boolean
  def exists(  f: A => Boolean)                     : Boolean
  def contains[B >: A](value: B)                    : Boolean
  def count                                         : Int
  def countAndTime                                  : (Int, Time.Length)

  def reduce(bf: (A,A) => A)                        : A
  def reduceOpt(bf: (A,A) => A)                     : Opt[A]
  def fold(start: A)(bf: (A,A) => A)                : A
  def foldAs[B](start:B)(bf:(B,A)=>B, cf: (B,B)=>B) : B

  def sum                       (using Math.Sum[A]) : A
  def min                       (using Ordering[A]) : A
  def minBy[B](f: A => B)       (using Ordering[B]) : A
  def max                       (using Ordering[A]) : A
  def maxBy[B](f: A => B)       (using Ordering[B]) : A
  def range                     (using Ordering[A]) : Range[A]
  def minOpt                    (using Ordering[A]) : Opt[A]
  def minByOpt[B](f: A => B)    (using Ordering[B]) : Opt[A]
  def maxOpt                    (using Ordering[A]) : Opt[A]
  def maxByOpt[B](f: A => B)    (using Ordering[B]) : Opt[A]
  def rangeOpt                  (using Ordering[A]) : Opt[Range[A]]

  def foreach[U](f: A => U)                         : Unit
  def drain                                         : Unit

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _use -> ### Consume Interface

@def find -> Find value

    Finds value accepted by given predicate

    Note: If value is not found operation fails, use  [[findOpt]] in most cases

@def findOpt -> Find optional value

    Finds value accepted by given predicate or returns void option if not found

@def findAnyOpt -> Find optional any value

    Finds any value or returns void option if not found

@def exists -> Exists check

    Returns true if there is an elemnet satisfying given predicate

@def isEvery -> Forall check

    Returns true if every single element satisfies the given predicate

@def contains -> Value check

    Returns true if flow contains given value

@def count -> All count

    Counts all flow elements

@def countAndTime -> Count and time

    Returns all elements count and Time.Length it took to pump the flow

    ```
       val (cnt,time) = (1 <> 1000).stream.parallel.peek(_ => J.sleep(1.Millis)).countAndTime

       ("" + cnt + " elements processed in " + time.tag).TP

       // Output
       1000 elements processed in 0.040820901 sec
    ```
    Note. Only massively parallel execution allowed to process the above example in 0.04 seconds

@def reduce -> Reduce

     Folds elements with a binary function

     Note. Threre is no default value, and if flow is empty, operation fails. Use [[reduceOpt]] as a safer option

     @param f binary function to fold elements with

@def reduceOpt -> Optional reduce

     Folds elements with a binary function or returns empty option when stream is empty

     @param f binary function to fold elements with


@def foldAs -> Fold and convert

     Folds and converts elements with a binary function

    @param start seed value to start with
    @param f binary function to fold elements with

@def fold -> Fold

     Folds elements with a binary function

    @param start seed value to start with
    @param f binary function to fold elements with

@def min -> Minimum

     Computes minimum value

     Fails for empty streams

@def minOpt -> Optional minimum

     Computes minimum value or returns void option for empty streams

@def minBy -> Minimum by property

     Computes minimum value based on given function

     Fails for empty streams

@def minByOpt -> Optional minimum by property

     Computes minimum value based on given function or returns void option for empty streams

@def max -> Maximum

     Computes maximum value

     Fails for empty streams

@def maxOpt -> Optional maximum

     Computes maximum value or returns void option for empty streams

@def maxBy -> Maximum by property

     Computes maximum value based on given function

     Fails for empty streams

@def maxByOpt -> Optional maximum by property

     Computes maximum value based on given function or returns void option for empty streams

@def range -> Range

     Computes value range

     Fails for empty streams

@def rangeOpt -> Optional range

     Computes value value or returns void option for empty streams

@def sum -> Sum

    Calculates sum of all values

    For empty stream returns zero

@def drain -> Pump flow out

    Fetches and discards all flow elements

    This operation can be usefull for side effects built into pipeline

@def foreach -> Process flow

    Applies given function to each flow element

*/
