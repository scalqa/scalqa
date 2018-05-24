package scalqa; package Float; package Like

trait _Trait extends Any with Numeric with Any.Value.Float with Able.DataEqual[Float] {
  protected override type THIS <: Like
  protected override type VALUE = Float

  override def value: Float = super.value: @inline

  protected def companion: Companion[THIS]
  protected def _dataEqual(v: Float): Boolean = v == value
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
