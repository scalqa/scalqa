package scalqa; package gen; package `given`; import language.implicitConversions

class ArrayShape[A, ARRAY <: lang.Array.AnyType[A]]

object ArrayShape extends zDefDefault:
  inline given givenBoolean[A<:Boolean.Raw]: ArrayShape[A,Array[A]] = new ArrayShape[A, Array[A]]
  inline given givenByte   [A<:Byte.Raw   ]: ArrayShape[A,Array[A]] = new ArrayShape[A, Array[A]]
  inline given givenChar   [A<:Char.Raw   ]: ArrayShape[A,Array[A]] = new ArrayShape[A, Array[A]]
  inline given givenShort  [A<:Short.Raw  ]: ArrayShape[A,Array[A]] = new ArrayShape[A, Array[A]]
  inline given givenInt    [A<:Int.Raw    ]: ArrayShape[A,Array[A]] = new ArrayShape[A, Array[A]]
  inline given givenLong   [A<:Long.Raw   ]: ArrayShape[A,Array[A]] = new ArrayShape[A, Array[A]]
  inline given givenFloat  [A<:Float.Raw  ]: ArrayShape[A,Array[A]] = new ArrayShape[A, Array[A]]
  inline given givenDouble [A<:Double.Raw ]: ArrayShape[A,Array[A]] = new ArrayShape[A, Array[A]]
  inline given givenRef    [A<:AnyRef     ]: ArrayShape[A,Array[A]] = new ArrayShape[A, Array[A]]

private[gen] class zDefDefault:
  inline given givenAny    [A             ]: ArrayShape[A,Array[A]] = new ArrayShape[A, Array[A]]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
