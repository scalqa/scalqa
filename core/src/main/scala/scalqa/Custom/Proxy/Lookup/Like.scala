package scalqa; package Custom; package Proxy; package Lookup

trait Like[A, B] extends scalqa.Lookup[A, B] with Any.Wrap[scalqa.Lookup[A, B]] {

  override def size = real.size

  override def getOpt(key: A) = real.getOpt(key)

  override def allPairs = real.allPairs
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
