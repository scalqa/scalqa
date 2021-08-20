package scalqa; package fx; package base; package style; import language.implicitConversions

import javafx.css.{ PseudoClass => JPseudoClass }
import Style.PseudoClass

object PseudoClass extends Abstract.Delegate.Opaque[PseudoClass,JPseudoClass]("Fx.Style.PseudoClass"):
  /**/     inline def apply(s: String)              : PseudoClass = JPseudoClass.getPseudoClass(s).cast[PseudoClass]
  implicit inline def implicitFrom(inline v: String): PseudoClass = apply(v)

  extension (x: PseudoClass)
    inline def name: String = x.real.getPseudoClassName

  object OPAQUE:
    opaque type TYPE <: AnyRef.Opaque = JPseudoClass & AnyRef.Opaque

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
