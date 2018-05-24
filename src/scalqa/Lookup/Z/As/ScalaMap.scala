package scalqa; package Lookup; package Z; package As

private[Lookup] class ScalaMap[A, +B](protected val real: Lookup[A, B]) extends collection.AbstractMap[A, B] {

  def -(key: A): scala.collection.Map[A, B] = Fail.unsupported()

  def +[B1 >: B](kv: (A, B1)): scala.collection.Map[A, B1] = Fail.unsupported()

  def get(key: A): Option[B] = real.opt(key).asOption

  def iterator = real.allPairs.as[Iterator]

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/