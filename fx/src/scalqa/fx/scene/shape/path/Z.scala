package scalqa; package fx; package scene; package shape; package path

import javafx.scene.{ shape => J }

private[path] object Z:

  trait Base[TYPE <: Base[TYPE, BASE], BASE <: J.PathElement] extends Any with Element with Abstract.Delegate.Value[TYPE, BASE]:
    protected def setup: Setup[TYPE, BASE]

  abstract class Setup[TYPE <: Base[TYPE, BASE], BASE <: J.PathElement] extends Abstract.Delegate.Value.Setup[TYPE, BASE]



/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
