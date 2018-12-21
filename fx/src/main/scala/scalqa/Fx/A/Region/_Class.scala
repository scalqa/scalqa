package scalqa; package Fx; package A; package Region

class _Class extends Parent {
  protected type REAL <: javafx.scene.layout.Region

  protected def _createGui: REAL = new javafx.scene.layout.Region().asInstanceOf[REAL]
  // --------------------------------------------------------------------------------------------------

  def maxWidthPro: Pro.OM[Double] = Custom.ProWO(real.maxWidthProperty); def maxWidth = real.getMaxWidth; def maxWidth_=(b: Double) = real.setMaxWidth(b)

  def minWidthPro: Pro.OM[Double] = Custom.ProWO(real.minWidthProperty); def minWidth = real.getMinWidth; def minWidth_=(b: Double) = real.setMinWidth(b)

  def prefWidthPro: Pro.OM[Double] = Custom.ProWO(real.prefWidthProperty); def prefWidth = real.getPrefWidth; def prefWidth_=(b: Double) = real.setPrefWidth(b)

  def minHeightPro: Pro.OM[Double] = Custom.ProWO(real.minHeightProperty); def minHeight = real.getMinHeight; def minHeight_=(b: Double) = real.setMinHeight(b)

  def maxHeightPro: Pro.OM[Double] = Custom.ProWO(real.maxHeightProperty); def maxHeight = real.getMaxHeight; def maxHeight_=(b: Double) = real.setMaxHeight(b)

  def prefHeightPro: Pro.OM[Double] = Custom.ProWO(real.prefHeightProperty); def prefHeight = real.getPrefHeight; def prefHeight_=(b: Double) = real.setPrefHeight(b)

  def widthPro: Pro.O[Double] = Custom.ProO(real.widthProperty); def width = real.getWidth; def width_=(v: Double) = { maxWidth = v; minWidth = v; prefWidth = v; }

  def heightPro: Pro.O[Double] = Custom.ProO(real.heightProperty); def height = real.getHeight

  def paddingPro: Pro.OM[Insets] = Custom.ProWO(real.paddingProperty).asBiMappedView(Insets.Map); def padding: Insets = real.getPadding; def padding_=(b: Insets) = real.setPadding(b)

  def backgroundPro: Pro.OM[Background] = Custom.ProWO(real.backgroundProperty).asBiMappedView(Background.Map); def background: Background = real.getBackground; def background_=(b: Background) = real.setBackground(b)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def backgroundPro -> Background
 * 
 * 		The background of the Region, which is made up of zero or more BackgroundFills, and zero or more BackgroundImages
 * 
 * 		It is possible for a Background to be empty, where it has neither fills nor images, and is semantically equivalent to null
 *
 * @def paddingPro -> Padding
 *
 *     The top, right, bottom, and left padding around the region's content
 *
 *     This space will be included in the calculation of the region's minimum and preferred sizes
 *
 *     By default padding is Insets.EMPTY. Setting the value to null should be avoided.
 *
 * @def heightPro -> Height
 *
 *     The height of this resizable node
 *
 *     This property is set by the region's parent during layout and may not be set by the application
 *
 *     If an application needs to explicitly control the size of a region, it should override its preferred size range by setting the minHeight, prefHeight, and maxHeight properties
 *
 * @def widthPro -> Width
 *
 *     The width of this resizable node
 *
 *     This property is set by the region's parent during layout and may not be set by the application
 *
 *     If an application needs to explicitly control the size of a region, it should override its preferred size range by setting the minWidth, prefWidth, and maxWidth properties
 *
 * @def prefHeightPro -> Preferred height
 *
 *     Property for overriding the region's computed preferred width
 *
 *     This should only be set if the region's internally computed preferred width doesn't meet the application's layout needs
 *
 *     Defaults to the [[Region.UseComputedSize]] flag, which means that getPrefWidth(forHeight) will return the region's internally computed preferred width
 *
 * @def maxHeightPro -> Maximum height
 *
 *     Property for overriding the region's computed maximum height
 *
 *     This should only be set if the region's internally computed maximum height doesn't meet the application's layout needs
 *
 *     Defaults to the [[Region.UseComputedSize]] flag, which means that getMaxHeight(forWidth) will return the region's internally computed maximum height
 *
 *     Setting this value to the [[Region.UsePrefSize]] flag will cause getMaxHeight(forWidth) to return the region's preferred height, enabling applications to easily restrict the resizability of the region
 *
 * @def minHeightPro -> Minimum height
 *
 *     Property for overriding the region's computed minimum height
 *
 *     This should only be set if the region's internally computed minimum height doesn't meet the application's layout needs
 *
 *     Defaults to the [[Region.UseComputedSize]] flag, which means that minHeight(forWidth) will return the region's internally computed minimum height
 *
 *     Setting this value to the [[Region.UsePrefSize]] flag will cause minHeight(forWidth) to return the region's preferred height, enabling applications to easily restrict the resizability of the region
 *
 * @def maxWidthPro -> Maximum width
 *
 *    Property for overriding the region's computed maximum width
 *
 *    This should only be set if the region's internally computed maximum width doesn't meet the application's layout needs
 *
 *    Defaults to the [[Region.UseComputedSize]] flag, which means that maxWidth(forHeight) will return the region's internally computed maximum width
 *
 *    Setting this value to the [[Region.UsePrefSize]] flag will cause maxWidth(forHeight) to return the region's preferred width, enabling applications to easily restrict the resizability of the region
 *
 * @def minWidthPro -> Maximum width
 *
 *    Property for overriding the region's computed minimum width
 *
 *    This should only be set if the region's internally computed minimum width doesn't meet the application's layout needs
 *
 *    Defaults to the [[Region.UseComputedSize]]  flag, which means that minWidth(forHeight) will return the region's internally computed minimum width
 *
 *    Setting this value to the [[Region.UsePrefSize]] flag will cause minWidth(forHeight) to return the region's preferred width, enabling applications to easily restrict the resizability of the region
 *
 * @def prefWidthPro -> Preferred width
 *
 *     Property for overriding the region's computed preferred width. This should only be set if the region's internally computed preferred width doesn't meet the application's layout needs
 *
 *     Defaults to the [[Region.UseComputedSize]] flag, which means that getPrefWidth(forHeight) will return the region's internally computed preferred width
 *
 *
 *
 */
