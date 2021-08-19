package scalqa; package `val`; package stream; package z; package _use; import language.implicitConversions

object process:

  def drain  [A,U](x: ~[A])       : Unit = x.FOREACH(_ => ())

  def fornil [A,U](x: ~[A],f: =>U): Unit = if (x.read_?.isEmpty) { var v:U = f }

  def apply[A,U,W](x: ~[A], foreachFun: A=>U, fornilFun: => W): Unit =
    var o=x.read_?
    if (o.isEmpty)
      var v: W = fornilFun
    else
      while(o.nonEmpty)
        foreachFun(o.`val`)
        o=x.read_?
    ()

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/