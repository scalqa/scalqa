package scalqa; import language.implicitConversions

object Lang:
  transparent inline def Any        = lang.Any
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
  // -------- Shortcuts ----------------------------------------------------------------------------------------
  transparent inline def Ref        = lang.any.Ref;             type Ref             = scala.AnyRef
  transparent inline def Raw        = lang.any.Raw;             type Raw             = scala.AnyVal
  transparent inline def Opaque     = lang.any.Opaque;          type Opaque          = lang.Any.Opaque

package object lang:
  inline implicit def implicitFromRaw(inline v: Raw.Boolean): Boolean = v.cast[Boolean]
  inline implicit def implicitFromRaw(inline v: Raw.Byte)   : Byte    = v.cast[Byte]
  inline implicit def implicitFromRaw(inline v: Raw.Char)   : Char    = v.cast[Char]
  inline implicit def implicitFromRaw(inline v: Raw.Short)  : Short   = v.cast[Short]
  inline implicit def implicitFromRaw(inline v: Raw.Int)    : Int     = v.cast[Int]
  inline implicit def implicitFromRaw(inline v: Raw.Long)   : Long    = v.cast[Long]
  inline implicit def implicitFromRaw(inline v: Raw.Float)  : Float   = v.cast[Float]
  inline implicit def implicitFromRaw(inline v: Raw.Double) : Double  = v.cast[Double]

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

    val v: Lang.Any.Ref.Buffer[String] = ?_?_?
    // is same as
    val v: Any.Ref.Buffer[String] = ?_?_?
    // is same as
    val v: Ref.Buffer[String] = ?_?_?
    ```

@def Any     ->  Object alias \n\n Shortcut to [[scalqa.lang.Any$      Lang.Any]]
@def Boolean ->  Object alias \n\n Shortcut to [[scalqa.lang.Boolean$  Lang.Boolean]]
@def Byte    ->  Object alias \n\n Shortcut to [[scalqa.lang.Byte$     Lang.Byte]]
@def Char    ->  Object alias \n\n Shortcut to [[scalqa.lang.Char$     Lang.Char]]
@def Short   ->  Object alias \n\n Shortcut to [[scalqa.lang.Short$    Lang.Short]]
@def Int     ->  Object alias \n\n Shortcut to [[scalqa.lang.Int$      Lang.Int]]
@def Long    ->  Object alias \n\n Shortcut to [[scalqa.lang.Long$     Lang.Long]]
@def Float   ->  Object alias \n\n Shortcut to [[scalqa.lang.Float$    Lang.Float]]
@def Double  ->  Object alias \n\n Shortcut to [[scalqa.lang.Double$   Lang.Double]]
@def String  ->  Object alias \n\n Shortcut to [[scalqa.lang.String$   Lang.String]]

@type Ref    ->  Type alias \n\n Shortcut to scala.AnyRef
@def  Ref    ->  Companion alias \n\n Shortcut to [[scalqa.lang.any.Ref$ Any.Ref]]

@type Raw    ->  Type alias \n\n Shortcut to [[scalqa.lang.any.Raw Any.Raw]]
@def  Raw    ->  Companion alias \n\n Shortcut to [[scalqa.lang.any.Raw$ Any.Raw]]

*/