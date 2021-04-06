package scalqa; import language.implicitConversions

object Lang:
  /**/       val Any        = lang.Any
  /**/       val Array      = lang.Array
  /**/       val Boolean    = lang.Boolean
  /**/       val Byte       = lang.Byte
  /**/       val Char       = lang.Char
  /**/       val Short      = lang.Short
  /**/       val Int        = lang.Int
  /**/       val Long       = lang.Long
  /**/       val Float      = lang.Float
  /**/       val Double     = lang.Double
  /**/       val String     = lang.String
  // -------- Shortcuts ----------------------------------------------------------------------------------------
  /**/       val Ref        = lang.any.Ref;             type Ref             = scala.AnyRef
  /**/       val Raw        = lang.any.Raw;             type Raw             = scala.AnyVal
  /**/       val Opaque     = lang.any.Opaque;          type Opaque          = lang.Any.Opaque
  @fast lazy val Shape      = lang.any.self.Shape
  @fast lazy val Doc        = lang.any.self.Doc;        type Doc             = lang.any.self.Doc
  @fast lazy val Def       = lang.any.self.Def
  @fast lazy val Void       = lang.any.self.Void;       type Void            = lang.any.self.Void

package lang:
  inline implicit def xx(inline v: Raw.Boolean): Boolean = v.cast[Boolean]
  inline implicit def xx(inline v: Raw.Byte)   : Byte    = v.cast[Byte]
  inline implicit def xx(inline v: Raw.Char)   : Char    = v.cast[Char]
  inline implicit def xx(inline v: Raw.Short)  : Short   = v.cast[Short]
  inline implicit def xx(inline v: Raw.Int)    : Int     = v.cast[Int]
  inline implicit def xx(inline v: Raw.Long)   : Long    = v.cast[Long]
  inline implicit def xx(inline v: Raw.Float)  : Float   = v.cast[Float]
  inline implicit def xx(inline v: Raw.Double) : Double  = v.cast[Double]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Lang -> ### Language Extensions

    [[Lang]] is fully exported to scalqa root, thus all members and aliases of [[Core]] can be called with or without "Lang." prefix.

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

@val Any     ->  Object alias \n\n Shortcut to [[scalqa.lang.Any$      Lang.Any]]
@val Boolean ->  Object alias \n\n Shortcut to [[scalqa.lang.Boolean$  Lang.Boolean]]
@val Byte    ->  Object alias \n\n Shortcut to [[scalqa.lang.Byte$     Lang.Byte]]
@val Char    ->  Object alias \n\n Shortcut to [[scalqa.lang.Char$     Lang.Char]]
@val Short   ->  Object alias \n\n Shortcut to [[scalqa.lang.Short$    Lang.Short]]
@val Int     ->  Object alias \n\n Shortcut to [[scalqa.lang.Int$      Lang.Int]]
@val Long    ->  Object alias \n\n Shortcut to [[scalqa.lang.Long$     Lang.Long]]
@val Float   ->  Object alias \n\n Shortcut to [[scalqa.lang.Float$    Lang.Float]]
@val Double  ->  Object alias \n\n Shortcut to [[scalqa.lang.Double$   Lang.Double]]
@val String  ->  Object alias \n\n Shortcut to [[scalqa.lang.String$   Lang.String]]

@type Ref    ->  Type alias \n\n Shortcut to scala.AnyRef
@val  Ref    ->  Companion alias \n\n Shortcut to [[scalqa.lang.any.Ref$ Any.Ref]]

@type Raw    ->  Type alias \n\n Shortcut to [[scalqa.lang.any.Raw Any.Raw]]
@val  Raw    ->  Companion alias \n\n Shortcut to [[scalqa.lang.any.Raw$ Any.Raw]]

@type Doc   ->  Type alias      \n\n Shortcut to [[scalqa.gen.Doc                       Lang.Doc]]
@val  Doc   ->  Companion alias \n\n Shortcut to [[scalqa.gen.Doc$                      Lang.Doc]]

@type Void   ->  Type alias \n\n Shortcut to [[scalqa.lang.any.type.Void Any.Self.Void]]
@val  Void   ->  Companion alias \n\n Shortcut to [[scalqa.lang.any.type.Void$ Any.Self.Void]]

*/