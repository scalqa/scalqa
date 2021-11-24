package scalqa; package `val`; package stream; package z; package _build; package _extend; import language.implicitConversions

class joinAllAt[A](p1: Stream[A], pos: Int, p2: Stream[A]) extends Stream[A] with Custom.Pipeline.Tree with Able.Size.Opt.Long:
  private var i = 0
  private var end = false

  def readOpt =
    if (end) p1.readOpt
    else if (i < pos)
      i += 1
      p1.readOpt orOpt { i = pos; readOpt }
    else
      p2.readOpt orOpt { end = true; readOpt }

  override            def doc        = super.doc += ("position", pos)
  def sizeLongOpt = p1.sizeLongOpt.mix(p2.sizeLongOpt, _ + _)
  /**/                def docTree    = Doc.Tree(this.doc, Custom.Pipeline.docTree(p1), Custom.Pipeline.docTree(p2))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
