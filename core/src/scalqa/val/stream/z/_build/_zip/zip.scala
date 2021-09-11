package scalqa; package `val`; package stream; package z; package _build; package _zip; import language.implicitConversions

class zip[A,B](one: ~[A], two: ~[B]) extends ~[(A, B)] with Custom.Pipeline.Tree with Able.Size.Opt.Long:

  @tn("read_Opt")     def read_?     = one.read_?.map_?(v => two.read_?.map(w => (v,w)))
  @tn("sizeLong_Opt") def sizeLong_? = one.sizeLong_?.mix(two.sizeLong_?, _ min _)
  /**/                def docTree    = Doc.Tree(this.doc, Custom.Pipeline.docTree(one), Custom.Pipeline.docTree(two))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
