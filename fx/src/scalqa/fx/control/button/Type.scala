package scalqa; package fx; package control; package button

import javafx.scene.control.{ButtonType => JType}

object Type extends Abstract.Delegate.Opaque[Button.Type, JType]("Fx.Button.Type"):

  object TYPE:
    opaque type DEF <: AnyRef.Opaque = JType & AnyRef.Opaque

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
