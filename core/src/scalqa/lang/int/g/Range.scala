package scalqa; package lang; package int; package g; import language.implicitConversions

class Range[A<:RAW](_start: A, _size: Int) extends Val.<>[A] with Able.Size with Able.~[A] with any.raw.Specialized.OnInt:
  def this(start:A, end:A, endIn: Boolean) = this(start, end.real - start.real + endIn.Int)
  type THIS_TYPE = Range[A]
  /**/              def start                  : A             = _start
  /**/              def end                    : A             = (endX - (_size > 0).Int).cast[A]
  /**/              def endX                   : A             = (_start + _size).cast[A]
  /**/              def endIsIn                : Boolean       = _size > 0
  /**/              def size                   : Int           = _size
  override          def isEmpty                : Boolean       = _size < 1
  /**/              def ordering               : G.Ordering[A] = Int.ordering.cast[G.Ordering[A]]
  @tn("stream")     def ~                      : Stream[A]     = new z.Range.Stream[A](_start.real.Int,endX.real,1L)
  @tn("step_Stream")def step_~(step: Int)      : Stream[A]     = new z.Range.Stream(_start.real.Int,endX.real,step)
  override          def contains(v: A)         : Boolean       = _start <= v && v < endX
  /**/              def contains(r: Range[A])  : Boolean       = _contains(r.start,r.endX)
  override          def contains(r: Val.<>[A]) : Boolean       = _contains(r.start,(r.end + r.endIsIn.Int).cast[A])
  /**/              def join(v: A)             : Range[A]      = if(v<_start) _mk(v,endX) else if(v>=endX) Range(_start,v-_start+1) else this
  /**/              def join(r: Range[A])      : Range[A]      = _join      (r.start, r.endX)
  /**/              def join(r: Val.<>[A])     : Range[A]      = _join      (r.start,(r.end + r.endIsIn.Int).cast[A])
  /**/              def overlaps(r: Range[A])  : Boolean       = _overlaps  (r.start ,r.endX)
  /**/              def overlaps(r: Val.<>[A]) : Boolean       = _overlaps  (r.start,(r.end + r.endIsIn.Int).cast[A])
  @tn("overlap_Opt")def overlap_?(r: Range[A]) : Opt[Range[A]] = _overlapOpt(r.start, r.endX)
  @tn("overlap_Opt")def overlap_?(r: Val.<>[A]): Opt[Range[A]] = _overlapOpt(r.start,(r.end + r.endIsIn.Int).cast[A])
  @tn("pack")       def ><                     : Pack[A]       = Pack.fromArray(z.Range.mkArray(start,size),size)
  /**/       inline def toBuffer               : Buffer[A]     = new Buffer(toArray.cast[Array[Int]],size)
  /**/       inline def toArray                : Array[A]      = z.Range.mkArray(start,size).cast[Array[A]]
  // -----------------------------------------------------------------------------------------------------------------------------
  private           def _contains  (f:A, to:A) : Boolean       = _start<=f && to<=endX
  private           def _join      (f:A, to:A) : Range[A]      = if(f<=_start){ if(to<endX) _mk(f,endX) else _mk(f,to)} else if(to<=endX) this else _mk(_start,to)
  private           def _overlaps  (f:A, to:A) : Boolean       = if(f<=_start) _start<to else f < endX
  private           def _overlapOpt(f:A, to:A) : Opt[Range[A]] = if(f<=_start){if(to<=_start) \/ else if(to<=endX) _mk(_start,to) else this} else if(f>=endX) \/ else if(to<=endX) _mk(f,to) else _mk(f,endX)
  private    inline def _mk (f:A, inline to:A) : Range[A]      = Range(f,to-f)

object Range:
  extension(x:Range[Int])
    @tn("moveRight")inline def >>(move: Int)    : Range[Int] = Range(x.start+move,x.size)
    @tn("moveLeft") inline def <<(move: Int)    : Range[Int] = Range(x.start-move,x.size)
    @tn("grow")     inline def +(growBy: Int)   : Range[Int] = Range(x.start,x.size + growBy)
    @tn("shrink")   inline def -(shrinkBy: Int) : Range[Int] = Range(x.start,x.size - shrinkBy atLeast 0)
    @tn("checkIn")  inline def checkIn(size:Int): Range[Int] = {if(x.start<0 || x.endX>size) J.illegalArgument(""+x.start+" <>> "+x.endX+" is out of range 0 <>> "+size); x}
    @tn("default")  inline def default(size:Int): Range[Int] = {var v=x; if(v.isInstanceOf[Void]) v = 0 <>> size; v }
  // ------------------------------------------------------------------------------------------------------------------------------------------
  implicit inline def implicitRequest(inline v: \/)   : Range[Int] = z.Range.Void
  extension[A<:RAW,T,STM<: ~~.AnyType[T]](inline x: Range[A])
    /**/                                  inline def map    [B>:T](inline f:A=> B)   (using inline t: Given.StreamTag[B,STM]): STM       = g.Stream.map[A,T,STM](x.~)[B](f)(using t)
    /**/                                  inline def flatMap[B>:T](inline f:A=> ~[T])(using inline t: Given.StreamTag[B,STM]): STM       = g.Stream.flatMap[A,T,STM](x.~)[B](f)(using t)
  extension[A<:RAW]  (inline x: Range[A]) inline def withFilter(inline f: Fun.Filter[A])                                    : Stream[A] = x.~.take(f)
  extension[A<:RAW,U](inline x: Range[A]) inline def foreach(   inline f: A=>U)                                             : Unit      = z.range.Macro.foreach(x,f)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
