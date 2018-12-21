package scalqa; package Fx; package Shape; package Path

class _Class extends Shape  {
  protected type REAL = javafx.scene.shape.Path
  protected def _createGui: REAL = new REAL

  def fillRulePro = Custom.ProWO(real.fillRuleProperty).asBiMappedView(FillRule); def fillRule = real.getFillRule; def fillRule_=(v: FillRule) = real.setFillRule(v)

  val elements = new Custom.IdxOM(real.getElements).asBiMappedView(Element.map)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
