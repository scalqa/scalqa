package scalqa; package `val`; package opt; import language.implicitConversions;

abstract class _givens extends givenDefailts:
  self: Opt.type =>

  inline given givenUsingOpt[A[B],B](using v: A[B]) : Opt[A[B]]                = v.cast[Opt[A[B]]]
  given givenCanEqualOpt[A,B](using CanEqual[A,B])  : CanEqual[Opt[A], Opt[B]] = CanEqual.derived
  given givenClassTag[A]  (using t: ClassTag[A])    : ClassTag[Opt[A]]         = t.cast[ClassTag[Opt[A]]]
  given givenTypeDef [A]                            : Given.TypeDef[Opt[A]]    = Given.TypeDef("Opt")
  given givenVoidDef [A]                            : Given.VoidDef[Opt[A]]    with { inline def value_isVoid(v: Opt[A]) = v eq ZZ.None }

  given givenDocDef[A](using t: Given.DocDef[A]) : Given.DocDef[Opt[A]] with
    def value_tag(v: Opt[A]): String   = if(v eq ZZ.None) "Opt(\\/)" else "Opt("+t.value_tag(v.cast[A])+")"
    def value_doc(v: Opt[A]): Doc      = Doc("Opt@"+v.self_^.hash)

  implicit   inline def implicitToBoolean[A]( inline v: Opt[A])                              : Boolean   = v.nonEmpty
  implicit   inline def implicitFrom      [A](inline v: \/)                                  : Opt[A]    = ZZ.None.cast[Opt[A]]
  implicit   inline def implicitFrom      [A](inline v: scala.Option[A])                     : Opt[A]    = fromScala[A](v)
  implicit   inline def implicitFrom      [A](inline v: java.util.Optional[A])               : Opt[A]    = fromJava[A](v)
  implicit   inline def implicitFromAny   [A](inline v: A)                                   : Opt[A]    = v.cast[Opt[A]]
  implicit   inline def implicitFromResult[A](inline v: Result[A])                           : Opt[A]    = v.value_?
  implicit   inline def implicitFromRawBooleanOpt[A<:Boolean.Raw](inline v: Boolean.G.Opt[A]): Opt[A]    = v.ref
  implicit   inline def implicitFromRawByteOpt   [A<:Byte.Raw]   (inline v: Byte.G.Opt[A])   : Opt[A]    = v.ref
  implicit   inline def implicitFromRawCharOpt   [A<:Char.Raw]   (inline v: Char.G.Opt[A])   : Opt[A]    = v.ref
  implicit   inline def implicitFromRawShortOpt  [A<:Short.Raw]  (inline v: Short.G.Opt[A])  : Opt[A]    = v.ref
  implicit   inline def implicitFromRawIntOpt    [A<:Int.Raw]    (inline v: Int.G.Opt[A])    : Opt[A]    = v.ref
  implicit   inline def implicitFromRawLongOpt   [A<:Long.Raw]   (inline v: Long.G.Opt[A])   : Opt[A]    = v.ref
  implicit   inline def implicitFromRawFloatOpt  [A<:Float.Raw]  (inline v: Float.G.Opt[A])  : Opt[A]    = v.ref
  implicit   inline def implicitFromRawDoubleOpt [A<:Double.Raw] (inline v: Double.G.Opt[A]) : Opt[A]    = v.ref

  // These need not to show in docs
  implicit   inline def zzImplicitFromRaw[A<:Boolean.Raw](inline v: A)                       : Opt[A]    = java.lang.Boolean  .valueOf(v.cast[Boolean]).cast[Opt[A]]
  implicit   inline def zzImplicitFromRaw[A<:Byte.Raw]   (inline v: A)                       : Opt[A]    = java.lang.Byte     .valueOf(v.cast[Byte]   ).cast[Opt[A]]
  implicit   inline def zzImplicitFromRaw[A<:Char.Raw]   (inline v: A)                       : Opt[A]    = java.lang.Character.valueOf(v.cast[Char]   ).cast[Opt[A]]
  implicit   inline def zzImplicitFromRaw[A<:Short.Raw]  (inline v: A)                       : Opt[A]    = java.lang.Short    .valueOf(v.cast[Short]  ).cast[Opt[A]]
  implicit   inline def zzImplicitFromRaw[A<:Int.Raw]    (inline v: A)                       : Opt[A]    = java.lang.Integer  .valueOf(v.cast[Int]    ).cast[Opt[A]]
  implicit   inline def zzImplicitFromRaw[A<:Long.Raw]   (inline v: A)                       : Opt[A]    = java.lang.Long     .valueOf(v.cast[Long]   ).cast[Opt[A]]
  implicit   inline def zzImplicitFromRaw[A<:Float.Raw]  (inline v: A)                       : Opt[A]    = java.lang.Float    .valueOf(v.cast[Float]  ).cast[Opt[A]]
  implicit   inline def zzImplicitFromRaw[A<:Double.Raw] (inline v: A)                       : Opt[A]    = java.lang.Double   .valueOf(v.cast[Double] ).cast[Opt[A]]

// ******************************************************
class givenDefailts:
  inline given givenUsingOptNone[A[B],B]      : Val.Opt[A[B]]    = \/
  inline given givenOrdering[T<:Comparable[T]]: Opt[Ordering[T]] = gen.math.ordering.Z.OrderingForComparable.cast[Ordering[T]]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@def implicitFrom    -> General void instance request \n\n It is possible to use general request \\/ to get void instance of this type, thanks to this implicit conversion.

*/