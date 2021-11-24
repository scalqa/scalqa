package scalqa; package `val`; package stream; package z; package x; import language.implicitConversions

abstract class Pipe[A](val base: AnyRef) extends Stream[A] with Custom.Pipeline

object Pipe:
  abstract class asBoolean(val base: AnyRef) extends Boolean.Stream with Custom.Pipeline
  abstract class asByte   (val base: AnyRef) extends Byte   .Stream with Custom.Pipeline
  abstract class asChar   (val base: AnyRef) extends Char   .Stream with Custom.Pipeline
  abstract class asShort  (val base: AnyRef) extends Short  .Stream with Custom.Pipeline
  abstract class asInt    (val base: AnyRef) extends Int    .Stream with Custom.Pipeline
  abstract class asLong   (val base: AnyRef) extends Long   .Stream with Custom.Pipeline
  abstract class asFloat  (val base: AnyRef) extends Float  .Stream with Custom.Pipeline
  abstract class asDouble (val base: AnyRef) extends Double .Stream with Custom.Pipeline

  abstract class Sized[A](x: AnyRef) extends Pipe[A](x) with Able.Size.Opt.Long:
    def sizeLongOpt : Long.Opt = Able.Size.sizeLongOpt(x)

  abstract class Calc[A](x: AnyRef) extends Pipe[A](x) with Able.Size.Opt.Long:
    /**/  private       var in          : Boolean   = false
    @fast private  lazy val result      : Stream[A] = { in=true; calc }
    /**/  protected     def calc        : Stream[A]
    /**/                def sizeLongOpt : Long.Opt  = (in ? result).mapOpt(_.sizeLongOpt)
    /**/                def readOpt     : Opt[A]    = result.readOpt

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
