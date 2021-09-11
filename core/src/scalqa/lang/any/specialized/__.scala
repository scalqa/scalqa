package scalqa; package lang; package any; import specialized.*; import language.implicitConversions

class Specialized[A]:
  @tn("Stream") type ~     <: Any.~[A]
  @tn("Range")  type <>    <: Any.<>[A]
  @tn("Pack")   type ><    <: Any.><[A]
  /**/          type Opt   <: Any.Opt[A]
  /**/          type Array <: Any.Array[A]

object Specialized extends zSpecializedDefault:
  inline given givenBoolean[A<:Any.Boolean ]: X.Boolean[A] = new X.Boolean[A] // Do not optimize "new",
  inline given givenByte   [A<:Any.Byte    ]: X.Byte[A]    = new X.Byte[A]    // when inlined and not used,
  inline given givenChar   [A<:Any.Char    ]: X.Char[A]    = new X.Char[A]    // it disappears.
  inline given givenShort  [A<:Any.Short   ]: X.Short[A]   = new X.Short[A]   // Otherwise, it gets complex.
  inline given givenInt    [A<:Any.Int     ]: X.Int[A]     = new X.Int[A]
  inline given givenLong   [A<:Any.Long    ]: X.Long[A]    = new X.Long[A]
  inline given givenFloat  [A<:Any.Float   ]: X.Float[A]   = new X.Float[A]
  inline given givenDouble [A<:Any.Double  ]: X.Double[A]  = new X.Double[A]
  inline given givenRef    [A<:scala.AnyRef]: X.AnyRef[A]  = new X.AnyRef[A]

  // **************************************************************************************
  class Primitive[A] extends Specialized[A]:
    @tn("Stream") type ~     <: Any.Primitive_~[A]
    @tn("Range")  type <>    <: Any.Primitive_<>[A]
    @tn("Pack")   type ><    <: Any.Primitive_><[A]
    /**/          type Opt   <: Any.PrimitiveOpt[A]
    /**/          type Array <: Any.PrimitiveArray[A]

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  transparent inline def Opt = specialized.Opt;   type Opt[A,OPT<:Any.Opt[A]] = specialized.Opt[A,OPT]
  transparent inline def X  = specialized.X

private[any] class zSpecializedDefault:
  inline given givenAny[A]: X.AnyRef[A] = new X.AnyRef[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Specialized ->

  Specialized instance determines custom implementation of ~, <>, ><, Opt, or Array.
  Usually it is used by inlined method and gets resolved by the compiler, so threre is zero runtime cost.

  For example, consider stream method [[scalqa.val.stream._build._map map]], which returns different types of stream:
  ```
    val floats  : Float.~   =  (1 <> 9).~.map(_.toFloat)

    val longs   : Long.~    =  (1 <> 9).~.map(_.toLong)

    val strings : ~[String] =  (1 <> 9).~.map(_.toString)
  ```
*/