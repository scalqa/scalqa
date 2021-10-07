package scalqa; package lang; package float; package g; import language.implicitConversions

import z.{ range as OPS }

class Range[A<:Raw](_start: A, _end: A, endIn: Boolean) extends Val.<>[A] with any.z.PrimitiveTag.Float:
  type THIS_TYPE = Range[A]
  final             def start                  : A               = _start
  final             def end                    : A               = _end
  final             def endIsIn                : Boolean         = endIn
  final             def ordering               : Ordering[A]     = Primitive.ordering.cast[Ordering[A]]
  override          def contains(v: A)         : Boolean         = _start <= v && OPS.<=(v,true)(_end,endIn)
  /**/              def contains(r: Range[A])  : Boolean         = OPS.contains(_start,_end,endIn)(r.start,r.end,r.endIsIn)
  override          def contains(r: Val.<>[A]) : Boolean         = OPS.ref(r,OPS.contains(_start,_end,endIn)(_,_,_))
  /**/              def join(v: A)             : THIS_TYPE       = OPS.join(this,_start,_end,endIn,v)
  /**/              def join(r: Range[A])      : THIS_TYPE       = OPS.join(this,_start,_end,endIn)(r.start,r.end,r.endIsIn)
  /**/              def join(r: Val.<>[A])     : THIS_TYPE       = OPS.ref(r,OPS.join(this,_start,_end,endIn)(_,_,_))
  /**/              def overlaps(r: Range[A])  : Boolean         = OPS.overlaps(_start,_end,endIn)(r.start,r.end,r.endIsIn)
  /**/              def overlaps(r: Val.<>[A]) : Boolean         = OPS.ref(r,OPS.overlaps(_start,_end,endIn)(_,_,_))
  @tn("overlap_Opt")def overlap_?(r: Range[A]) : Opt[THIS_TYPE]  = OPS.overlap_Opt(this,_start,_end,endIn)(r.start,r.end,r.endIsIn)
  @tn("overlap_Opt")def overlap_?(r: Val.<>[A]): Opt[THIS_TYPE]  = OPS.ref(r,OPS.overlap_Opt(this,_start,_end,endIn)(_,_,_))
  @tn("step_Stream")def step_~(step: A)        : Stream[A]       = Z.Stream_fromRange(this,step.real)

object Range

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Range -> ### Float Specialized Generic Range

  To be used with Float based opaque values.

*/