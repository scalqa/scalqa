package scalqa; package lang; package boolean; import language.implicitConversions

import `val`.stream.Custom.Pipeline

object  Z:

  object VoidStream extends G.~[Primitive] with Able.Size.Zero with Gen.Void:
    @tn("readRaw_Opt")  def readRaw_? : G.Opt[Primitive] = \/

  class JointStream[A<:Raw](s1: G.~[A], s2: G.~[A]) extends G.~[A] with Pipeline.Tree with Able.Size.Opt.Long:
    private             var v          : Boolean     = true
    @tn("readRaw_Opt")  def readRaw_?  : G.Opt[A]    = if(v) s1.readRaw_? or_? {v = false; s2.readRaw_?}       else s2.readRaw_?
    @tn("sizeLong_Opt") def sizeLong_? : Long.Opt    = if(v) s1.sizeLong_?.mix(s2.sizeLong_?, _ + _) else s2.sizeLong_?
    /**/                def docTree    : Doc.Tree    = Doc.Tree(this.doc, Pipeline.docTree(s1), Pipeline.docTree(s2))
    override            def dischargeTo(b:Buffer[A]) = { if(v) b.addAll(s1); b.addAll(s2) }

  class Stream_ofIdx[A<:Raw](idx: G.Idx[A]) extends G.~[A] with Able.Size:
    private             var i         = 0
    private             val sz        = idx.size
    @tn("readRaw_Opt")  def readRaw_? = { var o:G.Opt[A] = \/; if(i<sz) { o = idx(i); i+=1 }; o}
    /**/                def size      = sz - i

  class Stream_ofArray[A<:Raw](a: Array[Primitive], sz: Int) extends G.~[A] with Able.Size:
    def this(a: Array[Primitive]) = this(a,a.length)
    private            var i                         = 0
    @tn("readRaw_Opt") def readRaw_?                 = { var o:G.Opt[A]= \/; if(i<sz) { o=G.Opt(a(i).cast[A]); i+=1 }; o}
    /**/               def size                      = sz - i
    override           def dischargeTo(b: Buffer[A]) = if(i<sz) b.addArray_trusted(a.cast[Array[A]], i, sz-i)
    /**/               def doc                       = this.defaultDoc += ("array",a)

  class Stream_ofOne[A<:Raw](v: A) extends G.~[A] with Able.Size:
    private             var used      : Boolean  = false
    @tn("readRaw_Opt")  def readRaw_? : G.Opt[A] = if(used) \/ else { used=true; v }
    /**/                def size      : Int      = if(used) 0 else 1

  class OptDocDef[A<:Raw :Any.Def.Tag](using t:Any.Def.TypeName[A]) extends Any.Def.Doc[G.Opt[A]] with Any.Def.Tag[G.Opt[A]]:
    def value_tag(v: G.Opt[A])       = t.typeName + ".Opt(" + v.map(_.tag).or("\\/") + ")"
    def value_doc(v: G.Opt[A])       = Doc(t.typeName + ".Opt") += ("value", v.map(_.tag).or("\\/"))

  object OptEmptyDef extends Any.Def.Void[G.Opt[Primitive]] with Any.Def.Empty[G.Opt[Primitive]]:
    def value_isVoid( v:G.Opt[Primitive]) = v.isEmpty
    def value_isEmpty(v:G.Opt[Primitive]) = v.isEmpty

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
