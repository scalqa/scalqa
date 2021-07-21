package scalqa; package gen; package `given`; import language.implicitConversions

class  PackTag[A, PACK <: ><.AnyType[A]]

object PackTag extends zPackTagDefault:
  inline given givenBoolean   [A<:Any.Raw.Boolean]: PackTag[A,Boolean.G.><[A]] = new PackTag[A, Boolean.G.><[A]]
  inline given givenByte      [A<:Any.Raw.Byte   ]: PackTag[A,Byte   .G.><[A]] = new PackTag[A, Byte   .G.><[A]]
  inline given givenChar      [A<:Any.Raw.Char   ]: PackTag[A,Char   .G.><[A]] = new PackTag[A, Char   .G.><[A]]
  inline given givenShort     [A<:Any.Raw.Short  ]: PackTag[A,Short  .G.><[A]] = new PackTag[A, Short  .G.><[A]]
  inline given givenInt       [A<:Any.Raw.Int    ]: PackTag[A,Int    .G.><[A]] = new PackTag[A, Int    .G.><[A]]
  inline given givenLong      [A<:Any.Raw.Long   ]: PackTag[A,Long   .G.><[A]] = new PackTag[A, Long   .G.><[A]]
  inline given givenFloat     [A<:Any.Raw.Float  ]: PackTag[A,Float  .G.><[A]] = new PackTag[A, Float  .G.><[A]]
  inline given givenDouble    [A<:Any.Raw.Double ]: PackTag[A,Double .G.><[A]] = new PackTag[A, Double .G.><[A]]
  inline given givenRef       [A<:Any.Ref]        : PackTag[A,          ><[A]] = new PackTag[A,           ><[A]]

  // *********************************************************************************************************
  sealed class Raw[A, PACK <: ><.RawType[A]]

  object Raw:
    inline given givenBoolean[A<:Any.Raw.Boolean] : Raw[A,Boolean.G.><[A]]     = new Raw[A,Boolean.G.><[A]]
    inline given givenByte   [A<:Any.Raw.Byte]    : Raw[A,Byte   .G.><[A]]     = new Raw[A,Byte   .G.><[A]]
    inline given givenChar   [A<:Any.Raw.Char]    : Raw[A,Char   .G.><[A]]     = new Raw[A,Char   .G.><[A]]
    inline given givenShort  [A<:Any.Raw.Short]   : Raw[A,Short  .G.><[A]]     = new Raw[A,Short  .G.><[A]]
    inline given givenInt    [A<:Any.Raw.Int]     : Raw[A,Int    .G.><[A]]     = new Raw[A,Int    .G.><[A]]
    inline given givenLong   [A<:Any.Raw.Long]    : Raw[A,Long   .G.><[A]]     = new Raw[A,Long   .G.><[A]]
    inline given givenFloat  [A<:Any.Raw.Float]   : Raw[A,Float  .G.><[A]]     = new Raw[A,Float  .G.><[A]]
    inline given givenDouble [A<:Any.Raw.Double]  : Raw[A,Double .G.><[A]]     = new Raw[A,Double .G.><[A]]

// **********************************************************************************************************************************************
private[`given`] class zPackTagDefault:
  inline given givenAny[A]: PackTag[A, ><[A]] = new PackTag[A, ><[A]]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
