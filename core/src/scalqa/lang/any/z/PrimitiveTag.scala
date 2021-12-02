package scalqa; package lang; package any; package z; import language.implicitConversions

trait PrimitiveTag

object PrimitiveTag:
  trait Boolean extends PrimitiveTag
  trait Byte    extends PrimitiveTag
  trait Char    extends PrimitiveTag
  trait Short   extends PrimitiveTag
  trait Int     extends PrimitiveTag
  trait Long    extends PrimitiveTag
  trait Float   extends PrimitiveTag
  trait Double  extends PrimitiveTag

  @tn("opt") def ?(v: AnyRef): Opt[String] = v match
    case v: Boolean => "Boolean"
    case v: Byte    => "Byte"
    case v: Char    => "Char"
    case v: Short   => "Short"
    case v: Int     => "Int"
    case v: Long    => "Long"
    case v: Float   => "Float"
    case v: Double  => "Double"
    case _          => VOID

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
