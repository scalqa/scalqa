package scalqa; package `val`; package range; package z; import language.implicitConversions

object ops:
  inline def isEmpty [A](inline x: Range[A])             : Boolean  = x.start.>(x)
  inline def contains[A](inline x: Range[A], v: A)       : Boolean  = !v.<(x) && !v.>(x)
  inline def contains[A](inline x: Range[A], r: Range[A]): Boolean  = !r.start.<(x) && !r.end.>(r.endIsIn,x)
  inline def overlaps[A](inline x: Range[A], r: Range[A]): Boolean  = if(r.start.<(x)) !x.start.>(r) else !r.start.>(x)

  inline def join[RNG<:Range[A],A](x:RNG, v: A, inline f: (A,A,Boolean) => RNG): RNG =
    if(v.<(x))      f.mk(v,x.end,x.endIsIn)
    else if(v.>(x)) f.mk(x.start,v,true)
    else            x

  inline def join[RNG<:Range[A],A](x: RNG, r: Range[A],inline f: (A,A,Boolean) => RNG): RNG =
    if(r.start.<(x))
      if(r.end.>(r.endIsIn,x)) f.mk(r.start,r.end,r.endIsIn)
      else                      f.mk(r.start,x.end,x.endIsIn)
    else
      if(r.end.>(r.endIsIn,x)) f.mk(x.start,r.end,r.endIsIn)
      else                      x

  inline def overlapOpt[RNG<:Range[A],A](x: RNG, r: Range[A],inline f: (A,A,Boolean) => RNG): Opt[RNG] =
    if(r.start.<(x))
      if(r.end.>(r.endIsIn,x)) x
      else if(x.start.>(r))     VOID
      else                      f.mk(x.start,r.end,r.endIsIn)
    else
      if(x.end.>(x.endIsIn,r)) f.mk(r.start,r.end,r.endIsIn)
      else if(r.start.>(x))     VOID
      else                      f.mk(r.start,x.end,x.endIsIn)

  // Helpers
  extension[A](inline x: A)
    private inline def < (r:Range[A])                               : Boolean = r.ordering.compare(x,r.start) < 0
    private inline def > (inline r:Range[A])                        : Boolean = x.>(true,r)
    private inline def > (inline xIn: Boolean,r:Range[A])           : Boolean = {val i=r.ordering.compare(x,r.end); i>0 || i==0 && (xIn && !r.endIsIn)}

  extension[RNG<:Range[A],A](inline f: (A,A,Boolean) => RNG)
    private inline def mk(inline _s:A,inline _e:A,inline _i:Boolean): RNG     = { val s = _s; val e = _e; val i = _i; f(s,e,i) }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
