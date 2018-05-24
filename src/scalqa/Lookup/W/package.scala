package scalqa; package Lookup

package object W {
  type The[A, B] = The._Class[A, B]

  def get[A, B](ma: ~[(A, B)]): W[A, B] = new The[A, B]().I(l => ma.apply(_(l.put)))

  def get[A, B]: W[A, B] = new The[A, B]

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
