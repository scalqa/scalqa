package scalqa; package `val`; package stream; package _Use; import language.implicitConversions

import Custom.{ Math as CM }
import CM.Average

transparent trait _calculate:
  self: _use =>

  extension[A](x: ~[A])
    @tn("min")         def min                    (using Ordering[A]) : A             = x.min_?.get
    @tn("max")         def max                    (using Ordering[A]) : A             = x.max_?.get
    @tn("range")       def range                  (using Ordering[A]) : Range[A]      = x.range_?.get
    @tn("sum")         def sum                      (using n:Math[A]) : A             = x.sum_? or n.zero
    @tn("average")     def average               (using v:Average[A]) : A             = v.average(x)
    // ------------------------------------------------------------
    @tn("min_Opt")     def min_?                (using c:Ordering[A]) : Opt[A]        = if(c.isInstanceOf[CM[_]]) c.cast[CM[A]].min_?(x)          else x.read_?.map(u=>{var v=u;   x.FOREACH(w => if(c.compare(v,w)>0) v=w); v})
    @tn("max_Opt")     def max_?                (using c:Ordering[A]) : Opt[A]        = if(c.isInstanceOf[CM[_]]) c.cast[CM[A]].max_?(x)          else x.read_?.map(u=>{var v=u;   x.FOREACH(w => if(c.compare(v,w)<0) v=w); v})
    @tn("range_Opt")   def range_?              (using c:Ordering[A]) : Opt[<>[A]]    = if(c.isInstanceOf[CM[_]]) c.cast[CM[A]].range_?(x)        else x.read_?.map(u=>{var f,l=u; x.FOREACH(v => {if(c.compare(v,f)<0) f=v; if(c.compare(v,l)>0) l=v}); Val.<>(f,l,true)(using c)})
    @tn("sum_Opt")     def sum_?                    (using n:Math[A]) : Opt[A]        = if(n.isInstanceOf[CM[_]]) n.cast[CM[A]].calculateSum_?(x) else x.read_?.map(v=>{var r=v;   x.FOREACH(v => r=n.plus(r,v)); r})
    @tn("average_Opt") def average_?             (using v:Average[A]) : Opt[A]        = v.averageOpt(x)
    @tn("minBy")       def minBy  [B](f: A=>B)  (using   Ordering[B]) : A             = x.minBy_?(f).get
    @tn("maxBy")       def maxBy  [B](f: A=>B)  (using   Ordering[B]) : A             = x.maxBy_?(f).get
    @tn("minBy_Opt")   def minBy_?[B](f: A=>B)  (using c:Ordering[B]) : Opt[A]        = x.read_?.map(u=>{var v,w=u; var vf=f(u); var wf=vf; x.FOREACH(w=>{ wf=f(w); if(c.compare(vf,wf)>0){v=w;vf=wf}});v})
    @tn("maxBy_Opt")   def maxBy_?[B](f: A=>B)  (using c:Ordering[B]) : Opt[A]        = x.read_?.map(u=>{var v,w=u; var vf=f(u); var wf=vf; x.FOREACH(w=>{ wf=f(w); if(c.compare(vf,wf)<0){v=w;vf=wf}});v})


    def averageFew[B,C,D,E,F](fb:A=>Opt[B], fc:A=>Opt[C], fd:A=>Opt[D]= \/, fe:A=>Opt[E]= \/, ff:A=>Opt[F]= \/)
                                  (using nb:Average[B],nc:Average[C],nd:Average[D],ne:Average[E],nf:Average[F]) : (B,C)|(B,C,D)|(B,C,D,E)|(B,C,D,E,F) = z.use.calculate.averageFew(x,fb,fc,fd,fe,ff)

    def sumFew  [B,C,D,E,F](fb:A=>Opt[B], fc:A=>Opt[C], fd:A=>Opt[D]= \/, fe:A=>Opt[E]= \/, ff:A=>Opt[F]= \/)
                                                 (using nb:Math[B],nc:Math[C],nd:Math[D],ne:Math[E],nf:Math[F]) : (B,C)|(B,C,D)|(B,C,D,E)|(B,C,D,E,F) = z.use.calculate.sumFew(x,fb,fc,fd,fe,ff)

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
         (10 <> 15).~.map(_.Float).average  // Returns 12.5
     ```

     Note: [[average]] is available for types providing given [[scalqa.val.stream.custom.Math.Average ~~.Custom.Math.Average]] implementations,
     which are by default Double, Float and opaque numerics based on Double and Float

@def average_? ->  Average option

     Computes average or returns void option for empty stream

     ```
         (10 <> 15).~.map(_.Float).average_?  // Returns Opt(12.5)
     ```

     Note: [[average_?]] is available for types providing given [[scalqa.val.stream.custom.Math.Average ~~.Custom.Math.Average]] implementations,
     which are by default Double, Float and opaque numerics based on Double and Float

@def averageFew -> Multi average

     Simultaneously computes up to 5 average values for properties specified by functions

     Returns tuple of appropriate size with values corresponding to the given mappings

     For empty Stream returned tuple will hold zeros

     ```
         (1 <> 1000).~.averageFew(_ * 10F, _ * 100F).TP  // Prints (5005, 50050)

          val (first, second, third) = (1 <> 1000).~.averageFew(v => v.Double, _ * 10.0, _ * 100.0)

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
