package scalqa

package object Pro {
  type M[A] = M._Trait[A]
  type OM[A] = OM._Trait[A]
  type O[A] = O._Trait[A]
  type Info = Info._Class

  def make[A](source: => A): Pro[A] = new Z.A.Sourced(source)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
