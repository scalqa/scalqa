package scalqa; package lang; import language.implicitConversions

object Any:
  type Boolean      = scala.Boolean     | Boolean.Opaque
  type Byte         = scala.Byte        | Byte.Opaque
  type Char         = scala.Char        | Char.Opaque
  type Short        = scala.Short       | Short.Opaque
  type Int          = scala.Int         | Int.Opaque
  type Long         = scala.Long        | Long.Opaque
  type Float        = scala.Float       | Float.Opaque
  type Double       = scala.Double      | Double.Opaque
  type Opaque       = AnyRef.Opaque     | Primitive.Opaque

  type Array[A]     = scala.Array[A]    | Primitive.Array[A]
  type Stream[A]    = Val.Stream[A]     | Primitive.Stream[A]
  type Range[A]     = Val.Range[A]      | Primitive.Range[A]
  type Pack[A]      = Val.Pack[A]       | Primitive.Pack[A]
  type Buffer[A]    = Val.Buffer[A]     | Primitive.Buffer[A]
  type Collection[A]= Val.Collection[A] | Primitive.Collection[A]
  type Lookup[A,B]  = Val.Lookup[A,B]   | Primitive.Lookup[A,B]
  type Idx[A]       = Val.Idx[A]        | Primitive.Idx[A]
  type Opt[A]       = Val.Opt[A]        | Primitive.Opt[A]
  type Pro[A]       = Val.Pro[A]        | Primitive.Pro[A]
  type Set[A]       = Val.Set[A]        | Primitive.Set[A]

  // Those are void resolutions for Any.Opt[A]. There is no reason to show them in docs, because same implicits are documented in each G.Opt.
  implicit inline def z_ImplicitVoidRequestToValOpt    [A<:Any        ](v:VOID): Val.Opt[A]       = ZZ.None.cast[Val.Opt[A]]
  implicit inline def z_ImplicitVoidRequestToBooleanOpt[A<:Any.Boolean](v:VOID): Boolean.G.Opt[A] = Boolean.G.Opt.void[A]
  implicit inline def z_ImplicitVoidRequestToByteOpt   [A<:Any.Byte   ](v:VOID): Byte.G.Opt[A]    = Byte.G.Opt.void[A]
  implicit inline def z_ImplicitVoidRequestToCharOpt   [A<:Any.Char   ](v:VOID): Char.G.Opt[A]    = Char.G.Opt.void[A]
  implicit inline def z_ImplicitVoidRequestToShortOpt  [A<:Any.Short  ](v:VOID): Short.G.Opt[A]   = Short.G.Opt.void[A]
  implicit inline def z_ImplicitVoidRequestToIntOpt    [A<:Any.Int    ](v:VOID): Int.G.Opt[A]     = Int.G.Opt.void[A]
  implicit inline def z_ImplicitVoidRequestToLongOpt   [A<:Any.Long   ](v:VOID): Long.G.Opt[A]    = Long.G.Opt.void[A]
  implicit inline def z_ImplicitVoidRequestToFloatOpt  [A<:Any.Float  ](v:VOID): Float.G.Opt[A]   = Float.G.Opt.void[A]
  implicit inline def z_ImplicitVoidRequestToDoubleOpt [A<:Any.Double ](v:VOID): Double.G.Opt[A]  = Double.G.Opt.void[A]

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  /**/                                                  type _methods       = any._methods
  transparent inline def Specialized = any.Specialized; type Specialized[A] = any.Specialized[A]
  transparent inline def Primitive   = any.Primitive
  transparent inline def Def         = any.Def

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Any -> Companion to scala.Any

@type Stream      ->  All stream kinds      \n\n All supported stream implementations.
@type Range       ->  All range kinds       \n\n All supported range implementations.
@type Pack        ->  All pack kinds        \n\n All supported pack implementations.
@type Array       ->  All Array kinds       \n\n All possible Array types supported by JVM.
@type Buffer      ->  All Buffer kinds      \n\n All supported Buffer implementations.
@type Collection  ->  All Collection kinds  \n\n All supported Collection implementations.
@type Idx         ->  All Idx kinds         \n\n All supported indexed collection implementations.
@type Lookup      ->  All Lookup kinds      \n\n All supported lookup colelction implementations.
@type Opt         ->  All Opt kinds         \n\n All supported Opt implementations.
@type Pro         ->  All Pro kinds         \n\n All supported Provider/Property implementations.
@type Set         ->  All Set kinds         \n\n All supported Set implementations.
@type Opaque      ->  All Opaque kinds      \n\n All supported Opaque root types.

@type Boolean ->  All Boolean-like types \n\n The type is needed for specialized Boolean based generic containers. From JVM prospective Any.Boolean is just a Boolean primitive.
@type Byte    ->  All Byte-like    types \n\n The type is needed for specialized Byte    based generic containers. From JVM prospective Any.Byte    is just a Byte    primitive.
@type Char    ->  All Char-like    types \n\n The type is needed for specialized Char    based generic containers. From JVM prospective Any.Char    is just a Char    primitive.
@type Short   ->  All Short-like   types \n\n The type is needed for specialized Short   based generic containers. From JVM prospective Any.Short   is just a Short   primitive.
@type Int     ->  All Int-like     types \n\n The type is needed for specialized Int     based generic containers. From JVM prospective Any.Int     is just an Int    primitive.
@type Long    ->  All Long-like    types \n\n The type is needed for specialized Long    based generic containers. From JVM prospective Any.Long    is just a Long    primitive.
@type Float   ->  All Float-like   types \n\n The type is needed for specialized Float   based generic containers. From JVM prospective Any.Float   is just a Float   primitive.
@type Double  ->  All Double-like  types \n\n The type is needed for specialized Double  based generic containers. From JVM prospective Any.Double  is just a Double  primitive.

*/