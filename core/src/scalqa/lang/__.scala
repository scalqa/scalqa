package scalqa; import language.implicitConversions

object Lang:
  transparent inline def Any        = lang.Any
  transparent inline def AnyRef     = lang.AnyRef
  transparent inline def Array      = lang.Array
  transparent inline def Boolean    = lang.Boolean
  transparent inline def Byte       = lang.Byte
  transparent inline def Char       = lang.Char
  transparent inline def Short      = lang.Short
  transparent inline def Int        = lang.Int
  transparent inline def Long       = lang.Long
  transparent inline def Float      = lang.Float
  transparent inline def Double     = lang.Double
  transparent inline def String     = lang.String
  transparent inline def More       = lang.More

package object lang:
  // Allow Primitive to Primitive conversion insize "lang"
  inline implicit def z_From(inline v: Any.Boolean): Boolean = v.cast[Boolean]
  inline implicit def z_From(inline v: Any.Byte)   : Byte    = v.cast[Byte]
  inline implicit def z_From(inline v: Any.Char)   : Char    = v.cast[Char]
  inline implicit def z_From(inline v: Any.Short)  : Short   = v.cast[Short]
  inline implicit def z_From(inline v: Any.Int)    : Int     = v.cast[Int]
  inline implicit def z_From(inline v: Any.Long)   : Long    = v.cast[Long]
  inline implicit def z_From(inline v: Any.Float)  : Float   = v.cast[Float]
  inline implicit def z_From(inline v: Any.Double) : Double  = v.cast[Double]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Lang -> ### Language Extensions

    [[Lang]] is fully exported to scalqa root, thus all members of [[Lang]] can be called with or without "Lang." prefix.

    For example:
    ```
    val v: Lang.Byte.Idx = ?_?_?
    // is same as
    val v: Byte.Idx      = ?_?_?

    val v: Lang.Int.Buffer = ?_?_?
    // is same as
    val v: Int.Buffer      = ?_?_?
    ```

@def  Any       ->  Type companion alias \n\n Shortcut to [[scalqa.lang.Any$ Lang.Any]]
@def  AnyRef    ->  Type companion alias \n\n Shortcut to [[scalqa.lang.AnyRef$ Lang.AnyRef]]
@def  Array     ->  Type companion alias \n\n Shortcut to [[scalqa.lang.Array$ Lang.Array]]
@def  Boolean   ->  Type companion alias \n\n Shortcut to [[scalqa.lang.Boolean$ Lang.Boolean]]
@def  Byte      ->  Type companion alias \n\n Shortcut to [[scalqa.lang.Byte$ Lang.Byte]]
@def  Char      ->  Type companion alias \n\n Shortcut to [[scalqa.lang.Char$ Lang.Char]]
@def  Short     ->  Type companion alias \n\n Shortcut to [[scalqa.lang.Short$ Lang.Short]]
@def  Int       ->  Type companion alias \n\n Shortcut to [[scalqa.lang.Int$ Lang.Int]]
@def  Long      ->  Type companion alias \n\n Shortcut to [[scalqa.lang.Long$ Lang.Long]]
@def  Float     ->  Type companion alias \n\n Shortcut to [[scalqa.lang.Float$ Lang.Float]]
@def  Double    ->  Type companion alias \n\n Shortcut to [[scalqa.lang.Double$ Lang.Double]]
@def  String    ->  Type companion alias \n\n Shortcut to [[scalqa.lang.String$ Lang.String]]
*/