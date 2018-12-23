package scalqa; package Fx; package Geometry

import javafx.geometry.{ Insets => JInsets }

class Insets private (val real: JInsets) extends AnyVal with A.Delegate.Data[Insets, JInsets] with Any.Able.ToInfo {
  protected def setup = Insets

  def top = real.getTop

  def bottom = real.getBottom

  def right = real.getRight

  def left = real.getLeft

  def newTop(n: Double) = Insets.make(n, right, bottom, left)

  def newBottom(n: Double) = Insets.make(top, right, n, left)

  def newRight(n: Double) = Insets.make(top, n, bottom, left)

  def newLeft(n: Double) = Insets.make(top, right, bottom, n)

  // --------------------------------------------------------------------------------------------------
  def toInfo = new Pro.Info(this) += (("top", top)) += (("bottom", bottom)) += (("left", left)) += (("right", right))
}

object Insets extends A.Delegate.Data.Setup[Insets, JInsets] {

  def make(v: JInsets) = new Insets(v)

  def make(top: Double, right: Double, bottom: Double, left: Double): Insets = make(new JInsets(top, right, bottom, left))

  def make(all: Double): Insets = make(all, all, all, all)
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
