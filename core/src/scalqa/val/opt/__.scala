package scalqa; package `val`; import language.implicitConversions;

object Opt extends opt._methods:
  type AnyType[A] = Opt[A] | RawType[A]
  type RawType[A] = lang.boolean.G.Opt[A & Boolean.Raw] | lang.byte.G.Opt[A & Byte.Raw] | lang.char .G.Opt[A & Char.Raw]  | lang.short .G.Opt[A & Short.Raw]
                  | lang.int    .G.Opt[A & Int.Raw]     | lang.long.G.Opt[A & Long.Raw] | lang.float.G.Opt[A & Float.Raw] | lang.double.G.Opt[A & Double.Raw]

  /**/              def apply[A](v: A)                                                    : Opt[A]    = v.cast[AnyRef].cast[Opt[A]]
  /**/       inline def fromScala[A](v: scala.Option[A])                                  : Opt[A]    = if (v.isEmpty) \/ else v.get
  /**/       inline def fromJava [A](v: java.util.Optional[A])                            : Opt[A]    = if (v.isPresent) v.get else \/
  @tn("getVoid")    def void[A]                                                           : Opt[A]    = ZZ.None.cast[Opt[A]]

  implicit   inline def implicitToBoolean[A]( inline v: Opt[A])                           : Boolean   = v.nonEmpty
  implicit   inline def implicitFrom[A](v: scala.Option[A])                               : Opt[A]    = fromScala[A](v)
  implicit   inline def implicitFrom[A](v: java.util.Optional[A])                         : Opt[A]    = fromJava[A](v)
  implicit   inline def implicitFrom[A](inline v: \/)                                     : Opt[A]    = ZZ.None.cast[Opt[A]]
  implicit   inline def implicitFromResult[A](inline v: Result[A])                        : Opt[A]    = v.value_?
  implicit   inline def implicitFromBooleanOpt[A<:Boolean.Raw](inline v: Boolean.G.Opt[A]): Opt[A]    = v.ref
  implicit   inline def implicitFromByteOpt   [A<:Byte.Raw]   (inline v: Byte.G.Opt[A])   : Opt[A]    = v.ref
  implicit   inline def implicitFromCharOpt   [A<:Char.Raw]   (inline v: Char.G.Opt[A])   : Opt[A]    = v.ref
  implicit   inline def implicitFromShortOpt  [A<:Short.Raw]  (inline v: Short.G.Opt[A])  : Opt[A]    = v.ref
  implicit   inline def implicitFromIntOpt    [A<:Int.Raw]    (inline v: Int.G.Opt[A])    : Opt[A]    = v.ref
  implicit   inline def implicitFromLongOpt   [A<:Long.Raw]   (inline v: Long.G.Opt[A])   : Opt[A]    = v.ref
  implicit   inline def implicitFromFloatOpt  [A<:Float.Raw]  (inline v: Float.G.Opt[A])  : Opt[A]    = v.ref
  implicit   inline def implicitFromDoubleOpt [A<:Double.Raw] (inline v: Double.G.Opt[A]) : Opt[A]    = v.ref
  implicit   inline def implicitFromFromValue[A](inline v: A)                             : Opt[A]    = v.cast[Opt[A]]
  implicit   inline def implicitFromValue[A<:Boolean.Raw](inline v: A)                    : Opt[A]    = java.lang.Boolean  .valueOf(v.cast[Boolean]).cast[Opt[A]]
  implicit   inline def implicitFromValue[A<:Byte.Raw](inline v: A)                       : Opt[A]    = java.lang.Byte     .valueOf(v.cast[Byte]   ).cast[Opt[A]]
  implicit   inline def implicitFromValue[A<:Char.Raw](inline v: A)                       : Opt[A]    = java.lang.Character.valueOf(v.cast[Char]   ).cast[Opt[A]]
  implicit   inline def implicitFromValue[A<:Short.Raw](inline v: A)                      : Opt[A]    = java.lang.Short    .valueOf(v.cast[Short]  ).cast[Opt[A]]
  implicit   inline def implicitFromValue[A<:Int.Raw](inline v: A)                        : Opt[A]    = java.lang.Integer  .valueOf(v.cast[Int]    ).cast[Opt[A]]
  implicit   inline def implicitFromValue[A<:Long.Raw](inline v: A)                       : Opt[A]    = java.lang.Long     .valueOf(v.cast[Long]   ).cast[Opt[A]]
  implicit   inline def implicitFromValue[A<:Float.Raw](inline v: A)                      : Opt[A]    = java.lang.Float    .valueOf(v.cast[Float]  ).cast[Opt[A]]
  implicit   inline def implicitFromValue[A<:Double.Raw](inline v: A)                     : Opt[A]    = java.lang.Double   .valueOf(v.cast[Double] ).cast[Opt[A]]

  object OPAQUE:
    opaque type TYPE[+A] <: AnyRef.Opaque = AnyRef.Opaque

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
@object OPAQUE  -> ### Value Option

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

@def implicitFrom    -> General void instance request \n\n It is possible to use general request \\/ to get void instance of this type, thanks to this implicit conversion.

*/