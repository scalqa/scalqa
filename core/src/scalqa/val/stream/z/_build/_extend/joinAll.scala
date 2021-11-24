package scalqa; package `val`; package stream; package z; package _build; package _extend; import language.implicitConversions

class joinAll[A](p1: Stream[A], p2: Stream[A]) extends Stream[A] with custom.Pipeline.Tree with custom.Discharge[A] with Able.Size.Opt.Long:
  private var v = true
  /**/     def readOpt                   = if(v) p1.readOpt orOpt {v = false; p2.readOpt}    else p2.readOpt
  /**/     def sizeLongOpt               = if(v) p1.sizeLongOpt.mix(p2.sizeLongOpt, _ + _ ) else p2.sizeLongOpt
  override def docTree                   = Doc.Tree(this.doc, Custom.Pipeline.docTree(p1), Custom.Pipeline.docTree(p2))
  override def dischargeTo(b: Buffer[A]) = { if(v) b.addAll(p1); b.addAll(p2) }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
