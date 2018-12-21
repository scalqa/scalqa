package scalqa; package Lookup

package object M {

  def make[A, B](ma: ~[(A, B)]): M[A, B] = new A.Basic[A, B]().I(l => ma.foreach(_(l.put)))

  def make[A, B]: M[A, B] = new A.Basic[A, B]

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
