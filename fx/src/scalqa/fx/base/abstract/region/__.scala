package scalqa; package fx; package base; package `abstract`; import language.implicitConversions

class Region extends Parent:
  protected type REAL <: javafx.scene.layout.Region
  protected def _createReal              : REAL                       = javafx.scene.layout.Region().cast[REAL]

  def maxWidthPro                        : Double.Pro.OM              = Fx.JavaFx.To.pro_OM(real.maxWidthProperty)
  def maxWidth                           : Double                     = real.getMaxWidth
  def maxWidth_=(b: Double)              : Unit                       = real.setMaxWidth(b)
  def minWidthPro                        : Double.Pro.OM              = Fx.JavaFx.To.pro_OM(real.minWidthProperty)
  def minWidth                           : Double                     = real.getMinWidth
  def minWidth_=(b: Double)              : Unit                       = real.setMinWidth(b)
  def prefWidthPro                       : Double.Pro.OM              = Fx.JavaFx.To.pro_OM(real.prefWidthProperty)
  def prefWidth                          : Double                     = real.getPrefWidth
  def prefWidth_=(b: Double)             : Unit                       = real.setPrefWidth(b)
  def minHeightPro                       : Double.Pro.OM              = Fx.JavaFx.To.pro_OM(real.minHeightProperty)
  def minHeight                          : Double                     = real.getMinHeight
  def minHeight_=(b: Double)             : Unit                       = real.setMinHeight(b)
  def maxHeightPro                       : Double.Pro.OM              = Fx.JavaFx.To.pro_OM(real.maxHeightProperty)
  def maxHeight                          : Double                     = real.getMaxHeight
  def maxHeight_=(b: Double)             : Unit                       = real.setMaxHeight(b)
  def prefHeightPro                      : Double.Pro.OM              = Fx.JavaFx.To.pro_OM(real.prefHeightProperty)
  def prefHeight                         : Double                     = real.getPrefHeight
  def prefHeight_=(b: Double)            : Unit                       = real.setPrefHeight(b)
  def widthPro                           : Double.Pro.O               = Fx.JavaFx.To.pro_O(real.widthProperty)
  def width                              : Double                     = real.getWidth
  def width_=(v: Double)                 : Unit                       = { maxWidth = v; minWidth = v; prefWidth = v; }
  def heightPro                          : Double.Pro.O               = Fx.JavaFx.To.pro_O(real.heightProperty)
  def height                             : Double                     = real.getHeight
  def paddingPro                         : Pro.OM[Insets]             = Fx.JavaFx.To.pro_OM(real.paddingProperty).mutableMapView[Insets]
  def padding                            : Insets                     = Insets(real.getPadding)
  def padding_=(v: Insets)               : Unit                       = real.setPadding(v.real)
  def backgroundPro                      : Pro.OM[Region.Background]  = Fx.JavaFx.To.pro_OM(real.backgroundProperty).mutableMapView[Region.Background]
  def background                         : Region.Background          = real.getBackground
  def background_=(b: Region.Background) : Unit                       = real.setBackground(b)

object Region:
  def apply() = new Abstract.Region

  inline def UseComputedSize  = javafx.scene.layout.Region.USE_COMPUTED_SIZE
  inline def UsePrefSize      = javafx.scene.layout.Region.USE_PREF_SIZE

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Background = region.Background.TYPE.DEF; transparent inline def Background = region.Background


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**

@def backgroundPro -> Background

       The background of the Region, which is made up of zero or more BackgroundFills, and zero or more BackgroundImages

       It is possible for a Background to be empty, where it has neither fills nor images, and is semantically equivalent to null


@def paddingPro -> Padding

       The top, right, bottom, and left padding around the region's content

       This space will be included in the calculation of the region's minimum and preferred sizes

       By default padding is Insets.EMPTY. Setting the value to null should be avoided.


@def heightPro -> Height

       The height of this resizable node

       This property is set by the region's parent during layout and may not be set by the application

       If an application needs to explicitly control the size of a region, it should override its preferred size range by setting the minHeight, prefHeight, and maxHeight properties


@def widthPro -> Width

       The width of this resizable node

       This property is set by the region's parent during layout and may not be set by the application

       If an application needs to explicitly control the size of a region, it should override its preferred size range by setting the minWidth, prefWidth, and maxWidth properties


@def prefHeightPro -> Preferred height

       Property for overriding the region's computed preferred width

       This should only be set if the region's internally computed preferred width doesn't meet the application's layout needs

       Defaults to the [[Region.UseComputedSize]] flag, which means that getPrefWidth(forHeight) will return the region's internally computed preferred width


@def maxHeightPro -> Maximum height

       Property for overriding the region's computed maximum height

       This should only be set if the region's internally computed maximum height doesn't meet the application's layout needs

       Defaults to the [[Region.UseComputedSize]] flag, which means that getMaxHeight(forWidth) will return the region's internally computed maximum height

       Setting this value to the [[Region.UsePrefSize]] flag will cause getMaxHeight(forWidth) to return the region's preferred height, enabling applications to easily restrict the resizability of the region


@def minHeightPro -> Minimum height

       Property for overriding the region's computed minimum height

       This should only be set if the region's internally computed minimum height doesn't meet the application's layout needs

       Defaults to the [[Region.UseComputedSize]] flag, which means that minHeight(forWidth) will return the region's internally computed minimum height

       Setting this value to the [[Region.UsePrefSize]] flag will cause minHeight(forWidth) to return the region's preferred height, enabling applications to easily restrict the resizability of the region


@def maxWidthPro -> Maximum width

      Property for overriding the region's computed maximum width

      This should only be set if the region's internally computed maximum width doesn't meet the application's layout needs

      Defaults to the [[Region.UseComputedSize]] flag, which means that maxWidth(forHeight) will return the region's internally computed maximum width

      Setting this value to the [[Region.UsePrefSize]] flag will cause maxWidth(forHeight) to return the region's preferred width, enabling applications to easily restrict the resizability of the region


@def minWidthPro -> Maximum width

      Property for overriding the region's computed minimum width

      This should only be set if the region's internally computed minimum width doesn't meet the application's layout needs

      Defaults to the [[Region.UseComputedSize]]  flag, which means that minWidth(forHeight) will return the region's internally computed minimum width

      Setting this value to the [[Region.UsePrefSize]] flag will cause minWidth(forHeight) to return the region's preferred width, enabling applications to easily restrict the resizability of the region


@def prefWidthPro -> Preferred width

       Property for overriding the region's computed preferred width. This should only be set if the region's internally computed preferred width doesn't meet the application's layout needs

       Defaults to the [[Region.UseComputedSize]] flag, which means that getPrefWidth(forHeight) will return the region's internally computed preferred width

*/
