package scalqa; package fx; package scene

import javafx.scene.paint.{ Paint => JPaint }
import Fx.Paint

object Paint extends Abstract.Delegate.Opaque[Paint, JPaint]("Fx.Paint"):
  type Color = paint.Color.TYPE.DEF; transparent inline def Color = paint.Color

  object TYPE:
    opaque type DEF <: JPaint & AnyRef.Opaque = JPaint & AnyRef.Opaque


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
