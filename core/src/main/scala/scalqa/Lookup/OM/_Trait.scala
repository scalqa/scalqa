package scalqa; package Lookup; package OM

trait _Trait[A, B] extends M[A, B] with O[A, B] {

  def replaceAll(s: ~[(A, B)]): Unit = { multiChange(c => { c.clear; s(t => c.put(t._1, t._2)) }) }

  def multiChange(ch: M[A, B] => Any): Unit

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
