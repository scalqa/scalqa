package scalqa; package fx; package scene; package shape; package path

import javafx.scene.shape.{ ClosePath => JClosePath }

class ClosePath(val real: JClosePath) extends AnyVal with Z.Base[ClosePath,JClosePath]:
  protected def setup = ClosePath

object ClosePath extends Z.Setup[ClosePath,JClosePath]:
  def apply(v: JClosePath) : ClosePath = new ClosePath(v)
  def apply()              : ClosePath = apply(JClosePath())

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
