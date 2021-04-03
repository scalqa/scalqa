package scalqa; package fx; package scene

import javafx.scene.paint.{ Paint => JPaint }

object Paint extends Abstract.Delegate.Opaque[Paint, JPaint]("Fx.Paint"):
  type Color = paint.Color.opaque.`type`; val Color = paint.Color

  object opaque:
    opaque type `type` <: JPaint & Opaque.Ref = JPaint & Opaque.Ref


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
