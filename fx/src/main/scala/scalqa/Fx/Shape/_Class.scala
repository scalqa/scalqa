package scalqa; package Fx; package Shape

abstract class _Class extends A.Node {
  protected type REAL <: javafx.scene.shape.Shape
  // --------------------------------------------------------------------------------------------------

  def fillPro: Pro.OM[Paint] = Custom.ProWO(real.fillProperty).asBiMappedView(Paint.Map); def fill: Paint = fillPro(); def fill_=(p: Paint): Unit = fillPro() = p

  def strokePro: Pro.OM[Paint] = Custom.ProWO(real.strokeProperty).asBiMappedView(Paint.Map); def stroke: Paint = strokePro(); def stroke_=(p: Paint): Unit = strokePro() = p

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
