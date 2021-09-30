package scalqa; package `val`; package stream; package z; package flow; import language.implicitConversions

class SequencialFlow[A](s: ~[A]) extends Flow[A] with Custom.Pipeline:
  private var x: ~[A] = s
  /**/        inline def isParallel                                   : Boolean           = false
  @tn("stream")      def ~                                            : ~[A]              = x
  @tn("sizeLong_Opt")def sizeLong_?                                   : Long.Opt          = s.sizeLong_?
  protected override def base                                         : ~[A]              = x
  /**/               def takeType[B](using t: ClassTag[B])            : Flow[B]           = this.cast[SequencialFlow[B]].^(_.x = x.takeType[B])
  /**/               def collect[B](f: PartialFunction[A,B])          : Flow[B]           = this.cast[SequencialFlow[B]].^(_.x = x.collect(f))
  /**/               def take(f: A => Boolean)                        : Flow[A]           = this.^(_.x = x.take(f))
  /**/               def drop(f: A => Boolean)                        : Flow[A]           = this.^(_.x = x.drop(f))
  /**/               def map[B](f: A => B)                            : Flow[B]           = this.cast[SequencialFlow[B]].^(_.x = x.map(f))
  @tn("map_Opt")     def map_?[B](f: A => Opt[B])                     : Flow[B]           = this.cast[SequencialFlow[B]].^(_.x = x.map_?(f))
  /**/               def flatMap[B](f: A => ~[B])                     : Flow[B]           = this.cast[SequencialFlow[B]].^(_.x = x.flatMap(f))
  /**/               def peek(f: A => Unit)                           : Flow[A]           = this.^(_.x = x.peek(f))
  /**/               def peekIndexed[U](f: (Int,A)=>U, start:Int=0)   : Flow[A]           = this.^(_.x = x.peekIndexed(f,start))
  /**/               def contains[B >: A](value: B)                   : Boolean           = x.contains(value)
  /**/               def exists(f: A => Boolean)                      : Boolean           = x.exists(f)
  /**/               def isEvery(f: A => Boolean)                     : Boolean           = x.isEvery(f)
  /**/               def find(f: A => Boolean)                        : A                 = x.find(f)
  @tn("find_Opt")    def find_?(f: A => Boolean)                      : Opt[A]            = x.find_?(f)
  @tn("findAny_Opt") def findAny_?                                    : Opt[A]            = x.read_?
  /**/               def reduce(f: (A,A) => A)                        : A                 = x.reduce(f)
  @tn("reduce_Opt")  def reduce_?(f: (A,A) => A)                      : Opt[A]            = x.reduce_?(f)
  /**/               def fold(start: A)(f:(A,A)=>A)                   : A                 = x.fold(start)(f)
  /**/               def foldAs[B](s:B)(f:(B,A)=>B, v:(B,B)=>B)       : B                 = x.foldAs(s)(f)
  /**/               def sum                    (using v:Math.Sum[A]) : A                 = x.sum
  /**/               def range                    (using Ordering[A]) : Range[A]          = x.range
  /**/               def min                      (using Ordering[A]) : A                 = x.min
  /**/               def max                      (using Ordering[A]) : A                 = x.max
  /**/               def minBy[B](f: A => B)      (using Ordering[B]) : A                 = x.minBy(f)
  /**/               def maxBy[B](f: A => B)      (using Ordering[B]) : A                 = x.maxBy(f)
  @tn("min_Opt")     def min_?                    (using Ordering[A]) : Opt[A]            = x.min_?
  @tn("minBy_Opt")   def minBy_?[B](f: A => B)    (using Ordering[B]) : Opt[A]            = x.minBy_?(f)
  @tn("max_Opt")     def max_?                    (using Ordering[A]) : Opt[A]            = x.max_?
  @tn("maxBy_Opt")   def maxBy_?[B](f: A => B)    (using Ordering[B]) : Opt[A]            = x.maxBy_?(f)
  @tn("range_Opt")   def range_?                  (using Ordering[A]) : Opt[Range[A]]     = x.range_?
  /**/               def foreach[U](c: A => U)                        : Unit              = x.foreach(c)
  /**/               def process[U,W](f: A => U, fornil: => W)        : Unit              = x.process(f,fornil)
  /**/               def drain                                        : Unit              = x.drain
  /**/               def count                                        : Int               = x.count
  /**/               def countAndTime                                 : (Int,Time.Length) = x.countAndTime

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (f) 2020, Scalqa.org Inc
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
