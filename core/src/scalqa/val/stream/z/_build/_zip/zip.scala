package scalqa; package `val`; package stream; package z; package _build; package _zip; import language.implicitConversions

class zip[A,B](one: Stream[A], two: Stream[B]) extends Stream[(A, B)] with Custom.Pipeline.Tree with Able.Size.Opt.Long:

  def readOpt     = one.readOpt.mapOpt(v => two.readOpt.map(w => (v,w)))
  def sizeLongOpt = one.sizeLongOpt.mix(two.sizeLongOpt, _ min _)
  def docTree     = Doc.Tree(this.doc, Custom.Pipeline.docTree(one), Custom.Pipeline.docTree(two))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
