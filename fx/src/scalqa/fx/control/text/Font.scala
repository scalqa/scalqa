package scalqa; package fx; package control; package text; import language.implicitConversions

import javafx.scene.text.{ Font => JFont }
import Text.Font

object Font extends Abstract.Delegate.Opaque[Font, JFont]("Fx.Font"):
  def apply(family: String, size: Double) : Font = JFont.font(family, size)

  object OPAQUE:
    opaque type TYPE <: AnyRef.Opaque = JFont & AnyRef.Opaque

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
