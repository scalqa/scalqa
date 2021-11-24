package scalqa; package lang; package any; import specialized.*; import language.implicitConversions

class Specialized[A]:
  type Array      <: Any.Array[A]
  type Stream     <: Any.Stream[A]
  type Range      <: Any.Range[A]
  type Pack       <: Any.Pack[A]
  type Buffer     <: Any.Buffer[A]
  type Collection <: Any.Collection[A]
  type Idx        <: Any.Idx[A]
  type Lookup[B]  <: Any.Lookup[A,B]
  type Opt        <: Any.Opt[A]
  type Pro        <: Any.Pro[A]
  type Set        <: Any.Set[A]

object Specialized extends z_SpecializedDefault:
  inline given givenBoolean[A<:Any.Boolean ]: X.Boolean[A] = new X.Boolean[A] // Do not optimize "new",
  inline given givenByte   [A<:Any.Byte    ]: X.Byte[A]    = new X.Byte[A]    // when inlined and not used,
  inline given givenChar   [A<:Any.Char    ]: X.Char[A]    = new X.Char[A]    // it disappears.
  inline given givenShort  [A<:Any.Short   ]: X.Short[A]   = new X.Short[A]   // Otherwise, it gets complex.
  inline given givenInt    [A<:Any.Int     ]: X.Int[A]     = new X.Int[A]
  inline given givenLong   [A<:Any.Long    ]: X.Long[A]    = new X.Long[A]
  inline given givenFloat  [A<:Any.Float   ]: X.Float[A]   = new X.Float[A]
  inline given givenDouble [A<:Any.Double  ]: X.Double[A]  = new X.Double[A]
  inline given givenRef    [A<:scala.AnyRef]: X.AnyRef[A]  = new X.AnyRef[A]

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  /**/                                            type Primitive[A]           = specialized.Primitive[A]
  transparent inline def Opt = specialized.Opt;   type Opt[A,OPT<:Any.Opt[A]] = specialized.Opt[A,OPT]
  transparent inline def X  = specialized.X

private[any] class z_SpecializedDefault:
  inline given givenAny[A]: X.AnyRef[A] = new X.AnyRef[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Specialized ->

  Specialized instance determines custom implementation of given type containers.
  Usually it is used by inlined methods and gets resolved by the compiler, so threre is zero runtime cost.

  For example, consider specialized stream method [[scalqa.val.stream._build._map map]], which returns different types of stream:
  ```
    val floats  : Float.Stream   =  (1 <> 9).stream.map(_.toFloat)

    val longs   : Long.Stream    =  (1 <> 9).stream.map(_.toLong)

    val strings : Stream[String] =  (1 <> 9).stream.map(_.toString)
  ```
*/