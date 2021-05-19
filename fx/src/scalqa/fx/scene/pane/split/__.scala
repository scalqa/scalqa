package scalqa; package fx; package scene; package pane; import language.implicitConversions

import javafx.scene.control.SplitPane

class Split extends Control:
  def this(o: Orientation) = { this(); orientation = o }
  protected override def _createReal = new REAL
  protected type REAL = SplitPane

  /**/                   val items                         : Idx.M[Node.Like]  = Idx.M.wrap(real.getItems).mutableMap_^[Node.Like]
  /**/             lazy  val dividers                      : Idx[Split.Divider]  = Idx.wrap(real.getDividers).map_^(new Split.Divider(_))

  @tn("orientation_Pro") def orientation_*                 : Pro.OM[Orientation] = Fx.JavaFx.As.pro_OM(real.orientationProperty).mutableMap_^[Orientation]
  /**/                   def orientation                   : Orientation         = orientation_*()
  /**/                   def orientation_=(o: Orientation) : Unit                = orientation_*() = o

  /**dividerPercent is a percent of entire space allocated to the added section, last section gets the rest*/
  def add(e: Node.Like, dividerPercentOpt : Opt[Percent] = \/): this.type =
    items += e
    priorPercentOpt.forval(p => real.setDividerPosition(items.size - 2, real.getDividers.~.map(_.getPosition).dropLast(1).last_?.or(0D) + p.Double / 100d))
    priorPercentOpt = dividerPercentOpt
    this

  private var priorPercentOpt : Opt[Percent] = \/

object Split:
  type Divider = split.Divider

  def apply()                                       : Pane.Split = new Pane.Split
  def apply(o: Orientation)                         : Pane.Split = apply().^(_.orientation = o)
  def apply(e1: Node.Like, e2: Node.Like) : Pane.Split = apply().^(_.items += e1 += e2)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
