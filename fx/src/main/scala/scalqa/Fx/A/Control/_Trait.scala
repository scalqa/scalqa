package scalqa; package Fx; package A; package Control

trait _Trait extends Region {
  protected type REAL <: javafx.scene.control.Control

  def tooltipPro: Pro.OM[Tooltip] = Custom.ProWO(real.tooltipProperty).asBiMappedView(Tooltip.map);

  def tooltip: Tooltip = Tooltip.make(real.getTooltip);
  def tooltip_=(t: Tooltip): Unit = real.setTooltip(if (t.isVoid) null else t.real)
  def tooltip_=(s: String): Unit = tooltip = new Tooltip(s)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *
 * @def tooltipPro -> Tooltip
 *
 *   ToolTip for this control
 */
