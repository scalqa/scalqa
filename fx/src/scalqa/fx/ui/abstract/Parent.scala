package scalqa; package fx; package ui; package `abstract`; import language.implicitConversions

trait Parent extends Node:
  protected type REAL <: javafx.scene.Parent

  @tn("needsLayout_Pro") def needsLayout_* : Boolean.Pro.O  = Fx.JavaFx.As.pro_O(real.needsLayoutProperty)
  /**/                   def needsLayout   : Boolean        = real.isNeedsLayout

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**

@def needsLayout_* -> Needs layout check

   		Indicates that this Node and its subnodes requires a layout pass on the next pulse


*/
