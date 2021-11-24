package scalqa; package `val`; package stream; package z; package _use; package _aggregate; import language.implicitConversions

object reduce:

  inline def opt[A](x: Stream[A], inline f: (A,A) => A) : Opt[A] = inline x match
    case _ :  Stream[A & Any.Boolean] => booleanOpt(x.cast[Stream[Boolean]],(x,y) => f(x.cast[A],y.cast[A]).cast[Boolean]).cast[A]
    case _ :  Stream[A & Any.Byte]    => byteOpt   (x.cast[Stream[Byte]],   (x,y) => f(x.cast[A],y.cast[A]).cast[Byte   ]).cast[A]
    case _ :  Stream[A & Any.Short]   => shortOpt  (x.cast[Stream[Short]],  (x,y) => f(x.cast[A],y.cast[A]).cast[Short  ]).cast[A]
    case _ :  Stream[A & Any.Char]    => charOpt   (x.cast[Stream[Char]],   (x,y) => f(x.cast[A],y.cast[A]).cast[Char   ]).cast[A]
    case _ :  Stream[A & Any.Int]     => intOpt    (x.cast[Stream[Int]],    (x,y) => f(x.cast[A],y.cast[A]).cast[Int    ]).cast[A]
    case _ :  Stream[A & Any.Long]    => longOpt   (x.cast[Stream[Long]],   (x,y) => f(x.cast[A],y.cast[A]).cast[Long   ]).cast[A]
    case _ :  Stream[A & Any.Float]   => floatOpt  (x.cast[Stream[Float]],  (x,y) => f(x.cast[A],y.cast[A]).cast[Float  ]).cast[A]
    case _ :  Stream[A & Any.Double]  => doubleOpt (x.cast[Stream[Double]], (x,y) => f(x.cast[A],y.cast[A]).cast[Double ]).cast[A]
    case _                       => refOpt(x,f)

  def refOpt[A] (x: Stream[A],      f: (A,A) => A      ): Opt[A]       = x.readOpt.map(v => fold.ref(x,v,f))
  def booleanOpt(x: Stream[Boolean],f: Boolean.Fun.Fold): Opt[Boolean] = x.readOpt.map(v => fold.boolean(x,v,f))
  def byteOpt   (x: Stream[Byte],   f: Byte.Fun.Fold   ): Opt[Byte]    = x.readOpt.map(v => fold.byte(x,v,f))
  def charOpt   (x: Stream[Char],   f: Char.Fun.Fold   ): Opt[Char]    = x.readOpt.map(v => fold.char(x,v,f))
  def shortOpt  (x: Stream[Short],  f: Short.Fun.Fold  ): Opt[Short]   = x.readOpt.map(v => fold.short(x,v,f))
  def intOpt    (x: Stream[Int],    f: Int.Fun.Fold    ): Opt[Int]     = x.readOpt.map(v => fold.int(x,v,f))
  def longOpt   (x: Stream[Long],   f: Long.Fun.Fold   ): Opt[Long]    = x.readOpt.map(v => fold.long(x,v,f))
  def floatOpt  (x: Stream[Float],  f: Float.Fun.Fold  ): Opt[Float]   = x.readOpt.map(v => fold.float(x,v,f))
  def doubleOpt (x: Stream[Double], f: Double.Fun.Fold ): Opt[Double]  = x.readOpt.map(v => fold.double(x,v,f))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
