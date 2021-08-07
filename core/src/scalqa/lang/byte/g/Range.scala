package scalqa; package lang; package byte; package g; import language.implicitConversions

class Range[A<:Raw](_start: A, _size: Int) extends Val.<>[A] with Able.Size with Able.~[A] with Raw.Specialized:
  def this(start:A, end:A, endIn: Boolean) = this(start, end.cast[Int] - start.cast[Int] - endIn.toInt)
  type THIS_TYPE = Range[A]
  /**/              def start                  : A               = _start
  /**/              def end                    : A               = (endX - (_size > 0).toInt).cast[A]
  /**/              def endX                   : A               = (_start + _size).cast[A]
  /**/              def endIsIn                : Boolean         = _size > 0
  /**/              def size                   : Int             = _size
  override          def isEmpty                : Boolean         = _size < 1
  /**/              def ordering               : G.Ordering[A]   = Byte.ordering.cast[G.Ordering[A]]
  @tn("stream")     def ~                      : Stream[A]       = Z.Stream_fromRange(_start.cast[Int],endX.cast[Int],1)
  @tn("step_Stream")def step_~(step: Int)      : Stream[A]       = Z.Stream_fromRange(_start.cast[Int],endX.cast[Int],step)
  override          def contains(v: A)         : Boolean         = _start <= v && v < endX
  /**/              def contains(r: Range[A])  : Boolean         = _contains(r.start,r.endX)
  override          def contains(r: Val.<>[A]) : Boolean         = _contains(r.start,(r.end + r.endIsIn.toInt).cast[A])
  /**/              def join(v: A)             : Range[A]        = if(v<_start) _mk(v,endX) else if(v>=endX) Range(_start,v-_start+1) else this
  /**/              def join(r: Range[A])      : Range[A]        = _join      (r.start, r.endX)
  /**/              def join(r: Val.<>[A])     : Range[A]        = _join      (r.start,(r.end + r.endIsIn.toInt).cast[A])
  /**/              def overlaps(r: Range[A])  : Boolean         = _overlaps  (r.start ,r.endX)
  /**/              def overlaps(r: Val.<>[A]) : Boolean         = _overlaps  (r.start,(r.end + r.endIsIn.toInt).cast[A])
  @tn("overlap_Opt")def overlap_?(r: Range[A]) : Opt[Range[A]]   = _overlapOpt(r.start, r.endX)
  @tn("overlap_Opt")def overlap_?(r: Val.<>[A]): Opt[Range[A]]   = _overlapOpt(r.start,(r.end + r.endIsIn.toInt).cast[A])
  // -----------------------------------------------------------------------------------------------------------------------------
  private           def _contains  (f:A, to:A) : Boolean         = _start<=f && to<=endX
  private           def _join      (f:A, to:A) : Range[A]        = if(f<=_start){ if(to<endX) _mk(f,endX) else _mk(f,to)} else if(to<=endX) this else _mk(_start,to)
  private           def _overlaps  (f:A, to:A) : Boolean         = if(f<=_start) _start<to else f < endX
  private           def _overlapOpt(f:A, to:A) : Opt[Range[A]]   = if(f<=_start){if(to<=_start) \/ else if(to<=endX) _mk(_start,to) else this} else if(f>=endX) \/ else if(to<=endX) _mk(f,to) else _mk(f,endX)
  private    inline def _mk (f:A, inline to:A) : Range[A]        = Range(f,to-f)

object Range:
  extension[A<:Raw,T,STM<: ~~.AnyType[T]](inline x: Range[A])
    /**/                                  inline def map    [B>:T](inline f:A=> B)   (using inline t: Given.StreamShape[B,STM]): STM       = g.Stream.map[A,T,STM](x.~)[B](f)(using t)
    /**/                                  inline def flatMap[B>:T](inline f:A=> ~[T])(using inline t: Given.StreamShape[B,STM]): STM       = g.Stream.flatMap[A,T,STM](x.~)[B](f)(using t)
  extension[A<:Raw]  (inline x: Range[A]) inline def withFilter(inline f: Fun.Filter[A])                                       : Stream[A] = x.~.take(f)
  extension[A<:Raw,U](inline x: Range[A]) inline def foreach(   inline f: A=>U)                                                : Unit      = for(i <- x.start.real.toInt <>> x.endX.real.toInt) f(i.cast[A])

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
