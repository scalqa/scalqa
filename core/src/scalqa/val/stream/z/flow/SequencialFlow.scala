package scalqa; package `val`; package stream; package z; package flow; import language.implicitConversions

class SequencialFlow[A](s: Stream[A]) extends Flow[A] with Custom.Pipeline:
  private var x: Stream[A] = s
  protected override def base                      : Stream[A]         = x
  def isParallel                                   : Boolean           = false
  def stream                                       : Stream[A]         = x
  def sizeLongOpt                                  : Long.Opt          = s.sizeLongOpt
  def takeType[B](using t: ClassTag[B])            : Flow[B]           = this.cast[SequencialFlow[B]].self(_.x = x.takeType[B])
  def collect[B](f: PartialFunction[A,B])          : Flow[B]           = this.cast[SequencialFlow[B]].self(_.x = x.collect(f))
  def take(f: A => Boolean)                        : Flow[A]           = this.self(_.x = x.take(f))
  def drop(f: A => Boolean)                        : Flow[A]           = this.self(_.x = x.drop(f))
  def map[B](f: A => B)                            : Flow[B]           = this.cast[SequencialFlow[B]].self(_.x = x.map(f))
  def mapOpt[B](f: A => Opt[B])                    : Flow[B]           = this.cast[SequencialFlow[B]].self(_.x = x.mapOpt(f))
  def flatMap[B](f: A => Stream[B])                : Flow[B]           = this.cast[SequencialFlow[B]].self(_.x = x.flatMap(f))
  def peek(f: A => Unit)                           : Flow[A]           = this.self(_.x = x.peek(f))
  def peekIndexed[U](f: (Int,A)=>U, start:Int=0)   : Flow[A]           = this.self(_.x = x.peekIndexed(f,start))
  def contains[B >: A](value: B)                   : Boolean           = x.contains(value)
  def exists(f: A => Boolean)                      : Boolean           = x.exists(f)
  def isEvery(f: A => Boolean)                     : Boolean           = x.isEvery(f)
  def find(f: A => Boolean)                        : A                 = x.find(f)
  def findOpt(f: A => Boolean)                     : Opt[A]            = x.findOpt(f)
  def findAnyOpt                                   : Opt[A]            = x.readOpt
  def reduce(f: (A,A) => A)                        : A                 = x.reduce(f)
  def reduceOpt(f: (A,A) => A)                     : Opt[A]            = x.reduceOpt(f)
  def fold(start: A)(f:(A,A)=>A)                   : A                 = x.fold(start)(f)
  def foldAs[B](s:B)(f:(B,A)=>B, v:(B,B)=>B)       : B                 = x.foldAs(s)(f)
  def sum                    (using v:Math.Sum[A]) : A                 = x.sum
  def range                    (using Ordering[A]) : Range[A]          = x.range
  def min                      (using Ordering[A]) : A                 = x.min
  def max                      (using Ordering[A]) : A                 = x.max
  def minBy[B](f: A => B)      (using Ordering[B]) : A                 = x.minBy(f)
  def maxBy[B](f: A => B)      (using Ordering[B]) : A                 = x.maxBy(f)
  def minOpt                   (using Ordering[A]) : Opt[A]            = x.minOpt
  def minByOpt[B](f: A => B)   (using Ordering[B]) : Opt[A]            = x.minByOpt(f)
  def maxOpt                   (using Ordering[A]) : Opt[A]            = x.maxOpt
  def maxByOpt[B](f: A => B)   (using Ordering[B]) : Opt[A]            = x.maxByOpt(f)
  def rangeOpt                 (using Ordering[A]) : Opt[Range[A]]     = x.rangeOpt
  def foreach[U](c: A => U)                        : Unit              = x.foreach(c)
  def process[U,W](f: A => U, fornil: => W)        : Unit              = x.process(f,fornil)
  def drain                                        : Unit              = x.drain
  def count                                        : Int               = x.count
  def countAndTime                                 : (Int,Time.Length) = x.countAndTime

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (f) 2020, Scalqa.org Inc
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
