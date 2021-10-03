package scalqa; package lang; import language.implicitConversions

object Any:
  /**/         type Boolean      = scala.Boolean     | Boolean.Opaque
  /**/         type Byte         = scala.Byte        | Byte.Opaque
  /**/         type Char         = scala.Char        | Char.Opaque
  /**/         type Short        = scala.Short       | Short.Opaque
  /**/         type Int          = scala.Int         | Int.Opaque
  /**/         type Long         = scala.Long        | Long.Opaque
  /**/         type Float        = scala.Float       | Float.Opaque
  /**/         type Double       = scala.Double      | Double.Opaque
  /**/         type Opaque       = AnyRef.Opaque     | Primitive.Opaque

  /**/         type Array[A]     = scala.Array[A]    | Primitive.Array[A]
  @tn("Stream")type ~[A]         = Val.~[A]          | Primitive.~[A]
  @tn("Range") type <>[A]        = Val.<>[A]         | Primitive.<>[A]
  @tn("Pack")  type ><[A]        = Val.><[A]         | Primitive.><[A]
  /**/         type Buffer[A]    = Val.Buffer[A]     | Primitive.Buffer[A]
  /**/         type Collection[A]= Val.Collection[A] | Primitive.Collection[A]
  /**/         type Lookup[A,B]  = Val.Lookup[A,B]   | Primitive.Lookup[A,B]
  /**/         type Idx[A]       = Val.Idx[A]        | Primitive.Idx[A]
  /**/         type Opt[A]       = Val.Opt[A]        | Primitive.Opt[A]
  /**/         type Pro[A]       = Val.Pro[A]        | Primitive.Pro[A]
  /**/         type Set[A]       = Val.Set[A]        | Primitive.Set[A]

  // Those are void resolutions for Any.Opt[A]. There is no reason to show them in docs, because same implicits are documented in each G.Opt.
  implicit inline def zzImplicitVoidRequestToValOpt    [A<:Any        ](v: \/): Val.Opt[A]       = ZZ.None.cast[Val.Opt[A]]
  implicit inline def zzImplicitVoidRequestToBooleanOpt[A<:Any.Boolean](v: \/): Boolean.G.Opt[A] = Boolean.G.Opt.void[A]
  implicit inline def zzImplicitVoidRequestToByteOpt   [A<:Any.Byte   ](v: \/): Byte.G.Opt[A]    = Byte.G.Opt.void[A]
  implicit inline def zzImplicitVoidRequestToCharOpt   [A<:Any.Char   ](v: \/): Char.G.Opt[A]    = Char.G.Opt.void[A]
  implicit inline def zzImplicitVoidRequestToShortOpt  [A<:Any.Short  ](v: \/): Short.G.Opt[A]   = Short.G.Opt.void[A]
  implicit inline def zzImplicitVoidRequestToIntOpt    [A<:Any.Int    ](v: \/): Int.G.Opt[A]     = Int.G.Opt.void[A]
  implicit inline def zzImplicitVoidRequestToLongOpt   [A<:Any.Long   ](v: \/): Long.G.Opt[A]    = Long.G.Opt.void[A]
  implicit inline def zzImplicitVoidRequestToFloatOpt  [A<:Any.Float  ](v: \/): Float.G.Opt[A]   = Float.G.Opt.void[A]
  implicit inline def zzImplicitVoidRequestToDoubleOpt [A<:Any.Double ](v: \/): Double.G.Opt[A]  = Double.G.Opt.void[A]

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

@type Array  ->  All Array kinds  \n\n All possible Array types supported by JVM.
@type ~      ->  All stream kinds \n\n All supported stream implementations.
@type <>     ->  All range kinds  \n\n All supported range implementations.
@type ><     ->  All pack kinds   \n\n All supported pack implementations.
@type Opt    ->  All Opt kinds    \n\n All supported Opt implementations.
@type Opaque ->  All Opaque kinds \n\n All supported Opaque root types.

@type Boolean ->  All Boolean-like types \n\n The type is needed for specialized Boolean based generic containers. From JVM prospective Any.Boolean is just a Boolean primitive.
@type Byte    ->  All Byte-like    types \n\n The type is needed for specialized Byte    based generic containers. From JVM prospective Any.Byte    is just a Byte    primitive.
@type Char    ->  All Char-like    types \n\n The type is needed for specialized Char    based generic containers. From JVM prospective Any.Char    is just a Char    primitive.
@type Short   ->  All Short-like   types \n\n The type is needed for specialized Short   based generic containers. From JVM prospective Any.Short   is just a Short   primitive.
@type Int     ->  All Int-like     types \n\n The type is needed for specialized Int     based generic containers. From JVM prospective Any.Int     is just an Int    primitive.
@type Long    ->  All Long-like    types \n\n The type is needed for specialized Long    based generic containers. From JVM prospective Any.Long    is just a Long    primitive.
@type Float   ->  All Float-like   types \n\n The type is needed for specialized Float   based generic containers. From JVM prospective Any.Float   is just a Float   primitive.
@type Double  ->  All Double-like  types \n\n The type is needed for specialized Double  based generic containers. From JVM prospective Any.Double  is just a Double  primitive.

*/