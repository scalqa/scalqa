package scalqa; package fx; package scene; import language.implicitConversions

abstract class Pane extends Abstract.Region:
  protected type REAL <: javafx.scene.layout.Pane
  protected override def _createReal: REAL = new javafx.scene.layout.Pane().cast[REAL]

  val children            : Idx.M[Fx.Node.Like] = Idx.M.wrap(real.getChildren).mutableMapView[Fx.Node.Like]
  def add(n: Fx.Node.Like): Unit                = children += n

object Pane:
  def apply(e1: String, e2: Fx.Node.Like)       : Pane = Pane(Label(e1), e2)
  def apply(e1: Fx.Node.Like, e2: Fx.Node.Like) : Pane = Pane.Grid().self(v => { v.add(0,0,e1); v.add(0,1,e2) })

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Split         = pane.Split;          transparent inline def Split         = pane.Split
  type Tab           = pane.Tab;            transparent inline def Tab           = pane.Tab
  type Border        = pane.Border;         transparent inline def Border        = pane.Border
  type Flow          = pane.Flow;           transparent inline def Flow          = pane.Flow
  type Grid          = pane.Grid;           transparent inline def Grid          = pane.Grid
  type HorizontalBox = pane.HorizontalBox;  transparent inline def HorizontalBox = pane.HorizontalBox
  type Stack         = pane.Stack
  type VerticalBox   = pane.VerticalBox;    transparent inline def VerticalBox   = pane.VerticalBox
/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
