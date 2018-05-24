package scalqa; package Short; package Like

trait _Trait extends Any with Numeric with Any.Value.Short with Able.DataEqual[Short] {
  protected override type THIS <: Like
  protected override type VALUE = Short

  override def value: Short = super.value: @inline

  protected def companion: Companion[THIS]
  protected def _dataEqual(v: Short): Boolean = v == value
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
