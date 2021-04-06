package scalqa; package lang; package any; package self; package shape; import language.implicitConversions

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

  object Any:

    class Def[A, ARRAY <: Any[A]]

    object Def extends zDefDefault:
      inline given xxBoolean[A<:Raw.Boolean]: Def[A,Array[A]] = new Def[A, Array[A]]
      inline given xxByte   [A<:Raw.Byte   ]: Def[A,Array[A]] = new Def[A, Array[A]]
      inline given xxChar   [A<:Raw.Char   ]: Def[A,Array[A]] = new Def[A, Array[A]]
      inline given xxShort  [A<:Raw.Short  ]: Def[A,Array[A]] = new Def[A, Array[A]]
      inline given xxInt    [A<:Raw.Int    ]: Def[A,Array[A]] = new Def[A, Array[A]]
      inline given xxLong   [A<:Raw.Long   ]: Def[A,Array[A]] = new Def[A, Array[A]]
      inline given xxFloat  [A<:Raw.Float  ]: Def[A,Array[A]] = new Def[A, Array[A]]
      inline given xxDouble [A<:Raw.Double ]: Def[A,Array[A]] = new Def[A, Array[A]]
      inline given xxRef    [A<:Ref        ]: Def[A,Array[A]] = new Def[A, Array[A]]

    private[OfArray] class zDefDefault:
      inline given xxAny    [A             ]: Def[A,Array[A]] = new Def[A, Array[A]]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
