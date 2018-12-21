package scalqa; package Any; package Datum; package Ref 

trait _Trait[TYPE <: _Trait[TYPE, VALUE], VALUE] extends Any with Any.Datum[TYPE, VALUE] {

  protected def setup: Setup[TYPE, VALUE]

  @inline protected def make(v: VALUE): TYPE = setup.Map(v)

}

private object _Trait {

  @inline def real[B](v: _Trait[_, B]) = v.real

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
