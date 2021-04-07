package scalqa; package fx; package ui; import language.implicitConversions

object Style extends String.Custom.Data[Style]("Fx.Style"):
  val Default : Idx                  = \/
  given FxConverter: TwoWayFun[String,Style] = \/

  /**/     inline def apply   (inline v: String): Style = v.asOpaque[Style]
  implicit inline def xxString(inline v: String): Style = apply(v)

  extension(x: Style)
    override def join(v: Style|String) : Style = apply(if(x.isVoid) v.real else if(v.real.isVoid) x.real else x.real + ';' + v.real)

  object opaque:
    opaque type `type` <: Any.Opaque.String = Any.Opaque.String

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  inline def Class       = style.Class;         type Class       = style.Class.opaque.`type`
  inline def PseudoClass = style.PseudoClass;   type PseudoClass = style.PseudoClass.opaque.`type`
  inline def PseudoGroup = style.PseudoGroup;   type PseudoGroup = style.PseudoGroup

package style:
  type Class       = style.Class.opaque.`type`
  type PseudoClass = style.PseudoClass.opaque.`type`

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/