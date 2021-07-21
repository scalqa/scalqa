package scalqa; package `val`; package stream; package custom; package pipeline; import language.implicitConversions

abstract class ParallelFlow[A] extends Flow[A] with Pipeline.Tree:
  /**/               def isParallel                                 : Boolean          = true
  @tn("stream")      def ~                                          : ~[A]             = z.a.Stream_fromParallelFlow(this)
  /**/               def name                                       : String
  /**/               def takeType[B](using t: ClassTag[B])          : Flow[B]          = take(v => !t.unapply(v).isEmpty).cast[Flow[B]]
  /**/               def collect[B](f: PartialFunction[A,B])        : Flow[B]          = take(f.isDefinedAt).map(f.apply)
  @tn("map_Opt")     def map_?[B](f: A => Opt[B])                   : Flow[B]          = map(f(_)).drop(_.isEmpty).map(_.get)
  /**/               def peekIndexed[U](f:(Int,A)=>U, start:Int=0)  : Flow[A]          = {var c=J.Concurrent.Counter(start-1); peek(v => f(c.next,v)) }
  /**/               def contains[B >: A](value: B)                 : Boolean          = find_?(value == _).nonEmpty
  /**/               def exists(f: A => Boolean)                    : Boolean          = find_?(f).nonEmpty
  /**/               def isEvery(f: A => Boolean)                   : Boolean          = drop(f).findAny_?.isEmpty
  /**/               def find(f: A => Boolean)                      : A                = find_?(f).get
  @tn("find_Opt")    def find_?(f: A => Boolean)                    : Opt[A]           = take(f).findAny_?
  /**/               def reduce(bf: (A,A) => A)                     : A                = reduce_?(bf).get
  /**/               def fold(start: A)(bf: (A,A) => A)             : A                = foldAs[A](start)(bf, bf)
  /**/               def sum                 (using m: Gen.Math[A]) : A                = foldAs(m.zero)(m.plus,m.plus)
  /**/               def range                (using o:Ordering[A]) : Range[A]         = range_?.get
  /**/               def min                  (using o:Ordering[A]) : A                = min_?.get
  /**/               def max                  (using o:Ordering[A]) : A                = max_?.get
  /**/               def minBy[B](f: A => B)  (using o:Ordering[B]) : A                = minBy_?(f).get
  /**/               def maxBy[B](f: A => B)  (using o:Ordering[B]) : A                = maxBy_?(f).get
  @tn("min_Opt")     def min_?                (using o:Ordering[A]) : Opt[A]           = reduce_?((x, y) => if (o.compare(x, y) <= 0) x else y)
  @tn("minBy_Opt")   def minBy_?[B](f:A=>B)   (using o:Ordering[B]) : Opt[A]           = reduce_?((x, y) => if (o.compare(f(x), f(y)) <= 0) x else y)
  @tn("max_Opt")     def max_?                (using o:Ordering[A]) : Opt[A]           = reduce_?((x, y) => if (o.compare(x, y) >= 0) x else y)
  @tn("maxBy_Opt")   def maxBy_?[B](f:A=>B)   (using o:Ordering[B]) : Opt[A]           = reduce_?((x, y) => if (o.compare(f(x), f(y)) >= 0) x else y)
  @tn("range_Opt")   def range_?              (using o:Ordering[A]) : Opt[Range[A]]    = foldAs[Range[A]](`val`.range.Z.Void[A]())(_ join _, _ join _).^.?
  /**/               def process[U,W](f: A=>U, fornil: => W)        : Unit             = { var b = true; foreach(v => { b = false; f(v)}); if(b) fornil }
  /**/               def drain                                      : Unit             = foreach(_ => ())
  /**/               def countAndTime                               : (Int,Time.Length)= {val v=System.nanoTime; (count, Time.Length.fromNanos(System.nanoTime - v))}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/

/**
@class ParallelFlow -> ###

  This is a base for parallel [[scalqa.stream.Flow Flow]] implementations

  In Scalqa it is allowed to setup custom parallel calculations engine, and this class is reccomended way to start

*/
