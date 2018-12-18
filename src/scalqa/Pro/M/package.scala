package scalqa; package Pro

package object M {

  def make[@specialized(DATA) A](value: A): M[A] = new A.Basic(value)

  def named[@specialized(DATA) A](pName: String, value: A): M[A] with Any.Able.Name = new A.Basic(value) with Any.Able.Name { def name = pName }

  def sealable[A](value: A): M[A] with Any.Able.Seal = new Z.A.Sealable(value)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 */
