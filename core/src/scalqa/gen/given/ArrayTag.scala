package scalqa; package gen; package `given`; import language.implicitConversions

class ArrayTag[A, ARRAY <: Array.AnyType[A]]

object ArrayTag extends zDefDefault:
  inline given givenBoolean[A<:Raw.Boolean]: ArrayTag[A,Array[A]] = new ArrayTag[A, Array[A]]
  inline given givenByte   [A<:Raw.Byte   ]: ArrayTag[A,Array[A]] = new ArrayTag[A, Array[A]]
  inline given givenChar   [A<:Raw.Char   ]: ArrayTag[A,Array[A]] = new ArrayTag[A, Array[A]]
  inline given givenShort  [A<:Raw.Short  ]: ArrayTag[A,Array[A]] = new ArrayTag[A, Array[A]]
  inline given givenInt    [A<:Raw.Int    ]: ArrayTag[A,Array[A]] = new ArrayTag[A, Array[A]]
  inline given givenLong   [A<:Raw.Long   ]: ArrayTag[A,Array[A]] = new ArrayTag[A, Array[A]]
  inline given givenFloat  [A<:Raw.Float  ]: ArrayTag[A,Array[A]] = new ArrayTag[A, Array[A]]
  inline given givenDouble [A<:Raw.Double ]: ArrayTag[A,Array[A]] = new ArrayTag[A, Array[A]]
  inline given givenRef    [A<:Ref        ]: ArrayTag[A,Array[A]] = new ArrayTag[A, Array[A]]

private[gen] class zDefDefault:
  inline given givenAny    [A             ]: ArrayTag[A,Array[A]] = new ArrayTag[A, Array[A]]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
