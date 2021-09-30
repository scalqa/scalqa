package scalqa; package lang; package any; package specialized; import language.implicitConversions

object X:

  class AnyRef[A] extends Specialized[A]:
    @tn("Stream") type ~  = Val.~ [A];                        type Idx = Val.Idx[A];                        type Array      = scala.Array[A]
    @tn("Range")  type <> = Val.<>[A];                        type Opt = Val.Opt[A];                        type Collection = Val.Collection[A]
    @tn("Pack")   type >< = Val.><[A];                        type Pro = Val.Pro[A];                        type Buffer     = Val.Buffer[A]
    /**/                                                                                                    type Lookup[B]  = Val.Lookup.Stable[A,B]
  class Boolean[A<:Any.Boolean] extends Primitive[A]:
    @tn("Stream") type ~  = lang.boolean.G.~ [A&Any.Boolean]; type Idx = lang.boolean.G.Idx[A&Any.Boolean]; type Array      = scala.Array               [A&Any.Boolean]
    @tn("Pack")   type >< = lang.boolean.G.><[A&Any.Boolean]; type Opt = lang.boolean.G.Opt[A&Any.Boolean]; type Collection = lang.boolean.G.Collection [A&Any.Boolean]
    /**/                                                      type Pro = lang.boolean.G.Pro[A&Any.Boolean]; type Buffer     = lang.boolean.G.Buffer     [A&Any.Boolean]
    /**/                                                                                                    type Lookup[B]  = Val.Lookup.Stable         [A&Any.Boolean,B]
  class Byte[A<:Any.Byte] extends Primitive[A]:
    @tn("Stream") type ~  = lang.byte.G.~ [A&Any.Byte];       type Idx = lang.byte.G.Idx[A&Any. Byte];      type Array      = scala.Array               [A&Any.Byte]
    @tn("Range")  type <> = lang.byte.G.<>[A&Any.Byte];       type Opt = lang.byte.G.Opt[A&Any. Byte];      type Collection = lang.byte.G.Collection    [A&Any.Byte]
    @tn("Pack")   type >< = lang.byte.G.><[A&Any.Byte];       type Pro = lang.byte.G.Pro[A&Any. Byte];      type Buffer     = lang.byte.G.Buffer        [A&Any.Byte]
    /**/                                                                                                    type Lookup[B]  = lang.byte.G.Lookup.Stable [A&Any.Byte,B]
  class Char[A<:Any.Char] extends Primitive[A]:
    @tn("Stream") type ~  = lang.char.G.~ [A&Any.Char];       type Idx = lang.char.G.Idx[A&Any.Char];       type Array      = scala.Array               [A&Any.Char]
    @tn("Range")  type <> = lang.char.G.<>[A&Any.Char];       type Opt = lang.char.G.Opt[A&Any.Char];       type Collection = lang.char.G.Collection    [A&Any.Char]
    @tn("Pack")   type >< = lang.char.G.><[A&Any.Char];       type Pro = lang.char.G.Pro[A&Any.Char];       type Buffer     = lang.char.G.Buffer        [A&Any.Char]
    /**/                                                                                                    type Lookup[B]  = lang.char.G.Lookup.Stable [A&Any.Char,B]
  class Short[A<:Any.Short] extends Primitive[A]:
    @tn("Stream") type ~  = lang.short.G.~ [A&Any.Short];     type Idx = lang.short.G.Idx[A&Any.Short];     type Array      = scala.Array               [A&Any.Short]
    @tn("Range")  type <> = lang.short.G.<>[A&Any.Short];     type Opt = lang.short.G.Opt[A&Any.Short];     type Collection = lang.short.G.Collection   [A&Any.Short]
    @tn("Pack")   type >< = lang.short.G.><[A&Any.Short];     type Pro = lang.short.G.Pro[A&Any.Short];     type Buffer     = lang.short.G.Buffer       [A&Any.Short]
    /**/                                                                                                    type Lookup[B]  = lang.short.G.Lookup.Stable[A&Any.Short,B]
  class Int[A<:Any.Int] extends Primitive[A]:
    @tn("Stream") type ~  = lang.int.G.~ [A&Any.Int];         type Idx = lang.int.G.Idx[A&Any.Int];         type Array      = scala.Array               [A&Any.Int]
    @tn("Range")  type <> = lang.int.G.<>[A&Any.Int];         type Opt = lang.int.G.Opt[A&Any.Int];         type Collection = lang.int.G.Collection     [A&Any.Int]
    @tn("Pack")   type >< = lang.int.G.><[A&Any.Int];         type Pro = lang.int.G.Pro[A&Any.Int];         type Buffer     = lang.int.G.Buffer         [A&Any.Int]
    /**/                                                                                                    type Lookup[B]  = lang.int.G.Lookup.Stable  [A&Any.Int,B]
  class Long[A<:Any.Long] extends Primitive[A]:
    @tn("Stream") type ~  = lang.long.G.~ [A&Any.Long];       type Idx = lang.long.G.Idx[A&Any.Long];       type Array      = scala.Array               [A&Any.Long]
    @tn("Range")  type <> = lang.long.G.<>[A&Any.Long];       type Opt = lang.long.G.Opt[A&Any.Long];       type Collection = lang.long.G.Collection    [A&Any.Long]
    @tn("Pack")   type >< = lang.long.G.><[A&Any.Long];       type Pro = lang.long.G.Pro[A&Any.Long];       type Buffer     = lang.long.G.Buffer        [A&Any.Long]
    /**/                                                                                                    type Lookup[B]  = lang.long.G.Lookup.Stable [A&Any.Long,B]
  class Float[A<:Any.Float] extends Primitive[A]:
    @tn("Stream") type ~  = lang.float.G.~ [A&Any.Float];     type Idx = lang.float.G.Idx[A&Any.Float];     type Array      = scala.Array               [A&Any.Float]
    @tn("Range")  type <> = lang.float.G.<>[A&Any.Float];     type Opt = lang.float.G.Opt[A&Any.Float];     type Collection = lang.float.G.Collection   [A&Any.Float]
    @tn("Pack")   type >< = lang.float.G.><[A&Any.Float];     type Pro = lang.float.G.Pro[A&Any.Float];     type Buffer     = lang.float.G.Buffer       [A&Any.Float]
    /**/                                                                                                    type Lookup[B]  = Val.Lookup.Stable         [A&Any.Float,B]
  class Double[A<:Any.Double] extends Primitive[A]:
    @tn("Stream") type ~  = lang.double.G.~ [A&Any.Double];   type Idx = lang.double.G.Idx[A&Any.Double];   type Array      = scala.Array               [A&Any.Double]
    @tn("Range")  type <> = lang.double.G.<>[A&Any.Double];   type Opt = lang.double.G.Opt[A&Any.Double];   type Collection = lang.double.G.Collection  [A&Any.Double]
    @tn("Pack")   type >< = lang.double.G.><[A&Any.Double];   type Pro = lang.double.G.Pro[A&Any.Double];   type Buffer     = lang.double.G.Buffer      [A&Any.Double]
    /**/                                                                                                    type Lookup[B]  = Val.Lookup.Stable         [A&Any.Double,B]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
