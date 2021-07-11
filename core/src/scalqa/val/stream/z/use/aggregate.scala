package scalqa; package `val`; package stream; package z; package use; import language.implicitConversions

object aggregate:

  transparent inline def _foldAs[A,B](inline x: ~[A], inline s: B, inline f: (B,A) => B) : B  = inline x match
    case _ : ~[A & Raw.Boolean] => { var r = s; process.foreachBoolean(x.cast[~[Boolean]],v => r = f(r,v.cast[A])); r}
    case _ : ~[A & Raw.Byte]    => { var r = s; process.foreachByte(   x.cast[~[Byte]],   v => r = f(r,v.cast[A])); r}
    case _ : ~[A & Raw.Short]   => { var r = s; process.foreachShort(  x.cast[~[Short]],  v => r = f(r,v.cast[A])); r}
    case _ : ~[A & Raw.Char]    => { var r = s; process.foreachChar(   x.cast[~[Char]],   v => r = f(r,v.cast[A])); r}
    case _ : ~[A & Raw.Int]     => { var r = s; process.foreachInt(    x.cast[~[Int]],    v => r = f(r,v.cast[A])); r}
    case _ : ~[A & Raw.Long]    => { var r = s; process.foreachLong(   x.cast[~[Long]],   v => r = f(r,v.cast[A])); r}
    case _ : ~[A & Raw.Float]   => { var r = s; process.foreachFloat(  x.cast[~[Float]],  v => r = f(r,v.cast[A])); r}
    case _ : ~[A & Raw.Double]  => { var r = s; process.foreachDouble( x.cast[~[Double]], v => r = f(r,v.cast[A])); r}
    case _                      => foldAs(x,s,f)

  def foldAs[A,B](x: ~[A], s: B, f: (B,A) => B) : B  = { var r = s; x.FOREACH(v => r = f(r,v)); r}

  inline def _fold[A](inline x: ~[A], inline s: A, inline f: (A,A) => A) : A  = inline s match
    case _ : Raw.Boolean => foldBoolean(x.cast[~[Boolean]],s.cast[Boolean],(x,y) => f(x.cast[A],y.cast[A]).cast[Boolean]).cast[A]
    case _ : Raw.Byte    => foldByte   (x.cast[~[Byte]],   s.cast[Byte],   (x,y) => f(x.cast[A],y.cast[A]).cast[Byte   ]).cast[A]
    case _ : Raw.Short   => foldShort  (x.cast[~[Short]],  s.cast[Short],  (x,y) => f(x.cast[A],y.cast[A]).cast[Short  ]).cast[A]
    case _ : Raw.Char    => foldChar   (x.cast[~[Char]],   s.cast[Char],   (x,y) => f(x.cast[A],y.cast[A]).cast[Char   ]).cast[A]
    case _ : Raw.Int     => foldInt    (x.cast[~[Int]],    s.cast[Int],    (x,y) => f(x.cast[A],y.cast[A]).cast[Int    ]).cast[A]
    case _ : Raw.Long    => foldLong   (x.cast[~[Long]],   s.cast[Long],   (x,y) => f(x.cast[A],y.cast[A]).cast[Long   ]).cast[A]
    case _ : Raw.Float   => foldFloat  (x.cast[~[Float]],  s.cast[Float],  (x,y) => f(x.cast[A],y.cast[A]).cast[Float  ]).cast[A]
    case _ : Raw.Double  => foldDouble (x.cast[~[Double]], s.cast[Double], (x,y) => f(x.cast[A],y.cast[A]).cast[Double ]).cast[A]
    case _               => fold(x,s,f)

  def fold[A](x: ~[A], s: A, f: (A,A) => A) : A = { var r = s; x.FOREACH(fv => r = f(r,fv)); r}
  def foldBoolean(x: ~[Boolean],s: Boolean, f: Boolean.Fun.Fold): Boolean = x match {case x: Boolean.~ => x.fold(s)(f); case _ => {var v=s; var o=x.read_?; while(o.nonEmpty){v=f(v,o.`val`); o=x.read_?};v}}
  def foldByte   (x: ~[Byte],   s: Byte,    f: Byte.Fun.Fold   ): Byte    = x match {case x: Byte.~    => x.fold(s)(f); case _ => {var v=s; var o=x.read_?; while(o.nonEmpty){v=f(v,o.`val`); o=x.read_?};v}}
  def foldChar   (x: ~[Char],   s: Char,    f: Char.Fun.Fold   ): Char    = x match {case x: Char.~    => x.fold(s)(f); case _ => {var v=s; var o=x.read_?; while(o.nonEmpty){v=f(v,o.`val`); o=x.read_?};v}}
  def foldShort  (x: ~[Short],  s: Short,   f: Short.Fun.Fold  ): Short   = x match {case x: Short.~   => x.fold(s)(f); case _ => {var v=s; var o=x.read_?; while(o.nonEmpty){v=f(v,o.`val`); o=x.read_?};v}}
  def foldInt    (x: ~[Int],    s: Int,     f: Int.Fun.Fold    ): Int     = x match {case x: Int.~     => x.fold(s)(f); case _ => {var v=s; var o=x.read_?; while(o.nonEmpty){v=f(v,o.`val`); o=x.read_?};v}}
  def foldLong   (x: ~[Long],   s: Long,    f: Long.Fun.Fold   ): Long    = x match {case x: Long.~    => x.fold(s)(f); case _ => {var v=s; var o=x.read_?; while(o.nonEmpty){v=f(v,o.`val`); o=x.read_?};v}}
  def foldFloat  (x: ~[Float],  s: Float,   f: Float.Fun.Fold  ): Float   = x match {case x: Float.~   => x.fold(s)(f); case _ => {var v=s; var o=x.read_?; while(o.nonEmpty){v=f(v,o.`val`); o=x.read_?};v}}
  def foldDouble (x: ~[Double], s: Double,  f: Double.Fun.Fold ): Double  = x match {case x: Double.~  => x.fold(s)(f); case _ => {var v=s; var o=x.read_?; while(o.nonEmpty){v=f(v,o.`val`); o=x.read_?};v}}

  inline def _reduce_Opt[A](x: ~[A], inline f: (A,A) => A) : Opt[A] = inline x match
    case _ :  ~[A & Raw.Boolean] => reduceBoolean_Opt(x.cast[~[Boolean]],(x,y) => f(x.cast[A],y.cast[A]).cast[Boolean]).cast[A]
    case _ :  ~[A & Raw.Byte]    => reduceByte_Opt   (x.cast[~[Byte]],   (x,y) => f(x.cast[A],y.cast[A]).cast[Byte   ]).cast[A]
    case _ :  ~[A & Raw.Short]   => reduceShort_Opt  (x.cast[~[Short]],  (x,y) => f(x.cast[A],y.cast[A]).cast[Short  ]).cast[A]
    case _ :  ~[A & Raw.Char]    => reduceChar_Opt   (x.cast[~[Char]],   (x,y) => f(x.cast[A],y.cast[A]).cast[Char   ]).cast[A]
    case _ :  ~[A & Raw.Int]     => reduceInt_Opt    (x.cast[~[Int]],    (x,y) => f(x.cast[A],y.cast[A]).cast[Int    ]).cast[A]
    case _ :  ~[A & Raw.Long]    => reduceLong_Opt   (x.cast[~[Long]],   (x,y) => f(x.cast[A],y.cast[A]).cast[Long   ]).cast[A]
    case _ :  ~[A & Raw.Float]   => reduceFloat_Opt  (x.cast[~[Float]],  (x,y) => f(x.cast[A],y.cast[A]).cast[Float  ]).cast[A]
    case _ :  ~[A & Raw.Double]  => reduceDouble_Opt (x.cast[~[Double]], (x,y) => f(x.cast[A],y.cast[A]).cast[Double ]).cast[A]
    case _                       => reduce_Opt(x,f)

  def reduce_Opt    [A](x: ~[A],      f: (A,A) => A      ): Opt[A]       = x.read_?.map(v => fold(x,v,f))
  def reduceBoolean_Opt(x: ~[Boolean],f: Boolean.Fun.Fold): Opt[Boolean] = x.read_?.map(v => foldBoolean(x,v,f))
  def reduceByte_Opt   (x: ~[Byte],   f: Byte.Fun.Fold   ): Opt[Byte]    = x.read_?.map(v => foldByte(x,v,f))
  def reduceChar_Opt   (x: ~[Char],   f: Char.Fun.Fold   ): Opt[Char]    = x.read_?.map(v => foldChar(x,v,f))
  def reduceShort_Opt  (x: ~[Short],  f: Short.Fun.Fold  ): Opt[Short]   = x.read_?.map(v => foldShort(x,v,f))
  def reduceInt_Opt    (x: ~[Int],    f: Int.Fun.Fold    ): Opt[Int]     = x.read_?.map(v => foldInt(x,v,f))
  def reduceLong_Opt   (x: ~[Long],   f: Long.Fun.Fold   ): Opt[Long]    = x.read_?.map(v => foldLong(x,v,f))
  def reduceFloat_Opt  (x: ~[Float],  f: Float.Fun.Fold  ): Opt[Float]   = x.read_?.map(v => foldFloat(x,v,f))
  def reduceDouble_Opt (x: ~[Double], f: Double.Fun.Fold ): Opt[Double]  = x.read_?.map(v => foldDouble(x,v,f))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
