package scalqa; package `val`; package stream; package z; package _build; import scala.language.implicitConversions

object filter:

  def takeAll   [A]  (x: ~[A], v: ~[A])          : ~[A] = { val set = v.toSet; if(set.isEmpty) \/ else x.TAKE(v => set.contains(v)) }
  def takeAllBy [A,B](x: ~[A], f: A=>B, v: ~[B]) : ~[A] = { val set = v.toSet; if(set.isEmpty) \/ else x.TAKE(v => set.contains(f(v)))}
  def takeOnly  [A]  (x: ~[A], v: A,  vs: Seq[A]): ~[A] = if(vs.isEmpty) x.TAKE(_ == v) else this.takeAll(x,vs.~ + v)
  def takeOnlyBy[A,B](x: ~[A], f:A=>B,vs: Seq[B]): ~[A] = this.takeAllBy(x,f,vs)

  def dropAll   [A]  (x: ~[A], v: ~[A])          : ~[A] = { val set=v.toSet;  if(set.isEmpty) x else x.DROP(v => set.contains(v))}
  def dropAllBy [A,B](x: ~[A], f: A=>B,v: ~[B])  : ~[A] = { val set=v.toSet;  if(set.isEmpty) x else x.DROP(v => set.contains(f(v)))}
  def dropOnly  [A]  (x: ~[A], v: A,  vs: Seq[A]): ~[A] = if(vs.isEmpty) x.DROP(_ == v) else this.dropAll(x,vs.~ + v)
  def dropOnlyBy[A,B](x: ~[A], f:A=>B,vs: Seq[B]): ~[A] = this.dropAllBy(x,f,vs)


  inline def DROP[A](inline x: ~[A], inline f: A => Boolean): ~[A] =
    class DROP(x: ~[A]) extends z.x.Pipe[A](x):
      @tn("read_Opt")
      def read_? =
        var o=x.read_?
        while(o)
          if(!f(o.cast[A])) return o
          o=x.read_?
        o
    new DROP(x)

  inline def TAKE[A](inline x: ~[A], inline f: A => Boolean): ~[A] =
    class TAKE(x: ~[A]) extends z.x.Pipe[A](x):
      @tn("read_Opt")
      def read_? =
        var o=x.read_?
        while(o)
          if(f(o.cast[A])) return o
          o=x.read_?
        o
    new TAKE(x)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
