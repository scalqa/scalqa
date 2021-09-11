package scalqa; package lang; package float; package g; import language.implicitConversions

class Range[A<:Raw](_start: A, e: A, eIn: Boolean) extends Val.<>[A] with any.z.PrimitiveTag.Float:
  type THIS_TYPE = Range[A]
  final             def start                           : A             = _start
  final             def end                             : A             = e
  final             def endIsIn                         : Boolean       = eIn
  final             def ordering                        : G.Ordering[A] = Float.ordering.cast[G.Ordering[A]]
  @tn("step_Stream")def step_~(step: A)                 : Stream[A]     = Z.Stream_fromRange(this, step.real)
  override          def contains(v: A)                  : Boolean       = _start <= v && v <* (true,e,eIn)
  /**/              def contains(r: Range[A])           : Boolean       = _contains(r.start,r.end,r.endIsIn)
  override          def contains(r: Val.<>[A])          : Boolean       = _contains(r.start,r.end,r.endIsIn)
  /**/              def join(v: A)                      : Range[A]      = if(v<_start) Range(v,e,eIn) else if(v *> (true,e,eIn)) Range(_start,v,true) else this
  /**/              def join(r: Range[A])               : Range[A]      = _join      (r.start,r.end,r.endIsIn)
  /**/              def join(r: Val.<>[A])              : Range[A]      = _join      (r.start,r.end,r.endIsIn)
  /**/              def overlaps(r: Range[A])           : Boolean       = _overlaps  (r.start,r.end,r.endIsIn)
  /**/              def overlaps(r: Val.<>[A])          : Boolean       = _overlaps  (r.start,r.end,r.endIsIn)
  @tn("overlap_Opt")def overlap_?(r: Range[A])          : Opt[Range[A]] = _overlapOpt(r.start,r.end,r.endIsIn)
  @tn("overlap_Opt")def overlap_?(r: Val.<>[A])         : Opt[Range[A]] = _overlapOpt(r.start,r.end,r.endIsIn)
  // -----------------------------------------------------------------------------------------------------------------------------
  private    inline def _contains  (f:A,t:A,tIn:Boolean): Boolean       = _start<=f && e *> (eIn,t,tIn)
  private    inline def _join      (f:A,t:A,tIn:Boolean): Range[A]      = if(f<=_start){ if(e <* (eIn,t,tIn)) Range(f,t,tIn) else Range(f,e,eIn) } else if(e <* (eIn,t,tIn)) Range(_start,t,tIn) else this
  private    inline def _overlaps  (f:A,t:A,tIn:Boolean): Boolean       = if(f<=_start) _start <* (true,t,tIn) else f <* (true,e,eIn)
  private    inline def _overlapOpt(f:A,t:A,tIn:Boolean): Opt[Range[A]] = if(f<=_start){if(_start *> (true,t,tIn)) \/ else if(t <* (tIn,e,eIn)) Range(_start,t,tIn) else this}
    /**/                                                                  else if(f *> (true,e,eIn)) \/ else if(t <* (tIn,e,eIn)) Range(f,t,tIn) else Range(f,e,eIn)
  extension(x: A)
    private inline def <*(inline xIn: Boolean, v:A, inline vIn:Boolean): Boolean = x < v || (!xIn &&  vIn) && x==v
    private inline def *>(inline xIn: Boolean, v:A, inline vIn:Boolean): Boolean = x > v || ( xIn && !vIn) && x==v

object Range

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
