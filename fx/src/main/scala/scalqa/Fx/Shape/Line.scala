package scalqa; package Fx; package Shape

class Line extends Shape with Any.Able.ToInfo {
  def this(startX: Double, startY: Double, endX: Double, endY: Double) = { this; _onCreateGuiRun(new javafx.scene.shape.Line(startX, startY, endX, endY)) }

  protected def _createGui = new REAL
  protected type REAL = javafx.scene.shape.Line

  def startXPro: Pro.OM[Double] = Custom.ProWO(real.startXProperty); def startX = real.getStartX; def startX_=(b: Double) = real.setStartX(b)

  def startYPro: Pro.OM[Double] = Custom.ProWO(real.startYProperty); def startY = real.getStartY; def startY_=(b: Double) = real.setStartY(b)

  def endXPro: Pro.OM[Double] = Custom.ProWO(real.endXProperty); def endX = real.getEndX; def endX_=(b: Double) = real.setEndX(b)

  def endYPro: Pro.OM[Double] = Custom.ProWO(real.endYProperty); def endY = real.getEndY; def endY_=(b: Double) = real.setEndY(b)

  // -----------------------------------------------------------------------------------------------------
  def x = (startX, endX); def x_=(startEnd: (Double, Double)) = { startX = startEnd._1; endX = startEnd._2 }
  def y = (startY, endY); def y_=(startEnd: (Double, Double)) = { startY = startEnd._1; endY = startEnd._2 }
  def start = (startX, startY); def start_=(xy: (Double, Double)) = { startX = xy._1; startY = xy._2 }
  def end = (endX, endY); def end_=(xy: (Double, Double)) = { endX = xy._1; endY = xy._2 }

  // -----------------------------------------------------------------------------------------------------

  def toInfo = new Pro.Info(this) += ("x", x) += ("y", y)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
