package scalqa; package `val`; package stream; package z; package _use; import language.implicitConversions

object process:

  def drain  [A,U](x: Stream[A])       : Unit = x.FOREACH(_ => ())

  def fornil [A,U](x: Stream[A],f: =>U): Unit = if (x.readOpt.isEmpty) { var v:U = f }

  def apply[A,U,W](x: Stream[A], foreachFun: A=>U, fornilFun: => W): Unit =
    var o=x.readOpt
    if (!o)
      var v: W = fornilFun
    else
      while(o)
        foreachFun(o.`val`)
        o=x.readOpt
    ()

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
