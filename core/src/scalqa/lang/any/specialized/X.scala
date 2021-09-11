package scalqa; package lang; package any; package specialized; import language.implicitConversions

object X:

  class AnyRef[A] extends Specialized[A]:
    @tn("Stream") type ~     = Val.~ [A];                          type Array = scala.Array[A]
    @tn("Range")  type <>    = Val.<>[A];                          type Opt   = Val.Opt[A]
    @tn("Pack")   type ><    = Val.><[A]

  class Boolean[A<:Any.Boolean] extends Specialized.Primitive[A]:
    @tn("Stream") type ~     = lang.Boolean.G.~ [A & Any.Boolean]; type Array = scala.Array[A & Any.Boolean]
    @tn("Pack")   type ><    = lang.Boolean.G.><[A & Any.Boolean]; type Opt   = lang.Boolean.G.Opt[A & Any.Boolean]

  class Byte[A<:Any.Byte] extends Specialized.Primitive[A]:
    @tn("Stream") type ~     = lang.Byte.G.~ [A & Any.Byte];       type Array = scala.Array[A & Any.Byte]
    @tn("Range")  type <>    = lang.Byte.G.<>[A & Any.Byte];       type Opt   = lang.Byte.G.Opt[A& Any.Byte]

    @tn("Pack")   type ><    = lang.Byte.G.><[A & Any.Byte]

  class Char[A<:Any.Char] extends Specialized.Primitive[A]:
    @tn("Stream") type ~     = lang.Char.G.~ [A & Any.Char];       type Array = scala.Array[A & Any.Char]
    @tn("Range")  type <>    = lang.Char.G.<>[A & Any.Char];       type Opt   = lang.Char.G.Opt[A & Any.Char]
    @tn("Pack")   type ><    = lang.Char.G.><[A & Any.Char]

  class Short[A<:Any.Short] extends Specialized.Primitive[A]:
    @tn("Stream") type ~     = lang.Short.G.~ [A & Any.Short];     type Array = scala.Array[A & Any.Short]
    @tn("Range")  type <>    = lang.Short.G.<>[A & Any.Short];     type Opt   = lang.Short.G.Opt[A & Any.Short]
    @tn("Pack")   type ><    = lang.Short.G.><[A & Any.Short]

  class Int[A<:Any.Int] extends Specialized.Primitive[A]:
    @tn("Stream") type ~     = lang.Int.G.~ [A & Any.Int];         type Array = scala.Array[A & Any.Int]
    @tn("Range")  type <>    = lang.Int.G.<>[A & Any.Int];         type Opt   = lang.Int.G.Opt[A & Any.Int]
    @tn("Pack")   type ><    = lang.Int.G.><[A & Any.Int]

  class Long[A<:Any.Long] extends Specialized.Primitive[A]:
    @tn("Stream") type ~     = lang.Long.G.~ [A & Any.Long];       type Array = scala.Array[A & Any.Long]
    @tn("Range")  type <>    = lang.Long.G.<>[A & Any.Long];       type Opt   = lang.Long.G.Opt[A & Any.Long]
    @tn("Pack")   type ><    = lang.Long.G.><[A & Any.Long]

  class Float[A<:Any.Float] extends Specialized.Primitive[A]:
    @tn("Stream") type ~     = lang.Float.G.~ [A & Any.Float];     type Array = scala.Array[A & Any.Float]
    @tn("Range")  type <>    = lang.Float.G.<>[A & Any.Float];     type Opt   = lang.Float.G.Opt[A & Any.Float]
    @tn("Pack")   type ><    = lang.Float.G.><[A & Any.Float]

  class Double[A<:Any.Double] extends Specialized.Primitive[A]:
    @tn("Stream") type ~     = lang.Double.G.~ [A & Any.Double];   type Array = scala.Array[A & Any.Double]
    @tn("Range")  type <>    = lang.Double.G.<>[A & Any.Double];   type Opt   = lang.Double.G.Opt[A & Any.Double]
    @tn("Pack")   type ><    = lang.Double.G.><[A & Any.Double]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
