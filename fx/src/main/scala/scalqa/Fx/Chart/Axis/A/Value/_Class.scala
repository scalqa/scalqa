package scalqa; package Fx; package Chart; package Axis; package A; package Value

abstract class _Class[A](val map: BiMap[A, Double]) extends Axis[A] with _pro[A] {
  type VALUE = JNumber
  override protected type REAL <: javafx.scene.chart.ValueAxis[JNumber]

  lazy val valueMap: BiMap[A, JNumber] = BiMap(map(_), n => map.undo(n.doubleValue))

  val ordering: Ordering[A] = Ordering.Double.on(map)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
