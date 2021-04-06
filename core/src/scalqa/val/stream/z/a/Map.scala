package scalqa; package `val`; package stream; package z; package a; import language.implicitConversions

object Map:
  abstract class ToRef    [A]                 (x: Ref) extends                 Pipe[A](x) with Able.Size.Opt.Long{ @tn("sizeLong_Opt") def sizeLong_? = Able.Size.sizeLong_?(x)}
  abstract class ToBoolean[A<:Any.Raw.Boolean](x: Ref) extends lang.boolean.Z.Pipe[A](x) with Able.Size.Opt.Long{ @tn("sizeLong_Opt") def sizeLong_? = Able.Size.sizeLong_?(x)}
  abstract class ToByte   [A<:Any.Raw.Byte]   (x: Ref) extends lang.byte   .Z.Pipe[A](x) with Able.Size.Opt.Long{ @tn("sizeLong_Opt") def sizeLong_? = Able.Size.sizeLong_?(x)}
  abstract class ToChar   [A<:Any.Raw.Char]   (x: Ref) extends lang.char   .Z.Pipe[A](x) with Able.Size.Opt.Long{ @tn("sizeLong_Opt") def sizeLong_? = Able.Size.sizeLong_?(x)}
  abstract class ToShort  [A<:Any.Raw.Short]  (x: Ref) extends lang.short  .Z.Pipe[A](x) with Able.Size.Opt.Long{ @tn("sizeLong_Opt") def sizeLong_? = Able.Size.sizeLong_?(x)}
  abstract class ToInt    [A<:Any.Raw.Int]    (x: Ref) extends lang.int    .Z.Pipe[A](x) with Able.Size.Opt.Long{ @tn("sizeLong_Opt") def sizeLong_? = Able.Size.sizeLong_?(x)}
  abstract class ToLong   [A<:Any.Raw.Long]   (x: Ref) extends lang.long   .Z.Pipe[A](x) with Able.Size.Opt.Long{ @tn("sizeLong_Opt") def sizeLong_? = Able.Size.sizeLong_?(x)}
  abstract class ToFloat  [A<:Any.Raw.Float]  (x: Ref) extends lang.float  .Z.Pipe[A](x) with Able.Size.Opt.Long{ @tn("sizeLong_Opt") def sizeLong_? = Able.Size.sizeLong_?(x)}
  abstract class ToDouble [A<:Any.Raw.Double] (x: Ref) extends lang.double .Z.Pipe[A](x) with Able.Size.Opt.Long{ @tn("sizeLong_Opt") def sizeLong_? = Able.Size.sizeLong_?(x)}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
