package scalqa; package lang; package float; import language.implicitConversions

import `val`.stream.Custom.Pipeline

object  Z:

  object VoidStream extends G.Stream[Primitive] with Able.Size.Zero with Gen.Void:
    /**/     def readRawOpt : G.Opt[Primitive]=VOID

  class JointStream[A<:Raw](s1: G.Stream[A], s2: G.Stream[A]) extends G.Stream[A] with Pipeline.Tree with Able.Size.Opt.Long:
    private  var v          : Boolean     = true
    /**/     def readRawOpt : G.Opt[A]    = if(v) s1.readRawOpt orOpt {v = false; s2.readRawOpt}       else s2.readRawOpt
    /**/     def sizeLongOpt: Long.Opt    = if(v) s1.sizeLongOpt.mix(s2.sizeLongOpt, _ + _) else s2.sizeLongOpt
    /**/     def docTree    : Doc.Tree    = Doc.Tree(this.doc, Pipeline.docTree(s1), Pipeline.docTree(s2))
    override def dischargeTo(b:Buffer[A]) = { if(v) b.addAll(s1); b.addAll(s2) }

  class Stream_ofIdx[A<:Raw](idx: G.Idx[A]) extends G.Stream[A] with Able.Size:
    private  var i          = 0
    private  val sz         = idx.size
    /**/     def readRawOpt = { var o:G.Opt[A]=VOID; if(i<sz) { o = idx(i); i+=1 }; o}
    /**/     def size       = sz - i

  class Stream_ofArray[A<:Raw](a: Array[Primitive], sz: Int) extends G.Stream[A] with Able.Size:
    def this(a: Array[Primitive]) = this(a,a.length)
    private  var i                         = 0
    /**/     def readRawOpt                = { var o:G.Opt[A]=VOID;if(i<sz) { o=a(i).cast[G.Opt[A]]; i+=1 }; o}
    /**/     def size                      = sz - i
    override def dischargeTo(b: Buffer[A]) = if(i<sz) b.addArray_trusted(a.cast[Array[A]], i, sz-i)
    /**/     def doc                       = this.defaultDoc += ("array",a)

  class Stream_ofOne[A<:Raw](v: A) extends G.Stream[A] with Able.Size:
    private  var used      : Boolean  = false
    /**/     def readRawOpt: G.Opt[A] = if(used) VOID else { used=true; v }
    /**/     def size      : Int      = if(used) 0 else 1

  class Stream_fromRange[A<:Raw](r: Val.Range[A], step: Float) extends G.Stream[A]:
    private var v = r.start; private val e=r.end; private val eIn=r.endIsIn
    def readRawOpt = if(v < e || eIn && v==e) { val w=v; v=(v+step).cast[A]; w } else VOID

  class OptDocDef[A<:Raw :Any.Def.Tag](using t:Any.Def.TypeName[A]) extends Any.Def.Doc[G.Opt[A]] with Any.Def.Tag[G.Opt[A]]:
    def value_tag(v: G.Opt[A])       = t.typeName + ".Opt(" + v.map(_.tag).or( "VOID") + ")"
    def value_doc(v: G.Opt[A])       = Doc(t.typeName + ".Opt") += ("value", v.map(_.tag).or( "VOID"))

  object OptEmptyDef extends Any.Def.Void[G.Opt[Primitive]] with Any.Def.Empty[G.Opt[Primitive]]:
    def value_isVoid( v:G.Opt[Primitive]) = v.isEmpty
    def value_isEmpty(v:G.Opt[Primitive]) = v.isEmpty

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
