package scalqa; package Fx; package A

package object Region {
  type Background = Background._Class

  val UseComputedSize = javafx.scene.layout.Region.USE_COMPUTED_SIZE

  val UsePrefSize = javafx.scene.layout.Region.USE_PREF_SIZE

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @val UseComputedSize -> Flag value
 *
 *     Sentinel value which can be passed to a region's minWidth, minHeight, prefWidth, prefHeight, maxWidth, maxHeight methods
 *     to reset the region's size constraint back to it's intrinsic size returned by computeMinWidth, computeMinHeight, computePrefWidth, computePrefHeight, computeMaxWidth, or computeMaxHeight
 *
 * @val UsePrefSize -> Flag value
 *
 *    Sentinel value which can be passed to a region's minWidth, minHeight, maxWidth or maxHeight methods to indicate that the preferred dimension should be used for that max and/or min constraint
 *
 *
 */
