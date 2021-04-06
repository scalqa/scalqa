package scalqa; package member

import Member.Id

object Id extends String.Custom.Type[Id]("Member.Id"):

  def apply(x: String): Id =
    var v = x.toLowerCase
    if(v.contains("opaque") && !v.contains("any.opaque") && !v.contains("delegate.opaque"))
      if(v.endsWith( ".opaque$.type")) v = v.dropLast(13)
      if(v.endsWith("$$opaque$.type")) v = v.dropLast(14)
    v.asOpaque[Id]

  def apply(x: Signature): Id =
    val id = x.collect{
      case v: String => v
      case v: Link   => apply(v.dri).toString
    }.takeWhile(_ != "[").mkString
    apply(id)

  def apply(x: DRI): Id =
    var v = x.location
    val e = x.anchor.takeBefore("-")
    if(e!=null && e.length>0) v = v+"."+e
    apply(v)

  extension(x: Id)
    def isOpaqueBase: Boolean = x.toString.endsWith("$$opaque$")

    def moduleId: Module.Id = Module.Id(x)

    def navigation: Seq[(String,String,String)] =
      var i = -1
      var s = x.split_~('.').dropFirst(1).reverse.map(v=>v.real.docLabel).map(v =>{ i+=1; (".",v.simpleName,"" + ("../" * i) + v +(if(i>0) "$" else "") + ".html")}).toSeq
      if(s.nonEmpty)
        var n = s.head._2
        if(n.contains("$$"))
          s = s.tail.prependedAll(n.split('$').filter(_.length>0).reverse.map(v => {val t=(".",v,n+".html"); val i=n.lastIndexOf("$$"); if(i>0) n=n.takeFirst(i+1); t}))
        if(x.isOpaqueBase) s = s.drop(1)
      val rt = "../" * (i+1)
      Seq((" ","scalqa",rt+"scalqa.html")) ++ s.reverse

  object opaque:
    opaque type `type` <: Opaque.String = String & Opaque.String

