package scalqa; package lang; package byte; package g; import language.implicitConversions

class Range[A<:RAW](s: A, sz: Int) extends Val.<>[A] with Able.Size with Able.~[A] with any.raw.Specialized.OnByte:
  def this(start:A, end:A, endIn: Boolean) = this(start, end.real - start.real - endIn.Int)
  type THIS_TYPE = Range[A]
  /**/              def start                  : A               = s
  /**/              def end                    : A               = (endX - (sz > 0).Int).cast[A]
  /**/              def endX                   : A               = (s + sz).cast[A]
  /**/              def endIsIn                : Boolean         = sz > 0
  /**/              def size                   : Int             = sz
  override          def isEmpty                : Boolean         = sz < 1
  /**/              def ordering               : G.Ordering[A] = Byte.ordering.cast[G.Ordering[A]]
  @tn("stream")     def ~                      : Stream[A]       = Z.Stream_fromRange(s.cast[Int],endX.real,1)
  @tn("step_Stream")def step_~(step: Int)      : Stream[A]       = Z.Stream_fromRange(s.cast[Int],endX.real,step)
  override          def contains(v: A)         : Boolean         = s <= v && v < endX
  /**/              def contains(r: Range[A])  : Boolean         = _contains(r.start,r.endX)
  override          def contains(r: Val.<>[A]) : Boolean         = _contains(r.start,(r.end + r.endIsIn.Int).cast[A])
  /**/              def join(v: A)             : Range[A]        = if(v<s) _mk(v,endX) else if(v>=endX) Range(s,v-s+1) else this
  /**/              def join(r: Range[A])      : Range[A]        = _join      (r.start, r.endX)
  /**/              def join(r: Val.<>[A])     : Range[A]        = _join      (r.start,(r.end + r.endIsIn.Int).cast[A])
  /**/              def overlaps(r: Range[A])  : Boolean         = _overlaps  (r.start ,r.endX)
  /**/              def overlaps(r: Val.<>[A]) : Boolean         = _overlaps  (r.start,(r.end + r.endIsIn.Int).cast[A])
  @tn("overlap_Opt")def overlap_?(r: Range[A]) : Opt[Range[A]]   = _overlapOpt(r.start, r.endX)
  @tn("overlap_Opt")def overlap_?(r: Val.<>[A]): Opt[Range[A]]   = _overlapOpt(r.start,(r.end + r.endIsIn.Int).cast[A])
  // -----------------------------------------------------------------------------------------------------------------------------
  private           def _contains  (f:A, to:A) : Boolean         = s<=f && to<=endX
  private           def _join      (f:A, to:A) : Range[A]        = if(f<=s){ if(to<endX) _mk(f,endX) else _mk(f,to)} else if(to<=endX) this else _mk(s,to)
  private           def _overlaps  (f:A, to:A) : Boolean         = if(f<=s) s<to else f < endX
  private           def _overlapOpt(f:A, to:A) : Opt[Range[A]]   = if(f<=s){if(to<=s) \/ else if(to<=endX) _mk(s,to) else this} else if(f>=endX) \/ else if(to<=endX) _mk(f,to) else _mk(f,endX)
  private    inline def _mk (f:A, inline to:A) : Range[A]        = Range(f,to-f)

object Range:
  extension[A<:RAW,T,STM<: ~~.AnyType[T]](inline x: Range[A])
    /**/                                  inline def map    [B>:T](inline f:A=> B)   (using inline s: Self.StreamTag[B,STM]): STM       = g.Stream.map[A,T,STM](x.~)[B](f)(using s)
    /**/                                  inline def flatMap[B>:T](inline f:A=> ~[T])(using inline s: Self.StreamTag[B,STM]): STM       = g.Stream.flatMap[A,T,STM](x.~)[B](f)(using s)
  extension[A<:RAW]  (inline x: Range[A]) inline def withFilter(inline f: Fun.Filter[A])                                      : Stream[A] = x.~.take(f)
  extension[A<:RAW,U](inline x: Range[A]) inline def foreach(   inline f: A=>U)                                               : Unit      = for(i <- x.start.real.Int <>> x.endX.real.Int) f(i.cast[A])

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
