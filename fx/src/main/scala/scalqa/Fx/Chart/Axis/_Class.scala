package scalqa; package Fx; package Chart; package Axis

abstract class _Class[A] extends Fx.A.Region with _pro {
  type VALUE
  protected type REAL <: javafx.scene.chart.Axis[VALUE]

  def valueMap: BiMap[A, VALUE]

  val ordering: Ordering[A]

  def apply(v: A): Double = real.getDisplayPosition(valueMap(v))

  def ticks: Idx[Tick[A]] = Idx.wrap(real.getTickMarks).asMappedView(Tick(_, valueMap))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
