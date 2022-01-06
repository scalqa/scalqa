package scalqa; package lang; package int; package g; import language.implicitConversions

import z.{ Range as OPS }

class Range[A<:Raw](_start: A, _size: Int) extends Val.Range[A] with Able.Size with Able.Stream[A] with any.z.PrimitiveTag.Int:
  def this(start:A, end:A, endIn: Boolean) = this(start, end.real - start.real + endIn.toInt)
  type THIS_TYPE = Range[A]
  /**/     def start                     : A               = _start
  /**/     def end                       : A               = (endX - (_size > 0).toInt).cast[A]
  /**/     def endX                      : A               = (_start + _size).cast[A]
  /**/     def endIsIn                   : Boolean         = _size > 0
  /**/     def size                      : Int             = _size
  override def isEmpty                   : Boolean         = _size < 1
  /**/     def ordering                  : Ordering[A]     = Primitive.ordering.cast[Ordering[A]]
  override def contains(v: A)            : Boolean         = _start <= v && v < endX
  /**/     def contains(r: Range[A])     : Boolean         = _start <= r.start && r.endX <= endX
  override def contains(r: Val.Range[A]) : Boolean         = OPS.ref(r, _start <= _ && _ <=  endX)
  /**/     def join(v: A)                : THIS_TYPE       = OPS.join(this,_start,endX,v)
  /**/     def join(r: Range[A])         : THIS_TYPE       = OPS.join(this,_start,endX,r.start,r.endX)
  /**/     def join(r: Val.Range[A])     : THIS_TYPE       = OPS.ref(r,OPS.join(this,_start,endX,_,_))
  /**/     def overlaps(r: Range[A])     : Boolean         = OPS.overlaps(_start,endX,r.start,r.endX)
  /**/     def overlaps(r: Val.Range[A]) : Boolean         = OPS.ref(r,OPS.overlaps(_start,endX,_,_))
  /**/     def overlapOpt(r: Range[A])   : Opt[THIS_TYPE]  = OPS.overlapOpt(this,_start,endX,r.start,r.endX)
  /**/     def overlapOpt(r:Val.Range[A]): Opt[THIS_TYPE]  = OPS.ref(r,OPS.overlapOpt(this,_start,endX,_,_))
  // -----------------------------------------------------------------------------------------------------------------------------
  inline   def ~~                        : Stream[A]       = stream
  /**/     def stream                    : Stream[A]       = z.range.Stream_fromRange[A](_start.real,endX.real,1L)
  /**/     def pack                      : Pack[A]         = Pack.fromArray(z.range.mkArray(start,size),size)
  inline   def toBuffer                  : Buffer[A]       = new Buffer(toArray.cast[Array[Int]],size)
  inline   def toArray                   : Array[A]        = z.range.mkArray(start,size).cast[Array[A]]

object Range:
  extension[A<:Raw](inline x: Range[A])
    inline def map    [B](inline f: A=>B)           (using inline s:Specialized[B]): s.Stream    = x.stream.map(f)
    inline def flatMap[B](inline f:A=>Val.Stream[B])(using inline s:Specialized[B]): s.Stream    = x.stream.flatMap(f)
    inline def withFilter(inline f: Fun.Filter[A])                                 : G.Stream[A] = x.stream.take(f)
    inline def foreach[U](inline f: A=>U)                                          : Unit   = z.range.foreachMacro(x,f)
  // ------------------------------------------------------------------------------------------------------------------------------------------
  implicit inline def implicitRequest(v:VOID)   : Int.Range  = z_Void;  object z_Void extends G.Range[Int](0,0) with Gen.Void
  extension(x:Int.Range)
    @tn("moveRight")inline def >>(move: Int)    : Int.Range  = Range(x.start+move,x.size)
    @tn("moveLeft") inline def <<(move: Int)    : Int.Range  = Range(x.start-move,x.size)
    @tn("grow")     inline def +(growBy: Int)   : Int.Range  = Range(x.start,x.size + growBy)
    @tn("shrink")   inline def -(shrinkBy: Int) : Int.Range  = Range(x.start,x.size - shrinkBy max 0)
    /**/            inline def checkIn(size:Int): Int.Range  = {if(x.start<0 || x.endX>size) J.illegalArgument(""+x.start+" <>> "+x.endX+" is out of range 0 <>> "+size); x}
    /**/            inline def default(size:Int): Int.Range  = {var v=x; if(v.isInstanceOf[Void]) v = 0 <>> size; v }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Range -> ### Int Specialized Generic Range

  To be used with Int based opaque values.

@def ~~ -> Alias to "stream"

*/