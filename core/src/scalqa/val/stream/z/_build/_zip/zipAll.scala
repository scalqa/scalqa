package scalqa; package `val`; package stream; package z; package _build; package _zip; import language.implicitConversions

class zipAll[A,B](one: Stream[A], two: Stream[B], ao: Opt[A], bo: Opt[B]) extends Stream[(A, B)] with Custom.Pipeline.Tree with Able.Size.Opt.Long:
  private var done1, done2 = false

  def readOpt = if(done1 && done2) \/ else
    val o1 : Opt[A] = if(done1) \/ else one.readOpt.fornil{done1=true}
    val o2 : Opt[B] = if(done2) \/ else two.readOpt.fornil{done2=true}
    if(done1 && done2) \/ else (o1 orOpt ao or fail("first"), o2 orOpt bo or fail("second"))

  def sizeLongOpt      = one.sizeLongOpt.mix(two.sizeLongOpt, _ max _)
  override            def docTree         = Doc.Tree(this.doc, Custom.Pipeline.docTree(one), Custom.Pipeline.docTree(two))
  private             def fail(x: String) = J.illegalState("~.zip '" + x + "' default ? is not provided, but is required to match other [[Stream]]'s length")

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
