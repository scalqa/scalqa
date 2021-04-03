package scalqa; package `val`; package stream; package z; package build; package group; import language.implicitConversions

class groupBy[A](x: ~[A], g: (A,A) => Boolean) extends group[A,Unit](x,g):
  def this(x: ~[A], f: A => Any, more: Seq[A => Any]) = this(
    x,
    if(more.isEmpty) {
      (x, y) => f(x) == f(y)
    } else {
      val a = more.toArray
      (x,y) => {
        var b = f(x) == f(y)
        var i = 0
        while(b && i<a.length)
          val f = a(i)
          b = f(x) == f(y)
          i += 1
        b
      }
    })

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
