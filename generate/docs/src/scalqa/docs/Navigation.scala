package scalqa; package docs

object Navigation:

  def build(x: DRI): Seq[(String,String,String)] =
    var i = -1
    var s = x.tag.split_~('.').dropFirst(1).reverse.map(v=>v.real.docLabel).map(v =>{ i+=1; (".",v.simpleName,"" + ("../" * i) + v +(if(i>0) "$" else "") + ".html")}).toSeq

    if(s.isEmpty || s.head._2 == "Md") return Nil

    var n = s.head._2
    if(n.contains("$$"))
      s = s.tail.prependedAll(n.split('$').filter(_.length>0).reverse.map(v => {val t=(".",v,n+".html"); val i=n.lastIndexOf("$$"); if(i>0) n=n.takeFirst(i+1); t}))
    Seq((" ","scalqa",("../" * (i+1))+"scalqa.html")) ++ s.reverse

