package scalqa; package `val`; package stream; package z; package x; import language.implicitConversions

abstract class Pipe[A](val base: AnyRef) extends ~[A] with Custom.Pipeline

object Pipe:
  abstract class asBoolean(val base: AnyRef) extends Boolean.~ with Custom.Pipeline
  abstract class asByte   (val base: AnyRef) extends Byte   .~ with Custom.Pipeline
  abstract class asChar   (val base: AnyRef) extends Char   .~ with Custom.Pipeline
  abstract class asShort  (val base: AnyRef) extends Short  .~ with Custom.Pipeline
  abstract class asInt    (val base: AnyRef) extends Int    .~ with Custom.Pipeline
  abstract class asLong   (val base: AnyRef) extends Long   .~ with Custom.Pipeline
  abstract class asFloat  (val base: AnyRef) extends Float  .~ with Custom.Pipeline
  abstract class asDouble (val base: AnyRef) extends Double .~ with Custom.Pipeline

  abstract class Sized[A](x: AnyRef) extends Pipe[A](x) with Able.Size.Opt.Long:
    @tn("sizeLong_Opt") def sizeLong_? : Long.Opt = Able.Size.sizeLong_?(x)

  abstract class Calc[A](x: AnyRef) extends Pipe[A](x) with Able.Size.Opt.Long:
    /**/  private       var in         : Boolean  = false
    @fast private  lazy val result     : ~[A]     = { in=true; calc }
    /**/  protected     def calc       : ~[A]
    @tn("sizeLong_Opt") def sizeLong_? : Long.Opt = (in ? result).map_?(_.sizeLong_?)
    @tn("read_Opt")     def read_?     : Opt[A]   = result.read_?

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
