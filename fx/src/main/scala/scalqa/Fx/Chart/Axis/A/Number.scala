package scalqa; package Fx; package Chart; package Axis; package A

class Number[A](m: BiMap[A, Double]) extends Value[A](m) {
  def this(name: String, m: BiMap[A, Double]) = { this(m); name.I.Opt(label = _) }
  def this(name: String, map: A => Double, undo: Double => A) = this(name, BiMap(map, undo))

  protected override type REAL = javafx.scene.chart.NumberAxis
  protected override def _createGui = new REAL
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
