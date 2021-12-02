package scalqa; package fx; package scene; package pane; import language.implicitConversions

import javafx.scene.control.SplitPane

class Split extends Control:
  def this(o: Orientation) = { this(); orientation = o }
  protected override def _createReal = new REAL
  protected type REAL = SplitPane

  /**/  val items                         : Idx.M[Fx.Node.Like] = Idx.M.wrap(real.getItems).mutableMapView[Fx.Node.Like]
  lazy  val dividers                      : Idx[Split.Divider]  = Idx.wrap(real.getDividers).mapView(new Split.Divider(_))

  /**/  def orientationPro                : Pro.OM[Orientation] = Fx.JavaFx.To.pro_OM(real.orientationProperty).mutableMapView[Orientation]
  /**/  def orientation                   : Orientation         = orientationPro()
  /**/  def orientation_=(o: Orientation) : Unit                = orientationPro() = o

  /**dividerPercent is a percent of entire space allocated to the added section, last section gets the rest*/
  def add(e: Fx.Node.Like, dividerPercentOpt : Opt[Percent]=VOID): this.type =
    items += e
    priorPercentOpt.forval(p => real.setDividerPosition(items.size - 2, real.getDividers.valStream.map(_.getPosition).dropLast(1).lastOpt.or(0D) + p.toDouble / 100d))
    priorPercentOpt = dividerPercentOpt
    this

  private var priorPercentOpt : Opt[Percent]=VOID

object Split:
  type Divider = split.Divider

  def apply()                                   : Pane.Split = new Pane.Split
  def apply(o: Orientation)                     : Pane.Split = apply().self(_.orientation = o)
  def apply(e1: Fx.Node.Like, e2: Fx.Node.Like) : Pane.Split = apply().self(_.items += e1 += e2)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
