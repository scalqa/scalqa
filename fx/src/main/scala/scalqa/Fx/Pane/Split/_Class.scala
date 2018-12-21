package scalqa; package Fx; package Pane; package Split

import javafx.scene.control.SplitPane

class _Class protected[Split] extends Fx.A.Control {
  protected override def _createGui = new REAL
  protected type REAL = SplitPane

  val items: Idx.M[Fx.A.Node.Like] = Idx.M.wrap(real.getItems).asBiMappedView(Fx.A.Node.Like.Map)

  lazy val dividers: Idx[Divider] = Idx.wrap(real.getDividers).asMappedView(new Divider(_))

  def orientationPro = Custom.ProWO(real.orientationProperty).asBiMappedView(Orientation); def orientation = orientationPro(); def orientation_=(o: Orientation) = orientationPro() = o

  private var priorPercentOpt: Opt[Percent] = \/

  /**dividerPercent is a percent of entire space allocated to the added section, last section gets the rest*/
  def add(e: Fx.A.Node.Like, dividerPercentOpt: Opt[Percent] = \/): this.type = {
    items += e
    priorPercentOpt(p => real.setDividerPosition(items.size - 2, real.getDividers.all.map(_.getPosition).dropLast(1).lastOpt.or(0D) + p.toDouble / 100d))
    priorPercentOpt = dividerPercentOpt
    this
  }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
