package scalqa; package `val`; package stream; package z; package _use; package _evaluate; import language.implicitConversions

object find:

  def opt[A](x: Stream[A], f: A => Boolean): Opt[A] =
    var o = x.readOpt
    var b = true
    while(b && o)
      if(f(o.cast[A])) b = false
      else o = x.readOpt
    o

  def positionOpt[A](x: Stream[A], f: A => Boolean): Int.Opt =
    var i = 0
    var o = x.readOpt
    while(o)
      if(f(o.`val`)) return i
      o = x.readOpt
      i += 1
    VOID

  def sequencePositionOpt[A](x: Stream[A], v: Stream[A]): Int.Opt =
    val pk = v.pack
    var i,j,p = 0
    var o = x.readOpt
    while(o)
      if(o.`val` == pk(i))
        if(i==0) p = j
        i += 1
        if(i==pk.size) return p
      else i = 0
      j += 1
      o = x.readOpt
    VOID

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
