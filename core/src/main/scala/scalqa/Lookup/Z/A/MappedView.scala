package scalqa; package Lookup; package Z; package A

private[Lookup] class MappedView[A, B, C](protected val real: Lookup[A, B], f: B => C) extends Lookup[A, C] {

  def allPairs: ~[(A, C)] = real.allPairs.map(_.map2(f))

  def getOpt(key: A): Opt[C] = real.getOpt(key).map(f)

  def size = real.size
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
