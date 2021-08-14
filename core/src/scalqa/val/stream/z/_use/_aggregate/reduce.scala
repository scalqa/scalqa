package scalqa; package `val`; package stream; package z; package _use; package _aggregate; import language.implicitConversions

object reduce:

  inline def opt[A](x: ~[A], inline f: (A,A) => A) : Opt[A] = inline x match
    case _ :  ~[A & Boolean.Raw] => boolean_Opt(x.cast[~[Boolean]],(x,y) => f(x.cast[A],y.cast[A]).cast[Boolean]).cast[A]
    case _ :  ~[A & Byte.Raw]    => byte_Opt   (x.cast[~[Byte]],   (x,y) => f(x.cast[A],y.cast[A]).cast[Byte   ]).cast[A]
    case _ :  ~[A & Short.Raw]   => short_Opt  (x.cast[~[Short]],  (x,y) => f(x.cast[A],y.cast[A]).cast[Short  ]).cast[A]
    case _ :  ~[A & Char.Raw]    => char_Opt   (x.cast[~[Char]],   (x,y) => f(x.cast[A],y.cast[A]).cast[Char   ]).cast[A]
    case _ :  ~[A & Int.Raw]     => int_Opt    (x.cast[~[Int]],    (x,y) => f(x.cast[A],y.cast[A]).cast[Int    ]).cast[A]
    case _ :  ~[A & Long.Raw]    => long_Opt   (x.cast[~[Long]],   (x,y) => f(x.cast[A],y.cast[A]).cast[Long   ]).cast[A]
    case _ :  ~[A & Float.Raw]   => float_Opt  (x.cast[~[Float]],  (x,y) => f(x.cast[A],y.cast[A]).cast[Float  ]).cast[A]
    case _ :  ~[A & Double.Raw]  => double_Opt (x.cast[~[Double]], (x,y) => f(x.cast[A],y.cast[A]).cast[Double ]).cast[A]
    case _                       => ref_Opt(x,f)

  def ref_Opt[A] (x: ~[A],      f: (A,A) => A      ): Opt[A]       = x.read_?.map(v => fold.ref(x,v,f))
  def boolean_Opt(x: ~[Boolean],f: Boolean.Fun.Fold): Opt[Boolean] = x.read_?.map(v => fold.boolean(x,v,f))
  def byte_Opt   (x: ~[Byte],   f: Byte.Fun.Fold   ): Opt[Byte]    = x.read_?.map(v => fold.byte(x,v,f))
  def char_Opt   (x: ~[Char],   f: Char.Fun.Fold   ): Opt[Char]    = x.read_?.map(v => fold.char(x,v,f))
  def short_Opt  (x: ~[Short],  f: Short.Fun.Fold  ): Opt[Short]   = x.read_?.map(v => fold.short(x,v,f))
  def int_Opt    (x: ~[Int],    f: Int.Fun.Fold    ): Opt[Int]     = x.read_?.map(v => fold.int(x,v,f))
  def long_Opt   (x: ~[Long],   f: Long.Fun.Fold   ): Opt[Long]    = x.read_?.map(v => fold.long(x,v,f))
  def float_Opt  (x: ~[Float],  f: Float.Fun.Fold  ): Opt[Float]   = x.read_?.map(v => fold.float(x,v,f))
  def double_Opt (x: ~[Double], f: Double.Fun.Fold ): Opt[Double]  = x.read_?.map(v => fold.double(x,v,f))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
