package scalqa; package lang; package byte; package z; import language.implicitConversions

object range:

  inline def mk[A<:Raw](start:Int, endX:Int): G.Range[A] = new G.Range(start.cast[A],endX - start)

  inline def ref[A<:Raw,B](inline x: Range[A], inline fun: (A,A) => B): B =
    val r = x.cast[Range[A]]
    val rs = r.start
    val re = (r.end + r.endIsIn.toInt).cast[A]
    fun(rs,re)

  inline def join[A<:Raw](self: G.Range[A], inline start:A, inline end:A, inline value:A): G.Range[A] =
    val s = start.cast[Int]
    val e = end  .cast[Int]
    val v = value.cast[Int]
    if     (v<s)  mk(v,e)
    else if(v>=e) mk(s,v+1)
    else          self

  inline def join[A<:Raw](self: G.Range[A], inline start:A, inline end:A, inline start2:A, inline end2:A): G.Range[A] =
    val s  = start .cast[Int]; val e  = end .cast[Int]
    val s2 = start2.cast[Int]; val e2 = end2.cast[Int]
    if(s2<=s)
      if(e<=e2) mk(s2,e2)
      else      mk(s2,e)
    else
      if(e<=e2) mk(s,e2)
      else      self

  inline def overlaps[A<:Raw](inline start:A, inline end:A, inline start2:A, inline end2:A): Boolean =
    val s2 = start2.cast[Int]
    if(s2 <= start) start < end2 else s2 < end

  inline def overlapOpt[A<:Raw](self: G.Range[A], inline start:A, inline end:A, inline start2:A, inline end2:A): Opt[G.Range[A]] =
    val s  = start .cast[Int]; val e  = end .cast[Int]
    val s2 = start2.cast[Int]; val e2 = end2.cast[Int]
    if(s2<=s)
      if(e2<=s)      VOID
      else if(e2<=e) mk(s,e2)
      else           self
    else
      if(s2>=e)      VOID
      else if(e2<=e) mk(s2,e2)
      else           mk(s2,e)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
