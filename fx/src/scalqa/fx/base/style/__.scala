package scalqa; package fx; package base; import language.implicitConversions

import Fx.Style

object Style extends String.Opaque.Data[Style]("Fx.Style"):
  /**/     inline def apply(inline v: String)       : Style   = v.toOpaque
  implicit inline def implicitFrom(inline v: String): Style   = apply(v)

  given FxConverter: TwoWayFunction[String,Style]=VOID

  extension(x: Style)
    @tn("join") def +(v: Style|String): Style = {val s=v.cast[String]; if(x.isVoid) s:Style else if(s.isVoid) x else x.real + ';' + s }

  object TYPE:
    opaque type DEF <: String.Opaque = String.Opaque

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  transparent inline def Class       = style.Class;         type Class       = style.Class.TYPE.DEF
  transparent inline def PseudoClass = style.PseudoClass;   type PseudoClass = style.PseudoClass.TYPE.DEF
  transparent inline def PseudoGroup = style.PseudoGroup;   type PseudoGroup = style.PseudoGroup

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
