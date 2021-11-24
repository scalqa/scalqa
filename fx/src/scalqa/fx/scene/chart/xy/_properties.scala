package scalqa; package fx; package scene; package chart; package xy

transparent trait _properties[X,Y]:
  self: Chart.XY[X, Y] =>

  def alternativeColumnFillVisiblePro             : Boolean.Pro.OM  = Fx.JavaFx.To.pro_OM(real.alternativeColumnFillVisibleProperty)
  def alternativeColumnFillVisible                : Boolean         = real.isAlternativeColumnFillVisible
  def alternativeColumnFillVisible_=(v: Boolean)  : Unit            = real.setAlternativeColumnFillVisible(v)

  def alternativeRowFillVisiblePro                : Boolean.Pro.OM  = Fx.JavaFx.To.pro_OM(real.alternativeRowFillVisibleProperty)
  def alternativeRowFillVisible                   : Boolean         = real.isAlternativeRowFillVisible
  def alternativeRowFillVisible_=(v: Boolean)     : Unit            = real.setAlternativeRowFillVisible(v)

  def horizontalGridLinesVisiblePro               : Boolean.Pro.OM  = Fx.JavaFx.To.pro_OM(real.horizontalGridLinesVisibleProperty)
  def horizontalGridLinesVisible                  : Boolean         = real.isHorizontalGridLinesVisible
  def horizontalGridLinesVisible_=(v: Boolean)    : Unit            = real.setHorizontalGridLinesVisible(v)

  def horizontalZeroLineVisiblePro                : Boolean.Pro.OM  = Fx.JavaFx.To.pro_OM(real.horizontalZeroLineVisibleProperty)
  def horizontalZeroLineVisible                   : Boolean         = real.isHorizontalZeroLineVisible
  def horizontalZeroLineVisible_=(v: Boolean)     : Unit            = real.setHorizontalZeroLineVisible(v)

  def verticalGridLinesVisiblePro                 : Boolean.Pro.OM  = Fx.JavaFx.To.pro_OM(real.verticalGridLinesVisibleProperty)
  def verticalGridLinesVisible                    : Boolean         = real.getVerticalGridLinesVisible
  def verticalGridLinesVisible_=(v: Boolean)      : Unit            = real.setVerticalGridLinesVisible(v)

  def verticalZeroLineVisiblePro                  : Boolean.Pro.OM  = Fx.JavaFx.To.pro_OM(real.verticalZeroLineVisibleProperty)
  def verticalZeroLineVisible                     : Boolean         = real.isVerticalZeroLineVisible
  def verticalZeroLineVisible_=(v: Boolean)       : Unit            = real.setVerticalZeroLineVisible(v)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
