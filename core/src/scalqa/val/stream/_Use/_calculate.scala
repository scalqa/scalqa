package scalqa; package `val`; package stream; package _use; import language.implicitConversions

import Custom.Math.Average

transparent trait _calculate:
  self: _Use =>

  extension[A](inline x: ~[A])
    @tn("min")         inline def min                      (using inline o:Ordering[A]) : A          = x.min_?.get
    @tn("min_Opt")     inline def min_?                    (using inline o:Ordering[A]) : Opt[A]     = z._use.calculate.min_Opt(x,o)
    @tn("max")         inline def max                      (using inline o:Ordering[A]) : A          = x.max_?.get
    @tn("max_Opt")     inline def max_?                    (using inline o:Ordering[A]) : Opt[A]     = z._use.calculate.max_Opt(x,o)
    @tn("range")       inline def range                    (using inline o:Ordering[A]) : Range[A]   = x.range_?.get
    @tn("range_Opt")   inline def range_?                  (using inline o:Ordering[A]) : Opt[<>[A]] = z._use.calculate.range_Opt(x,o)
    @tn("sum")         inline def sum                          (using inline n:Math[A]) : A          = x.sum_? or n.zero
    @tn("sum_Opt")     inline def sum_?                        (using inline n:Math[A]) : Opt[A]     = z._use._calculate.sum.opt(x,n)
    @tn("average")     inline def average                   (using inline v:Average[A]) : A          = v.average(x)
    @tn("average_Opt") inline def average_?                 (using inline v:Average[A]) : Opt[A]     = v.averageOpt(x)
    @tn("minBy")       inline def minBy  [B](inline f: A=>B)(using inline o:Ordering[B]): A          = x.minBy_?(f).get
    @tn("maxBy")       inline def maxBy  [B](inline f: A=>B)(using inline o:Ordering[B]): A          = x.maxBy_?(f).get
    @tn("minBy_Opt")   inline def minBy_?[B](inline f: A=>B)(using inline o:Ordering[B]): Opt[A]     = z._use.calculate.minBy_Opt(x,f,o)
    @tn("maxBy_Opt")   inline def maxBy_?[B](inline f: A=>B)(using inline o:Ordering[B]): Opt[A]     = z._use.calculate.maxBy_Opt(x,f,o)

    inline def averageFew[B,C,D,E,F](inline fb:A=>Opt[B], inline fc:A=>Opt[C], inline fd:A=>Opt[D]= \/, inline fe:A=>Opt[E]= \/, inline ff:A=>Opt[F]= \/)
                                  (using inline nb:Average[B], inline nc:Average[C], inline nd:Average[D], inline ne:Average[E], inline nf:Average[F])
                                                         : (B,C) | (B,C,D) | (B,C,D,E) | (B,C,D,E,F) = z._use._calculate.average.few(x,fb,fc,fd,fe,ff)

    inline def sumFew  [B,C,D,E,F](inline fb:A=>Opt[B], inline fc:A=>Opt[C], inline fd:A=>Opt[D]= \/, inline fe:A=>Opt[E]= \/, inline ff:A=>Opt[F]= \/)
                                                 (using inline nb:Math[B], inline nc:Math[C], inline nd:Math[D], inline ne:Math[E], inline nf:Math[F])
                                                         : (B,C) | (B,C,D) | (B,C,D,E) | (B,C,D,E,F) = z._use._calculate.sum.few(x,fb,fc,fd,fe,ff)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _calculate -> ### Stream Calculation Interface


@def min -> Minimum

     Computes minimum value

     Fails for empty streams

@def min_? -> Optional minimum

     Computes minimum value or returns void option for empty streams

@def minBy -> Minimum by property

     Computes minimum value based on given function

     Fails for empty streams

@def minBy_? -> Optional minimum by property

     Computes minimum value based on given function or returns void option for empty streams

@def max -> Maximum

     Computes maximum value

     Fails for empty streams

@def max_? -> Optional maximum

     Computes maximum value or returns void option for empty streams

@def maxBy -> Maximum by property

     Computes maximum value based on given function

     Fails for empty streams

@def maxBy_? -> Optional maximum by property

     Computes maximum value based on given function or returns void option for empty streams

@def range -> Range

     Computes value range

     Fails for empty streams

@def range_? -> Optional range

     Computes value value or returns void option for empty streams


@def average ->  Average

     Computes average

     For empty Stream returns zero value

     ```
         (10 <> 15).~.map(_.toFloat).average  // Returns 12.5
     ```

     Note: [[average]] is available for types providing given [[scalqa.val.stream.custom.Math.Average ~~.Custom.Math.Average]] implementations,
     which are by default Double, Float and opaque numerics based on Double and Float

@def average_? ->  Average option

     Computes average or returns void option for empty stream

     ```
         (10 <> 15).~.map(_.toFloat).average_?  // Returns Opt(12.5)
     ```

     Note: [[average_?]] is available for types providing given [[scalqa.val.stream.custom.Math.Average ~~.Custom.Math.Average]] implementations,
     which are by default Double, Float and opaque numerics based on Double and Float

@def averageFew -> Multi average

     Simultaneously computes up to 5 average values for properties specified by functions

     Returns tuple of appropriate size with values corresponding to the given mappings

     For empty Stream returned tuple will hold zeros

     ```
         (1 <> 1000).~.averageFew(_ * 10F, _ * 100F).TP  // Prints (5005, 50050)

          val (first, second, third) = (1 <> 1000).~.averageFew(v => v.toDouble, _ * 10.0, _ * 100.0)

          first.TP     // Prints 5005
          second.TP    // Prints 5005
          third.TP     // Prints 5005
     ```
     Note: Averages areavailable for types providing given [[scalqa.val.stream.custom.Average ~~.Custom.Average]] implementations,
     which are by default Double, Float and opaque numerics based on Double and Float

@def sum -> Sum

    Calculates sum of all values

    For empty stream returns zero

     ```
         (1 <> 1000).~.sum.TP // Prints 500500
     ```

@def sum_? -> Optional sum

    Calculates sum of all values or returns void option for empty streams

     ```
         (1 <> 1000).~.sum_?.TP // Prints Opt(500500)
     ```

@def sumFew -> Multi sum

     Simultaneously computes up to 5 sum values for properties specified by given functions

     Returns tuple of appropriate size with values corresponding to the given mappings

     For empty Stream returned tuple will hold zeros

     ```
       (1 <> 1000).~.sumFew(_ * 10, _ * 100).TP  // Prints (5005000, 50050000)

       val (first, second, third) = (1 <> 1000).~.sumFew(v => v, _ * 10, _ * 100)

       first.TP     // Prints 500500
       second.TP    // Prints 5005000
       third.TP     // Prints 50050000
     ```
*/
