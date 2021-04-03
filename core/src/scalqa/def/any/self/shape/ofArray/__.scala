package scalqa; package `def`; package any; package self; package shape; import language.implicitConversions

object OfArray:

  type Any[A] = Array[A]
              | Array[A & Raw.Boolean]
              | Array[A & Raw.Byte]
              | Array[A & Raw.Char]
              | Array[A & Raw.Short]
              | Array[A & Raw.Int]
              | Array[A & Raw.Long]
              | Array[A & Raw.Float]
              | Array[A & Raw.Double]

  // ***************************************************************************************************************
  class Tag[A, ARRAY <: Any[A]]

  object Tag extends zTagDefault:
    inline given xxBoolean[A<:Raw.Boolean]: Tag[A,Array[A]] = new Tag[A, Array[A]]
    inline given xxByte   [A<:Raw.Byte   ]: Tag[A,Array[A]] = new Tag[A, Array[A]]
    inline given xxChar   [A<:Raw.Char   ]: Tag[A,Array[A]] = new Tag[A, Array[A]]
    inline given xxShort  [A<:Raw.Short  ]: Tag[A,Array[A]] = new Tag[A, Array[A]]
    inline given xxInt    [A<:Raw.Int    ]: Tag[A,Array[A]] = new Tag[A, Array[A]]
    inline given xxLong   [A<:Raw.Long   ]: Tag[A,Array[A]] = new Tag[A, Array[A]]
    inline given xxFloat  [A<:Raw.Float  ]: Tag[A,Array[A]] = new Tag[A, Array[A]]
    inline given xxDouble [A<:Raw.Double ]: Tag[A,Array[A]] = new Tag[A, Array[A]]
    inline given xxRef    [A<:Ref        ]: Tag[A,Array[A]] = new Tag[A, Array[A]]

  private[OfArray] class zTagDefault:
    inline given xxAny    [A             ]: Tag[A,Array[A]] = new Tag[A, Array[A]]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
