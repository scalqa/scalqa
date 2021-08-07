package scalqa; package gen; package `given`; import language.implicitConversions

class  PackShape[A, PACK <: ><.AnyType[A]]

object PackShape extends zPackShapeDefault:
  inline given givenBoolean   [A<:Boolean.Raw]: PackShape[A,Boolean.G.><[A]] = new PackShape[A, Boolean.G.><[A]]
  inline given givenByte      [A<:Byte.Raw   ]: PackShape[A,Byte   .G.><[A]] = new PackShape[A, Byte   .G.><[A]]
  inline given givenChar      [A<:Char.Raw   ]: PackShape[A,Char   .G.><[A]] = new PackShape[A, Char   .G.><[A]]
  inline given givenShort     [A<:Short.Raw  ]: PackShape[A,Short  .G.><[A]] = new PackShape[A, Short  .G.><[A]]
  inline given givenInt       [A<:Int.Raw    ]: PackShape[A,Int    .G.><[A]] = new PackShape[A, Int    .G.><[A]]
  inline given givenLong      [A<:Long.Raw   ]: PackShape[A,Long   .G.><[A]] = new PackShape[A, Long   .G.><[A]]
  inline given givenFloat     [A<:Float.Raw  ]: PackShape[A,Float  .G.><[A]] = new PackShape[A, Float  .G.><[A]]
  inline given givenDouble    [A<:Double.Raw ]: PackShape[A,Double .G.><[A]] = new PackShape[A, Double .G.><[A]]
  inline given givenRef       [A<:AnyRef]        : PackShape[A,          ><[A]] = new PackShape[A,           ><[A]]

  // *********************************************************************************************************
  sealed class Raw[A, PACK <: ><.RawType[A]]

  object Raw:
    inline given givenBoolean[A<:Boolean.Raw] : Raw[A,Boolean.G.><[A]]       = new Raw[A,Boolean.G.><[A]]
    inline given givenByte   [A<:Byte.Raw]    : Raw[A,Byte   .G.><[A]]       = new Raw[A,Byte   .G.><[A]]
    inline given givenChar   [A<:Char.Raw]    : Raw[A,Char   .G.><[A]]       = new Raw[A,Char   .G.><[A]]
    inline given givenShort  [A<:Short.Raw]   : Raw[A,Short  .G.><[A]]       = new Raw[A,Short  .G.><[A]]
    inline given givenInt    [A<:Int.Raw]     : Raw[A,Int    .G.><[A]]       = new Raw[A,Int    .G.><[A]]
    inline given givenLong   [A<:Long.Raw]    : Raw[A,Long   .G.><[A]]       = new Raw[A,Long   .G.><[A]]
    inline given givenFloat  [A<:Float.Raw]   : Raw[A,Float  .G.><[A]]       = new Raw[A,Float  .G.><[A]]
    inline given givenDouble [A<:Double.Raw]  : Raw[A,Double .G.><[A]]       = new Raw[A,Double .G.><[A]]

// **********************************************************************************************************************************************
private[`given`] class zPackShapeDefault:
  inline given givenAny[A]: PackShape[A, ><[A]] = new PackShape[A, ><[A]]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
