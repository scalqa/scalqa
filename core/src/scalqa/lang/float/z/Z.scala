package scalqa; package lang; package float; import language.implicitConversions

import `val`.stream.Custom.Pipeline

object  Z:

  abstract class Pipe[A<:RAW](override val base: Ref) extends G.~[A] with Pipeline

  object VoidStream extends G.~[Float] with Able.Size.Zero with Gen.Void:
    @tn("readRaw_Opt")  def readRaw_?  : Float.Opt = \/

  class JointStream[A<:RAW](s1: G.~[A], s2: G.~[A]) extends G.~[A] with Pipeline.Tree with Able.Size.Opt.Long:
    private             var v          : Boolean     = true
    @tn("readRaw_Opt")  def readRaw_?  : G.Opt[A]    = if(v) s1.readRaw_? or_? {v = false; s2.readRaw_?}       else s2.readRaw_?
    @tn("sizeLong_Opt") def sizeLong_? : Long.Opt    = if(v) s1.sizeLong_?.mix(s2.sizeLong_?, _ + _) else s2.sizeLong_?
    /**/                def infoTree   : Doc.Tree    = Doc.Tree(this.doc, Pipeline.infoTree(s1), Pipeline.infoTree(s2))
    override            def dischargeTo(b:Buffer[A]) = { if(v) b.addAll(s1); b.addAll(s2) }

  class Stream_ofIdx[A<:RAW](idx: Idx[A]) extends G.~[A] with Able.Size:
    private             var i         = 0
    private             val sz        = idx.size
    @tn("readRaw_Opt")  def readRaw_? = { var o:G.Opt[A] = \/; if(i<sz) { o = idx(i); i+=1 }; o}
    /**/                def size      = sz - i

  class Stream_ofOne[A<:RAW](v: A) extends G.~[A] with Able.Size:
    private             var used      : Boolean  = false
    @tn("readRaw_Opt")  def readRaw_? : G.Opt[A] = if(used) \/ else { used=true; v }
    /**/                def size      : Int      = if(used) 0 else 1

  class Stream_fromRange[A<:RAW](r: Val.<>[A], step: Float) extends G.~[A]:
    private var v = r.start; private val e=r.end; private val eIn=r.endIsIn
    @tn("readRaw_Opt") def readRaw_? = if(v < e || eIn && v==e) { val w=v; v=(v+step).cast[A]; w } else \/

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
