package scalqa; package Any; package Datum.Short; package Sequential

trait _Trait[TYPE <: _Trait[TYPE]] extends Any with Ordered[TYPE] {

  protected def setup: Setup[TYPE]

  def +(i: Int): TYPE = make(real + i toByte)

  def -(i: Int): TYPE = make(real - i toByte)

  def prior: TYPE = this - 1

  def next: TYPE = this + 1

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
