package scalqa; package `val`; package stream; package z; package x; import language.implicitConversions

import Able.Size.Opt.{ Long as SIZED }

abstract   class Map[A]   (x: AnyRef) extends Pipe       [A](x) with SIZED{ @tn("sizeLong_Opt") def sizeLong_? = Able.Size.sizeLong_?(x)}
object Map:
  abstract class AsBoolean(x: AnyRef) extends Pipe.asBoolean(x) with SIZED{ @tn("sizeLong_Opt") def sizeLong_? = Able.Size.sizeLong_?(x)}
  abstract class AsByte   (x: AnyRef) extends Pipe.asByte   (x) with SIZED{ @tn("sizeLong_Opt") def sizeLong_? = Able.Size.sizeLong_?(x)}
  abstract class AsChar   (x: AnyRef) extends Pipe.asChar   (x) with SIZED{ @tn("sizeLong_Opt") def sizeLong_? = Able.Size.sizeLong_?(x)}
  abstract class AsShort  (x: AnyRef) extends Pipe.asShort  (x) with SIZED{ @tn("sizeLong_Opt") def sizeLong_? = Able.Size.sizeLong_?(x)}
  abstract class AsInt    (x: AnyRef) extends Pipe.asInt    (x) with SIZED{ @tn("sizeLong_Opt") def sizeLong_? = Able.Size.sizeLong_?(x)}
  abstract class AsLong   (x: AnyRef) extends Pipe.asLong   (x) with SIZED{ @tn("sizeLong_Opt") def sizeLong_? = Able.Size.sizeLong_?(x)}
  abstract class AsFloat  (x: AnyRef) extends Pipe.asFloat  (x) with SIZED{ @tn("sizeLong_Opt") def sizeLong_? = Able.Size.sizeLong_?(x)}
  abstract class AsDouble (x: AnyRef) extends Pipe.asDouble (x) with SIZED{ @tn("sizeLong_Opt") def sizeLong_? = Able.Size.sizeLong_?(x)}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
