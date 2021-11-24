package scalqa; package fx; package scene; package shape; import language.implicitConversions

class Path extends Shape:
  protected type REAL = javafx.scene.shape.Path
  protected def _createReal: REAL = new REAL

  val elements                     : Idx.OM[Path.Element]  = Fx.JavaFx.To.idx_OM(real.getElements).mutableMapView[Path.Element]
  def fillRulePro                  : Pro.OM[Path.FillRule] = Fx.JavaFx.To.pro_OM(real.fillRuleProperty).mutableMapView[Path.FillRule]
  def fillRule                     : Path.FillRule         = real.getFillRule
  def fillRule_=(v: Path.FillRule) : Unit                  = real.setFillRule(v)

object Path:
  def apply()             : Shape.Path = new Shape.Path
  def apply(v: Element *) : Shape.Path = apply().self(_.elements ++= v)

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Element      = path.Element;        transparent inline def Element      = path.Element
  type ArcTo        = path.ArcTo;          transparent inline def ArcTo        = path.ArcTo
  type ClosePath    = path.ClosePath;      transparent inline def ClosePath    = path.ClosePath
  type CubicCurveTo = path.CubicCurveTo;   transparent inline def CubicCurveTo = path.CubicCurveTo
  type FillRule     = path.FillRule;       transparent inline def FillRule     = path.FillRule
  type HLineTo      = path.HLineTo;        transparent inline def HLineTo      = path.HLineTo
  type LineTo       = path.LineTo;         transparent inline def LineTo       = path.LineTo
  type MoveTo       = path.MoveTo;         transparent inline def MoveTo       = path.MoveTo
  type QuadCurveTo  = path.QuadCurveTo;    transparent inline def QuadCurveTo  = path.QuadCurveTo
  type VLineTo      = path.VLineTo;        transparent inline def VLineTo      = path.VLineTo

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
