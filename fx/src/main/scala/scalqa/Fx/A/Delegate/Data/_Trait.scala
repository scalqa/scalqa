package scalqa; package Fx; package A; package Delegate; package Data

trait _Trait[TYPE <: _Trait[TYPE, VALUE], VALUE <: AnyRef] extends Any with Delegate with Any.Datum.Ref[TYPE, VALUE] {
  protected type REAL = VALUE

  def real: REAL

  protected def setup: Setup[TYPE, VALUE]

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 */
