package scalqa; package lang; package int; package z; import scala.language.implicitConversions

object Range:

  inline def mk[A<:Raw](start:Int, endX:Int): G.<>[A] = new G.<>(start.cast[A],endX - start)

  inline def ref[A<:Raw,B](inline x: <>[A], inline fun: (A,A) => B): B =
    val r = x.cast[<>[A]]
    val rs = r.start
    val re = (r.end + r.endIsIn.toInt).cast[A]
    fun(rs,re)

  inline def join[A<:Raw](self: G.<>[A], inline start:A, inline end:A, inline value:A): G.<>[A] =
    val s = start.cast[Int]
    val e = end  .cast[Int]
    val v = value.cast[Int]
    if     (v<s)  mk(v,e)
    else if(v>=e) mk(s,v+1)
    else          self

  inline def join[A<:Raw](self: G.<>[A], inline start:A, inline end:A, inline start2:A, inline end2:A): G.<>[A] =
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

  inline def overlap_Opt[A<:Raw](self: G.<>[A], inline start:A, inline end:A, inline start2:A, inline end2:A): Opt[G.<>[A]] =
    val s  = start .cast[Int]; val e  = end .cast[Int]
    val s2 = start2.cast[Int]; val e2 = end2.cast[Int]
    if(s2<=s)
      if(e2<=s)      \/
      else if(e2<=e) mk(s,e2)
      else           self
    else
      if(s2>=e)      \/
      else if(e2<=e) mk(s2,e2)
      else           mk(s2,e)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
