package scalqa; package `val`; package stream; package z; package _use; import language.implicitConversions

object transformTo:

  def toIdx[A](x: ~[A])                 : Idx[A]       = pack.z.ArrayPack.fromStream[A](x)

  def toLookupBy[A,B](x: ~[A],f: A => B): Lookup[B,A]  = {val l=Lookup.Mutable[B,A](); x.FOREACH(v => l.put(f(v),v)); l}

  def makeString[A](x: ~[A], sep: String, t :Any.Def.Doc[A]): String =
    x.read_?.map(v => {
      val b = String.Builder(256)
      b += t.value_tag(v)
      x.FOREACH(v => { b += sep; b += t.value_tag(v)})
      b.tag
    }) or ""


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
