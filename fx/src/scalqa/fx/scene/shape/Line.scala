package scalqa; package fx; package scene; package shape

class Line extends Shape:
  protected def this(startX: Double, startY: Double, endX: Double, endY: Double) = { this(); _createRealOverride(new javafx.scene.shape.Line(startX, startY, endX, endY)) }
  protected def _createReal = new REAL
  protected type REAL = javafx.scene.shape.Line

  def startXPro                       : Double.Pro.OM   = Fx.JavaFx.To.pro_OM(real.startXProperty)
  def startX                          : Double          = real.getStartX
  def startX_=(b: Double)             : Unit            = real.setStartX(b)
  def startYPro                       : Double.Pro.OM   = Fx.JavaFx.To.pro_OM(real.startYProperty)
  def startY                          : Double          = real.getStartY
  def startY_=(b: Double)             : Unit            = real.setStartY(b)
  def endXPro                         : Double.Pro.OM   = Fx.JavaFx.To.pro_OM(real.endXProperty)
  def endX                            : Double          = real.getEndX
  def endX_=(b: Double)               : Unit            = real.setEndX(b)
  def endYPro                         : Double.Pro.OM   = Fx.JavaFx.To.pro_OM(real.endYProperty)
  def endY                            : Double          = real.getEndY
  def endY_=(b: Double)               : Unit            = real.setEndY(b)

  def x                               : (Double,Double) = (startX, endX)
  def x_=(startEnd: (Double, Double)) : Unit            = { startX = startEnd._1; endX = startEnd._2 }
  def y                               : (Double,Double) = (startY, endY)
  def y_=(startEnd: (Double, Double)) : Unit            = { startY = startEnd._1; endY = startEnd._2 }
  def start                           : (Double,Double) = (startX, startY)
  def start_=(xy: (Double, Double))   : Unit            = { startX = xy._1; startY = xy._2 }
  def end                             : (Double,Double) = (endX, endY)
  def end_=(xy: (Double, Double))     : Unit            = { endX = xy._1; endY = xy._2 }

object Line:
  def apply()                                                           : Line = new Line
  def apply(startX: Double, startY: Double, endX: Double, endY: Double) : Line = new Line(startX, startY, endX, endY)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
