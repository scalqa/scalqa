package scalqa; package fx; package base; import language.implicitConversions

import javafx.geometry.{ Pos => JPos }

enum Pos(val real: JPos) extends Fx.JavaFx.Enum[JPos]:
  case Void           extends Pos(JPos.CENTER) with Gen.Void
  case TopLeft        extends Pos(JPos.TOP_LEFT)
  case TopCenter      extends Pos(JPos.TOP_CENTER)
  case TopRight       extends Pos(JPos.TOP_RIGHT)
  case CenterLeft     extends Pos(JPos.CENTER_LEFT)
  case Center         extends Pos(JPos.CENTER)
  case CenterRight    extends Pos(JPos.CENTER_RIGHT)
  case BottomLeft     extends Pos(JPos.BOTTOM_LEFT)
  case BottomCenter   extends Pos(JPos.BOTTOM_CENTER)
  case BottomRight    extends Pos(JPos.BOTTOM_RIGHT)
  case BaselineLeft   extends Pos(JPos.BASELINE_LEFT)
  case BaselineCenter extends Pos(JPos.BASELINE_CENTER)
  case BaselineRight  extends Pos(JPos.BASELINE_RIGHT)

  def vertical   : VPos = VPos(real.getVpos)
  def horizontal : HPos = HPos(real.getHpos)

object Pos extends Fx.JavaFx.Enum.Companion[Pos, JPos]:
  implicit inline def implicitFrom(v: \/)    : Pos = Void
  implicit inline def implicitFrom(v: CENTER): Pos = Center
  implicit inline def implicitFrom(v: TOP)   : Pos = TopCenter
  implicit inline def implicitFrom(v: BOTTOM): Pos = BottomCenter
  implicit inline def implicitFrom(v: LEFT)  : Pos = CenterLeft
  implicit inline def implicitFrom(v: RIGHT) : Pos = CenterRight
  implicit        def implicitFrom(v: HPos)  : Pos = v match
    case HPos.Left   => BaselineLeft
    case HPos.Center => BaselineCenter
    case HPos.Right  => BaselineRight

  implicit        def implicitFrom(v: VPos)  : Pos = v match
    case VPos.Top      => TopCenter
    case VPos.Center   => Center
    case VPos.Baseline => BaselineCenter
    case VPos.Bottom   => BottomCenter

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
