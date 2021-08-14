package scalqa; package `val`; package stream; package z; package _use; package _evaluate; import language.implicitConversions

object count:

  def all[A](x: ~[A]): Int =
    var c=0
    x.FOREACH(_ => c+=1)
    c

  def conditional[A](x: ~[A],f: A => Boolean): Int =
    var c = 0
    x.FOREACH(v => if(f(v)) c += 1)
    c

  def andTime[A](x: ~[A]): (Int,Time.Length) =
    val v = System.nanoTime
    (x.count, (System.nanoTime - v).Nanos)

  def few[A](x: ~[A], f1: A => Boolean, f2: A => Boolean, f3: A => Boolean = \/, f4: A => Boolean = \/, f5: A => Boolean = \/)
    : (Int,Int) | (Int,Int,Int) | (Int,Int,Int,Int) | (Int,Int,Int,Int,Int) =

      var v1 = 0
      var v2 = 0
      var v3 = 0
      var v4 = 0
      var v5 = 0

      val is3 = f3.^.nonVoid
      val is4 = f4.^.nonVoid
      val is5 = f5.^.nonVoid

      x.FOREACH(v => {
        if(f1(v)) v1+=1;
        if(f2(v)) v2+=1;
        if(is3 && f3(v)) v3+=1;
        if(is4 && f4(v)) v4+=1;
        if(is5 && f5(v)) v5+=1;
      })

      if(is5)      (v1,v2,v3,v4,v5)
      else if(is4) (v1,v2,v3,v4)
      else if(is3) (v1,v2,v3)
      else         (v1,v2)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
