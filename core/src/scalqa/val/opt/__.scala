package scalqa; package `val`; import language.implicitConversions;

object Opt extends opt._extension:
  /**/              def apply[A](v: A)                                              : Opt[A]    = v.cast[AnyRef].cast[Opt[A]]
  ///**/       inline def apply[A](inline v: A)                                       : Opt[A]    = v.cast[AnyRef].cast[Opt[A]]
  /**/       inline def fromScala[A](v: scala.Option[A])                            : Opt[A]    = if (v.isEmpty) \/ else v.get
  /**/       inline def fromJava [A](v: java.util.Optional[A])                      : Opt[A]    = if (v.isPresent) v.get else \/
  @tn("getVoid")    def void[A]                                                     : Opt[A]    = ZZ.None.cast[Opt[A]]

  implicit   inline def xxFromScala[A](v: scala.Option[A])                          : Opt[A]    = fromScala[A](v)
  implicit   inline def xxFromJava [A](v: java.util.Optional[A])                    : Opt[A]    = fromJava[A](v)
  implicit   inline def xxFromResult[A](inline v: Result[A])                        : Opt[A]    = v.value_?
  implicit   inline def xx_Boolean[A]( inline v: Opt[A])                            : Boolean   = v.nonEmpty
  implicit   inline def xxRequest[A](inline v: \/)                                  : Opt[A]    = ZZ.None.cast[Opt[A]]
  implicit   inline def xxBooleanOpt[A<:Any.Raw.Boolean](inline v: Boolean.G.Opt[A]): Opt[A]    = v.ref
  implicit   inline def xxByteOpt   [A<:Any.Raw.Byte]   (inline v: Byte.G.Opt[A])   : Opt[A]    = v.ref
  implicit   inline def xxCharOpt   [A<:Any.Raw.Char]   (inline v: Char.G.Opt[A])   : Opt[A]    = v.ref
  implicit   inline def xxShortOpt  [A<:Any.Raw.Short]  (inline v: Short.G.Opt[A])  : Opt[A]    = v.ref
  implicit   inline def xxIntOpt    [A<:Any.Raw.Int]    (inline v: Int.G.Opt[A])    : Opt[A]    = v.ref
  implicit   inline def xxLongOpt   [A<:Any.Raw.Long]   (inline v: Long.G.Opt[A])   : Opt[A]    = v.ref
  implicit   inline def xxFloatOpt  [A<:Any.Raw.Float]  (inline v: Float.G.Opt[A])  : Opt[A]    = v.ref
  implicit   inline def xxDoubleOpt [A<:Any.Raw.Double] (inline v: Double.G.Opt[A]) : Opt[A]    = v.ref
  implicit   inline def xxFromValue[A](inline v: A)                                 : Opt[A]    = v.cast[Opt[A]]
  implicit   inline def xxFromValue[A<:Raw.Boolean](inline v: A)                    : Opt[A]    = java.lang.Boolean.valueOf(v.real).cast[Opt[A]]
  implicit   inline def xxFromValue[A<:Raw.Byte](inline v: A)                       : Opt[A]    = java.lang.Byte.valueOf(v.real).cast[Opt[A]]
  implicit   inline def xxFromValue[A<:Raw.Char](inline v: A)                       : Opt[A]    = java.lang.Character.valueOf(v.real).cast[Opt[A]]
  implicit   inline def xxFromValue[A<:Raw.Short](inline v: A)                      : Opt[A]    = java.lang.Short.valueOf(v.real).cast[Opt[A]]
  implicit   inline def xxFromValue[A<:Raw.Int](inline v: A)                        : Opt[A]    = java.lang.Integer.valueOf(v.real).cast[Opt[A]]
  implicit   inline def xxFromValue[A<:Raw.Long](inline v: A)                       : Opt[A]    = java.lang.Long.valueOf(v.real).cast[Opt[A]]
  implicit   inline def xxFromValue[A<:Raw.Float](inline v: A)                      : Opt[A]    = java.lang.Float.valueOf(v.real).cast[Opt[A]]
  implicit   inline def xxFromValue[A<:Raw.Double](inline v: A)                     : Opt[A]    = java.lang.Double.valueOf(v.real).cast[Opt[A]]

  object opaque:
    opaque type `type`[+A] <: Opaque.Ref = Opaque.Ref

  // **************************************
  private[scalqa] object None:
    override def equals(v: Any) = false
    override def toString       = "Opt.\\/"

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object opaque -> ### Value Option

      [[Opt]] is a container, which can hold a single value or be void (test [[is_\\/]])

      Option can be converted to value with method `or`, which also takes default value for case when option is void

      Option is often used as Boolean, where ''Option'' with value is converted to 'true' and void option is converted to 'false'

      By Scalqa convention, method names, which return [[Opt]] type, are ended with '_?' instead of word 'Option'

      ```
      val l: Lookup[Int,String] = ?_?_?

      val o: Opt[String] = l.get_?(12)

      if(o) println("Value found.")
      else  println("Value not found.")
      ```

@def void  -> Get void instance

@def xxRequest -> General void instance request \n\n It is possible to use general request \/ to get void instance of this type, thanks to this implicit conversion.

*/