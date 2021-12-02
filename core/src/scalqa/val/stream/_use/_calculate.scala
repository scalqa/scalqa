package scalqa; package `val`; package stream; package _use; import language.implicitConversions

import z._use.{ calculate as Z }
import Gen.Math.{ Average, Sum }

transparent trait _calculate:
  self: _Use =>

  extension[A](inline x: Stream[A])
    inline def min                       (using inline o:Ordering[A]) : A             = x.minOpt.get
    inline def minOpt                    (using inline o:Ordering[A]) : Opt[A]        = Z.minOpt(x,o)
    inline def max                       (using inline o:Ordering[A]) : A             = x.maxOpt.get
    inline def maxOpt                    (using inline o:Ordering[A]) : Opt[A]        = Z.maxOpt(x,o)
    inline def range                     (using inline o:Ordering[A]) : Range[A]      = x.rangeOpt.get
    inline def rangeOpt                  (using inline o:Ordering[A]) : Opt[Range[A]] = Z.rangeOpt(x,o)
    inline def sum                            (using inline v:Sum[A]) : A             = v.sumOpt(x) or v.zero
    inline def sumOpt                         (using inline v:Sum[A]) : Opt[A]        = v.sumOpt(x)
    inline def average                    (using inline v:Average[A]) : A             = v.average(x)
    inline def averageOpt                 (using inline v:Average[A]) : Opt[A]        = v.averageOpt(x)
    inline def minBy   [B](inline f: A=>B)(using inline o:Ordering[B]): A             = x.minByOpt(f).get
    inline def maxBy   [B](inline f: A=>B)(using inline o:Ordering[B]): A             = x.maxByOpt(f).get
    inline def minByOpt[B](inline f: A=>B)(using inline o:Ordering[B]): Opt[A]        = Z.minByOpt(x,f,o)
    inline def maxByOpt[B](inline f: A=>B)(using inline o:Ordering[B]): Opt[A]        = Z.maxByOpt(x,f,o)

    inline def averageFew[B,C,D,E,F](inline fb:A=>Opt[B], inline fc:A=>Opt[C], inline fd:A=>Opt[D]=VOID,inline fe:A=>Opt[E]=VOID,inline ff:A=>Opt[F]=VOID)
                                  (using inline nb:Average[B], inline nc:Average[C], inline nd:Average[D], inline ne:Average[E], inline nf:Average[F])
                                                         : (B,C) | (B,C,D) | (B,C,D,E) | (B,C,D,E,F) = z._use._calculate.average.few(x,fb,fc,fd,fe,ff)

    inline def sumFew  [B,C,D,E,F](inline fb:A=>Opt[B], inline fc:A=>Opt[C], inline fd:A=>Opt[D]=VOID,inline fe:A=>Opt[E]=VOID,inline ff:A=>Opt[F]=VOID)
                                                 (using inline nb:Sum[B], inline nc:Sum[C], inline nd:Sum[D], inline ne:Sum[E], inline nf:Sum[F])
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


@def average ->  Average

     Computes average

     For empty Stream returns zero value

     ```
         (10 <> 15).stream.map(_.toFloat).average  // Returns 12.5
     ```

     Note: [[average]] is available for types providing given [[scalqa.gen.math.Average Math.Average]] implementations,
     which are by default Double, Float and opaque numerals based on Double and Float

@def averageOpt ->  Average option

     Computes average or returns void option for empty stream

     ```
         (10 <> 15).stream.map(_.toFloat).averageOpt  // Returns Opt(12.5)
     ```

     Note: [[averageOpt]] is available for types providing given [[scalqa.gen.math.Average Math.Average]] implementations,
     which are by default Double, Float and opaque numerals based on Double and Float

@def averageFew -> Multi average

     Simultaneously computes up to 5 average values for properties specified by functions

     Returns tuple of appropriate size with values corresponding to the given mappings

     For empty Stream returned tuple will hold zeros

     ```
         (1 <> 1000).stream.averageFew(_ * 10F, _ * 100F).TP  // Prints (5005, 50050)

          val (first, second, third) = (1 <> 1000).stream.averageFew(v => v.toDouble, _ * 10.0, _ * 100.0)

          first.TP     // Prints 5005
          second.TP    // Prints 5005
          third.TP     // Prints 5005
     ```
     Note: Averages areavailable for types providing given [[scalqa.val.stream.custom.Average Stream.Custom.Average]] implementations,
     which are by default Double, Float and opaque numerals based on Double and Float

@def sum -> Sum

    Calculates sum of all values

    For empty stream returns zero

     ```
         (1 <> 1000).stream.sum.TP // Prints 500500
     ```

@def sumOpt -> Optional sum

    Calculates sum of all values or returns void option for empty streams

     ```
         (1 <> 1000).stream.sumOpt.TP // Prints Opt(500500)
     ```

@def sumFew -> Multi sum

     Simultaneously computes up to 5 sum values for properties specified by given functions

     Returns tuple of appropriate size with values corresponding to the given mappings

     For empty Stream returned tuple will hold zeros

     ```
       (1 <> 1000).stream.sumFew(_ * 10, _ * 100).TP  // Prints (5005000, 50050000)

       val (first, second, third) = (1 <> 1000).stream.sumFew(v => v, _ * 10, _ * 100)

       first.TP     // Prints 500500
       second.TP    // Prints 5005000
       third.TP     // Prints 50050000
     ```
*/
