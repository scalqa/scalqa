package scalqa; package `val`; package stream; package z; package a; import language.implicitConversions

abstract class Pipe[A](val base: AnyRef) extends ~[A] with Custom.Pipeline

object Pipe:
  type ofRef[A] = Pipe[A]
  abstract class ofBoolean[A<:Boolean.Raw](val base: AnyRef) extends Boolean.G.~[A] with Custom.Pipeline
  abstract class ofByte   [A<:Byte.Raw   ](val base: AnyRef) extends Byte   .G.~[A] with Custom.Pipeline
  abstract class ofChar   [A<:Char.Raw   ](val base: AnyRef) extends Char   .G.~[A] with Custom.Pipeline
  abstract class ofShort  [A<:Short.Raw  ](val base: AnyRef) extends Short  .G.~[A] with Custom.Pipeline
  abstract class ofInt    [A<:Int.Raw    ](val base: AnyRef) extends Int    .G.~[A] with Custom.Pipeline
  abstract class ofLong   [A<:Long.Raw   ](val base: AnyRef) extends Long   .G.~[A] with Custom.Pipeline
  abstract class ofFloat  [A<:Float.Raw  ](val base: AnyRef) extends Float  .G.~[A] with Custom.Pipeline
  abstract class ofDouble [A<:Double.Raw ](val base: AnyRef) extends Double .G.~[A] with Custom.Pipeline

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
