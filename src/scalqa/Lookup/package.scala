package scalqa

package object Lookup {
  type The[A, B] = The._Class[A, B]
  type W[A, B] = W._Trait[A, B]
  type Val[A, B] = Val._Class[A, B]

  def getAll[A, B](a: ~[(A, B)]): Lookup[A, B] = new The.Proxy[A, B](W.get(a))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
