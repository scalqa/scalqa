package scalqa; package `val`; package stream; package z; package a; import language.implicitConversions

abstract class Pipe[A](val base: AnyRef) extends ~[A] with Custom.Pipeline

object Pipe:
  type Refs    [A]              = Pipe[A]
  type Booleans[A<:Boolean.Raw] = lang.boolean.Z.Pipe[A]
  type Bytes   [A<:Byte.Raw]    = lang.byte   .Z.Pipe[A]
  type Chars   [A<:Char.Raw]    = lang.char   .Z.Pipe[A]
  type Shorts  [A<:Short.Raw]   = lang.short  .Z.Pipe[A]
  type Ints    [A<:Int.Raw]     = lang.int    .Z.Pipe[A]
  type Longs   [A<:Long.Raw]    = lang.long   .Z.Pipe[A]
  type Floats  [A<:Float.Raw]   = lang.float  .Z.Pipe[A]
  type Doubles [A<:Double.Raw]  = lang.double .Z.Pipe[A]

  abstract class Sized[A](x: AnyRef) extends Pipe[A](x) with Able.Size.Opt.Long:
    @tn("sizeLong_Opt") def sizeLong_? : Long.Opt = Able.Size.sizeLong_?(x)

  abstract class Calculated[A](x: AnyRef) extends Pipe[A](x) with Able.Size.Opt.Long:
    private             var in         : Boolean  = false
    @fast private  lazy val _result    : ~[A]     = { in=true; calculate }
    protected           def calculate  : ~[A]
    /**/                def result     : ~[A]     = _result
    @tn("sizeLong_Opt") def sizeLong_? : Long.Opt = _result.sizeLong_?
    @tn("read_Opt")     def read_?     : Opt[A]   = _result.read_?

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
