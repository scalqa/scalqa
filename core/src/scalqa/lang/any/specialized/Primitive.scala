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
