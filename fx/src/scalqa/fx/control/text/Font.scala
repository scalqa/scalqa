package scalqa; package fx; package control; package text; import language.implicitConversions

import javafx.scene.text.{ Font => JFont }

object Font extends Abstract.Delegate.Opaque[Font, JFont]("Fx.Font"):
  def apply(family: String, size: Double) : Font = JFont.font(family, size)

  object opaque:
    opaque type `type` <: Any.Opaque.Ref = JFont & Any.Opaque.Ref

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/