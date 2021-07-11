package scalqa; package `val`; import language.implicitConversions;

import Lang.Any.{ Raw as RAW }

object Opt extends opt._methods:
  type AnyType[A] = Opt[A] | RawType[A]
  type RawType[A] = lang.boolean.G.Opt[A & Raw.Boolean] | lang.byte.G.Opt[A & Raw.Byte] | lang.char .G.Opt[A & Raw.Char]  | lang.short .G.Opt[A & Raw.Short]
                  | lang.int    .G.Opt[A & Raw.Int]     | lang.long.G.Opt[A & Raw.Long] | lang.float.G.Opt[A & Raw.Float] | lang.double.G.Opt[A & Raw.Double]

  /**/              def apply[A](v: A)                                          : Opt[A]    = v.cast[AnyRef].cast[Opt[A]]
  /**/       inline def fromScala[A](v: scala.Option[A])                        : Opt[A]    = if (v.isEmpty) \/ else v.get
  /**/       inline def fromJava [A](v: java.util.Optional[A])                  : Opt[A]    = if (v.isPresent) v.get else \/
  @tn("getVoid")    def void[A]                                                 : Opt[A]    = ZZ.None.cast[Opt[A]]

  implicit   inline def implicitFromScala[A](v: scala.Option[A])                          : Opt[A]    = fromScala[A](v)
  implicit   inline def implicitFromJava [A](v: java.util.Optional[A])                    : Opt[A]    = fromJava[A](v)
  implicit   inline def implicitFromResult[A](inline v: Result[A])                        : Opt[A]    = v.value_?
  implicit   inline def implicitToBoolean[A]( inline v: Opt[A])                           : Boolean   = v.nonEmpty
  implicit   inline def implicitRequest[A](inline v: \/)                                  : Opt[A]    = ZZ.None.cast[Opt[A]]
  implicit   inline def implicitFromBooleanOpt[A<:RAW.Boolean](inline v: Boolean.G.Opt[A]): Opt[A]    = v.ref
  implicit   inline def implicitFromByteOpt   [A<:RAW.Byte]   (inline v: Byte.G.Opt[A])   : Opt[A]    = v.ref
  implicit   inline def implicitFromCharOpt   [A<:RAW.Char]   (inline v: Char.G.Opt[A])   : Opt[A]    = v.ref
  implicit   inline def implicitFromShortOpt  [A<:RAW.Short]  (inline v: Short.G.Opt[A])  : Opt[A]    = v.ref
  implicit   inline def implicitFromIntOpt    [A<:RAW.Int]    (inline v: Int.G.Opt[A])    : Opt[A]    = v.ref
  implicit   inline def implicitFromLongOpt   [A<:RAW.Long]   (inline v: Long.G.Opt[A])   : Opt[A]    = v.ref
  implicit   inline def implicitFromFloatOpt  [A<:RAW.Float]  (inline v: Float.G.Opt[A])  : Opt[A]    = v.ref
  implicit   inline def implicitFromDoubleOpt [A<:RAW.Double] (inline v: Double.G.Opt[A]) : Opt[A]    = v.ref
  implicit   inline def implicitFromFromValue[A](inline v: A)                             : Opt[A]    = v.cast[Opt[A]]
  implicit   inline def implicitFromValue[A<:Raw.Boolean](inline v: A)                    : Opt[A]    = java.lang.Boolean.valueOf(v.real).cast[Opt[A]]
  implicit   inline def implicitFromValue[A<:Raw.Byte](inline v: A)                       : Opt[A]    = java.lang.Byte.valueOf(v.real).cast[Opt[A]]
  implicit   inline def implicitFromValue[A<:Raw.Char](inline v: A)                       : Opt[A]    = java.lang.Character.valueOf(v.real).cast[Opt[A]]
  implicit   inline def implicitFromValue[A<:Raw.Short](inline v: A)                      : Opt[A]    = java.lang.Short.valueOf(v.real).cast[Opt[A]]
  implicit   inline def implicitFromValue[A<:Raw.Int](inline v: A)                        : Opt[A]    = java.lang.Integer.valueOf(v.real).cast[Opt[A]]
  implicit   inline def implicitFromValue[A<:Raw.Long](inline v: A)                       : Opt[A]    = java.lang.Long.valueOf(v.real).cast[Opt[A]]
  implicit   inline def implicitFromValue[A<:Raw.Float](inline v: A)                      : Opt[A]    = java.lang.Float.valueOf(v.real).cast[Opt[A]]
  implicit   inline def implicitFromValue[A<:Raw.Double](inline v: A)                     : Opt[A]    = java.lang.Double.valueOf(v.real).cast[Opt[A]]

  object opaque:
    opaque type `type`[+A] <: Opaque.Ref = Opaque.Ref

  // **************************************
  private[scalqa] object None:
    override def equals(v: scala.Any) = false
    override def toString             = "Opt.\\/"

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object opaque -> ### Value Option

      [[Opt]] is a container, which can hold a single value or be empty

      Option can be converted to value with method `or`, which also takes default value for the case when option is empty

      Option is often used as Boolean, where ''Option'' with value is converted to 'true' and empty option is converted to 'false'

      By Scalqa convention, method names, which return [[Opt]] type, are ended with '_?' instead of word 'Option'

      ```
      val l: Lookup[Int,String] = ?_?_?

      val o: Opt[String] = l.get_?(12)

      if(o) println("Value found.")
      else  println("Value not found.")
      ```

@def void  -> Get void instance

@def implicitRequest -> General void instance request \n\n It is possible to use general request \\/ to get void instance of this type, thanks to this implicit conversion.

*/