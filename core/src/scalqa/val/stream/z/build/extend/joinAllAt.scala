package scalqa; package `val`; package stream; package z; package build; package extend; import language.implicitConversions

class joinAllAt[A](p1: ~[A], pos: Int, p2: ~[A]) extends ~[A] with Custom.Pipeline.Tree with Able.Size.Opt.Long:
  private var i = 0
  private var end = false

  @tn("read_Opt") def read_? =
    if (end) p1.read_?
    else if (i < pos)
      i += 1
      p1.read_? or_? { i = pos; read_? }
    else
      p2.read_? or_? { end = true; read_? }

  override            def doc       = super.doc += ("position", pos)
  @tn("sizeLong_Opt") def sizeLong_? = p1.sizeLong_?.mix(p2.sizeLong_?, _ + _)
  /**/                def infoTree   = Doc.Tree(this.doc, Custom.Pipeline.infoTree(p1), Custom.Pipeline.infoTree(p2))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
