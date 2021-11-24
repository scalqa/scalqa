package scalqa; package fx; package scene; package shape; package path

import javafx.scene.{ shape => SH }

trait Element extends Any:
  def real                   : SH.PathElement
  def absolutePro            : Boolean.Pro.OM  = Fx.JavaFx.To.pro_OM(real.absoluteProperty)
  def absolute               : Boolean         = real.isAbsolute
  def absolute_=(b: Boolean) : Unit            = real.setAbsolute(b)

object Element:

  given FxConverter: TwoWayFunction[SH.PathElement, Element] = new TwoWayFunction[SH.PathElement, Element] {
    def apply(real: SH.PathElement) = Element(real)
    def undo(e: Element) = e.real
  }

  def apply(real: SH.PathElement): Element = real match
    case e: SH.ArcTo        => ArcTo(e)
    case e: SH.ClosePath    => ClosePath(e)
    case e: SH.CubicCurveTo => CubicCurveTo(e)
    case e: SH.HLineTo      => HLineTo(e)
    case e: SH.LineTo       => LineTo(e)
    case e: SH.MoveTo       => MoveTo(e)
    case e: SH.QuadCurveTo  => QuadCurveTo(e)
    case e: SH.VLineTo      => VLineTo(e)
    case _                  => J.illegalState()

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
