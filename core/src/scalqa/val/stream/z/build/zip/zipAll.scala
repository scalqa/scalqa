package scalqa; package `val`; package stream; package z; package build; package zip; import language.implicitConversions

class zipAll[A,B](one: ~[A], two: ~[B], ao: Opt[A], bo: Opt[B]) extends ~[(A, B)] with Custom.Pipeline.Tree with Able.Size.Opt.Long:
  private var done1, done2 = false

  @tn("read_Opt") def read_? = if(done1 && done2) \/ else
    val o1 : Opt[A] = if(done1) \/ else one.read_?.fornil{done1=true}
    val o2 : Opt[B] = if(done2) \/ else two.read_?.fornil{done2=true}
    if(done1 && done2) \/ else (o1 or_? ao or fail("first"), o2 or_? bo or fail("second"))

  @tn("sizeLong_Opt") def sizeLong_?      = one.sizeLong_?.mix(two.sizeLong_?, _ max _)
  override            def infoTree        = Self.Doc.Tree(this.doc, Custom.Pipeline.infoTree(one), Custom.Pipeline.infoTree(two))
  private             def fail(x: String) = J.illegalState("~.zip '" + x + "' default ? is not provided, but is required to match other [[Stream]]'s length")

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
