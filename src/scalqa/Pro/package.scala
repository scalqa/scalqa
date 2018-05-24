package scalqa

package object Pro {
  type The[A] = The._Class[A]
  type W[A] = W._Trait[A]
  type WO[A] = WO._Trait[A]
  type O[A] = O._Trait[A]

  def get[A](a: => A): Pro[A] = new Pro[A] { def apply = a }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
