package scalqa; package Any; package Datum.Byte

trait _Trait[TYPE <: _Trait[TYPE]] extends Any with Any.Wrap[Byte] with Custom.Number.Like {

  protected def real: Byte

  protected def realNumber = java.lang.Byte.valueOf(real)

  protected def setup: Setup[TYPE]

  @inline protected def make(v: Byte): TYPE = setup.Map(v)
}

private object _Trait {

  @inline def real(v: _Trait[_]) = v.real

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/