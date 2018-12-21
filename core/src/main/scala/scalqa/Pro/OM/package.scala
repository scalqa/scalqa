package scalqa; package Pro

package object OM {

  def make[@specialized(DATA) A](v: A): OM[A] = new A.Basic(v)

  def named[@specialized(DATA) A](pName: String, v: A): OM[A] with Any.Able.Name /*with Any.O.Source*/ = new A.Basic(v) with Any.Able.Name { def name = pName }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
