package scalqa; package Fx; package A; package Parent

trait _Trait extends Node {
  protected type REAL <: javafx.scene.Parent
  // --------------------------------------------------------------------------------------------------

  def needsLayoutPro: Pro.O[Boolean] = Custom.ProO(real.needsLayoutProperty); def needsLayout = real.isNeedsLayout

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def needsLayoutPro -> Needs layout check 
 * 
 * 		Indicates that this Node and its subnodes requires a layout pass on the next pulse
 * 
 */
