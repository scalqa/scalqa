package scalqa; package lang; package any; package specialized; import language.implicitConversions

class Primitive[A]private[specialized]() extends Specialized[A]:
  /**/          type Array      <: Any.Primitive.Array[A]
  @tn("Stream") type ~          <: Any.Primitive.~[A]
  @tn("Range")  type <>         <: Any.Primitive.<>[A]
  @tn("Pack")   type ><         <: Any.Primitive.><[A]
  /**/          type Buffer     <: Any.Primitive.Buffer[A]
  /**/          type Collection <: Any.Primitive.Collection[A]
  /**/          type Idx        <: Any.Primitive.Idx[A]
  /**/          type Lookup[B]  <: Any.Primitive.Lookup[A,B]
  /**/          type Opt        <: Any.Primitive.Opt[A]
  /**/          type Pro        <: Any.Primitive.Pro[A]
  /**/          type Set        <: Any.Primitive.Set[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Primitive ->

  There are 8 Specialized.Primitive implementations:
    [[scalqa.lang.any.specialized.X.Boolean Boolean]],
    [[scalqa.lang.any.specialized.X.Byte    Byte]],
    [[scalqa.lang.any.specialized.X.Char    Char]],
    [[scalqa.lang.any.specialized.X.Short   Short]],
    [[scalqa.lang.any.specialized.X.Int     Int]],
    [[scalqa.lang.any.specialized.X.Long    Long]],
    [[scalqa.lang.any.specialized.X.Float   Float]], and
    [[scalqa.lang.any.specialized.X.Double  Double]].

*/