package scalqa; package gen; package `given`; import language.implicitConversions

class  StreamShape[A, STREAM <: ~~.AnyType[A]]

object StreamShape extends zStreamShapeDefault:
  inline given givenBoolean     [A<:Boolean.Raw] : StreamShape[A,Boolean.G.~[A]] = new StreamShape[A, Boolean.G.~[A]]
  inline given givenByte        [A<:Byte.Raw   ] : StreamShape[A,Byte   .G.~[A]] = new StreamShape[A, Byte   .G.~[A]]
  inline given givenChar        [A<:Char.Raw   ] : StreamShape[A,Char   .G.~[A]] = new StreamShape[A, Char   .G.~[A]]
  inline given givenShort       [A<:Short.Raw  ] : StreamShape[A,Short  .G.~[A]] = new StreamShape[A, Short  .G.~[A]]
  inline given givenInt         [A<:Int.Raw    ] : StreamShape[A,Int    .G.~[A]] = new StreamShape[A, Int    .G.~[A]]
  inline given givenLong        [A<:Long.Raw   ] : StreamShape[A,Long   .G.~[A]] = new StreamShape[A, Long   .G.~[A]]
  inline given givenFloat       [A<:Float.Raw  ] : StreamShape[A,Float  .G.~[A]] = new StreamShape[A, Float  .G.~[A]]
  inline given givenDouble      [A<:Double.Raw ] : StreamShape[A,Double .G.~[A]] = new StreamShape[A, Double .G.~[A]]
  inline given givenRef         [A<:AnyRef]         : StreamShape[A,      Val.~[A]] = new StreamShape[A,       Val.~[A]]

  // ********************************************************************************************************************************************
  class  Raw[A, RAW <: ~~.RawType[A]] extends StreamShape[A,RAW]
  object Raw:
    inline given givenBoolean   [A<:Boolean.Raw] : Raw[A,Boolean.G.~[A]]         = new Raw[A,Boolean.G.~[A]]
    inline given givenByte      [A<:Byte.Raw   ] : Raw[A,Byte   .G.~[A]]         = new Raw[A,Byte   .G.~[A]]
    inline given givenChar      [A<:Char.Raw   ] : Raw[A,Char   .G.~[A]]         = new Raw[A,Char   .G.~[A]]
    inline given givenShort     [A<:Short.Raw  ] : Raw[A,Short  .G.~[A]]         = new Raw[A,Short  .G.~[A]]
    inline given givenInt       [A<:Int.Raw    ] : Raw[A,Int    .G.~[A]]         = new Raw[A,Int    .G.~[A]]
    inline given givenLong      [A<:Long.Raw   ] : Raw[A,Long   .G.~[A]]         = new Raw[A,Long   .G.~[A]]
    inline given givenFloat     [A<:Float.Raw  ] : Raw[A,Float  .G.~[A]]         = new Raw[A,Float  .G.~[A]]
    inline given givenDouble    [A<:Double.Raw ] : Raw[A,Double .G.~[A]]         = new Raw[A,Double .G.~[A]]

  // ********************************************************************************************************************************************
  class  Opt[A, OPT <: Val.Opt.AnyType[A], STREAM <: ~~.AnyType[A]]
  object Opt extends zOptTagDefault:
    inline given givenBoolean   [A<:Boolean.Raw] : Opt[A,Boolean.G.Opt[A], Boolean.G.~[A]] = new Opt[A,Boolean.G.Opt[A], Boolean.G.~[A]]
    inline given givenByte      [A<:Byte.Raw   ] : Opt[A,Byte   .G.Opt[A], Byte   .G.~[A]] = new Opt[A,Byte   .G.Opt[A], Byte   .G.~[A]]
    inline given givenChar      [A<:Char.Raw   ] : Opt[A,Char   .G.Opt[A], Char   .G.~[A]] = new Opt[A,Char   .G.Opt[A], Char   .G.~[A]]
    inline given givenShort     [A<:Short.Raw  ] : Opt[A,Short  .G.Opt[A], Short  .G.~[A]] = new Opt[A,Short  .G.Opt[A], Short  .G.~[A]]
    inline given givenInt       [A<:Int.Raw    ] : Opt[A,Int    .G.Opt[A], Int    .G.~[A]] = new Opt[A,Int    .G.Opt[A], Int    .G.~[A]]
    inline given givenLong      [A<:Long.Raw   ] : Opt[A,Long   .G.Opt[A], Long   .G.~[A]] = new Opt[A,Long   .G.Opt[A], Long   .G.~[A]]
    inline given givenFloat     [A<:Float.Raw  ] : Opt[A,Float  .G.Opt[A], Float  .G.~[A]] = new Opt[A,Float  .G.Opt[A], Float  .G.~[A]]
    inline given givenDouble    [A<:Double.Raw ] : Opt[A,Double .G.Opt[A], Double .G.~[A]] = new Opt[A,Double .G.Opt[A], Double .G.~[A]]

    inline given givenRefBoolean[A<:Boolean.Raw] : Opt[A,AnyRef .G.Opt[A], Boolean.G.~[A]] = new Opt[A,AnyRef .G.Opt[A], Boolean.G.~[A]]
    inline given givenRefByte   [A<:Byte.Raw   ] : Opt[A,AnyRef .G.Opt[A], Byte   .G.~[A]] = new Opt[A,AnyRef .G.Opt[A], Byte   .G.~[A]]
    inline given givenRefChar   [A<:Char.Raw   ] : Opt[A,AnyRef .G.Opt[A], Char   .G.~[A]] = new Opt[A,AnyRef .G.Opt[A], Char   .G.~[A]]
    inline given givenRefShort  [A<:Short.Raw  ] : Opt[A,AnyRef .G.Opt[A], Short  .G.~[A]] = new Opt[A,AnyRef .G.Opt[A], Short  .G.~[A]]
    inline given givenRefInt    [A<:Int.Raw    ] : Opt[A,AnyRef .G.Opt[A], Int    .G.~[A]] = new Opt[A,AnyRef .G.Opt[A], Int    .G.~[A]]
    inline given givenRefLong   [A<:Long.Raw   ] : Opt[A,AnyRef .G.Opt[A], Long   .G.~[A]] = new Opt[A,AnyRef .G.Opt[A], Long   .G.~[A]]
    inline given givenRefFloat  [A<:Float.Raw  ] : Opt[A,AnyRef .G.Opt[A], Float  .G.~[A]] = new Opt[A,AnyRef .G.Opt[A], Float  .G.~[A]]
    inline given givenRefDouble [A<:Double.Raw ] : Opt[A,AnyRef .G.Opt[A], Double .G.~[A]] = new Opt[A,AnyRef .G.Opt[A], Double .G.~[A]]
    inline given givenRef       [A<:AnyRef     ] : Opt[A,AnyRef.G.Opt[A],  AnyRef .G.~[A]] = new Opt[A,AnyRef .G.Opt[A], AnyRef .G.~[A]]
  private[`given`] class zOptTagDefault:
    inline given givenAny       [A             ] : Opt[A,AnyRef.G.Opt[A],  AnyRef .G.~[A]] = new Opt[A,AnyRef .G.Opt[A], AnyRef .G.~[A]]

// **********************************************************************************************************************************************
private[`given`] class zStreamShapeDefault:
  inline given givenAny[A]: StreamShape[A, Val.~[A]] = new StreamShape[A, Val.~[A]]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
