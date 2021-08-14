package scalqa; package gen; package `given`; import language.implicitConversions

class  OptShape[A, OPT <: Opt.AnyType[A]]

object OptShape extends zOptShapeDefault:
  inline given givenBoolean [A<:Boolean.Raw]: OptShape[A,Boolean.G.Opt[A]] = new OptShape[A, Boolean.G.Opt[A]]
  inline given givenByte    [A<:Byte.Raw   ]: OptShape[A,Byte   .G.Opt[A]] = new OptShape[A, Byte   .G.Opt[A]]
  inline given givenChar    [A<:Char.Raw   ]: OptShape[A,Char   .G.Opt[A]] = new OptShape[A, Char   .G.Opt[A]]
  inline given givenShort   [A<:Short.Raw  ]: OptShape[A,Short  .G.Opt[A]] = new OptShape[A, Short  .G.Opt[A]]
  inline given givenInt     [A<:Int.Raw    ]: OptShape[A,Int    .G.Opt[A]] = new OptShape[A, Int    .G.Opt[A]]
  inline given givenLong    [A<:Long.Raw   ]: OptShape[A,Long   .G.Opt[A]] = new OptShape[A, Long   .G.Opt[A]]
  inline given givenFloat   [A<:Float.Raw  ]: OptShape[A,Float  .G.Opt[A]] = new OptShape[A, Float  .G.Opt[A]]
  inline given givenDouble  [A<:Double.Raw ]: OptShape[A,Double .G.Opt[A]] = new OptShape[A, Double .G.Opt[A]]
  inline given givenRef     [A<:AnyRef     ]: OptShape[A,AnyRef .G.Opt[A]] = new OptShape[A, AnyRef .G.Opt[A]]

  // ***************************************************************************************************************
  sealed class Raw[A, OPT <: Opt.RawType[A]] extends OptShape[A,OPT]

  object Raw:
    inline given givenBoolean[A<:Boolean.Raw]: Raw[A,Boolean.G.Opt[A]]      = new Raw[A,Boolean.G.Opt[A]]()
    inline given givenByte   [A<:Byte.Raw   ]: Raw[A,Byte   .G.Opt[A]]      = new Raw[A,Byte   .G.Opt[A]]()
    inline given givenChar   [A<:Char.Raw   ]: Raw[A,Char   .G.Opt[A]]      = new Raw[A,Char   .G.Opt[A]]()
    inline given givenShort  [A<:Short.Raw  ]: Raw[A,Short  .G.Opt[A]]      = new Raw[A,Short  .G.Opt[A]]()
    inline given givenInt    [A<:Int.Raw    ]: Raw[A,Int    .G.Opt[A]]      = new Raw[A,Int    .G.Opt[A]]()
    inline given givenLong   [A<:Long.Raw   ]: Raw[A,Long   .G.Opt[A]]      = new Raw[A,Long   .G.Opt[A]]()
    inline given givenFloat  [A<:Float.Raw  ]: Raw[A,Float  .G.Opt[A]]      = new Raw[A,Float  .G.Opt[A]]()
    inline given givenDouble [A<:Double.Raw ]: Raw[A,Double .G.Opt[A]]      = new Raw[A,Double .G.Opt[A]]()

private[`given`] class zOptShapeDefault:
  inline given givenAny      [A             ]: OptShape[A,AnyRef.G.Opt[A]]  = new OptShape[A, AnyRef.G.Opt[A]]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
