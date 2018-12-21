package scalqa; package Fx; package Chart; package Axis; package A; package Category

class _Class extends Axis[String] {
  def this(name: String) = { this(); name.I.Opt(label = _) }
  type VALUE = String
  protected type REAL = javafx.scene.chart.CategoryAxis; override def _createGui = new REAL

  val list: Idx.M[String] = Idx.M.wrap(real.getCategories)

  final def valueMap = \/

  val ordering = Ordering.String

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
