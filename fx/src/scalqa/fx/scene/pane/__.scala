package scalqa; package fx; package scene; import language.implicitConversions

abstract class Pane extends Abstract.Region:
  protected type REAL <: javafx.scene.layout.Pane
  protected override def _createReal: REAL = new javafx.scene.layout.Pane().cast[REAL]

  val children               : Idx.M[Node.Like] = Idx.M.javaList_^(real.getChildren).twoWay_^[Node.Like]
  def add(n: Node.Like) : Unit                  = children += n

object Pane:
  def apply(e1: String, e2: Node.Like)      : Pane = Pane(Label(e1), e2)
  def apply(e1: Node.Like, e2: Node.Like) : Pane = Pane.Grid().^(v => { v.add(0,0,e1); v.add(0,1,e2) })

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Split         = pane.Split;         inline def Split         = pane.Split
  type Tab           = pane.Tab;           inline def Tab           = pane.Tab
  type Border        = pane.Border;        inline def Border        = pane.Border
  type Flow          = pane.Flow;          inline def Flow          = pane.Flow
  type Grid          = pane.Grid;          inline def Grid          = pane.Grid
  type HorizontalBox = pane.HorizontalBox; inline def HorizontalBox = pane.HorizontalBox
  type Stack         = pane.Stack
  type VerticalBox   = pane.VerticalBox;   inline def VerticalBox   = pane.VerticalBox
/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
