package scalqa; package `val`; package stream; package z; package a; import language.implicitConversions

object Map:
  abstract class ToRef    [A]                 (x: AnyRef) extends                Pipe[A](x) with Able.Size.Opt.Long{ @tn("sizeLong_Opt") def sizeLong_? = Able.Size.sizeLong_?(x)}
  abstract class ToBoolean[A<:Boolean.Raw](x: AnyRef) extends lang.boolean.Z.Pipe[A](x) with Able.Size.Opt.Long{ @tn("sizeLong_Opt") def sizeLong_? = Able.Size.sizeLong_?(x)}
  abstract class ToByte   [A<:Byte.Raw]   (x: AnyRef) extends lang.byte   .Z.Pipe[A](x) with Able.Size.Opt.Long{ @tn("sizeLong_Opt") def sizeLong_? = Able.Size.sizeLong_?(x)}
  abstract class ToChar   [A<:Char.Raw]   (x: AnyRef) extends lang.char   .Z.Pipe[A](x) with Able.Size.Opt.Long{ @tn("sizeLong_Opt") def sizeLong_? = Able.Size.sizeLong_?(x)}
  abstract class ToShort  [A<:Short.Raw]  (x: AnyRef) extends lang.short  .Z.Pipe[A](x) with Able.Size.Opt.Long{ @tn("sizeLong_Opt") def sizeLong_? = Able.Size.sizeLong_?(x)}
  abstract class ToInt    [A<:Int.Raw]    (x: AnyRef) extends lang.int    .Z.Pipe[A](x) with Able.Size.Opt.Long{ @tn("sizeLong_Opt") def sizeLong_? = Able.Size.sizeLong_?(x)}
  abstract class ToLong   [A<:Long.Raw]   (x: AnyRef) extends lang.long   .Z.Pipe[A](x) with Able.Size.Opt.Long{ @tn("sizeLong_Opt") def sizeLong_? = Able.Size.sizeLong_?(x)}
  abstract class ToFloat  [A<:Float.Raw]  (x: AnyRef) extends lang.float  .Z.Pipe[A](x) with Able.Size.Opt.Long{ @tn("sizeLong_Opt") def sizeLong_? = Able.Size.sizeLong_?(x)}
  abstract class ToDouble [A<:Double.Raw] (x: AnyRef) extends lang.double .Z.Pipe[A](x) with Able.Size.Opt.Long{ @tn("sizeLong_Opt") def sizeLong_? = Able.Size.sizeLong_?(x)}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
