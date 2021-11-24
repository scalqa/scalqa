package scalqa; package fx; package base; package `abstract`; import language.implicitConversions

trait Parent extends Node:
  protected type REAL <: javafx.scene.Parent

  def needsLayoutPro: Boolean.Pro.O  = Fx.JavaFx.To.pro_O(real.needsLayoutProperty)
  def needsLayout   : Boolean        = real.isNeedsLayout

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**

@def needsLayoutPro -> Needs layout check

   		Indicates that this Node and its subnodes requires a layout pass on the next pulse


*/
