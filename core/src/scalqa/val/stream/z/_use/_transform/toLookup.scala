package scalqa; package `val`; package stream; package z; package _use; package _transform; import language.implicitConversions

object toLookup:

  def keyByte [A](x: Stream[A],f: AnyRef.G.Fun.ToByte [A]): Byte .Lookup.Stable[A]   = {var l: Byte .Lookup.Stable[A]   = \/; x.FOREACH(v => l = l.join(f(v),v)); l}
  def keyChar [A](x: Stream[A],f: AnyRef.G.Fun.ToChar [A]): Char .Lookup.Stable[A]   = {var l: Char .Lookup.Stable[A]   = \/; x.FOREACH(v => l = l.join(f(v),v)); l}
  def keyShort[A](x: Stream[A],f: AnyRef.G.Fun.ToShort[A]): Short.Lookup.Stable[A]   = {var l: Short.Lookup.Stable[A]   = \/; x.FOREACH(v => l = l.join(f(v),v)); l}
  def keyInt  [A](x: Stream[A],f: AnyRef.G.Fun.ToInt  [A]): Int  .Lookup.Stable[A]   = {var l: Int  .Lookup.Stable[A]   = \/; x.FOREACH(v => l = l.join(f(v),v)); l}
  def keyLong [A](x: Stream[A],f: AnyRef.G.Fun.ToLong [A]): Long .Lookup.Stable[A]   = {var l: Long .Lookup.Stable[A]   = \/; x.FOREACH(v => l = l.join(f(v),v)); l}
  def ref   [B,A](x: Stream[A],f: A=>B                   ): Val  .Lookup.Stable[B,A] = {var l: Val  .Lookup.Stable[B,A] = \/; x.FOREACH(v => l = l.join(f(v),v)); l}

  inline def apply[A,B](inline x: Stream[B], inline f: B=>A)(using inline A: Specialized[A]): A.Lookup[B] =
    inline A match
      case _ : Specialized[A&Any.Boolean] => ref     (x,f               ).cast[A.Lookup[B]]
      case _ : Specialized[A&Any.Byte   ] => keyByte (x,f(_).cast[Byte ]).cast[A.Lookup[B]]
      case _ : Specialized[A&Any.Char   ] => keyChar (x,f(_).cast[Char ]).cast[A.Lookup[B]]
      case _ : Specialized[A&Any.Short  ] => keyShort(x,f(_).cast[Short]).cast[A.Lookup[B]]
      case _ : Specialized[A&Any.Int    ] => keyInt  (x,f(_).cast[Int  ]).cast[A.Lookup[B]]
      case _ : Specialized[A&Any.Long   ] => keyLong (x,f(_).cast[Long ]).cast[A.Lookup[B]]
      case _ : Specialized[A&Any.Float  ] => ref     (x,f               ).cast[A.Lookup[B]]
      case _ : Specialized[A&Any.Double ] => ref     (x,f               ).cast[A.Lookup[B]]
      case _                              => ref     (x,f               ).cast[A.Lookup[B]]

  inline def apply[A,B](inline x: Stream[(A,B)])(using inline A: Specialized[A]): A.Lookup[B] =
    inline A match
      case _ : Specialized[A&Any.Boolean] => Val  .Lookup.Stable[A,B](x).cast[A.Lookup[B]]
      case _ : Specialized[A&Any.Byte   ] => Byte .Lookup.Stable(x.cast[Stream[(Byte ,B)]]).cast[A.Lookup[B]]
      case _ : Specialized[A&Any.Char   ] => Char .Lookup.Stable(x.cast[Stream[(Char ,B)]]).cast[A.Lookup[B]]
      case _ : Specialized[A&Any.Short  ] => Short.Lookup.Stable(x.cast[Stream[(Short,B)]]).cast[A.Lookup[B]]
      case _ : Specialized[A&Any.Int    ] => Int  .Lookup.Stable(x.cast[Stream[(Int  ,B)]]).cast[A.Lookup[B]]
      case _ : Specialized[A&Any.Long   ] => Long .Lookup.Stable(x.cast[Stream[(Long ,B)]]).cast[A.Lookup[B]]
      case _ : Specialized[A&Any.Float  ] => Val  .Lookup.Stable[A,B](x).cast[A.Lookup[B]]
      case _ : Specialized[A&Any.Double ] => Val  .Lookup.Stable[A,B](x).cast[A.Lookup[B]]
      case _                              => Val  .Lookup.Stable[A,B](x).cast[A.Lookup[B]]


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
