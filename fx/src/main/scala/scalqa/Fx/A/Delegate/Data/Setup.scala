package scalqa; package Fx; package A; package Delegate; package Data

abstract class Setup[TYPE <: Data[TYPE, VALUE], VALUE <: AnyRef: Ilk] extends Any.Datum.Ref.Setup[TYPE, VALUE] {

  implicit def zzMake(v: VALUE): TYPE = make(v)

  implicit def zzVal(v: TYPE): VALUE = v.real
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
