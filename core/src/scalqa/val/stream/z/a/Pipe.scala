package scalqa; package `val`; package stream; package z; package a; import language.implicitConversions

abstract class Pipe[A](val base: Ref) extends ~[A] with Custom.Pipeline

object Pipe:
  type Ref[A]  = Pipe[A]
  type Booleans[A<:Any.Raw.Boolean] = `def`.boolean.Z.Pipe[A]
  type Bytes   [A<:Any.Raw.Byte]    = `def`.byte   .Z.Pipe[A]
  type Chars   [A<:Any.Raw.Char]    = `def`.char   .Z.Pipe[A]
  type Shorts  [A<:Any.Raw.Short]   = `def`.short  .Z.Pipe[A]
  type Ints    [A<:Any.Raw.Int]     = `def`.int    .Z.Pipe[A]
  type Longs   [A<:Any.Raw.Long]    = `def`.long   .Z.Pipe[A]
  type Floats  [A<:Any.Raw.Float]   = `def`.float  .Z.Pipe[A]
  type Doubles [A<:Any.Raw.Double]  = `def`.double .Z.Pipe[A]

  abstract class Sized[A](x: Any.Ref) extends Pipe[A](x) with Able.Size.Opt.Long:
    @tn("sizeLong_Opt") def sizeLong_? : Long.Opt = Able.Size.sizeLong_?(x)

  abstract class Calculated[A](x: Any.Ref) extends Pipe[A](x) with Able.Size.Opt.Long:
    private             var in         : scala.Boolean = false
    @fast private  lazy val _result    : ~[A]          = { in=true; calculate }
    protected           def calculate  : ~[A]
    /**/                def result     : ~[A]          = _result
    @tn("sizeLong_Opt") def sizeLong_? : Long.Opt      = _result.sizeLong_?
    @tn("read_Opt")     def read_?     : Opt[A]        = _result.read_?

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
