package scalqa; package fx; package scene; package shape; import language.implicitConversions

class Path extends Shape:
  protected type REAL = javafx.scene.shape.Path
  protected def _createReal: REAL = new REAL

  /**/                val elements                     : Idx.OM[Path.Element]  = Fx.JavaFx.To.idx_OM(real.getElements).mutableMap_^[Path.Element]
  @tn("fillRule_Pro") def fillRule_*                   : Pro.OM[Path.FillRule] = Fx.JavaFx.To.pro_OM(real.fillRuleProperty).mutableMap_^[Path.FillRule]
  /**/                def fillRule                     : Path.FillRule         = real.getFillRule
  /**/                def fillRule_=(v: Path.FillRule) : Unit                  = real.setFillRule(v)

object Path:
  def apply()             : Shape.Path = new Shape.Path
  def apply(v: Element *) : Shape.Path = apply().^(_.elements ++= v)

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Element      = path.Element;       inline def Element      = path.Element
  type ArcTo        = path.ArcTo;         inline def ArcTo        = path.ArcTo
  type ClosePath    = path.ClosePath;     inline def ClosePath    = path.ClosePath
  type CubicCurveTo = path.CubicCurveTo;  inline def CubicCurveTo = path.CubicCurveTo
  type FillRule     = path.FillRule;      inline def FillRule     = path.FillRule
  type HLineTo      = path.HLineTo;       inline def HLineTo      = path.HLineTo
  type LineTo       = path.LineTo;        inline def LineTo       = path.LineTo
  type MoveTo       = path.MoveTo;        inline def MoveTo       = path.MoveTo
  type QuadCurveTo  = path.QuadCurveTo;   inline def QuadCurveTo  = path.QuadCurveTo
  type VLineTo      = path.VLineTo;       inline def VLineTo      = path.VLineTo

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
