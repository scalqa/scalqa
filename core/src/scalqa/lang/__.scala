package scalqa; import language.implicitConversions

object Lang:
  transparent inline def Any        = lang.Any;                 type Any             = scala.Any
  transparent inline def AnyRef     = lang.AnyRef;              type AnyRef          = scala.AnyRef
  transparent inline def Array      = lang.Array;               type Array[A]        = scala.Array[A]
  transparent inline def Boolean    = lang.Boolean;             type Boolean         = scala.Boolean
  transparent inline def Byte       = lang.Byte;                type Byte            = scala.Byte
  transparent inline def Char       = lang.Char;                type Char            = scala.Char
  transparent inline def Short      = lang.Short;               type Short           = scala.Short
  transparent inline def Int        = lang.Int;                 type Int             = scala.Int
  transparent inline def Long       = lang.Long;                type Long            = scala.Long
  transparent inline def Float      = lang.Float;               type Float           = scala.Float
  transparent inline def Double     = lang.Double;              type Double          = scala.Double
  transparent inline def String     = lang.String;              type String          = java.lang.String

package object lang:
  // Allow Raw to Primitive conversion insize "lang"
  inline implicit def implicitFrom(inline v: Boolean.Raw): Boolean = v.cast[Boolean]
  inline implicit def implicitFrom(inline v: Byte.Raw)   : Byte    = v.cast[Byte]
  inline implicit def implicitFrom(inline v: Char.Raw)   : Char    = v.cast[Char]
  inline implicit def implicitFrom(inline v: Short.Raw)  : Short   = v.cast[Short]
  inline implicit def implicitFrom(inline v: Int.Raw)    : Int     = v.cast[Int]
  inline implicit def implicitFrom(inline v: Long.Raw)   : Long    = v.cast[Long]
  inline implicit def implicitFrom(inline v: Float.Raw)  : Float   = v.cast[Float]
  inline implicit def implicitFrom(inline v: Double.Raw) : Double  = v.cast[Double]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Lang -> ### Language Extensions

    [[Lang]] is fully exported to scalqa root, thus all members and aliases of [[Lang]] can be called with or without "Lang." prefix.

    For example:
    ```
    val v: Lang.Byte.Idx = ?_?_?
    // is same as
    val v: Byte.Idx     = ?_?_?

    val v: Lang.AnyRef.G.Buffer[String] = ?_?_?
    // is same as
    val v: AnyRef.G.Buffer[String] = ?_?_?
    // is same as
    val v: AnyRef.G.Buffer[String] = ?_?_?
    ```
*/