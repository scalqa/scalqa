package scalqa; package lang; package long; package z; import language.implicitConversions

object range:

  inline def <=[A<:Raw](inline xv:A, inline xIn: Boolean)(inline vv:A, inline vIn:Boolean): Boolean = { val x=xv.cast[Primitive]; val w=vv.cast[Primitive]; x < w || x==w && (!xIn ||  vIn) }
  inline def >=[A<:Raw](inline xv:A, inline xIn: Boolean)(inline vv:A, inline vIn:Boolean): Boolean = { val x=xv.cast[Primitive]; val w=vv.cast[Primitive]; x > w || x==w && ( xIn || !vIn) }

  inline def ref[A<:Raw,B](inline x: <>[A], inline fun: (A,A,Boolean) => B): B =
    val r = x.cast[<>[A]]
    val rs = r.start
    val re = r.end
    val ri = r.endIsIn
    fun(rs,re,ri)

  inline def contains[A<:Raw](inline start:A, inline end:A, inline endIn:Boolean)(inline start2:A, inline end2:A, inline endIn2:Boolean): Boolean =
    start <= start2 && >=(end,endIn)(end2,endIn2)

  inline def join[A<:Raw](self: G.<>[A], inline start:A, inline end:A, inline endIn:Boolean,inline value:A): G.<>[A] =
    val v = value
    if(v<=start) G.<>(v,end,endIn) else if(<=(v,true)(end,endIn)) self else G.<>(start,v,true)

  inline def join[A<:Raw](self: G.<>[A], inline start:A, inline end:A, inline endIn:Boolean)(inline start2:A, inline end2:A, inline endIn2:Boolean): G.<>[A] =
    val s2 = start2; val e2 = end2; val i2 = endIn2
    if(s2<=start)
      if(<=(end,endIn)(e2,i2)) G.<>(s2,e2,i2)
      else                     G.<>(s2,end,endIn)
    else
      if(<=(end,endIn)(e2,i2)) G.<>(start,e2,i2)
      else                     self

  inline def overlaps[A<:Raw](inline start:A, inline end:A, inline endIn:Boolean)(inline start2:A, inline end2:A, inline endIn2:Boolean): Boolean =
    val s2 = start2
    if(s2 <= start) <=(start,true)(end2,endIn2)
    else            <=(s2,   true)(end, endIn )

  inline def overlap_Opt[A<:Raw](self: G.<>[A], inline start:A, inline end:A, inline endIn:Boolean)(inline start2:A, inline end2:A, inline endIn2:Boolean): Opt[G.<>[A]] =
    val s2 = start2; val e2 = end2; val i2 = endIn2
    if(s2<=start)
      if(     <=(e2,i2)(start,true))  \/
      else if(<=(e2,i2)(end, endIn))  G.<>(start,e2,i2)
      else                            self
    else
      if(     >=(s2,true)(end,endIn)) \/
      else if(<=(e2,i2)  (end,endIn)) G.<>(s2,e2,i2)
      else                            G.<>(s2,end,endIn)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
