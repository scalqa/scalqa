package scalqa; package lang; package char; package g; import language.implicitConversions

import z.{ range as OPS }

class Range[A<:Raw](_start: A, _size: Int) extends Val.<>[A] with Able.Size with Able.~[A] with any.z.PrimitiveTag.Char:
  def this(start:A, end:A, endIn: Boolean) = this(start, end.cast[Int] - start.cast[Int] + endIn.toInt)
  type THIS_TYPE = Range[A]
  /**/              def start                  : A               = _start
  /**/              def end                    : A               = (endX - (_size > 0).toInt).cast[A]
  /**/              def endX                   : A               = (_start + _size).cast[A]
  /**/              def endIsIn                : Boolean         = _size > 0
  /**/              def size                   : Int             = _size
  override          def isEmpty                : Boolean         = _size < 1
  /**/              def ordering               : Ordering[A]     = Primitive.ordering.cast[Ordering[A]]
  override          def contains(v: A)         : Boolean         = _start <= v && v < endX
  /**/              def contains(r: Range[A])  : Boolean         = _start <= r.start && r.endX <= endX
  override          def contains(r: Val.<>[A]) : Boolean         = OPS.ref(r, _start <= _ && _ <=  endX)
  /**/              def join(v: A)             : THIS_TYPE       = OPS.join(this,_start,endX,v)
  /**/              def join(r: Range[A])      : THIS_TYPE       = OPS.join(this,_start,endX,r.start,r.endX)
  /**/              def join(r: Val.<>[A])     : THIS_TYPE       = OPS.ref(r,OPS.join(this,_start,endX,_,_))
  /**/              def overlaps(r: Range[A])  : Boolean         = OPS.overlaps(_start,endX,r.start,r.endX)
  /**/              def overlaps(r: Val.<>[A]) : Boolean         = OPS.ref(r,OPS.overlaps(_start,endX,_,_))
  @tn("overlap_Opt")def overlap_?(r: Range[A]) : Opt[THIS_TYPE]  = OPS.overlap_Opt(this,_start,endX,r.start,r.endX)
  @tn("overlap_Opt")def overlap_?(r: Val.<>[A]): Opt[THIS_TYPE]  = OPS.ref(r,OPS.overlap_Opt(this,_start,endX,_,_))
  // -----------------------------------------------------------------------------------------------------------------------------
  @tn("stream")     def ~                      : Stream[A]       = Z.Stream_fromRange(_start.cast[Int],endX.cast[Int],1)
  @tn("step_Stream")def step_~(step: Int)      : Stream[A]       = Z.Stream_fromRange(_start.cast[Int],endX.cast[Int],step)

object Range:
  extension[A<:Raw](inline x: Range[A])
    inline def map    [B](inline f: A=>B)   (using inline B:Specialized[B]): B.~    = x.~.map(f)
    inline def flatMap[B](inline f:A=> ~[B])(using inline B:Specialized[B]): B.~    = x.~.flatMap(f)
    inline def withFilter(inline f: Fun.Filter[A])                         : G.~[A] = x.~.take(f)
    inline def foreach[U](inline f: A=>U)                                  : Unit   = for(i <- x.start.real.toInt <>> x.endX.real.toInt) f(i.cast[A])

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Range -> ### Char Specialized Generic Range

  To be used with Char based opaque values.

*/