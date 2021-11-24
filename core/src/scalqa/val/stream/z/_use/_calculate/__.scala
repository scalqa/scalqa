package scalqa; package `val`; package stream; package z; package _use; import language.implicitConversions

import Custom.{ Ordering as CO }

object calculate:

  def minOpt[A](x: Stream[A], c:Ordering[A]): Opt[A] = c match
    case _ : CO[_] => c.cast[CO[A]].minOpt(x)
    case _         => x.readOpt.map(u => { var v=u; x.FOREACH(w => if(c.compare(v,w)>0) v = w); v})

  def maxOpt[A](x: Stream[A], c:Ordering[A]): Opt[A] = c match
    case _ : CO[_] => c.cast[CO[A]].maxOpt(x)
    case _         => x.readOpt.map(u => { var v=u; x.FOREACH(w => if(c.compare(v,w)<0) v = w); v})

  def rangeOpt[A](x: Stream[A], c:Ordering[A]) : Opt[Range[A]]    =c match
    case _ : CO[_] => c.cast[CO[A]].rangeOpt(x)
    case _         => x.readOpt.map(u=>{var f,l=u; x.FOREACH(v => {if(c.compare(v,f)<0) f=v; if(c.compare(v,l)>0) l=v}); Val.Range(f,l,true)(using c)})

  def minByOpt[A,B](x: Stream[A],f: A=>B, o:Ordering[B]) : Opt[A] =
    x.readOpt.map(u => {
      var v, w = u
      var vf = f(u);
      var wf = vf;
      x.FOREACH(w => {
        wf = f(w)
        if(o.compare(vf,wf)>0){ v=w; vf=wf }
      })
      v
    })

  def maxByOpt[A,B](x: Stream[A],f: A=>B, o:Ordering[B]) : Opt[A] =
    x.readOpt.map(u => {
      var v, w = u
      var vf = f(u)
      var wf = vf
      x.FOREACH(w => {
        wf = f(w)
        if(o.compare(vf,wf)<0){v=w;vf=wf}
      })
      v
    })

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
