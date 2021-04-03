package scalqa; import language.implicitConversions

object Def:
  /**/       val Any        = `def`.Any
  /**/       val Array      = `def`.Array
  /**/       val Boolean    = `def`.Boolean
  /**/       val Byte       = `def`.Byte
  /**/       val Char       = `def`.Char
  /**/       val Short      = `def`.Short
  /**/       val Int        = `def`.Int
  /**/       val Long       = `def`.Long
  /**/       val Float      = `def`.Float
  /**/       val Double     = `def`.Double
  /**/       val String     = `def`.String
  // -------- Shortcuts ----------------------------------------------------------------------------------------
  /**/       val Ref        = `def`.any.Ref;             type Ref             = scala.AnyRef
  /**/       val Raw        = `def`.any.Raw;             type Raw             = scala.AnyVal
  /**/       val Opaque     = `def`.any.Opaque;          type Opaque          = `def`.Any.Opaque
  @fast lazy val Shape      = `def`.any.self.Shape
  @fast lazy val Info       = `def`.any.self.Info;       type Info            = `def`.any.self.Info
  @fast lazy val Void       = `def`.any.self.Void;       type Void            = `def`.any.self.Void

package `def`:
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
@object Def -> ### Language Extensions

    [[Def]] is fully exported to scalqa root, thus all members and aliases of [[Def]] can be called with or without "Def." prefix.

    For example:
    ```
    val v: Def.Byte.Idx = ?_?_?
    // is same as
    val v: Byte.Idx     = ?_?_?

    val v: Def.Any.Ref.Buffer[String] = ?_?_?
    // is same as
    val v: Any.Ref.Buffer[String] = ?_?_?
    // is same as
    val v: Ref.Buffer[String] = ?_?_?
    ```

@val Any     ->  Object alias \n\n Shortcut to [[scalqa.def.Any$      Def.Any]]
@val Boolean ->  Object alias \n\n Shortcut to [[scalqa.def.Boolean$  Def.Boolean]]
@val Byte    ->  Object alias \n\n Shortcut to [[scalqa.def.Byte$     Def.Byte]]
@val Char    ->  Object alias \n\n Shortcut to [[scalqa.def.Char$     Def.Char]]
@val Short   ->  Object alias \n\n Shortcut to [[scalqa.def.Short$    Def.Short]]
@val Int     ->  Object alias \n\n Shortcut to [[scalqa.def.Int$      Def.Int]]
@val Long    ->  Object alias \n\n Shortcut to [[scalqa.def.Long$     Def.Long]]
@val Float   ->  Object alias \n\n Shortcut to [[scalqa.def.Float$    Def.Float]]
@val Double  ->  Object alias \n\n Shortcut to [[scalqa.def.Double$   Def.Double]]
@val String  ->  Object alias \n\n Shortcut to [[scalqa.def.String$   Def.String]]

@type Ref    ->  Type alias \n\n Shortcut to scala.AnyRef
@val  Ref    ->  Companion alias \n\n Shortcut to [[scalqa.def.any.Ref$ Any.Ref]]

@type Raw    ->  Type alias \n\n Shortcut to [[scalqa.def.any.Raw Any.Raw]]
@val  Raw    ->  Companion alias \n\n Shortcut to [[scalqa.def.any.Raw$ Any.Raw]]

@type Info   ->  Type alias      \n\n Shortcut to [[scalqa.gen.Info                       Def.Info]]
@val  Info   ->  Companion alias \n\n Shortcut to [[scalqa.gen.Doc$                      Def.Info]]

@type Void   ->  Type alias \n\n Shortcut to [[scalqa.def.any.type.Void Any.Self.Void]]
@val  Void   ->  Companion alias \n\n Shortcut to [[scalqa.def.any.type.Void$ Any.Self.Void]]

*/