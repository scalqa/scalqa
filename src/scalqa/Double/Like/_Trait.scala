package scalqa; package Double; package Like

trait _Trait extends Any with Numeric with Any.Value.Double with Able.DataEqual[Double] {
  protected override type THIS <: Like
  protected override type VALUE = Double

  override def value: Double = super.value: @inline

  protected def companion: Companion[THIS]
  protected def _dataEqual(v: Double): Boolean = v == value
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
